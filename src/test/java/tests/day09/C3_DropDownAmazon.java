package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropDownAmazon {

    /*
    ● Bir class oluşturun: D10_DropDownAmazon
● https://www.amazon.com/ adresine gidin.
            - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
-Test 2
            1. Kategori menusunden Books secenegini  secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin

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
        driver.get("http://amazon.com");

        WebElement aramaSayisi = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(aramaSayisi);
        List<WebElement> tumOpsiyonlar = select.getOptions();

        int beklenen = 45;
        int gerceklesen = tumOpsiyonlar.size();

        Assert.assertEquals(gerceklesen,beklenen,"beklenen sayi yanlis");

    }

    @Test
    public void test02() {
        driver.get("http://amazon.com");

        WebElement acilirListe = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(acilirListe);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement aramaSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSayisi.getText());

        Assert.assertTrue(aramaSayisi.getText().contains("Java"));
    }






























}
