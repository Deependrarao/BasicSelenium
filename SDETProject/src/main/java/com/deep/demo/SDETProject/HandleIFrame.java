package com.deep.demo.SDETProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrame {

	public static void main(String[] args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://docs.oracle.com/javase/8/docs/api/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
       //1st frame
       driver.switchTo().frame("packageListFrame");//name of the frame
       driver.findElement(By.xpath("//ul[1]/li[17]/a[1]")).click();
       driver.switchTo().defaultContent();//go back to main window
       Thread.sleep(3000);
       
       //2nd frame
       driver.switchTo().frame("packageFrame");
       driver.findElement(By.xpath("//ul[1]/li[3]/a/span")).click();
       driver.switchTo().defaultContent();
       Thread.sleep(3000);
       
       
       //3rd frame
       driver.switchTo().frame("classFrame");
       driver.findElement(By.xpath("//div[1]/ul/li[1]/a")).click();
      
	}

}
