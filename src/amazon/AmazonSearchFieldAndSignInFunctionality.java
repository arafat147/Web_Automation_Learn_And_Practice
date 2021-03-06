package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AmazonSearchFieldAndSignInFunctionality {

    String driverPath = "Browser Driver/chromedriver.exe";
    String chromeDriverExtension = "webdriver.chrome.driver";
    WebDriver driver;
    String amazonHomePageUrl = "http://www.amazon.com";
    String searchBoxFieldElement = "//*[@id=\"twotabsearchtextbox\"]";
    String searchButtonElement = "//*[@id=\"nav-search-submit-button\"]";
    String searchMaskKeywordElement = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]";
    String searchIphoneElement = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]";
    String signInButtonElement = "//*[@id=\"nav-link-accountList-nav-line-1\"]";
    String emailFieldElement = "//*[@id=\"ap_email\"]";

    @BeforeMethod
    public void driverOpen() throws InterruptedException {
        System.setProperty(chromeDriverExtension, driverPath);
        driver = new ChromeDriver();
        driver.get(amazonHomePageUrl);
        //driver.manage().window().fullscreen();
        Thread.sleep(2000);
    }

    //1: search mask
    @Test
    public void testMaskSearchResult() throws InterruptedException {
        clickOnSearchBox();
        String actualResult = driver.findElement(By.xpath(searchMaskKeywordElement)).getText();
        String expectedResult = "mask";
        Assert.assertEquals(actualResult, expectedResult, "Keyword did not match :");
    }

    public void clickOnSearchBox() throws InterruptedException {
        driver.findElement(By.xpath(searchBoxFieldElement)).sendKeys("Iphone 12 pro max");
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchButtonElement)).click();
        Thread.sleep(2000);
    }

    //2: search Iphone
    @Test
    public void testIphoneSearchResult() throws InterruptedException {
        clickOnSearchBox();
        String actualResult = driver.findElement(By.xpath(searchIphoneElement)).getText();
        String expectedResult = "\"Iphone\"";
        Assert.assertEquals(actualResult, expectedResult, "Keyword did not match :");
    }

    //3: click on product
    @Test
    public void searchiphone12ProMax() throws InterruptedException {
        clickOnSearchBox();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).click();
        Thread.sleep(2000);
        System.out.println("Test passed successfully!");

    }

    //4: Sign In functionality: open sign in page
    @Test
    public void openSignInPage() throws InterruptedException {
        driver.findElement(By.xpath(signInButtonElement)).click();
        Thread.sleep(2000);
    }

    //5: click and write in email field
    @Test
    public void clickAndWriteEmail() throws InterruptedException {
        openSignInPage();
        driver.findElement(By.xpath(emailFieldElement)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(emailFieldElement)).sendKeys("arafat.rahman93@gmail.com");
        Thread.sleep(2000);
    }

    //6: getting into password page:
    @Test
    public void clickAndWriteInPasswordField() throws InterruptedException {
        clickAndWriteEmail();
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("arafat@ad1579591");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#signInSubmit")).click();
        Thread.sleep(2000);
        System.out.println("Signed in successfully!");
    }
    //7: insert password in passwordField
    @Test
    public void passwordField() throws InterruptedException {
        clickAndWriteEmail();
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("arafat@ad1579591");
        Thread.sleep(2000);
        System.out.println("Password field is Writeable ");
    }
    //8: signIn
    @Test
    public void signIn() throws InterruptedException {
        passwordField();
        driver.findElement(By.cssSelector("#signInSubmit")).click();
        Thread.sleep(2000);
        System.out.println("Signed in successfully!");
    }



    @AfterTest
    public void driverClose() {
        driver.quit();
    }


}
