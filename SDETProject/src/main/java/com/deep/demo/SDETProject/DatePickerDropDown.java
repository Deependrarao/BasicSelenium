package com.deep.demo.SDETProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.linkText("BUY TICKET")).click();

		driver.findElement(By.id("dob")).click();//open the date picker

		Select month_drop= new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]")));
		month_drop.selectByVisibleText("Dec");

		Select year_drop = new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")));
		year_drop.selectByVisibleText("1994");

		String date = "7";

		List<WebElement> alldate = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td"));
		for(WebElement ele :alldate) {
			String dt = ele.getText();
			if(dt.equalsIgnoreCase(date)) {
				ele.click();
				break;  
			}
		}
		driver.quit();
	}

}
