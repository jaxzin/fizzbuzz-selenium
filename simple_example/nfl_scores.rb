# for this example I will use watir-webdriver, which provides a more
# 'DOM centric' API for accessing webdriver.  It sits on top of webdriver
# using webdriver's ruby language api.

# this example is intentionally minimal, uses no testing framework
# uses no abstraction layers, has no reporting, and hard codes constants inline

require 'watir-webdriver'

# create browser object  using chrome because it handles firing mouse events
# far better than firefox.
b = Watir::Browser.new :chrome

# navigate to espn web page
b.goto 'espn.go.com'

# page has a lot of ajax, so lets attempt to be sure the client side JS is done
# making requests before proceeding
Watir::Wait.until {b.execute_script("return jQuery.active == 0")}

# navigate to the NFL=Scores page..

# note: the test spec does not define what 'navigate' means in this case
# depending on what is needed in a real test this might be simply going to the
# known url of the page (often used for tests of the page itself), or trying to
# emulate real user actions such as clicking on nfl, then clicking on scores,
# or hovering on nfl, and then clicking on scores once the sub menu appears.
#  I'm choosing to emulate the latter as it is the most difficult and I presume
# that is somewhat the point of this exercise

# webdriver & firefox have a lot of difficulty with native events like mouseover
# and hover.  So much so that the code below that fires the mouseover event
# generates errors if run using firefox as the browser.  Some of the longest
# threads I have seen on webdriver bugs are for issues of this sort
# for example https://code.google.com/p/selenium/issues/detail?id=2067
# I know a number of workarounds for this sort of thing, but they do not work
# with your site because the sub-menu code is not even rendered into the DOM
# prior to the user mousing over 'nfl' in the first level menu

# simulate the user placing the mouse over the nfl menu
# b.li(:id => 'menu-nfl').fire_event 'mouseover'
b.li(:id => 'menu-nfl').hover

# once menu item has rendered, click on scores
b.li(:id => 'menu-nfl').link(:text => 'Scores').when_present.click

# verify page title
# note that test spec does not stipulate if this is the html title element
# or what the user would 'see' as a title on the page, so we will check both

html_title = b.title
expected_html_title = 'NFL Football Scores - NFL Scoreboard - ESPN - ESPN'
if html_title == expected_html_title
  puts 'HTML Title PASS: page has expected title in header section of html'
else
  puts "HTML Title FAIL:  expected: #{expected_html_title} actual: #{html_title}"
end

section_title = b.link(:class => 'section-title').text
expected_section_title = 'NFL Scoreboard'
if section_title == expected_section_title
  puts 'Section Title PASS: page has expected title at top of page'
else
  puts "Section Title FAIL:  expected: #{expected_section_title} actual: #{section_title}"
end

b.close