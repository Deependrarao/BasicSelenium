package com.deep.demo.SDETProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);

		act.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);

		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);

		act.sendKeys(Keys.SPACE).perform();
		Thread.sleep(3000);

		act.sendKeys(Keys.HELP).perform();
		Thread.sleep(3000);

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

		input1.sendKeys("Welcome to my home Mr.Deepu");
		//CTRL + A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();

		//CTRL + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();

		//TAB  -shift two input2
		act.sendKeys(Keys.TAB);
		act.perform();

		//CTRL + V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();

		//compare text
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
			System.out.println("Text copied");
		else
			System.out.println("Text not copied");

		driver.quit();
	}

}
