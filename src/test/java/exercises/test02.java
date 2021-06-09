package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class test02 {

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

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        driver.findElement(By.xpath("//input[@id='user_remember_me']")).click();

        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password"+ Keys.ENTER);

        driver.findElement(By.xpath("//button[@id='details-button']")).click();

        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        driver.findElement(By.xpath("//a[text()='Transfer Funds']")).click();

        WebElement fromAccount = driver.findElement(By.xpath("//select[@id='tf_fromAccountId']"));

        Select select = new Select(fromAccount);
        select.selectByIndex(2);

        WebElement toAccount = driver.findElement(By.id("tf_toAccountId"));

        Select select1 = new Select(toAccount);
        select1.selectByIndex(1);

        driver.findElement(By.id("tf_amount")).sendKeys("250");

        driver.findElement(By.id("tf_description")).sendKeys("Aciklama"+Keys.ENTER);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//a[text()='Online Statements']")).click();

        WebElement acilirListem2 = driver.findElement(By.xpath("//select[@id='os_accountId']"));

        Select select2 = new Select(acilirListem2);
        select2.selectByIndex(1);

        String beklenen = "Checking";
        String gerceklesen = select2.getFirstSelectedOption().getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(gerceklesen,beklenen);


        List<WebElement> listemacc = select2.getOptions();
        List<String> expectedacc = Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");
        List<String> actualacc = new ArrayList<String>();

        for (WebElement w : listemacc) {
            actualacc.add(w.getText());
        }

        softAssert.assertEquals(actualacc,expectedacc);


        softAssert.assertAll();













    }
}
