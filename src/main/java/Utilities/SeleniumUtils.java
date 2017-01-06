package Utilities;
import XPathConstantElements.DOTCOM;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by rrolando on 12/13/16.
 */
public class SeleniumUtils implements DOTCOM {
    //Selenium Properties
    public static final int MAX_WAIT_SECS = 10;
    public static final String DRIVER_LOCATION = "/Users/rrolando/SeleniumIntroduction/chromedriver";

    public static WebDriver driver;

    public SeleniumUtils(){
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public boolean waitUntilElementDisplayed(String expression){
        int counter = 0;
        do {
            if (verifyDisplayed(expression)){
                return true;
            }
            else if (counter > 3){
                if(verifyEnabled(expression)){
                    return true;
                }

                else if (verifyLocation(expression)){
                    return true;
                }
            }

            counter++;
            try {
                TimeUnit.MILLISECONDS.sleep(950);
            }catch(Exception e){
                return false;
            }
        } while (counter < 10);

        return false;
    }

    public boolean verifyDisplayed(String expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (driver.findElement(By.xpath(expression)).isDisplayed()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyEnabled(String expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (driver.findElement(By.xpath(expression)).isEnabled()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyLocation(String expression){
        try{
            TimeUnit.MILLISECONDS.sleep(50);
            if(driver.findElement(By.xpath(expression)).getLocation().x < 0 ||
                    driver.findElement(By.xpath(expression)).getLocation().y < 0){
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifySubMenuItem() {
        WebElement mainMenuElement, subMenuElement;
        Actions builder = new Actions(driver);

        try {
            if(waitUntilAllDepartmentMenuOpens(christmasSubMenu)){
                builder.moveToElement(driver.findElement(By.xpath(christmasSubMenu))).clickAndHold().perform();
                driver.findElement(By.xpath(christmasTreesSubMenu)).click();
            }
            //builder.click(driver.findElement(By.xpath(departmentMainMenu))).moveToElement(driver.findElement(By.xpath(christmasSubMenu))).build().perform();
            //TimeUnit.SECONDS.sleep(1);
            //driver.findElement(By.xpath(christmasTreesSubMenu)).click();
            if(waitUntilElementDisplayed(searchChristmasTrees)){
                return true;
            }

        }catch(Exception ie) {
            return false;
        }
        return false;
    }

    public boolean waitUntilAllDepartmentMenuOpens(String expression){
        int counter = 0;
        do{
            driver.findElement(By.xpath(departmentMainMenu)).click();
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                return false;
            }

            if(verifyDisplayed(expression)){
                return true;
            }

            counter++;
        }while(counter < 10);
        return false;
    }


    public boolean verifyCanSelectFromMenu(){
        WebElement mainMenuElement, subMenuElement;
        Actions builder = new Actions(driver);

        mainMenuElement = driver.findElement(By.xpath(".//a[text()='All Departments']"));
        subMenuElement = driver.findElement(By.xpath(".//a[text()='Christmas Decorations']"));

        //driver.findElement(By.xpath(departmentMainMenu)).click();
        if(waitUntilElementDisplayed(departmentMainMenu)) {
            builder.moveToElement(mainMenuElement).clickAndHold().perform();
            if(waitUntilElementDisplayed(christmasSubMenu)) {
                builder.moveToElement(subMenuElement).clickAndHold().perform();
                if(waitUntilElementDisplayed(christmasTreesSubMenu)) {
                    driver.findElement(By.xpath(".//a[text()='Christmas Trees']")).click();
                    if(waitUntilElementDisplayed(searchChristmasTrees)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verifyCanNavigate(String url, String expected){
        String pageTitle;
        try{
            driver.get(url);
            pageTitle = driver.getTitle();
            if(expected.equals(pageTitle)){
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    public boolean verifyLandingPage(String text){
        String landingPageText = null;

        if(waitUntilElementDisplayed(searchResultText)) {
            landingPageText = driver.findElement(By.xpath(searchResultText)).getText();
        }
        if(landingPageText.contains(text)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean fluentWait(String element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    // Instantiate Fluent Wait
                .withTimeout(MAX_WAIT_SECS,TimeUnit.SECONDS)        // Time out at Max Wait Time in Seconds
                .pollingEvery(500,TimeUnit.MILLISECONDS)            // verify existence every half second
                .ignoring(NoSuchElementException.class);            // ignore ONLY the NoSuchElementException
        try {
            //TimeUnit.MILLISECONDS.sleep(500);
            if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element))).isDisplayed()
                    // || wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element))).isEnabled() ||
                    || wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element))).getLocation().x < 0 ||
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element))).getLocation().y < 0
                    ) {
                TimeUnit.MILLISECONDS.sleep(500);
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    public void fluentWaitUntil(String element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    // Instantiate Fluent Wait
                .withTimeout(MAX_WAIT_SECS,TimeUnit.SECONDS)        // Time out at Max Wait Time in Seconds
                .pollingEvery(500,TimeUnit.MILLISECONDS)            // verify existence every half second
                .ignoring(NoSuchElementException.class);             // ignore ONLY the NoSuchElementException

        WebElement elem = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return input.findElement(By.xpath(element));
            }
        });

    }


}
