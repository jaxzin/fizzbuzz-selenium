from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
import unittest, time, re

class NavigateToNflScoreboard(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://espn.go.com/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_navigate_to_nfl_scoreboard(self):
        driver = self.driver
        driver.get("http://espn.go.com/")
        driver.find_element_by_name("&lpos=sitenavdefault&lid=sitenav_nfl").click()
        driver.find_element_by_link_text("Scores").click()
        self.assertEqual("NFL Football Scores - NFL Scoreboard - ESPN - ESPN", driver.title)
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException, e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException, e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
