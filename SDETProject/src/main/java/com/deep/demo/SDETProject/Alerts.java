package com.deep.demo.SDETProject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//alert window with ok button
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		//alert window time with ok button
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		//alert window ok with cancel button
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		
		//alert window with input box capture text from alert
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(5000);
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("the message display on alert:=>"+alertWindow.getText());
		alertWindow.sendKeys("dipurao");
		Thread.sleep(5000);
		alertWindow.accept();
		driver.quit();
	}

}
