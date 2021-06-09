package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test06_Iframe {

    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");
        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        int index=0;
        for (WebElement w : list) {
            System.out.println(index + " Nolu iframe " + w.getAttribute("src"));
            index++;
        }
        System.out.println("iFrame sayısı = " + ((List<?>) list).size());
        /*WebElement iframeElement = driver.findElement(By.xpath("//iframe[@src='http://www.weather.gov/']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.cssSelector("#inputstring")).sendKeys("10003");
        //Thread.sleep(5000);
        driver.findElement(By.cssSelector("#btnSearch")).click();
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h2[text()='Where Did iframes Come From?']")).getText());*/
    }
}
