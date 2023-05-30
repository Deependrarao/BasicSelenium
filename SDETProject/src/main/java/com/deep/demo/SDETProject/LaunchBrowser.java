package com.deep.demo.SDETProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LaunchBrowser {

	public static void main(String[] args) {
		//chromedrier launch 
       System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.google.com/");
       driver.close();
       //edgedriver launch
       System.setProperty("webdriver.edge.driver","D:\\edgedriver_win64\\msedgedriver.exe");
       WebDriver driver1 = new EdgeDriver();
       driver1.get("https://www.google.com/");
       driver1.close();
       
       //----using WebDriverManager--no need to download chromedriver and 
       //      edge driver driectly set provide by webdrivermanager
       WebDriverManager.chromedriver().setup();
       WebDriver driver2 = new ChromeDriver();
       driver2.get("https://www.google.com/");
       driver2.close();
       
       
       WebDriverManager.edgedriver().setup();
       WebDriver driver3 = new EdgeDriver();
       driver3.get("https://www.google.com/");
       driver3.manage().window().maximize();
       driver3.navigate().refresh();
       System.out.println("Title of the page:=>"+driver3.getTitle());
       System.out.println("Current URL of the page:=>"+driver3.getCurrentUrl());
       System.out.println("Pagesource of the page;=>"+driver3.getPageSource());
       driver3.close();
	}

}
