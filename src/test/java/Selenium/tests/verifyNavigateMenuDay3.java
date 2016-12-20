package Selenium.tests;

import Utilities.SeleniumUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by rrolando on 12/19/16.
 */
public class verifyNavigateMenuDay3 extends SeleniumUtils{
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

    @AfterClass
    public static void cleanDriver(){
        // Close driver
        driver.quit();
    }
}
