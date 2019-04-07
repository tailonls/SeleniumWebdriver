package test;

import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;

public class TesteAjax {
	private DSL dsl;
	
	@Before
	public void Inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		
		dsl = new DSL();
	}
	
	@Test
	public void TestaCampoAjax(){
		dsl.escreveCampo("j_idt116:name", "Esse � meu texto!");
		dsl.clicaBotao("j_idt116:j_idt119");
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(  ExpectedConditions.textToBe(By.id("j_idt116:display"), "Esse � meu texto!"));
		
		Assert.assertEquals("Esse � meu texto!", dsl.obtemValorTexto("j_idt116:display"));
	}
}