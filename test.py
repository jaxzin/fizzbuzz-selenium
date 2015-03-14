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
from sauceclient import SauceClient

# Import os for use of environmental variables
import os

# Start Saucelabs connection
sauce_url = "http://betweenbrain:e2007f7b-afd4-43a3-af7f-c5087c82199a@ondemand.saucelabs.com:80/wd/hub"

desired_capabilities = {
    'platform': "Windows 8",
    'browserName': "firefox",
    'version': "36",
}

driver = webdriver.Remote(desired_capabilities=desired_capabilities,
                          command_executor=sauce_url)
driver.implicitly_wait(10)
# End Saucelabs connection

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
page = HomePage(driver)
page.navigate()
page.clickScoresLink()
WebDriverWait(driver, 10).until(EC.title_contains("NFL"))
page.assertSectionTitle('NFL Scoreboard')
driver.quit()

# Report test results back to Sauce Labs
sauce_client = SauceClient("betweenbrain", "e2007f7b-afd4-43a3-af7f-c5087c82199a")
sauce_client.jobs.update_job(driver.session_id, passed=True, name=os.environ["TRAVIS_BUILD_NUMBER"])