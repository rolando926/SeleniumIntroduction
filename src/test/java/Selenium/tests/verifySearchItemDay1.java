package Selenium.tests;

import Utilities.SeleniumUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by rrolando on 12/19/16.
 */
public class verifySearchItemDay1 extends SeleniumUtils {
    @Test
    public void test1(){
        String landingPageText;
        String text = "pit";

        // Navigate to Home Depot
        driver.get("http://www.homedepot.com");

        // Wait to enter text
        //TimeUnit.SECONDS.sleep(1);

        // Enter item into Search box = headerSearch
        if(waitUntilElementDisplayed(headerSearchBar)) {
            driver.findElement(By.id("headerSearch")).sendKeys(text);
        }

        // Wait to enter text
        //TimeUnit.SECONDS.sleep(1);

        // Click on hour glass or Search
        if(waitUntilElementDisplayed(headerSearchBarButton)) {
            driver.findElement(By.id("headerSearchButton")).click();
        }

        //Implicit wait of 5 seconds
        //TimeUnit.SECONDS.sleep(5);

        //Extract information about page landing
        if(waitUntilElementDisplayed(".//span[@class='original-keyword u__regular']")) {
            landingPageText = driver.findElement(By.xpath(".//span[@class='original-keyword u__regular']")).getText();

            if (landingPageText.contains(text)) {
                System.out.println("The " + text + " landing page was found!");
            } else {
                System.out.println("Grabbed text = " + landingPageText);
                System.out.println("Error: The " + text + " landing page was not found!");
            }
        }

    }

    @AfterClass
    public static void cleanDriver(){
        // Close driver
        driver.quit();
    }
}
