package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Worldpopulation {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		String xpath_todayData = "//div[text()='  Today  ']//parent::div/div/div/span[contains(@class,'rts-counter')]";
		String xpath_todayThisYear = "//div[text()='  Today  ' or text() = '  This Year  ']//parent::div/div/div/span[contains(@class,'rts-counter')]";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(5);
		int counter = 1;
		while (counter <= 3) {

			if (counter == 21)
				break;
			System.out.println("-------------Today and This year population count------------");
			printPopulation(xpath_todayThisYear);
			System.out.println("==============================================================");
			Thread.sleep(1000);
			counter++;
		}
		driver.close();
	}

	public static void printPopulation(String locator) throws InterruptedException {

		List<WebElement> popList = driver.findElements(By.xpath(locator));

		for (WebElement e : popList) {
			System.out.println(e.getText());
		}

	}

}
