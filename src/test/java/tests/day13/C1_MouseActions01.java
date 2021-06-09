package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

import java.util.Set;

public class C1_MouseActions01 extends TestBaseMethod {

    /*1- Yeni bir class olusturalim: D14_MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
            3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu

    test edelim.

            5- Tamam diyerek alert’I kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim*/


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement sagTik = driver.findElement(By.id("hot-spot"));
        actions.contextClick(sagTik).perform();

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(actualAlertText, expectedAlertText);

        driver.switchTo().alert().accept();

        String ilksayfaHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        Set<String> listem = driver.getWindowHandles();

        String ikincisayfaHandle = "";
        for (String w : listem) {
            if (!w.equals(ilksayfaHandle)) {
                ikincisayfaHandle = w;
            }
        }

        driver.switchTo().window(ikincisayfaHandle);

        WebElement ikincisayfaH1tag = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
        String expectedTag = "Elemental Selenium";
        String actualTag = ikincisayfaH1tag.getText();
        actions.contextClick(ikincisayfaH1tag).perform();






        Assert.assertEquals(actualTag, expectedTag);

    }
}
