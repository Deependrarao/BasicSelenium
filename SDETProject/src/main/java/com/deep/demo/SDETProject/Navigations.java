package com.deep.demo.SDETProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com/");
        driver.navigate().back();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("https://www.snapdeal.com/");
       driver.quit();       
        

	}

}
