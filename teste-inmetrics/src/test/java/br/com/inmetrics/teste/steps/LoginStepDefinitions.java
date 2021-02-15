package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.locators.HomePage;
import br.com.inmetrics.teste.support.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;


    /*@Before
    public void setUp() {
        WebDriverFactory browsers = new WebDriverFactory();
        driver = browsers.getDriver("chrome");
        homePage = new HomePage(driver);
        driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
    }*/


    @And("clico em Entre")
    public void clicarNoBotaoEntre() {
        homePage.clicarEmEntre();
    }

    @When("preencho nome do usuario como {string}")
    public void preencherUsuarioLogin(String nome) {
        WebDriverFactory browsers = new WebDriverFactory();
        driver = browsers.getDriver("chrome");
        homePage = new HomePage(driver);
        driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
        homePage.inserirNomeUsuario(nome);
    }


    @And("senha {string}")
    public void clicarNoBotaoEntre(String senha) {
        homePage.inserirSenha(senha);
    }

    @Then("devo entrar na tela listagem de {string}")
    public void deveApresentarTelaDeFuncionarios(String labelFuncionario) {
        assertEquals(homePage.retornaLabelFuncionarios(), labelFuncionario);
    }

    @After
    public void closeBrowser(Scenario cenario) {

        if (cenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            cenario.attach(screenshot, "image/png", "name");
            driver.quit();
        } else {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            cenario.attach(screenshot, "image/png", "name");
            driver.quit();
        }
    }

}
