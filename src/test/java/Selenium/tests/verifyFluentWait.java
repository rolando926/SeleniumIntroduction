package Selenium.tests;

import Utilities.SeleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by rrolando on 12/19/16.
 */
public class verifyFluentWait extends SeleniumUtils {

    @Test
    public void test5(){

        // Navigate to Home Depot
        driver.get(homeURL);
        try {
            //Enter hammer into search box
            fluentWaitUntil(headerSearchBar);
            driver.findElement(By.xpath(headerSearchBar)).sendKeys("hammer");
            fluentWaitUntil(headerSearchBarButton);
            driver.findElement(By.xpath(headerSearchBarButton)).click();
            verifyLandingPage("hammer");
            fluentWaitUntil(searchPriceRefiner);
            driver.findElement(By.xpath(searchPriceRefiner)).click();
            fluentWaitUntil(firstPriceElement);
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(By.xpath(firstPriceElement)).click();
            TimeUnit.SECONDS.sleep(2);
            fluentWaitUntil(firstPriceLabel);
            System.out.println("Element price label has been found!");
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
