package component.steps;

import component.config.ConfigSpring;
import component.utils.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = ConfigSpring.class)
public class BaseSteps {

    @Before
    public void before() {
        Driver.getChromeDriver();
    }

    @After
    public void after() {
        Driver.closeDriver();}
}
