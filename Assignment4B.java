package com.ibm.seleniumconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4B {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		driver.get("https://www.amazon.in/");
		
		WebElement searchtextEle= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchtextEle.sendKeys("Laptops");
		
		WebElement searchEle= driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
		searchEle.click();
		System.out.println("The search result is displayed...");
		
		List<WebElement> linksEle=driver.findElements(By.tagName("a"));
		int noOfLinks=linksEle.size();
		
		System.out.println("The total number of links on the page: " +noOfLinks);
		
		for(int i=0;i<noOfLinks;i++)
		{
			WebElement linkEle= linksEle.get(i);
			
			String link=linkEle.getAttribute("href");
			System.out.println(link);
			
			String text= linkEle.getText();
			System.out.println(text);
		}
		System.out.println("End of Program!!!");
	}
}
