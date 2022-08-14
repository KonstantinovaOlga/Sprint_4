package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


public class OrderTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        MainPage objMainPage = new MainPage(driver);
        driver.get(objMainPage.URL);
        objMainPage.clickCookieAgree();
    }

    @Test
    public void TestOrder_1() {
        Order objOrder = new Order(driver);
        objOrder.clickButtonOrder1();
        new WebDriverWait(driver, 3);
        objOrder.fillDataOrder("Ольга","Константинова","Яблочная 6",
                "Сокольники","+7999999999","13.08.2022",
                "Тестовый комментарий");
        String expected = "Заказ оформлен";
        String result = objOrder.getStatusOrder();
        assertEquals(result, expected);
    }

    @Test
    public void TestOrder_2() {
        Order objOrder = new Order(driver);
        objOrder.scrollButtonOrder2();
        objOrder.clickButtonOrder2();
        new WebDriverWait(driver, 3);
        objOrder.fillDataOrder("Иван","Иванов","Вишневая 10",
                "Бульвар Рокосовского","+71111111111","15.08.2022",
                "Этот заказ создан автоматическим тестом");
        String expected = "Заказ оформлен";
        String result = objOrder.getStatusOrder();
        assertEquals(result, expected);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}