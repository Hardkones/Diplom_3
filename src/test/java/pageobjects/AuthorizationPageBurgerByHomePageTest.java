package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class AuthorizationPageBurgerByHomePageTest {
    private UserRequests userRequests;
    private WebDriver driver;
    private AuthorizationPageBurger objAuthorizationPage;

    @Before
    public void testCreateOrder() {
        userRequests = new UserRequests();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objAuthorizationPage = new AuthorizationPageBurger(driver);
        UserCreate userCreate = new UserCreate("Hardkones@yandex.ru", "123456", "Senya");
        userRequests.create(userCreate);
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
        UserLogin userLogin = new UserLogin("Hardkones@yandex.ru", "123456");
        ValidatableResponse response = userRequests.login(userLogin);
        String accessToken = response.extract().path("accessToken");
        userRequests.delete(accessToken);
        driver.quit();
    }
}
