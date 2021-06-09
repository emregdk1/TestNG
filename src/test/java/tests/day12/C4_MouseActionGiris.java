package tests.day12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C4_MouseActionGiris extends TestBaseMethod {

    @Test
    public void test01() {

        driver.get("http://amazon.com");

        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
    }
}
