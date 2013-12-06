package br.com.caelum.agiletickets.models;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ReservaTest {
	
	@Test
	public void deveReservarIngressoSemDesconto() {
		
		WebDriver firefox = new FirefoxDriver();
		
		firefox.navigate().to("http://localhost:8080");
		
		List<WebElement> listaDeLi = firefox.findElements(By.tagName("a"));
		listaDeLi.get(12).click();
		
		WebElement qtde = firefox.findElement(By.id("qtde"));		
		qtde.sendKeys("1");
		qtde.submit();
		
		WebElement mensagem = firefox.findElement(By.id("message"));
		
		Assert.assertTrue(mensagem.getText().contains("sucesso"));
		
		
	}
	
}
