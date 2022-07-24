package com.test.Vagrant;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 extends BrowserInit {

	@Test(priority = 0)
	public void openurl() throws InterruptedException {

		d.get(url_imdb);
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	public void film() throws InterruptedException {
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("Pushpa");
		Thread.sleep(4000);
		List<WebElement> list = d.findElements(By.xpath("//div[@class='sc-d2740ffb-2 STkQo searchResult__constTitle']"));
		for (WebElement l : list) {
			System.out.println(l.getText());
		}
	}

	@Test(priority = 2)
	public void date() {
		d.findElement(By.xpath("//*[@id=\"react-autowhatever-1--item-0\"]/a/div[2]/div[1]")).click();
		WebElement rdate = d.findElement(
				By.xpath("(//div[contains(@class,'ipc-metadata-list-item__content-container')])[17]/ul/li/a"));
		String date1 = rdate.getText();
		System.out.println("Release Date on imdb: " + date1);
	}

	@Test(priority = 3)
	public void country() {
		WebElement rcountry1 = d.findElement(
				By.xpath("(//div[contains(@class,'ipc-metadata-list-item__content-container')])[18]/ul/li/a"));
		String country1 = rcountry1.getText();
		System.out.println("Country on imdb: " + country1);
		System.out.println();
	}

}
