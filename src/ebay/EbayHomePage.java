package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbayHomePage {
    WebDriver driver;
    String driverExtension = "webdriver.gecko.driver";
    String driverPath = "Browser Driver/geckodriver.exe";
    String ebayUrl = "https://www.ebay.com/";

    @BeforeMethod
    public void startDriver() throws InterruptedException {
        System.setProperty(driverExtension,driverPath);
        driver = new FirefoxDriver();
        driver.get(ebayUrl);
        Thread.sleep(2000);
    }
    //21:
    @Test
    public void searchLaptop() throws InterruptedException {
        startDriver();
        driver.findElement(By.className("gh-tb ui-autocomplete-input")).sendKeys("Laptop");
        Thread.sleep(2000);
    }
    //22:
    @Test
    public void checkLaptopSearchText() throws InterruptedException {
        searchLaptop();
        driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).click();
        Thread.sleep(2000);
    }
    //23:
    @Test
    public void clickOnPicture() throws InterruptedException {
        searchLaptop();
        driver.findElement(By.xpath("#s0-14-11-5-9\\[0\\]-0-0 > a > div > div.srp-1p__content > div")).click();
        Thread.sleep(2000);
    }
    //24:
    @Test
    public void checkSearchLogo() throws InterruptedException {
        startDriver();
        String actualResult = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(actualResult,ExpectedResult,"Logo alphabets did not match!");
    }
    //25:
    @Test
    public void clickOnLaptop() throws InterruptedException {
        searchLaptop();
        driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3/span")).click();
        Thread.sleep(2000);
    }
    //26:
    @Test
    public void clickOnBellButton() throws InterruptedException {
        clickOnLaptop();
        driver.findElement(By.cssSelector("#gh-Alerts-i")).click();
        Thread.sleep(2000);
    }
    //27:
    @Test
    public void clickOnJacket() throws InterruptedException {
        startDriver();
        driver.findElement(By.xpath("//*[@id=\"s0-0-31-3-0-0[2]-4-match-media-0-ebay-carousel-list\"]/li[5]/a/div[1]/img")).click();
        Thread.sleep(2000);
    }
    //28:
    @Test
    public void selectSize() throws InterruptedException {
        clickOnJacket();
        driver.findElement(By.xpath("//*[@id=\"msku-sel-1\"]")).click();
        Thread.sleep(2000);
    }
    //29:
    public void selectColor() throws InterruptedException {
        clickOnJacket();
        driver.findElement(By.xpath("//*[@id=\"msku-sel-2\"]")).click();
        Thread.sleep(2000);
    }
    //30:
    public void addToCart() throws InterruptedException {
        clickOnJacket();
        driver.findElement(By.id("binBtn_btn")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
