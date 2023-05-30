package com.deep.demo.SDETProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		WebElement dropDownele = driver.findElement(By.xpath("//p/select"));
		Select dropdown = new Select(dropDownele);
	
		//dropdown.selectByIndex(2); //Albania
		//dropdown.selectByValue("BGD");//Bangladesh
		//dropdown.selectByVisibleText("India");//india
		
	//selecting option from dropdown without using method
		List<WebElement> alloptions = dropdown.getOptions();
		for(WebElement allOption:alloptions) {
		  if(allOption.getText().equals("Spain")) {
			  allOption.click();
			  break;
		  }
		}
		
	}

}
