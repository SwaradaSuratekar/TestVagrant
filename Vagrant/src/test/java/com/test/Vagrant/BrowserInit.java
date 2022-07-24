package com.test.Vagrant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInit {

	public static WebDriver d = null;
	String url_imdb = "https://www.imdb.com/";
	String url_wikipedia ="https://www.wikipedia.org/";
	public static String country1, date1, country, date;

	@BeforeTest
	public void initialize() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		Thread.sleep(10000);
	}

	@AfterSuite
	public void closure() {
		d.quit();
	}

}
