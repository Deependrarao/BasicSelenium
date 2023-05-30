package com.deep.demo.SDETProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenLinks=0;
		for(WebElement link:links) {			
			String url = link.getAttribute("href");
			if(url==null || url.isEmpty()) {
				System.out.println("Url is empth");
				continue;
			}
			URL u =new URL(url);
			try {
				HttpURLConnection httpcon = (HttpURLConnection) u.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400) {
					System.out.println(httpcon.getResponseCode()+url+" is"+"Broken links");
					brokenLinks++;
				}
				else
				{
					System.out.println(httpcon.getResponseCode()+url+"is"+"valid link");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("number of brokenlinks:=>"+brokenLinks);
		driver.quit();
	}

}
