package Depot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Login {

    WebDriver driver;

    @Test(dataProvider = "LoginData")
    public void testLogin(String username, String password) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        // Setup ChromeDriver (using WebDriverManager, this could be automated)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open login page
        driver.get("https://itdevenv.co.za/DEPOT/login");

        // Enter username and password from DataProvider
//        driver.findElement(By.id("username")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//        
//        // Click login button
//        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.name("EmailAddress")).sendKeys(username);  
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class=\"login-btn\"]")).click();
        Thread.sleep(5000);
        PurchaseOrder driverp =new PurchaseOrder();
        driverp.order();
        // Add assertion logic here
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Close browser
        driver.quit();
    }

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        FileInputStream file = new FileInputStream("src/test/resources/LoginData.xlsx");

        // Create Workbook instance
        Workbook workbook = new XSSFWorkbook(file);
        
        // Get sheet
        Sheet sheet = workbook.getSheet("Sheet1");
        
        // Get the number of rows and columns
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();
        
        Object[][] loginData = new Object[rows - 1][cols];  // Exclude header row
        
        for (int i = 1; i < rows; i++) {  // Start from row 1 to skip header
            for (int j = 0; j < cols; j++) {
                loginData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        workbook.close();
        return loginData;
    }
}




