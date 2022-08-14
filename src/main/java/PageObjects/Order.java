package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order {
    private final WebDriver driver;
    //Button of order 1
    private final By buttonOrder1 = By.className("Button_Button__ra12g");
    //Button of order 2
    private final By buttonOrder2 = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Field Name
    private final By fieldName = By.xpath("//input[@placeholder='* Имя']");
    //Field Surname
    private final By fieldSurname = By.xpath("//input[@placeholder='* Фамилия']");
    //Field Address
    private final By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Field Metro
    private final By fieldMetro = By.xpath("//input[@placeholder='* Станция метро']");
    //Field Phone
    private final By fieldPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Button Next
    private final By buttonNext = By.xpath("//button[text() = 'Далее']");
    //Field When
    private final By fieldWhen = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Amount of Days
    private final By amountDays = By.xpath("//div[text() = 'двое суток']");
    //List of terms
    private final By openListTerms = By.className("Dropdown-arrow");
    //Color black
    private final By colorBlack = By.id("black");
    //Field Comment
    private final By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private final By buttonYesOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Status of order
    private final By statusOrder = By.className("Order_ModalHeader__3FDaJ");

    public Order(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollButtonOrder2() {
        WebElement element = driver.findElement(buttonOrder2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new WebDriverWait(driver, 3);
    }

    public void clickButtonOrder1() {
        driver.findElement(buttonOrder1).click();
    }

    public void clickButtonOrder2() {
        driver.findElement(buttonOrder2).click();
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void fillName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void fillSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    public void fillAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void fillMetro(String metro) {
        driver.findElement(fieldMetro).sendKeys(metro+ Keys.ARROW_DOWN + Keys.ENTER);
    }

    public void fillPhone(String phone) {
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    public void fillWhen(String when) {
        driver.findElement(fieldWhen).sendKeys(when);
    }

    public void selectTerm() {
        driver.findElement(openListTerms).click();
        driver.findElement(amountDays).click();
    }

    public void clickBlack() {
        driver.findElement(colorBlack).click();
    }

    public void fillComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
    }

    public void clickYes() {
        driver.findElement(buttonYesOrder).click();
    }

    public String getStatusOrder(){
        return driver.findElement(statusOrder).getText();
    }

    public void fillDataOrder(String name, String surname, String address, String metro,
                              String phone, String date, String comment) {
        fillName(name);
        fillSurname(surname);
        fillAddress(address);
        fillMetro(metro);
        fillPhone(phone);
        clickButtonNext();
        new WebDriverWait(driver, 3);
        fillWhen(date);
        selectTerm();
        clickBlack();
        fillComment(comment);
        clickButtonOrder2();
        new WebDriverWait(driver, 3);
        clickYes();
        new WebDriverWait(driver, 3);
    }
}