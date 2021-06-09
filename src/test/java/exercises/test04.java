package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class test04 {

    /*
    ● Bir class olusturun: D12_Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
            ● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        “You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfully” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        WebElement dogrulama = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));

        String expectedResult = "You successfully clicked an alert";
        String actualResult = dogrulama.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult,expectedResult);

        softAssert.assertAll();

    }

    @Test
    public void test02() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();

        WebElement cancel = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));

        String expected = "successfully";
        String actual = cancel.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(actual.equals(expected));

        softAssert.assertAll();

    }

    @Test
    public void test03() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("Muittin");
        driver.switchTo().alert().accept();

        WebElement isimGir = driver.findElement(By.xpath("//p[text()='You entered: Muittin']"));

        String beklenen = "Muittin";
        String gerceklesen = isimGir.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(gerceklesen.contains(beklenen));

        softAssert.assertAll();

    }


















}
