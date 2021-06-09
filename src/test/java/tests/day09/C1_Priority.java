package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("before method calisti");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("after method calisti");
    }

    @Test
    public void test01() {
        System.out.println("test01 calisti");
    }

    @Test
    public void ikinciTest() {
        System.out.println("ikinci test calisti");
    }

    @Test (priority = 50)
    public void yazdimTest() {
        System.out.println("yazdim testi calisti");
    }






















}
