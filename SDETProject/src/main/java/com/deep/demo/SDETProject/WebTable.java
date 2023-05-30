package com.deep.demo.SDETProject;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//how many rows in table
		int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println("Total number of rows:=>"+rows);

		//how many columns in table
		int cols = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		System.out.println("Total number of columns:=>"+cols);

		//retrieve the specific row/clounm data
		String value = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[5]/td[3]/span")).getText();
		System.out.println("the value of:=>"+value);

		//retrieve all the data from the table
		for(int r=2; r<=rows; r++) {
			for(int c=1; c<=cols; c++) {
				String data = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+r+"]/td["+c+"]/span")).getText();
				System.out.print(data+" ");
			}
			System.out.println();
		}
      driver.quit();
	}

}
