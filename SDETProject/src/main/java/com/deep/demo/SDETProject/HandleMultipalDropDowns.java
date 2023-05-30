package com.deep.demo.SDETProject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipalDropDowns {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		 driver.manage().window().maximize();
		//first approach
		//		Select product = new Select(driver.findElement(By.xpath("//select[@id='first']")));
		//		product.selectByIndex(1); //Google
		//
		//		Select animal = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		//		animal.selectByVisibleText("Avatar");
		//		
		//        Select fooddrop = new Select(driver.findElement(By.xpath("//select[@id='second']")));
		//        fooddrop.selectByVisibleText("Pizza");

		//second approach by using create own method
		 WebElement product = driver.findElement(By.xpath("//select[@id='first']"));
		selecOptionDropFromDown(product,"Google");
		WebElement animal  = driver.findElement(By.xpath("//select[@id='animals']"));
		selecOptionDropFromDown(animal,"Avatar");
        WebElement food	   = driver.findElement(By.xpath("//select[@id='second']"));
		selecOptionDropFromDown(food,"Pizza");


	}
	
	
	public static void selecOptionDropFromDown(WebElement ele ,String value) {
		Select dropDown = new Select(ele);
		List<WebElement> allOptions = dropDown.getOptions();

		for(WebElement option:allOptions) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
