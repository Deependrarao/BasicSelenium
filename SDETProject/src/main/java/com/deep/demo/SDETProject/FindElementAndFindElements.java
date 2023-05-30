package com.deep.demo.SDETProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementAndFindElements {

	public static void main(String[] args) {		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();
        //FindElement() - return the single element
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        
        WebElement ele = driver.findElement(By.xpath("//div[@id='navFooter']//a"));
        System.out.println(ele.getText());
        
        //FindElements() - return the multipal element
       List<WebElement> elements = driver.findElements(By.xpath("//div[@id='navFooter']//a"));
	     System.out.println("Number of element captured:=>"+elements.size());
	     
	     for(WebElement link:elements) {
	    	 System.out.println(link.getText());
	     }
	     //if element not present then return zero elements
	     List<WebElement> elements1 = driver.findElements(By.xpath("//div[@id='navFoor']//a"));
	     System.out.println("Number of element captured:=>"+elements1.size());
	}

}
