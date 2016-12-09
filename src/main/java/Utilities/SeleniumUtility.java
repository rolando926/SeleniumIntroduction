package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by rrolando on 12/8/16.
 */
public class SeleniumUtility{

    //Declaring Web Driver
    public WebDriver driver;

    public SeleniumUtility(){
        // Instantiating Chrome Driver
        System.setProperty("webdriver.chrome.driver", "/Users/rrolando/SeleniumIntroduction/src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }


    public boolean waitUntilElementDisplayed(String expression){
        int counter = 0;
        try {
            do {
                if(driver.findElement(By.xpath(expression)).isDisplayed()){
                    return true;
                }
                TimeUnit.SECONDS.sleep(1);
                counter += 1;
            } while (counter < 10);
        }catch(InterruptedException ie){
            System.out.println("Error: Interrupted Exception found. "+ie);
            return false;
        }
        return false;
    }
}
