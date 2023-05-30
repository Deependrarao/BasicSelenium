package com.deep.demo.SDETProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {

	public static void main(String[] args) {
         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://jqueryui.com/tooltip/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.switchTo().frame(0);
         
        WebElement input_Box = driver.findElement(By.xpath("//input[@id='age']"));
        String toolTipText = input_Box.getAttribute("title");
        System.out.println("tooltip text in the input box:=>"+toolTipText);
	}

}
