// COM DSL!
package test;

import static core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BaseTest;
import core.DSL;

public class TesteCampoTreinamento extends BaseTest {
	private DSL dsl;

	@Before
	public void Inicializa() {
		getDriver().get("file:///C:/Users/Tailon/workspace/cursoSelenium/campos/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void testeTextField() {
		dsl.escreveCampo(By.xpath("//input[@id='elementosForm:nome']"), "Testando esse campo...");
		// dsl.escreveCampo("elementosForm:nome", "Testando esse campo...");
		Assert.assertEquals("Testando esse campo...", dsl.obterValorCampo("elementosForm:nome"));
	}

	@Test
	public void testeTextArea() {
		dsl.escreveCampo("elementosForm:sugestoes", "Testando...");
		Assert.assertEquals("Testando...", dsl.obterValorCampo("elementosForm:sugestoes"));
	}

	@Test
	public void testeCheckbox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.verificaRadioClicado("elementosForm:comidaFavorita");
	}

	@Test
	public void testeCombo() {
		dsl.selecionaCombo("elementosForm:escolaridade", "Doutorado");
		Assert.assertEquals("Doutorado", dsl.obtemValorCombo("elementosForm:escolaridade"));
	}

	@Test
	public void testeBotao() {
		dsl.clicaBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obtemValorBotao("buttonSimple"));
	}

	@Test
	public void testeLink() {
		dsl.clicaLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obtemValorLink("resultado"));
	}

	@Test
	public void testeTexto() {
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				dsl.obtemValorTexto(By.className("facilAchar")));
	}

	@Test // Testando com JavaScript
	public void testeJavaScript() {
		dsl.executaJavaScript("document.getElementById('elementosForm:nome').value = 'testando js nesse campo...'");
		dsl.executaJavaScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
	}

	@Test
	public void testeFrameEscondido() {
		dsl.entrarFrame("frame1");
		dsl.clicaBotao("frameButton");
		String msg = dsl.obtemTextoEAceitaAlert();
		Assert.assertEquals("Frame OK!", msg);
	}
}