package com.deep.demo.SDETProject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBroswerWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		String WindowId= driver.getWindowHandle();       //return id of single browser window
		System.out.println(WindowId);
		
	}

}
