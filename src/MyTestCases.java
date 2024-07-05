import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

WebDriver driver = new ChromeDriver ();
String Url = "https://www.almosafer.com/en" ; 
String expectedLanguage = "en";
String theExpectedCurrency = "SAR";
String theExpectedMobileNumber = "+966554400000";
boolean theExpectedQitafLogo = true;
Random rand = new Random();

@BeforeTest 
public void mySetup() {
driver.get(Url);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
}


@Test (priority = 1, enabled = false)
public void checkLangauge () {

WebElement htmlTag=  driver.findElement(By.tagName("html")) ;
String theActualLangauge = htmlTag.getAttribute("lang");

assertEquals(expectedLanguage, theActualLangauge);
}


@Test (priority = 2, enabled = false)
public void checkCurrency () {
	
	WebElement theCurrecnyButton = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
    String theActualCurrency = theCurrecnyButton.getText();
    assertEquals(theExpectedCurrency, theActualCurrency);
	
}

@Test (priority = 3, enabled = false)
public void checkMobileNumber () {
	
WebElement theStrongElement =driver.findElement(By.tagName("strong"));
String theActualMobilenumber = theStrongElement.getText();
assertEquals(theActualMobilenumber, theExpectedMobileNumber);
}


@Test (priority = 4, enabled = false)
public void checkQitafLogo () {

	
	WebElement thefooter = driver.findElement(By.cssSelector(".sc-eopZyb.dngPsA"));
	WebElement theDiv  = thefooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"));
	boolean theActualLogo = theDiv.findElement(By.tagName("svg")).isDisplayed();
	assertEquals(theActualLogo, theExpectedQitafLogo);
	}



@Test (priority = 5, enabled = false)
public void checkHotelsTabIsNotSelected () {
	
String theExpectedValueOfTheTab = "false";
String theActualTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");	
assertEquals(theActualTab, theExpectedValueOfTheTab);	} 



@Test (priority = 6, enabled= false )
public void checkDepartureandReturnDates (){

	LocalDate today = LocalDate.now();
	int theExpectedDepartureDate = today.plusDays(1).getDayOfMonth();
	int theExpectedReturnDate = today.plusDays(2).getDayOfMonth();
	
	String theActualDepartureDate = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText();
    String theActualReturnDate = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']")).getText();
     int theActualDepartureDateIN = Integer.parseInt(theActualDepartureDate);
     int theActualReturnDateIN = Integer.parseInt(theActualReturnDate);
     
     assertEquals(theActualDepartureDateIN, theExpectedDepartureDate);
     assertEquals(theActualReturnDateIN, theExpectedReturnDate);

}

@Test (priority = 7, enabled = true)
public void checkLanguageIsSelectedRandomly () {
	
	
	
	
	
}

}













