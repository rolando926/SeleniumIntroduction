package Selenium.THD.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import Utilities.SeleniumUtility;

/**
 * Created by rrolando on 12/8/16.
 */
public class VerifySearchItem extends SeleniumUtility{



    @Test
    public void test1(){
        String landingPageText;
        String text = "pit";

        try {

            // Navigate to Home Depot
            driver.get("http://www.homedepot.com");

            // Wait to enter text
            TimeUnit.SECONDS.sleep(1);

            // Enter item into Search box = headerSearch
            driver.findElement(By.id("headerSearch")).sendKeys(text);

            // Wait to enter text
            TimeUnit.SECONDS.sleep(1);

            // Click on hour glass or Search
            driver.findElement(By.id("headerSearchButton")).click();

            //Implicit wait of 5 seconds
            TimeUnit.SECONDS.sleep(5);

            //Extract information about page landing
            landingPageText = driver.findElement(By.xpath(".//span[@class='original-keyword u__regular']")).getText();
            if (landingPageText.contains(text)) {
                System.out.println("The " + text + " landing page was found!");
            } else {
                System.out.println("Grabbed text = " + landingPageText);
                System.out.println("Error: The " + text + " landing page was not found!");
            }

            // Close driver
            driver.quit();

        }catch(InterruptedException ie){
            System.out.println("Error: Interrupted Exception found. "+ ie);
        }

    }


}
