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

public class LkPageBurgerTest {
    private UserRequests userRequests;
    private WebDriver driver;
    private LKPageBurger objLKPage;
    private AuthorizationPageBurger objAuthorizationPage;

    @Before
    public void testCreateOrder() {
        userRequests = new UserRequests();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objAuthorizationPage = new AuthorizationPageBurger(driver);
        objLKPage = new LKPageBurger(driver);
        UserCreate userCreate = new UserCreate("Hardkones@yandex.ru", "123456", "Senya");
        userRequests.create(userCreate);
        objAuthorizationPage.authorizationByLKLink("Hardkones@yandex.ru", "123456");
    }
    @Test
    @DisplayName("Личный кабинет с описанием")
    public void transitionInPersonalArea() {
        objLKPage.clickPersonalAreaButton();
        assertTrue(objLKPage.personalAreaDescriptionIsDisplayed());
    }
    @Test
    @DisplayName("Переход в Конструктор из Личного Кабинета")
    public void transitionInBurgerConstructor() {

        objLKPage.clickPersonalAreaButton();
        objLKPage.clickConstructorLink();
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Переход на главную страницу по нажатию на лого")
    public void transitionInLogoLink() {
        objLKPage.clickPersonalAreaButton();
        objLKPage.clickLogoLink();
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Выход из Личного Кабинета")
    public void transitionToAuthPageFromLKPage() {
        objLKPage.logoutFromPersonalArea();
        assertTrue(objLKPage.loginTextIsDisplayed());
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
