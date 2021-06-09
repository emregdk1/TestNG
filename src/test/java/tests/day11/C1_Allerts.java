package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C1_Allerts {

    /*
    ● Bir class olusturun: D12_Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
            ● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        “You successfuly clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
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
        driver.close();
    }

    @Test
    public void acceptAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        WebElement cikanMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        String beklenen = "You successfully clicked an alert";
        String gerceklesen = cikanMesaj.getText();
        Assert.assertTrue(beklenen.contains("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();

        WebElement sonucYazisi = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));

        String expected = "successfully";
        String actual = sonucYazisi.getText();
        Assert.assertFalse(actual.contains(expected));

    }

    @Test
    public void sendKeysAllert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("Emre");
        driver.switchTo().alert().accept();

        WebElement ismim = driver.findElement(By.xpath("//p[text()='You entered: Emre']"));
        String beklenenisim = "Emre";
        String gerceklesenisim = ismim.getText();

        Assert.assertTrue(gerceklesenisim.contains(beklenenisim));


    }


























}
