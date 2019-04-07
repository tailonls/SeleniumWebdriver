package test;

import org.junit.Before;
import org.junit.Test;

import static core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;

public class TesteSincronismo {
	private DSL dsl;

	@Before
	public void Inicializa() {
		getDriver().get("file:///C:/Users/Tailon/workspace/cursoSelenium/campos/componentes.html");

		dsl = new DSL();
	}

	@Test
	public void testeEsperaFixa() throws InterruptedException {
		dsl.clicaBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escreveCampo("novoCampo", "Deu certo????");
	}

	@Test
	public void testeEsperaInplicita() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.clicaBotao("buttonDelay");
		dsl.escreveCampo("novoCampo", "Deu certo????");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	@Test
	public void testeEsperaExplicita() throws InterruptedException {
		dsl.clicaBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escreveCampo("novoCampo", "Deu certo????");

	}
}