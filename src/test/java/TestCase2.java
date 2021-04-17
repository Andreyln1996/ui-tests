import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;

class TestCase2 extends BasicTest
{
    @Test
    void calculatorConcatenateTest()
    {
        String rightanswer = "gsbu";

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        scroll(By.id("selectBuild"));
        selectFromDropdown(By.id("selectBuild"), "Prototype");
        driver.findElement(By.id("number1Field")).sendKeys("gs");
        driver.findElement(By.id("number2Field")).sendKeys("bu");
        selectFromDropdown(By.id("selectOperationDropdown"), "Concatenate");
        driver.findElement(By.id("calculateButton")).click();
        String answer = driver.findElement(By.id("numberAnswerField")).getAttribute("value");

        assertThat (" В поле ответа (Answer) значение не равно «gsbu»",answer.equals(rightanswer));
    }
}

