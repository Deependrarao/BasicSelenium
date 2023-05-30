package com.deep.demo.SDETProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptDemo {
  static WebDriver driver;
	public static void main(String[] args) throws IOException, Exception {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        //drwaing border and take Screenshot
        WebElement LogoBorder = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
        JavaScriptUtil.drawBorder(LogoBorder,driver);
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("ScreenShot\\img.png");
        FileUtils.copyFile(src, target);
        
        //Getting title of the page
        String title = JavaScriptUtil.getTitleByjs(driver);
        System.out.println("Title of the page:=>"+title);
        
        //click action
        WebElement mobileLink = driver.findElement(By.linkText("Mobiles"));
        JavaScriptUtil.clickElementByjs(mobileLink, driver);
        
        //Generate alert 
        JavaScriptUtil.generateAlertByjs(driver, "This is my alert Hello Deep...");
        Alert alert= driver.switchTo().alert();
        alert.accept();
        
        //Refreshing the page
        JavaScriptUtil.refreshBrowser(driver);
        
        //Scrolling down the page
        JavaScriptUtil.scrollPageDown(driver);
        Thread.sleep(5000);
        
        //Scrolling up the page
        JavaScriptUtil.scrollPageUp(driver);
        
        //Zoom the page
        JavaScriptUtil.zoomPageByjs(driver);
        
        //Flash page
        WebElement sell = driver.findElement(By.linkText("Sell"));
        JavaScriptUtil.flashByjs(sell, driver);
        
	}

}
