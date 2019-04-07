package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	public void escreveCampo(By by, String texto){
		getDriver().findElement( by ).sendKeys(texto); 
	}
	
	public void escreveCampo(String id, String texto){
		escreveCampo(By.id(id), texto);

	}
	
	public String obterValorCampo(String id){
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public void clicarRadio(By by){
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id){
		clicarRadio( By.id(id) );
	}
	
	public boolean verificaRadioClicado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void selecionaCombo(String id, String valor){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);	
		combo.selectByVisibleText(valor);
	}	
	
	public String obtemValorCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);	
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicaBotao(String id){
		getDriver().findElement( By.id(id) ).click();
	}
	
	public String obtemValorBotao(String id){
		return getDriver().findElement( By.id(id) ).getAttribute("value");
		
	}
	
	public void clicaLink(String id){
		getDriver().findElement( By.linkText(id) ).click();
	}
	
	public String obtemValorLink(String id){
		return getDriver().findElement( By.id(id) ).getText();		
	}
	
	public String obtemValorTexto(String id){
		return obtemValorTexto(By.id(id));
	}
	
	public String obtemValorTexto(By by){
		return getDriver().findElement( by ).getText();
	}
	
	/* *** ALERTS ********************** */
	
	public String obtemTextoAlert(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String obtemTextoEAceitaAlert(){
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}
	
	public void escreveAlertPrompt(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocaJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
/********* JavaScript************/
		
	public Object executaJavaScript(String cmd, Object... param){
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		return js.executeScript(cmd, param);	
	}
}