package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CriarUsuariosStepDefinitions {

	WebDriver driver;
	
	@Dado("Acessar a página de cadastro de usuário")
	public void passo1() {

		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa02");
	}

	@E("Informar o nome do usuário {string}")
	public void passo2(String nome) {

		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome);
	}

	@E("Informar o email do usuário {string}")
	public void passo3(String email) {
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
	}

	@E("Informar a senha do usuário {string}")
	public void passo4(String senha) {

		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys(senha);
	}

	@E("Confirmar a senha do usuário {string}")
	public void passo5(String senha) {

		driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys(senha);
	}

	@Quando("Solicitar a realização do cadastro")
	public void passo6() {

		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Então("Sistema cadastra o usuário com sucesso")
	public void passo7() {

		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Conta de usuário cadastrada com sucesso.");
		
		try {
			
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Criar usuário com sucesso.png"));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		driver.close();
	}
}
