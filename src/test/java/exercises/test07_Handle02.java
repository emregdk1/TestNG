package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseMethod;

import java.util.Set;

public class test07_Handle02 extends TestBaseMethod {

    /*● Tests package’inda yeni bir class olusturun: D13_WindowHandle2
    ● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.*/

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");

        SoftAssert softAssert = new SoftAssert();
        WebElement ilksayfaTextYazisi = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String expectedText = "Opening a new window";
        softAssert.assertEquals(ilksayfaTextYazisi.getText(),expectedText);

        String expectedilksayfaTitle = "The Internet";
        softAssert.assertEquals(driver.getTitle(),expectedilksayfaTitle);

        String ilksayfaHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> listem = driver.getWindowHandles();

        String ikincisayfaHandle = "";
        for (String w : listem) {
            if (!w.equals(ilksayfaHandle)) {
                ikincisayfaHandle = w;
            }
        }

        driver.switchTo().window(ikincisayfaHandle);

        String expectedikincisayfaTitle = "New Window";
        softAssert.assertEquals(driver.getTitle(),expectedikincisayfaTitle);

        WebElement ikincisayfaTextYazisi = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String expectedikincisayfaText = "New Window";
        softAssert.assertEquals(ikincisayfaTextYazisi.getText(),expectedikincisayfaText);

        driver.switchTo().window(ilksayfaHandle);
        softAssert.assertEquals(driver.getTitle(),expectedilksayfaTitle);


        softAssert.assertAll();

    }
}
