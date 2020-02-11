package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", // feature package path
		glue = "stepDefinations") // step definition package name

public class TestRunner extends AbstractTestNGCucumberTests {

}
