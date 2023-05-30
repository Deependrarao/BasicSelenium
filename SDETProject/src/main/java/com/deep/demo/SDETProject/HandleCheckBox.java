package com.deep.demo.SDETProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");

		//      //1.select specific checkbox
		//       WebElement checkBox = driver.findElement(By.xpath("//input[@value='red']"));
		//       checkBox.click();
		//       
		//    //2. select all the checkbox 
		//       List<WebElement> checkBoxs = driver.findElements(By.xpath("//input[@name='color']"));
		//       System.out.println("all the color checkbox:=>"+checkBoxs.size());
		//       for(WebElement ckBox :checkBoxs) {
		//    	   ckBox.click();
		//       }

		//3. select multiple checkBox by choice
//		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@name='color']"));
//		for(WebElement ckBox :checkBox) {
//			String checkBoxcolor = ckBox.getAttribute("value");
//			if(checkBoxcolor.equals("red") || checkBoxcolor.equals("yellow") || checkBoxcolor.equals("blue") ) {
//				ckBox.click();
//			}
			
		//4. select last two checkbox
		  List<WebElement> ckBox = driver.findElements(By.xpath("//input[@name='color']"));
		  int totalBox = ckBox.size();
		  for(int i=totalBox-3;i<totalBox;i++) {
			  ckBox.get(i).click();
		}
	}

}
