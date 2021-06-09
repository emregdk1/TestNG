package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C3_MouseActions03 extends TestBaseMethod {

    /*Yeni bir class olusturalim: D15_MouseActions4
1- https://www.facebook.com adresine gidelim
            2- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
3- Kaydol tusuna basalim*/

    @Test
    public void test01() {

        driver.get("http://www.facebook.com");

        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement isimKutusu = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);

        actions.click(isimKutusu)
                .sendKeys("Emre")
                .sendKeys(Keys.TAB)
                .sendKeys("Güdük")
                .sendKeys(Keys.TAB)
                .sendKeys("emreguduk@hotmail.com")
                .sendKeys(Keys.TAB).sendKeys("1598520").perform();




    }


}
