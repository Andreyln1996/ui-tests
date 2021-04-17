import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;

class TestCase1 extends BasicTest
{
    @Test
    void calculatorSubtractTest()
    {
        String rightanswer = "-1";

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        scroll(By.id("selectBuild"));
        selectFromDropdown(By.id("selectBuild"), "Prototype");
        driver.findElement(By.id("number1Field")).sendKeys("2");
        driver.findElement(By.id("number2Field")).sendKeys("3");
        selectFromDropdown(By.id("selectOperationDropdown"), "Subtract");
        driver.findElement(By.id("calculateButton")).click();
        String answer = driver.findElement(By.id("numberAnswerField")).getAttribute("value");

        assertThat (" В поле ответа (Answer) значение не равно «-1»",answer.equals(rightanswer));
    }
}
