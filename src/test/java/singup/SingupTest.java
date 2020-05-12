package singup;




import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


class SingupTest {
	private  WebDriver driver;
	
	private  String url = "https://www.organizze.com.br/";
	
	private String email = "teste20@great.com";
	private String passwd = " testaut2020";
	
	private String expectedHeaderResult = "Parab�ns! O Organizze j� est� preparado para voc�!";
	private String expectedBodyResult = "Enviamos um e-mail para sua caixa de entrada. Confirme seu cadastro para receber um e-mail importante da nossa equipe.";
	private String expectedButtonResult = "Ok, come�ar agora";
	
	@BeforeEach
	 void setUp() {
		System.out.println("Starting test...");
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	@AfterEach
	 void tearDown() {
		System.out.println("Ending test...");
		
		//driver.quit();
	}
	
	@Test
	void TestCase() throws InterruptedException{
		driver.get(url);
		
		WebElement singButton = driver.findElement(By.className("btn-transparent-gray"));
		singButton.click();
		
		WebElement option = driver.findElement(By.className("green"));
		option.click();
		
		WebElement mailInput = driver.findElement(By.id("email"));
		mailInput.sendKeys(email);
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement passwordConfirmationInput = driver.findElement(By.id("passwordConfirmation"));
		
		passwordInput.sendKeys(passwd);
		passwordConfirmationInput.sendKeys(passwd);
		
		WebElement checkbox = driver.findElement(By.id("termsOfUse"));
		checkbox.click();
		
		
		WebElement submitButton = driver.findElement(By.className("btn-primary"));
		submitButton.click();

		Thread.sleep(10000);
		
		WebElement resultHeader = driver.findElement(By.className("signup__success-box")).findElement(By.className("signup__status-title"));
		WebElement resultBody = driver.findElement(By.className("signup__success-box")).findElement(By.className("text-gray"));
		WebElement resultButton = driver.findElement(By.className("signup__success-box")).findElement(By.className("btn"));
		
		
		assertTrue("The message title doesn't look how expected",expectedHeaderResult.equals(resultHeader.getText()));
		assertTrue("The message doesn't look how expected",expectedBodyResult.equals(resultBody.getText()));
		assertTrue("The button doesn't look how expected",expectedButtonResult.equals(resultButton.getText()));
				

		
	}

}
