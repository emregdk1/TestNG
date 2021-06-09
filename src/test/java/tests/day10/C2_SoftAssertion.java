package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_SoftAssertion {

    /*
    "Selenium ogrenmek cok zevkli" cumlesinde
    asagidaki testleri yapiniz
     - cumle ogrenmek iceriyor
     - cumle Java icermiyor
     - cumle 4 kelimeden olusuyor
     - cumledeki karakter sayisi 25
     */

    WebDriver driver;

    String cumle = "Selenium ogrenmek cok zevkli";


    @Test
    public void hardAssertion() {

        Assert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");
        Assert.assertFalse(cumle.contains("Java"));
        System.out.println("2");

        String kelimeler[] = cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");

        String karakterler[] = cumle.split("");
        Assert.assertEquals(karakterler.length,28);
        System.out.println("4");

    }

    @Test
    public void softAssertionsTest() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cumle.contains("ogrenmek"),"ogrenmek testi failed");
        System.out.println("1");

        softAssert.assertFalse(cumle.contains("Java"),"Java testi failed");
        System.out.println("2");

        String kelimeler[] = cumle.split(" ");
        softAssert.assertEquals(kelimeler.length,4,"kelime sayisi testi failed");
        System.out.println("3");

        String karakterler[] = cumle.split("");
        softAssert.assertEquals(karakterler.length,25,"karakter sayisi testi failed");
        System.out.println("4");


        softAssert.assertAll();

        System.out.println("cikar");
    }
















}
