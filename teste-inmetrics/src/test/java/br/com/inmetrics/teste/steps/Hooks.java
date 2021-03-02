package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.support.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver webDriver;
    public String baseURL = "https://inm-test-app.herokuapp.com/accounts/login/";


    @Before
    public void setUp() {
        WebDriverFactory browsers = new WebDriverFactory();
        webDriver = browsers.getDriver("chrome");
        webDriver.get(baseURL);

    }

    @After
    public void closeBrowser(Scenario cenario) {
        byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        cenario.attach(screenshot, "image/png", "name");
       /* if (cenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            cenario.attach(screenshot, "image/png", "name");
        }*/
        webDriver.quit();
    }
}
