package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C4_KeyboardActions01 extends TestBaseMethod {

    /*1- Bir Class olusturalim D14_KeyboardActions1
2- https://www.amazon.com sayfasina gidelim
            3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin
    ve Enter’a basarak arama yaptirin
4- aramanin dogru oldugu test edin*/

    @Test
    public void test01() {
        driver.get("http://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        actions.click(aramaKutusu)
                .sendKeys("samsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER).perform();

        String expectedTitle = "samsung A71";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
}
