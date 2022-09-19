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

public class AuthorizationPageBurgerByRegisterPageTest {
        private UserRequests userRequests;
        private WebDriver driver;
        private AuthorizationPageBurger objAuthorizationPage;
        private RegisterPageBurger objRegisterPage;

        @Before
        public void testCreateOrder() {
            userRequests = new UserRequests();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://stellarburgers.nomoreparties.site/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            objAuthorizationPage = new AuthorizationPageBurger(driver);
            objRegisterPage = new RegisterPageBurger(driver);
        }
        @Test
        @DisplayName("Авторизация после успешной регистрации")
        public void successfullyAuthorizationAfterRegistration() {
            objRegisterPage.registration(
                    "Senya",
                    "Hardkones@yandex.ru",
                    "123456");
            objAuthorizationPage.authorizationByRegistration(
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
