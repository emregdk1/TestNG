package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_Iframe {

    /*

     ● Bir class olusturun: D12_IframeTest
● https://the-internet.herokuapp.com/iframe adresine gidin.
            ● Bir metod olusturun: iframeTest
 ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
            ○ Text Box’a “Merhaba Dunya!” yazin.
 ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve  konsolda yazdirin.

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
    public void iframeTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        WebElement iframeYazisi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(iframeYazisi.isEnabled());
        System.out.println(iframeYazisi.getText());

        driver.switchTo().frame(0);
        WebElement yaziAlani = driver.findElement(By.cssSelector(".mce-content-body"));
        yaziAlani.clear();
        yaziAlani.sendKeys("Merhaba Dunya!");

        driver.switchTo().defaultContent();
        WebElement seleniumLink = driver.findElement(By.linkText("Elemental Selenium"));

        softAssert.assertTrue(seleniumLink.isDisplayed());
        System.out.println(seleniumLink.getText());


        softAssert.assertAll();


    }





















}
