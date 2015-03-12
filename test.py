##
# Core dependencies
#
from page_objects import PageObject, PageElement
from selenium import webdriver

##
# Additional dependencies
#
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

##
# Test Classes
#
class BasePage(object):
  url = None

  def __init__(self, driver):
    self.driver = driver

  def navigate(self):
    self.driver.get(self.url)

  def assertSectionTitle(self, title):
    sectionTitleElement = driver.find_element_by_css_selector(".espn-logo .section-title")
    assert sectionTitleElement.text == title

class HomePage(BasePage):
  url = "http://espn.go.com/"

  def clickScoresLink(self):
    parentElement = self.driver.find_element_by_name("&lpos=sitenavdefault&lid=sitenav_nfl")
    ActionChains(driver).move_to_element(parentElement).perform()
    driver.find_element_by_name("&lpos=sitenavdefault&lid=nfl_scores").click()

##
# Execute test
#
driver = webdriver.Firefox()
page = HomePage(driver)
page.navigate()
page.clickScoresLink()
WebDriverWait(driver, 10).until(EC.title_contains("NFL"))
page.assertSectionTitle('NFL Scoreboard')
driver.quit()