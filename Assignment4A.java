package com.ibm.seleniumconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4A {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		driver.get("https://datatables.net/");
		Thread.sleep(5000);
		
		WebElement showentryEle= driver.findElement(By.xpath("//select[@name='example_length']/option[4]"));
		showentryEle.click();
		System.out.println("The count for show entries is selected as 100...");
		
		List<WebElement> rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int noOfRows=rows.size();
		
		int total=0;
		for(int i=1;i<=noOfRows;i++)
		{
		WebElement nameEle= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
		nameEle.click();
		
		WebElement salEle = driver.findElement(By.xpath("//span[@class='dtr-data']"));
		String salary = salEle.getText().trim().replace("$", "").replace(",", "");
		total = total+Integer.parseInt(salary);
		nameEle.click();
		}
		
		System.out.println("The total salary of all the employee: " +total);
		
		System.out.println("End of Program!!!");
	}
}