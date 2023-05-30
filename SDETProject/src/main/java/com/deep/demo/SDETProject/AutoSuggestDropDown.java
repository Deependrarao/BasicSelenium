package com.deep.demo.SDETProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.bing.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        Thread.sleep(3000);
       List<WebElement> lists = driver.findElements(By.xpath("//li[@role='option']//span"));
       System.out.println("size of auto suggestion:=> "+lists.size());
       for(WebElement list:lists) {
    	   if(list.getText().contains("dev")) {
    		   list.click();
    		   break;
    	   }
       }
      
	}
}
