package com.deep.demo.SDETProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        
        String year = "2023";
        String month = "Dec";
        String date = "14";
        
        driver.findElement(By.xpath("//label[@for='onward_cal']")).click(); //opens the date picker
        while(true)
        {
        	String monthyear= driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
        	
        	String arr[] = monthyear.split(" ");
        	String mnt   =  arr[0];
        	String yr    =  arr[1];
        	
        	if(mnt.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
        		break;
        	else
        		driver.findElement(By.xpath("//td[@class='next']/button")).click();
        }
        //date selection
        
        List<WebElement> alldate = driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]//td"));
		for(WebElement ele :alldate) {
			String dt = ele.getText();
			if(dt.equalsIgnoreCase(date)) {
				ele.click();
				break;
			}
		}
		
		
	}

}
