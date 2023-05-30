package com.deep.demo.SDETProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextGetAttributeValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement EmailBox = driver.findElement(By.id("Email"));
		EmailBox.clear();
		EmailBox.sendKeys("admin@yourstore.com");
		System.out.println("Result from getAttribute() method:=>"+EmailBox.getAttribute("value"));
		System.out.println("Result from getText() method:=> "+EmailBox.getText());

		WebElement pwdBox = driver.findElement(By.id("Password"));
		pwdBox.clear();
		pwdBox.sendKeys("admin");
		String title = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(title);
		System.out.println("Result from getAttribute() method:=>"+pwdBox.getAttribute("value"));
		System.out.println("Result from getText() method:=> "+pwdBox.getText());

		driver.findElement(By.xpath("//button")).click();


	}

}
