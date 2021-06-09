package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test05 {

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
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement iframeyazisi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iframeyazisi.isEnabled());
        System.out.println(iframeyazisi.getText());

        WebElement iFrameWE = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameWE);

        WebElement text = driver.findElement(By.xpath("//body[@id='tinymce']"));
        text.clear();
        text.sendKeys("Maraba Dunya!");

        driver.switchTo().defaultContent();

        WebElement seleniumYazisi = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(seleniumYazisi.isDisplayed());
        System.out.println(seleniumYazisi.getText());


    }


}
