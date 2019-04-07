// COM DSL!
package test;

import java.util.List;

import static core.DriverFactory.getDriver;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BaseTest;
import core.DSL;

public class TesteCadastro extends BaseTest {

	private DSL dsl;

	@Before
	public void Inicializa() {
		getDriver().get("file:///C:/GitPush/SeleniumWebdriver/campos/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void Testcadastro() {

		List<String> lista = new ArrayList<String>();

		lista.add("Cadastrado!");
		lista.add("Tailon");
		lista.add("Saraiva");
		lista.add("Masculino");
		lista.add("Pizza");
		lista.add("2graucomp");
		lista.add("O que eh esporte?");
		lista.add("That's all folks!");

		/* **** INSERE INFORMA��ES **** */

		dsl.escreveCampo("elementosForm:nome", "Tailon");
		dsl.escreveCampo("elementosForm:sobrenome", "Saraiva");
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		dsl.selecionaCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.selecionaCombo("elementosForm:escolaridade", "2o grau completo");
		dsl.escreveCampo("elementosForm:sugestoes", "That's all folks!");
		dsl.clicaBotao("elementosForm:cadastrar");

		/* **** VERIFICAR INFORMA��ES **** */

		Assert.assertEquals(lista.get(0), dsl.obtemValorTexto(By.xpath("//*[@id='resultado']/span")));
		Assert.assertEquals(lista.get(1), dsl.obtemValorTexto(By.xpath("//*[@id='descNome']/span")));
		Assert.assertEquals(lista.get(2), dsl.obtemValorTexto(By.xpath("//*[@id='descSobrenome']/span")));
		Assert.assertEquals(lista.get(3), dsl.obtemValorTexto(By.xpath("//*[@id='descSexo']/span")));
		Assert.assertEquals(lista.get(4), dsl.obtemValorTexto(By.xpath("//*[@id='descComida']/span")));
		Assert.assertEquals(lista.get(5), dsl.obtemValorTexto(By.xpath("//*[@id='descEscolaridade']/span")));
		Assert.assertEquals(lista.get(6), dsl.obtemValorTexto(By.xpath("//*[@id='descEsportes']/span")));
		Assert.assertEquals(lista.get(7), dsl.obtemValorTexto(By.xpath("//*[@id='descSugestoes']/span")));
	}
}