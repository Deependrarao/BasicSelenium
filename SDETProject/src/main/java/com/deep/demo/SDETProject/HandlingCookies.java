package com.deep.demo.SDETProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//How to capture cookies from browser?
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of the cookies:=>"+cookies.size());//6

		//How to print cookies from browser?
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}

		//How to add cookie to the browser?
		Cookie cookieobj = new Cookie("MyCookie123","123456");
		driver.manage().addCookie(cookieobj);

		cookies = driver.manage().getCookies();
		System.out.println("Size of the cookies after adding:=>"+cookies.size());//7

		//How to delete specific cookie from the browser?
		// driver.manage().deleteCookie(cookieobj);
		driver.manage().deleteCookieNamed("MyCookie123");
		cookies = driver.manage().getCookies();
		System.out.println("Size of the cookies after delete:=>"+cookies.size());//6


		//How to delete all cookie from the browser?
		driver.manage().deleteAllCookies(); 
		cookies = driver.manage().getCookies();
		System.out.println("Size of the cookies after all delete:=>"+cookies.size());//6


	}

}
