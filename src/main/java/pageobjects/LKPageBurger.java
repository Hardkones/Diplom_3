package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LKPageBurger {
    private WebDriver driver;
    public LKPageBurger(WebDriver driver) {

        this.driver = driver;
    }
    private final By personalAreaButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By personalAreaDescription = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");
    private final By logoLink = By.className("AppHeader_header__logo__2D0X2");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By loginText = By.xpath(".//h2[text()='Вход']");
    @Step("Клик по кнопке Личный Кабинет")
    public LKPageBurger clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
        return this;
    }
    @Step("Отображение описания Личного Кабинета")
    public boolean personalAreaDescriptionIsDisplayed() {
        return driver.findElement(personalAreaDescription).isDisplayed();
    }
    @Step("Клик по кнопке Конструктор из личного кабинета")
    public LKPageBurger clickConstructorLink() {
        driver.findElement(constructorLink).click();
        return this;
    }
    @Step("Клик по Лого из личного кабинета")
    public LKPageBurger clickLogoLink() {
        driver.findElement(logoLink).click();
        return this;
    }
    @Step("Клик по кнопке Выйти")
    public LKPageBurger clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return this;
    }
    @Step("Отображение кнопки Войти на странице авторизации")
    public boolean loginTextIsDisplayed() {
        return driver.findElement(loginText).isDisplayed();
    }
    @Step("Выход из Личного Кабинета")
    public LKPageBurger logoutFromPersonalArea() {
        clickPersonalAreaButton();
        clickLogoutButton();
        loginTextIsDisplayed();
        return this;
    }
}
