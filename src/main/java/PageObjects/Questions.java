package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Questions {

    private final WebDriver driver;

    public Questions(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToQuestions() {
        WebElement element = driver.findElement(By.className("Home_SubHeader__zwi_E"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new WebDriverWait(driver, 3);
    }

    public void clickQuestion(String number) {
        driver.findElement(By.id("accordion__heading-"+number)).click();
    }

    public String getTextAnswer(String number){
        return driver.findElement(By.id("accordion__panel-"+number)).getText();
    }

}