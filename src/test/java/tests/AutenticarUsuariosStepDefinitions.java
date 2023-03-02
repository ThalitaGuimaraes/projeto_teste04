package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AutenticarUsuariosStepDefinitions {

	WebDriver driver;
	
	@Dado("Acessar a página de autenticação")
	public void passo1() {
		
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa01");
	}
	
	@E("Informar o email {string}")
	public void passo2(String email) {
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
	}
	
	@E("Informar a senha {string}")
	public void passo3(String senha) {
		
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys(senha);
	}
	
	@Quando("Solicitar a realização do acesso")
	public void passo4() {
		
		driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]")).click();
	}
	
	@Então("Sistema autentica o usuário com sucesso")
	public void passo5() {
		
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Autenticação realizada com sucesso.");
	}
	
}
