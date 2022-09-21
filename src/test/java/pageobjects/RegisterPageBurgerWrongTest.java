package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class RegisterPageBurgerWrongTest {
    private WebDriver driver;
    private RegisterPageBurger objRegisterPage;

    @Before
    public void testCreateOrder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objRegisterPage = new RegisterPageBurger(driver);
    }
    @Test
    @DisplayName("Неккоректный пароль при Регистрации")
    public void registrationFail() {
        objRegisterPage.registrationFailed(
                "Senya",
                "Hardkones@yandex.ru",
                "123");
        assertTrue(objRegisterPage.getPasswordError());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
