package tests.day10;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_SoftAssertTest {

    /*
    Yeni bir Class Olusturun : D10_SoftAssertTest
1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
  "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
  "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
  "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

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

        driver.findElement(By.id("signin_button")).click();

        driver.findElement(By.id("user_login")).sendKeys("username");

        driver.findElement(By.id("user_password")).sendKeys("password" + Keys.ENTER);

        driver.findElement(By.id("primary-button")).click();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        WebElement acilirListe = driver.findElement(By.id("pc_currency"));
        Select select = new Select(acilirListe);
        select.selectByIndex(6);

        SoftAssert softAssert = new SoftAssert();
        String actuel = select.getFirstSelectedOption().getText();
        String expected = "Eurozone (euro)";

        softAssert.assertEquals(actuel,expected);

        List<WebElement> listem = select.getOptions();
        List<String> actualList = new ArrayList<String>();
        List<String> expectedList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");

        for (WebElement w : listem ) {
            actualList.add(w.getText());
        }

        softAssert.assertEquals(actualList,expectedList);


        softAssert.assertAll();


    }




















}
