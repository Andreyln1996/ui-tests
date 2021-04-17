import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.MatcherAssert.assertThat;

class TestCase3 extends BasicTest
{

    @Test
    void notNumberTest()
    {
        String rightanswer = "string: Not a number!";

        driver.get("https://testsheepnz.github.io/random-number.html");
        scroll(By.id("buildID"));
        Select dropdown = new Select(driver.findElement(By.id("buildNumber")));
        dropdown.selectByVisibleText("Demo");
        driver.findElement(By.id("rollDiceButton")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("numberGuess"))));
        driver.findElement(By.id("numberGuess")).sendKeys("string");
        driver.findElement(By.id("submitButton")).click();
        String answer = driver.findElement(By.id("feedbackLabel")).getText();

        assertThat ("Не появилось сообщение «string: Not a number!»", answer.equals(rightanswer));
    }
}