package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C1_DependsOnTest {

    /*
    ● Bir class oluşturun: DependsOnTest
● https://www.walmart.com/ adresine gidin.
            1. Test : Wallmart ana sayfaya gittiginizi test edin
    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    arama yapin ve aramanizin gerceklestigini Test edin
    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $6.65 oldugunu test edin

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
    public void test01homePage() {
        driver = new ChromeDriver();
        driver.get("http://www.walmart.com/");

        String expectedUrl = "http://www.walmart.com/";
        String actualUrl = "http://www.walmart.com/";

        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Test (dependsOnMethods = "test01homePage")
    public void test02search() {

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String aranacakKelime = "Nutella";
        aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(aranacakKelime));
    }

    @Test (dependsOnMethods ="test02search")
    public void test03Result() {

        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();

        WebElement fiyatTest = driver.findElement(By.xpath("(//span[@class='hide-content display-inline-block-m'])[1]"));
        String actualfiyat = fiyatTest.getText();
        String expectedfiyat = "$7.97";

        Assert.assertEquals(actualfiyat,expectedfiyat);




    }























}
