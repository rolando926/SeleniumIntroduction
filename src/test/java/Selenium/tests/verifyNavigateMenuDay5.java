package Selenium.tests;

import Utilities.SeleniumUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rrolando on 12/19/16.
 */
public class verifyNavigateMenuDay5 extends SeleniumUtils {
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
        driver.quit();
    }
}
