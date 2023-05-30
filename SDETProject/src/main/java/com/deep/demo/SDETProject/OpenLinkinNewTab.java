package com.deep.demo.SDETProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkinNewTab {

	public static void main(String[] args) {
	     WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://jqueryui.com/tooltip/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         
         String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
         driver.findElement(By.linkText("Themes")).sendKeys(tab);
         
         //open url in new window
         driver.get("https://www.redbus.in/");
         driver.switchTo().newWindow(WindowType.TAB);
         driver.get("https://www.redbus.in/railways");
	}

}
