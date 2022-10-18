package pageobjects;

import client.UserClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class AuthorizationPageBurgerByHomePageTest {
    private UserClient userClient;
    private WebDriver driver;
    private AuthorizationPageBurger objAuthorizationPage;

    @Before
    public void testCreateOrder() {
        userClient = new UserClient();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objAuthorizationPage = new AuthorizationPageBurger(driver);
        User user = new User("Hardkones@yandex.ru", "123456", "Senya");
        userClient.create(user);
    }
    @Test
    @DisplayName("Авторизация через кнопку Войти в аккаунт")
    public void successfullyAuthorizationByEnterAccountButton() {
        objAuthorizationPage.authorizationByEnterAccountButton(
                "Hardkones@yandex.ru",
                "123456");
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Авторизация через кнопку Личный Кабинет")
    public void successfullyAuthorizationByLKLinkButton() {
        objAuthorizationPage.authorizationByLKLink(
                "Hardkones@yandex.ru",
                "123456");
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Авторизация через кнопку Войти на странице восстановления пароля")
    public void authorizationByUpdatePasswordPage() {
        objAuthorizationPage.authorizationByResetPassword(
                "Hardkones@yandex.ru",
                "123456");
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @After
    public void tearDown() {
        User user = new User("Hardkones@yandex.ru", "123456");
        ValidatableResponse response = userClient.login(user);
        String accessToken = response.extract().path("accessToken");
        userClient.delete(accessToken);
        driver.quit();
    }
}
