package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TodaysDealsPage {


    WebDriver driver;
    String driverExtension = "webdriver.chrome.driver";
    String driverPath = "Browser Driver/chromedriver.exe";
    String amazonUrl = "https://www.amazon.com/";

    @BeforeMethod
    public void runDriver() {
        System.setProperty(driverExtension, driverPath);
        driver = new ChromeDriver();
        driver.get(amazonUrl);
    }

    //9: todays deals page (Continuing from AmazonSearchFieldAndSignInFunctionality) Class:
    @Test
    public void getInsideTodaysDealsPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        Thread.sleep(2000);
        System.out.println("Today's deals page link is working successfully! ");
    }

    //10:
    @Test
    public void clickOnElectronics() throws InterruptedException {
        getInsideTodaysDealsPage();
        driver.findElement(By.xpath("//*[@id=\"widgetFilters\"]/div/div[3]/div[4]/span/a/div/div[2]/span")).click();
        Thread.sleep(2000);
    }

    //11:
    @Test
    public void checkElectronicPageText() throws InterruptedException {
        clickOnElectronics();
        String actualResult = driver.findElement(By.xpath("//*[@id=\"FilterItemView_all_summary\"]/div/span[2]/a/span")).getText();
        String expectedResult = "Electronics";
        Assert.assertEquals(actualResult, expectedResult, "Text did not match");
        Thread.sleep(2000);
    }

    //12:
    @Test
    public void clickOnAProduct() throws InterruptedException {
        checkElectronicPageText();
        driver.findElement(By.xpath("//*[@id=\"101 4779ac04-announce\"]")).click();
        Thread.sleep(2000);
    }

    //13:
    @Test
    public void chooseTheDeal() throws InterruptedException {
        clickOnAProduct();
        driver.findElement(By.cssSelector("#octopus-dlp-asin-stream > ul > li:nth-child(2) > span > div > div.a-section.a-spacing-base.a-text-center.octopus-dlp-image-section > a > div")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();
        Thread.sleep(2000);
    }

    //14:
    @Test
    public void addToCart() throws InterruptedException {
        clickOnAProduct();
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();
        Thread.sleep(2000);
    }

    //15:
    @Test
    public void dropDownFeature() throws InterruptedException {
        clickOnElectronics();
        driver.findElement(By.xpath("//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/span/span/span")).click();
        Thread.sleep(2000);
    }
    //16:
    @Test
    public void chooseLowToHighOrder() throws InterruptedException {
        dropDownFeature();
        driver.findElement(By.xpath("//*[@id=\"dropdown-8112217736661058_1\"]")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}
