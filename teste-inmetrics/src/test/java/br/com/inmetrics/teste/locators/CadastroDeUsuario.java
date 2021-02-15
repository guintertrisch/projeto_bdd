package br.com.inmetrics.teste.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroDeUsuario {

    private WebDriverWait wait;
    private By usuario = By.name("username");
    private By senha = By.name("pass");
    private By confirmarSenha = By.name("confirmpass");
    private By botaoCadastrar = By.xpath("/html/body/div/div/div/form/div[7]/button");
    private By labelUsuarioJaCadastrado = By.xpath("/html/body/div/div/div/form/div[1]/span/div");

    public CadastroDeUsuario(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 45);
    }

    private WebElement usuario() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(usuario));
    }

    private WebElement senha() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(senha));
    }

    private WebElement confirmarSenha() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmarSenha));
    }

    private WebElement botaoCadastrar() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(botaoCadastrar));
    }

    private WebElement labelUsuarioJaCadastrado() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(labelUsuarioJaCadastrado));
    }

    public void inserirNomeUsuario(String nomeUsuario) {
        usuario().sendKeys(nomeUsuario);
    }

    public void inserirSenha(String password) {
        senha().sendKeys(password);
    }

    public void inserirConfirmacaoDeSenha(String senhaConfirmacao) {
        confirmarSenha().sendKeys(senhaConfirmacao);
    }

    public void clicarEmCadastrar() {
        botaoCadastrar().click();
    }

    public String retornaLabelUsuarioJaCadastrado() {
        return labelUsuarioJaCadastrado().getText();
    }

}
