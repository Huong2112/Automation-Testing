package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/main/resources/feature",
        glue = "stepDefinitions",
        //tags = "@TC_01 or @TC_02 or @TC_03 or @TC_04 or @TC_05 or @TC_06 or @TC_07"
        //tags = "@TC_01"
        //tags = "@TC_02"
        //tags = "@TC_03"
        tags = "@TC_04"
        //tags = "@TC_05"
        //tags = "@TC_06"
        //tags = "@TC_07"
)
public class CucumberRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void beforeClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "scenarios")
    public void test(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void afterClass() {
        testNGCucumberRunner.finish();
    }
}

