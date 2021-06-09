package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test01 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown() {
        //driver.close();

    }

    @Test
    public void test01() {
        driver.get("http://amazon.com");

        WebElement acilirListe = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(acilirListe);
        select.selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("yüzüklerin efendisi"+Keys.ENTER);

        WebElement aramaSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSayisi.getText());

        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]")).click();























    }



    }
