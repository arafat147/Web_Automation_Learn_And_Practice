package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BurgerButtonFunctionality {
    WebDriver driver;
    String driverExtension = "webdriver.chrome.driver";
    String driverPath = "Browser Driver/chromedriver.exe";
    String amazonUrl = "https://www.amazon.com/";

    @BeforeMethod
    public void startDriver(){
        System.setProperty(driverExtension,driverPath);
        driver = new ChromeDriver();
        driver.get(amazonUrl);
    }
    //17: BurgerButton Click:
    @Test
    public void clickOnBurgerButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        Thread.sleep(2000);
    }
    //18:
    @Test
    public void selectFromMenu() throws InterruptedException {
        clickOnBurgerButton();
        driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(2) > a")).click();
        Thread.sleep(2000);
    }
    //19:
    @Test
    public void checkBestSellerPageHeader() throws InterruptedException {
        selectFromMenu();
        String actualResult = driver.findElement(By.xpath("//*[@id=\"zg_banner_text_wrapper\"]")).getText();
        String expectedResult = "Amazon Best Sellers";
        Assert.assertEquals(actualResult,expectedResult,"Header did not match!");
    }
    //20:
    @Test
    public void clickOnLink() throws InterruptedException {
        selectFromMenu();
        driver.findElement(By.xpath("//*[@id=\"zg_left_col1\"]/div[1]/div[1]/a")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
