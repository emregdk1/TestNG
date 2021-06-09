package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

import java.util.Set;

public class test06_Handle01 extends TestBaseMethod {

    @Test
    public void test01() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        String ilksayfaHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        Set<String> listem = driver.getWindowHandles();

        String ikincisayfaHandle = "";
        for (String w : listem ) {
            if (!w.equals(ilksayfaHandle)) {
                ikincisayfaHandle = w;
            }
        }

        driver.switchTo().window(ikincisayfaHandle);

        WebElement sauceLabsYazisi = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));

        System.out.println(sauceLabsYazisi.isEnabled());


    }


}
