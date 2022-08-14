package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    protected static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Cookies
    private final By cookieAgree = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieAgree() {
        driver.findElement(cookieAgree).click();
    }
}