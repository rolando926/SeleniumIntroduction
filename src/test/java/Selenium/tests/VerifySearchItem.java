package Selenium.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import Utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by rrolando on 12/8/16.
 */
public class VerifySearchItem extends SeleniumUtils {


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

        // Close driver
        driver.quit();



    }


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

    // In this test we are eliminating the TimeUnit and using our new wait method
    // No need for try and catch
    @Test
    public void test3(){
        WebElement mainMenuElement, subMenuElement;
        Actions builder = new Actions(driver);

        driver.get("http://www.homedepot.com");

        mainMenuElement = driver.findElement(By.xpath(departmentMainMenu));
        subMenuElement = driver.findElement(By.xpath(christmasSubMenu));

        if(waitUntilElementDisplayed(departmentMainMenu)) {
            driver.findElement(By.xpath(departmentMainMenu)).click();
            builder.moveToElement(mainMenuElement).clickAndHold().perform();
        }

        if(waitUntilElementDisplayed(christmasSubMenu)) {
            builder.moveToElement(subMenuElement).clickAndHold().perform();
        }

        if(waitUntilElementDisplayed(christmasTreesSubMenu)) {
            driver.findElement(By.xpath(christmasTreesSubMenu)).click();
        }
    }


    // In this test we are nesting the conditional cause one is dependant one the other
    @Test
    public void test4(){
        WebElement mainMenuElement, subMenuElement;
        Actions builder = new Actions(driver);

        driver.get("http://www.homedepot.com");

        mainMenuElement = driver.findElement(By.xpath(departmentMainMenu));
        subMenuElement = driver.findElement(By.xpath(christmasSubMenu));

        if(waitUntilElementDisplayed(departmentMainMenu)) {
            driver.findElement(By.xpath(departmentMainMenu)).click();
            builder.moveToElement(mainMenuElement).clickAndHold().perform();
            if(waitUntilElementDisplayed(christmasSubMenu)) {
                builder.moveToElement(subMenuElement).clickAndHold().perform();
                if(waitUntilElementDisplayed(christmasTreesSubMenu)) {
                    driver.findElement(By.xpath(christmasTreesSubMenu)).click();
                }
            }
        }
    }

    // In this test we created methods for navigation and for verifying Menu navigation
    // This is the first time we use Asserts to either pass/fail a test
    // Methods must return true or false
    @Test
    public void test5(){

        //Navigating to Home Depot and validating
        Assert.assertTrue("Error: Can't navigate to desired page.", verifyCanNavigate(homeURL,"The Home Depot"));

        //Navigating through main Menu and validating Landing Page
        Assert.assertTrue("Error: Can't find menu elements from menu.", verifyCanSelectFromMenu());

    }


    @AfterClass
    public static void cleanDriver(){
        // Close driver
        cleanDriver();
        driver.quit();
    }


}
