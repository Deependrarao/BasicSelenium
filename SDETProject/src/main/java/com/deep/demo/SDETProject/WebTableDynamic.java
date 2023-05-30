package com.deep.demo.SDETProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDynamic {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Login
		WebElement userName = driver.findElement(By.id("input-username"));
		userName.sendKeys("demo");

		WebElement passWord = driver.findElement(By.id("input-password"));
		passWord.sendKeys("demo");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@id=\"modal-security\"]//div[1]/button")).click();

		//sales and orders
		driver.findElement(By.linkText("Sales")).click();
		driver.findElement(By.linkText("Orders")).click();

		//Find total number of pages in table
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(text); //showing  1 to 16 pages
		int Total_pages = Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		System.out.println("Total number of pages:=>"+Total_pages);

		for(int p=1; p<=5; p++) {
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li/span"));
			System.out.println("Active page:=>"+active_page.getText());
			//active_page.click();

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
			System.out.println("Number of rows:=>"+rows);
			
			//read all the rows from each page
			for(int r=1; r<=rows; r++) {
				String orderId = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[1]//td[2]")).getText();
				String store = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[4]//td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[6]//td[5]")).getText();
			
				System.out.println(orderId+ " "+store+ " "+status);
			}
			
			String pageno = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
		}
	}

}
