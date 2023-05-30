package com.deep.demo.SDETProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Fullpage screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("Screenshot\\hoampage.png");

		FileUtils.copyFile(src, target);

		//screenshot of section/portion of the page
		WebElement section = driver.findElement(By.xpath("//*[@id=\"ph-topic\"]/div[2]/div/div[4]"));
		File src1 = section.getScreenshotAs(OutputType.FILE);
		File target1 = new File("Screenshot\\section.png");

		FileUtils.copyFile(src1, target1);

		//screenshot of element/logo of the page
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"demo-page\"]/body/div[7]/header/nav/div[2]/a/img"));
		File src2 = logo.getScreenshotAs(OutputType.FILE);
		File target2 = new File("Screenshot\\logo.png");

		FileUtils.copyFile(src2, target2);
		
		driver.quit();
		

	}

}
