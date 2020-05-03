package helpers;

import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;


public class ErrorHelper {


    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    public void checkField(String actualValue, String expectedValue){
        errorCollector.checkThat( actualValue, new StringContains(expectedValue));
    }

}
