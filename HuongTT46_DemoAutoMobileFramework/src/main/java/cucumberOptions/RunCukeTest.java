package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunCukeTest {
    @CucumberOptions(
            features = "src\\main\\resources",
            glue = "steps",
            tags = "@TC_04"
    )
    public class CucumberRunner {
        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass
        public void beforeClass(){
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(dataProvider = "scenarios")
        public void test(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
            testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        }

        @DataProvider
        public Object[][] scenarios(){
            return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass
        public void afterClass(){
            testNGCucumberRunner.finish();
        }
    }
}
