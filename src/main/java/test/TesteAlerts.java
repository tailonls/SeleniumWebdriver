// COM DSL!
package test;

import org.junit.Test;

import core.BaseTest;
import core.DSL;

import static core.DriverFactory.getDriver;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;

public class TesteAlerts extends BaseTest {
	private DSL dsl;

	@Before
	public void Inicializa() {
		getDriver().get("file:///C:/Users/Tailon/workspace/cursoSelenium/campos/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void TesteAlertSimples() throws IOException {
		dsl.clicaBotao("alert");
		String texto = dsl.obtemTextoEAceitaAlert();
		Assert.assertEquals("Alert Simples", texto);
		dsl.escreveCampo("elementosForm:nome", texto);
	}

	@Test
	public void TesteAlertPrompt() {
		dsl.clicaBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.obtemTextoAlert());
		dsl.escreveAlertPrompt("12");
		Assert.assertEquals("Era 12?", dsl.obtemTextoEAceitaAlert());
		Assert.assertEquals(":D", dsl.obtemTextoEAceitaAlert());
	}
}