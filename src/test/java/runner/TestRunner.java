package runner;

import org.junit.runner.RunWith;

import tests.TestBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(features="src/test/java/features/Dashboard.feature"
,glue= {"tests"}
,plugin= {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase{


}
