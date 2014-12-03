fizzbuzz-selenium
=================

This is a QA engineering example. Please perform the following steps:

1. [Fork this repository](https://help.github.com/articles/fork-a-repo)
1. [Create a new branch](https://github.com/blog/1377-create-and-delete-branches)
1. Implement a simple interaction test with Selenium against espn.go.com.
  1. Your test should navigate to NFL > Scores link, click on it, and validate the browser is now on a page titled "NFL Scoreboard".
1. [Create a pull request](https://help.github.com/articles/creating-a-pull-request) and include instructions in the summary on how to run the test and replicate your results.
1. [Setup your fork for continuous integration](http://docs.travis-ci.com/user/languages/java/) using https://travis-ci.org/ and then update this README so it [includes the Travis build status image](http://docs.travis-ci.com/user/status-images/).

The following gives instructions how to run test with Selenium against espn.go.com to validate the browser is on a page titled "NFL Scoreboard"
Test Case: Validation of browser on page titled "NFL Scoreboard"
Input Date: url: http://espn.go.com
Steps:
1. Open the Selenium IDE: Web developer in Firefox
2. Type the base url: http://espn.go.com in Selenium IDE window
3. Type the url: http://espn.go.com in Firefox browser
4. Resize both windows so they are seen on the screen.
5. In Selenium IDE, click on 'Record' button to start recording the test.
6. In Firefox browser, navigate to NFL > Scores link and click on it.
7. Click on 'Full Scoreboard' link and wait for page to open up.
8. Navigate to page title 'NFL Scoreboard' and right click
9. Choose option verifyText to validate the page title
10. In Selenium IDE, the Value 'NFL Scoreboard' is displayed.
11. Stop Recording.
12. Save test case as nflsb1
13. Click on Play current test case button to run the test and replicate the results.
14. In Selenium IDE, under the 'Log' tab, view the results to validate whether Test case passed or failed.
