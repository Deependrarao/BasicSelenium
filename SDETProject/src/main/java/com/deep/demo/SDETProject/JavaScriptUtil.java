package com.deep.demo.SDETProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	//drawborder
	public static void drawBorder(WebElement element , WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}
	//title
	public static String getTitleByjs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	//click
	public static void clickElementByjs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	//alert
	public static void generateAlertByjs(WebDriver driver,String sms) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+sms+"')");
	}

	//refreshbrowser
	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}

	//ScrollingDown
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	//Scrollingup
	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

	//Zoom 
	public static void zoomPageByjs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='150%'");
	}

	//flash
	public static void flashByjs(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<=20; i++) {
			changeColor("red",element, driver);//1
			changeColor(bgcolor,element, driver);//1

		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + " ' ", element);

		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {
		}
	}
}
