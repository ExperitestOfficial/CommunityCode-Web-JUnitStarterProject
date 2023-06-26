import java.text.NumberFormat;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;

import java.net.URL;


public class WebExampleTest extends BaseTest {
	
	private RemoteWebDriver driver;
	
	@BeforeEach
	public void setUp() throws Exception {
		dc.setCapability("testName", "Web Example Test");
		dc.setCapability("accessKey", getAccessKey());
		
		/* Change this to run your test on different browsers. */
		dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		driver = new RemoteWebDriver(new URL(getCloudUrl(), "/wd/hub"), dc);
	}
	
	@Test
	public void browserTestGoogleSearch() {
		driver.get("https://master.dqb4f36jourft.amplifyapp.com/");
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		
		driver.findElement(By.xpath("//*[@data-auto='username']//input")).sendKeys("company");
		driver.findElement(By.xpath("//*[@data-auto='password']//input")).sendKeys("company");
		driver.findElement(By.className("login-button")).click();
		
		driver.findElement(By.xpath("//*[@data-auto='transfer-funds']")).click();
		
		driver.findElement(By.xpath("//input[@name='NAME']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@name='PHONE']")).sendKeys("1-234-5678");
		driver.findElement(By.xpath("//input[@name='AMOUNT']")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@name='COUNTRY']/..")).click();
		driver.findElement(By.xpath("//*[text()='INDIA']")).click();
		driver.findElement(By.xpath("//*[@data-auto='transfer-button']"));
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}
	
}