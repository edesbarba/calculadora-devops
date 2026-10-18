
package br.edu.exemplo.calculadora.aceitacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CalculadoraAceitacaoIT {

    @LocalServerPort
    private int porta;

    private WebDriver navegador;

    @BeforeEach
    void abrirCalculadora() {
        ChromeOptions opcoes = new ChromeOptions();

        if (Boolean.getBoolean("selenium.headless")) {
            opcoes.addArguments("--headless=new");
        }

        navegador = new ChromeDriver(opcoes);
        navegador.get("http://localhost:" + porta + "/");
    }

    @AfterEach
    void fecharNavegador() {
        if (navegador != null) {
            navegador.quit();
        }
    }

    private void preencherECalcular(
            String primeiro, String segundo, String operacao) {

        navegador.findElement(By.id("numero1"))
                 .sendKeys(primeiro);

        navegador.findElement(By.id("numero2"))
                 .sendKeys(segundo);

        new Select(navegador.findElement(By.id("operacao")))
                 .selectByValue(operacao);

        navegador.findElement(By.id("botao-calcular")).click();
    }

    @Test
    @DisplayName("AT01 - Somar pela interface web")
    void deveSomarPelaInterface() {
        preencherECalcular("10", "5", "somar");

        String resultado = new WebDriverWait(
                navegador, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.id("resultado")))
            .getText();

        assertEquals("15.0", resultado);
    }

    @Test
    @DisplayName("AT02 - Dividir pela interface web")
    void deveDividirPelaInterface() {
        preencherECalcular("10", "5", "dividir");

        String resultado = new WebDriverWait(
                navegador, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.id("resultado")))
            .getText();

        assertEquals("2.0", resultado);
    }

    @Test
    @DisplayName("AT03 - Mostrar erro ao dividir por zero")
    void deveMostrarErroDeDivisaoPorZero() {
        preencherECalcular("10", "0", "dividir");

        String mensagem = new WebDriverWait(
                navegador, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.id("mensagem-erro")))
            .getText();

        assertEquals(
            "Não é possível dividir por zero.", mensagem);
    }
}
