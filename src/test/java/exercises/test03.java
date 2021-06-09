package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test03 {

    /*
    Yeni bir Class Olusturun : D10_SoftAssertTest
1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin

     */


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://zero.webappsecurity.com/");

        WebElement signIN = driver.findElement(By.id("signin_button"));
        signIN.click();

        WebElement id = driver.findElement(By.id("user_login"));
        id.sendKeys("username");
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        WebElement checkbox = driver.findElement(By.id("user_remember_me"));
        checkbox.click();

        WebElement gönder = driver.findElement(By.xpath("//input[@name='submit']"));
        gönder.submit();

        WebElement gelismis = driver.findElement(By.id("details-button"));
        gelismis.click();

        WebElement ilerle = driver.findElement(By.id("proceed-link"));
        ilerle.click();

        WebElement activity = driver.findElement(By.xpath("//a[text()='Account Activity']"));
        activity.click();

        WebElement account = driver.findElement(By.id("aa_accountId"));
        Select select = new Select(account);
        select.selectByIndex(3);

        String beklenen = "Loan";
        String gerceklesen = select.getFirstSelectedOption().getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(gerceklesen,beklenen);

        List<WebElement> acilirListem = select.getOptions();
        List<String> expected = Arrays.asList("Saving, Checking, Saving, Loan, Credit Card, Brokerage");
        List<String> actual = new ArrayList<String>();

        for (WebElement w : acilirListem) {
            actual.add(w.getText());
        }

        WebElement find = driver.findElement(By.xpath("//a[text()='Find Transactions']"));
        find.click();

        driver.findElement(By.id("aa_description")).sendKeys("Açıklama");
        driver.findElement(By.id("aa_fromDate")).click();
        driver.findElement(By.xpath("//a[text()='4']")).click();
        driver.findElement(By.id("aa_toDate")).click();
        driver.findElement(By.xpath("//a[text()='10']")).click();
        driver.findElement(By.id("aa_fromAmount")).sendKeys("1000");
        driver.findElement(By.id("aa_toAmount")).sendKeys("500");

        WebElement type = driver.findElement(By.id("aa_type"));

        Select select1 = new Select(type);
        select1.selectByVisibleText("Withdrawal");

        WebElement Find = driver.findElement(By.xpath("//button[text()='Find']"));
        Find.click();

        WebElement noResult = driver.findElement(By.xpath("//div[@class='well']"));

        String beklenenyazi = "No Results.";
        String gerceklesenyazi = noResult.getText();

        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(gerceklesenyazi,beklenenyazi);









    }















}
