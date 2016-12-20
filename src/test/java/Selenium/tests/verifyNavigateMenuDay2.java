package Selenium.tests;

import Utilities.SeleniumUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by rrolando on 12/19/16.
 */
public class verifyNavigateMenuDay2 extends SeleniumUtils {
    // In Test 2 we are working with the Departments Menu
    // We need no give waits to allow hidden menu to show up
    // Because of the TimeUnit we need to wrap it in a try and catch
    @Test
    public void test2(){
        try {

            WebElement mainMenuElement, subMenuElement;
            Actions builder = new Actions(driver);

            driver.get("http://www.homedepot.com");

            mainMenuElement = driver.findElement(By.xpath(".//a[text()='All Departments']"));
            subMenuElement = driver.findElement(By.xpath(".//a[text()='Christmas Decorations']"));

            // Wait to enter text
            TimeUnit.SECONDS.sleep(1);
            builder.moveToElement(mainMenuElement).clickAndHold().perform();

            // Wait to enter text
            TimeUnit.SECONDS.sleep(2);
            builder.moveToElement(subMenuElement).clickAndHold().perform();

            // Wait to enter text
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(By.xpath(".//a[text()='Christmas Trees']")).click();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void cleanDriver(){
        // Close driver
        driver.quit();
    }
}
