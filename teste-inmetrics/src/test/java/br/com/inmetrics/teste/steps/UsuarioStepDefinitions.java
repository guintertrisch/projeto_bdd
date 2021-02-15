package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.locators.CadastroDeUsuario;
import br.com.inmetrics.teste.locators.HomePage;
import br.com.inmetrics.teste.support.GeradorNumeroUsuario;
import br.com.inmetrics.teste.support.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class UsuarioStepDefinitions {


    public WebDriver driver;
    private HomePage homePage;
    private CadastroDeUsuario cadastroDeUsuario;

    @Before
    public void setUp() {
        WebDriverFactory browsers = new WebDriverFactory();
        driver = browsers.getDriver("chrome");
        cadastroDeUsuario = new CadastroDeUsuario(driver);
        homePage = new HomePage(driver);
        driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
    }

    @Given("que eu acesse o link Cadastre-se")
    public void clicarNoLinkCadastrese() {
        WebDriverFactory browsers = new WebDriverFactory();
        driver = browsers.getDriver("chrome");
        cadastroDeUsuario = new CadastroDeUsuario(driver);
        homePage = new HomePage(driver);
        driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
        homePage.clicarEmCadastrese();
    }

    @And("preencho os dados de usuário com valor {string}")
    public void preencherUsuario(String usuario) {
        cadastroDeUsuario.inserirNomeUsuario(usuario + GeradorNumeroUsuario.retornaNovoNumero());

    }

    @And("a senha com valor {string}")
    public void preencherSenha(String senha) {
        homePage.inserirSenha(senha);
    }

    @And("confirme a senha com o valor {string}")
    public void preencherConfirmeSenha(String senha) {
        cadastroDeUsuario.inserirConfirmacaoDeSenha(senha);
    }

    @And("clico em Cadastrar")
    public void clicarEmCadastrar() {
        cadastroDeUsuario.clicarEmCadastrar();
    }

    @Then("devo retornar para tela de {string}")
    public void verificaSeVoltouParaTelaDeLogin(String nomeFormEsperado) {
        assertEquals(homePage.retornaTextoLabelLogin(), nomeFormEsperado);
    }

    @Then("deve mostrar a seguinte mensagem de {string}")
    public void verificaSeLabelUsuarioJacadastradoFoiInformado(String mensagem) {
        assertEquals(cadastroDeUsuario.retornaLabelUsuarioJaCadastrado(), mensagem);
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

