package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.locators.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginStepDefinitions {
    public WebDriver driver;
    public HomePage homePage;

    public LoginStepDefinitions() {
        this.driver = Hooks.webDriver;
        this.homePage = new HomePage(this.driver);
    }

    @And("clico em Entre")
    public void clicarNoBotaoEntre() {
        homePage.clicarEmEntre();
    }


    @And("senha {string}")
    public void clicarNoBotaoEntre(String senha) {
        homePage.inserirSenha(senha);
    }

    @Entao("devo entrar na tela de listagem de funcionarios")
    public void devo_entrar_na_tela_de_listagem_de_funcionarios() {
        assertEquals("FUNCIONÁRIOS", homePage.retornaLabelFuncionarios());
    }

    @Quando("preencho os dados de {string} e {string}")
    public void preencho_os_dados_de_e(String login, String password) {
        homePage.inserirNomeUsuario(login);
        homePage.inserirSenha(password);

    }


}


