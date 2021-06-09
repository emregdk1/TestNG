package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

import java.util.List;
import java.util.Set;

public class C2_HandleWindows01 extends TestBaseMethod {

    @Test
    public void test01() {

        driver.get("http://the-internet.herokuapp.com/iframe");

        String ilksayfaHandleDegeri = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        Set<String> listem = driver.getWindowHandles();

        String ikinciSayfaHandle = "";
        for (String  w : listem) {
            if (!w.equals(ilksayfaHandleDegeri)) {
                ikinciSayfaHandle = w;
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);

        WebElement sauceLabs = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(sauceLabs.getText());
    }


}
