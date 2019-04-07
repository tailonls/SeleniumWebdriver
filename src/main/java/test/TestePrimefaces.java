package test;

import static core.DriverFactory.getDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.DSL;

public class TestePrimefaces {

	private DSL dsl;

	@Before
	public void Inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL();
	}

	@Test
	public void testaComboPrime() {

		dsl.clicarRadio(By.xpath("//*[@id='j_idt117:console_input']/../..//span"));
		dsl.clicarRadio(By.xpath("//*[@id='j_idt117:console_items']//li[.='PS4']"));
	}
}