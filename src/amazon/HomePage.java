package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage {


    public static void main(String[] args) throws InterruptedException {
        //1.create path for browser:
        String chromeDriverPath = "C:\\Users\\arafa\\eclipse-workspace\\Web_Automation_Learn_And_Practice\\Browser Driver\\chromedriver.exe";
        //String firefoxDriverPath = "Browser Driver/geckodriver.exe";
        //2.set the property for driver:
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
        //3.create the object of the driver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver1 = new FirefoxDriver();
        //*********** Features using the driver*************\\

        //# use get method to navigate within the browser:
        driver.get("https://www.amazon.com/");
        //driver1.get("https://www.amazon.com/");
        //# to set time : it will wait for that time being and then close.
        //  without thread.sleep method, the browser will close immediately
        Thread.sleep(3000);
        //# fullScreen:
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        //# delete all cookies:
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        driver.close();
        //



    }

}
