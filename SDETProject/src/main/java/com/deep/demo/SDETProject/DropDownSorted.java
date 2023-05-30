package com.deep.demo.SDETProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSorted {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();// Live Posting
		WebElement dropDownele = driver.findElement(By.name("category_id"));
		Select dropSel = new Select(dropDownele);
		List<WebElement> options = dropSel.getOptions();

		ArrayList originalList = new ArrayList();
		ArrayList templList = new ArrayList();

		for (WebElement option : options) {
			originalList.add(option.getText());
			templList.add(option.getText());
		}
		System.out.println("OriginalList:=>" + originalList);
		System.out.println("TemplList:=>" + templList);

		Collections.sort(templList); // sorting

		System.out.println("OriginalList after sorting:=>" + originalList);
		System.out.println("TemplList after sorting:=>" + templList);

		if (originalList.equals(templList))
			System.out.println("Dropdown sorted");
		else
			System.out.println("Dropdown not sorted");

	}

}
