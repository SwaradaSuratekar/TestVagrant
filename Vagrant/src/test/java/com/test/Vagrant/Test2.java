package com.test.Vagrant;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 extends BrowserInit {

	@Test(priority = 0)
	public void openurl() throws InterruptedException {

		d.get(url_wikipedia);
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	public void film_test() throws InterruptedException {
		d.findElement(By.id("searchInput")).sendKeys("Pushpa");
		Thread.sleep(4000);
		List<WebElement> ls1 = d.findElements(By.xpath("//*[@id=\"typeahead-suggestions\"]/div/a/div[1]/h3"));
		for (WebElement l1 : ls1) {
			String list1 = l1.getText();
			System.out.println(list1);
		}
	}

	@Test(priority = 2)
	public void date_test() throws InterruptedException {
		Thread.sleep(4000);
		d.findElement(By.xpath("//a[contains(@class,'suggestion-link')][1]")).click();
		WebElement release = d.findElement(By.xpath("//table[contains(@class,'infobox vevent')]/tbody/tr[12]/td/div/ul/li"));
		String date = release.getText();
		System.out.println("Release Date on wikipedia: " + date);
	}

	@Test(priority = 3)
	public void country_test() throws InterruptedException {
		Thread.sleep(2000);
		WebElement rcountry = d.findElement(By.xpath("//table[contains(@class,'infobox vevent')]/tbody/tr[14]/td"));
		String country = rcountry.getText();
		System.out.println("Country on wikipedia: " + country);
	}

	
	  @Test(priority=4)
	  public void verification() { 
		  boolean verify_contry= country.equals(country1);
		  boolean verify_date= date.equals(date1);
		  Assert.assertTrue(verify_contry);
		  Assert.assertTrue(verify_date);
	  Assert.assertEquals(country, country1,"match");  
	  Assert.assertEquals(date, date1,"match");
	  }
	 
}
