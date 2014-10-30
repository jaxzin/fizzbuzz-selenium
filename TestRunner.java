import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestJunit.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
   }
} 

/*
This is a test created to check the page title of Scores in the espn website.
To Execute these tests and replicate the result
Create a work space for Juint /TestNg{Depends on which testing framework you prefer}

Using Test NG
C:\TestNG_WorkSpace/javac  CheckPageTitleNflScores.java
C:\java -cp "C:\TestNG_WORKSPACE" org.testng.TestNG testng.xml
 // testng.xml is the maven file we created to test include the test case.

Using Junit
C:\Junit_WorkSpace/javac  CheckPageTitleNflScores.java
C:\Junit_WORKSPACE\java TestRunner
*/
