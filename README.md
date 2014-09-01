fizzbuzz-selenium
Update From Jayant: 09/01/2014
--------------
Assumption:
1. Java 6.0 or above is installed on machine to execute the script

2. Maven is installed and a env variable "M2" is set correctly.

3. Chrome browser is installed on the machine.

4. Tested with Windows machine. Not sure if it will work with other Operating system without any change.

5. Assignement says to verify the tiletle as "NFL Scoreboard" while the actuall title of the page was "NFL Football Scores - NFL Scoreboard - ESPN - ESPN" . Hence I added the correct validation. 

------------------
Steps to execute:

1. Clone the update fizzbuzz-selenium in eclipse

2. Right click on NFLScore.java file and select JUnit to execute the script.

-----------------------------
Details on assignment completions:

1. I have used Java for scripting the automation

2. I have created a page object pattern of frame work for this one script. I understand that for 1 script this may not be required but i assumed that the intention of this assignment was to judge me on the various concepts of framework and using git, hence is chose to create all different packages.

3. We could have added lots of extra feature like reporting and reading form data source but with the limited time, i did not attempt to do this

4. I do not have any knowledge working on https://travis-ci.org/ , hence did not attempt that




fizzbuzz-selenium
=================

This is a QA engineering example. Please perform the following steps:

1. Fork this repository
1. Create a new branch
1. Implement a simple interaction test with Selenium against espn.go.com.
1. Your test should navigate to NFL > Scores link and validate the browser is now on a page titled "NFL Scoreboard".
1. Create a pull request and include instructions in the summary on how to run the test and replicate your results.
1. Bonus points for getting your fork running on https://travis-ci.org/ and update this README so it includes the build status image.
