package com.deep.demo.SDETProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement button = driver.findElement(By.xpath(" //span[contains(text(),'right click me')]"));
		Actions act = new Actions(driver);
		act.contextClick(button).perform(); //right click operation

		//drag and drop action
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement italy = driver.findElement(By.id("box106"));
		act.dragAndDrop(rome, italy).perform();


		//drag and drop image 
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement item1 = driver.findElement(By.xpath("//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//li[2]"));

		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		//moved both the item into trash
		act.dragAndDrop(item1, trash).perform();
		act.dragAndDrop(item2, trash).perform();

		//Mouse hover action
		driver.get("https://demo.opencart.com/");
		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement menuItem = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

		act.moveToElement(desktop).moveToElement(menuItem).click();
		driver.quit();
	}

}
