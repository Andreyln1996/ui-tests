import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasicTest
{
    static WebDriver driver;
    static WebDriverWait wait;
    static long timeoutInSecond = 10000;

    @BeforeAll
    static void beforeall()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, timeoutInSecond);
    }

    void selectFromDropdown(By element, String option)
    {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(option);
    }

    void scroll(By element)
    {
        WebElement lastElement = driver.findElement(element);
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, " + y + ")");
    }

    @AfterAll
    static void afterall()
    {
        driver.quit();
    }
}
