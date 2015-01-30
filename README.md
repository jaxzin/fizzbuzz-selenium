fizzbuzz-selenium
=================

This is a QA engineering example. Please perform the following steps:

1. [Fork this repository](https://help.github.com/articles/fork-a-repo)
1. [Create a new branch](https://github.com/blog/1377-create-and-delete-branches)
1. Implement a simple interaction test with Selenium against espn.go.com.
  1. Your test should navigate to NFL > Scores link, click on it, and validate the browser is now on a page titled "NFL Scoreboard".
1. [Create a pull request](https://help.github.com/articles/creating-a-pull-request) and include instructions in the summary on how to run the test and replicate your results.
1. [Setup your fork for continuous integration](http://docs.travis-ci.com/user/languages/java/) using https://travis-ci.org/ and then update this README so it [includes the Travis build status image](http://docs.travis-ci.com/user/status-images/).

=============================================================================
[Varun - GALLOP]

Findings:

- [Fork this repository] - DONE
- [Create a new branch] - Created a new branch - create-ESPN
- Written the selenium script for the given scenario
- [Create a pull request] - Done
- [Setup your fork for continuous integration] -
                 - Created an environment in Travis to run selenium test using ANT
                 - 
        [Issue]  - I have latest version of Selenium.jar but still script execution is failing due to Firefox version and Selenium.jar version mismatch.
                  I don't have the access to Linux environment where exactly i can work on the failures.
