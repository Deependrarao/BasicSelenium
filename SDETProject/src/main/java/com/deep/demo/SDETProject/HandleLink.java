package com.deep.demo.SDETProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Customer Service")).click();
		driver.findElement(By.partialLinkText("Service")).click();
		
		//how to capture all the link
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of the total links:=>"+links.size());
		
		//normal for loop
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
		driver.close();
	}

}
