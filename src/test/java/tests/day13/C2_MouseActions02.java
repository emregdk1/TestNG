package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C2_MouseActions02 extends TestBaseMethod {

   /* Yeni bir class olusturalim: D14_MouseActions2
1- https://demoqa.com/droppable adresine gidelim
            2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin*/


    @Test
    public void test01() {
        driver.get("http://demoqa.com/droppable");

        Actions actions = new Actions(driver);

        WebElement tasinacakdragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement koyulacakdropHere = driver.findElement(By.xpath("//div[@id='droppable']"));

        actions.dragAndDrop(tasinacakdragMe,koyulacakdropHere).build().perform();

        WebElement droppedText = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedText = "Dropped!";
        Assert.assertEquals(droppedText.getText(),expectedText);


    }
}
