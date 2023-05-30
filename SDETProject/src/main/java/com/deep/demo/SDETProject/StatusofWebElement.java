package com.deep.demo.SDETProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		//isDispalyed or isEnabled 
		WebElement searchBox = driver.findElement(By.xpath("//h5[contains(text(),'Element')]"));
		System.out.println("Display status:=>"+searchBox.isDisplayed());
		System.out.println("Display status:=>"+searchBox.isEnabled());

		driver.get("https://demoqa.com/elements");
		//isSelected radio button
		WebElement textBoxBtn = driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]"));
		textBoxBtn.click();
		WebElement radioBtn = driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
		System.out.println("Radio button isSelected:=>"+radioBtn.isSelected());
		radioBtn.click();
		System.out.println("Radio button isSelected:=>"+radioBtn.isSelected());
		radioBtn.clear();
		WebElement radioBtn2 = driver.findElement(By.xpath(" //label[contains(text(),'Impressive')]"));
		radioBtn2.click();
		System.out.println("Radio btn is selected:=>"+radioBtn2.isSelected());
	}

}
