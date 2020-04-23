package helpers;

import io.qameta.allure.Step;
import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;


public class ErrorHelper {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();
    @Step("Сравнение результата")
    public void checkField(String actualValue, String expectedValue){
        errorCollector.checkThat( actualValue, new StringContains(expectedValue));
    }

}
