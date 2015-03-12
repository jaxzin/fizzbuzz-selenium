# Dependencies
from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Import actions (e.g. hovering)
from selenium.webdriver.common.action_chains import ActionChains

# Create a new instance of the Firefox driver
driver = webdriver.Firefox()

# Navigate to http://espn.go.com/
driver.get("http://espn.go.com/")

# Find the NFL parent menu item
parentElement = driver.find_element_by_name("&lpos=sitenavdefault&lid=sitenav_nfl")

# Hover over the NFL parent menu item
hov = ActionChains(driver).move_to_element(parentElement)
hov.perform()

# Find the Scores child menu item
childElement = driver.find_element_by_name("&lpos=sitenavdefault&lid=nfl_scores")

# Click the found link
childElement.click()

try:
    # we have to wait for the page to refresh, the last thing that seems to be updated is the title
    WebDriverWait(driver, 10).until(EC.title_contains("NFL"))

    # Verify the page title
    assert driver.title == 'NFL Football Teams, Scores, Stats, News, Standings, Rumors - National Football League - ESPN'

finally:
    driver.quit()