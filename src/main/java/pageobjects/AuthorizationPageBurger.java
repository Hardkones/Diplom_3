package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AuthorizationPageBurger {
    private WebDriver driver;
    public AuthorizationPageBurger(WebDriver driver) {

        this.driver = driver;
    }
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By emailField = By.xpath(".//fieldset[1]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input");
    private final By enterAuthButton = By.xpath(".//button[text()='Войти']");
    private final By personalAreaLink = By.xpath(".//p[text()='Личный Кабинет']");
    private final By orderSubmitButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By forgotPasswordLink = By.xpath(".//a[@href='/forgot-password']");
    private final By rememberPassword = By.xpath(".//a[@href='/login']");

    public AuthorizationPageBurger clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
                return this;
    }
    public AuthorizationPageBurger clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }
    public AuthorizationPageBurger fillingAuthEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public AuthorizationPageBurger fillingAuthPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public AuthorizationPageBurger clickEnterAuthButton() {
        driver.findElement(enterAuthButton).click();
        return this;
    }
    public AuthorizationPageBurger clickLKLink() {
        driver.findElement(personalAreaLink).click();
        return this;
    }
    public boolean orderSubmitButtonIsDisplayed() {

        return driver.findElement(orderSubmitButton).isDisplayed();
    }
    public AuthorizationPageBurger clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
        return this;
    }
    public AuthorizationPageBurger clickRememberPassword() {
        driver.findElement(rememberPassword).click();
        return this;
    }
    public AuthorizationPageBurger authorizationByEnterAccountButton(String email, String password) {
        clickEnterAccountButton();
        fillingAuthEmailField(email);
        fillingAuthPasswordField(password);
        clickEnterAuthButton();
        orderSubmitButtonIsDisplayed();
        return this;
    }
    public AuthorizationPageBurger authorizationByLKLink(String email, String password) {
        clickLKLink();
        fillingAuthEmailField(email);
        fillingAuthPasswordField(password);
        clickEnterAuthButton();
        orderSubmitButtonIsDisplayed();
        return this;
    }
    public AuthorizationPageBurger authorizationByRegistration(String email, String password) {
        fillingAuthEmailField(email);
        fillingAuthPasswordField(password);
        clickEnterButton();
        orderSubmitButtonIsDisplayed();
        return this;
    }
    public AuthorizationPageBurger authorizationByResetPassword(String emailAuth, String password) {
        clickEnterAccountButton();
        clickForgotPasswordLink();
        clickRememberPassword();
        fillingAuthEmailField(emailAuth);
        fillingAuthPasswordField(password);
        clickEnterAuthButton();
        orderSubmitButtonIsDisplayed();
        return this;
    }
}
