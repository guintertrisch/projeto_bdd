package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.locators.CadastroDeUsuario;
import br.com.inmetrics.teste.locators.HomePage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class UsuarioStepDefinitions {

    public WebDriver driver;
    public HomePage homePage;
    public CadastroDeUsuario cadastroDeUsuario;

    public UsuarioStepDefinitions() {
        this.driver = Hooks.webDriver;
        this.cadastroDeUsuario = new CadastroDeUsuario(this.driver);
        this.homePage = new HomePage(this.driver);
    }

    @Quando("preencho os dados de cadastro {string} , {string}, {string}")
    public void preencho_os_dados_de_cadastro(String usuario, String password, String confirmpassword) {
        homePage.clicarEmCadastrese();
        cadastroDeUsuario.inserirNomeUsuario(usuario);
        cadastroDeUsuario.inserirSenha(password);
        cadastroDeUsuario.inserirConfirmacaoDeSenha(confirmpassword);

    }

    @E("clico em Cadastrar")
    public void clico_em_cadastrar() {
        cadastroDeUsuario.clicarEmCadastrar();
    }

    @Entao("devo voltar para tela de login")
    public void devo_voltar_para_tela_de_login() {
        assertEquals("Login", homePage.retornaTextoLabelLogin());
    }


}
