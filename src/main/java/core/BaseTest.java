package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName(); // nome do teste q esta sendo
												// executado

	@After
	public void Fecha() throws IOException {

		capturaTela(testName);

		// logica para usar o mesmo browser em varios testes conforme
		// Propriedades.java
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

	public static void capturaTela(TestName testName) throws IOException {
		TakesScreenshot imagem = (TakesScreenshot) getDriver();
		File arquivo = imagem.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/evidencias/" + testName.getMethodName() + ".jpg"));

	}
}