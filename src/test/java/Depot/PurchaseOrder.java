package Depot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseOrder {
	@SuppressWarnings("null")
	public void order() throws InterruptedException
	{
	
	WebDriver driver = null;
	
	driver.findElement(By.xpath("((//div[contains(@class, 'module-item')])[3]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement element=driver.findElement(By.xpath("//label[@class=\"nav-label\" and text()='Order Create & Delivery Accept']//../.."));
	//Element.click();
//	WebElement element = driver.findElement(By.id("yourElement"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	WebElement element1 =driver.findElement(By.xpath("//a[@href=\"/DEPOT/purchaseorder\"]"));
	js.executeScript("arguments[0].click();", element1);
	//Actions actions = new Actions(driver);

	//actions.moveToElement(element1).click().perform();
	
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
	//driver.findElement()
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Thread.sleep(5000);
	//driver.quit();
}
}
