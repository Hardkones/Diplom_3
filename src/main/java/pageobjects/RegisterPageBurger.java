package pageobjects;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPageBurger {
    private WebDriver driver;
    public RegisterPageBurger(WebDriver driver) {

        this.driver = driver;
    }
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By registerLink = By.className("Auth_link__1fOlj");
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    @Step("Клик по кнопке Войти в Аккаунт")
    public RegisterPageBurger clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
        return this;
    }
    @Step("Клик по кнопке Зарегистрироваться на странице авторизации")
    public RegisterPageBurger clickRegisterButtonLink() {
        driver.findElement(registerLink).click();
        return this;
    }
    @Step("Заполнение поля Имя")
    public RegisterPageBurger fillingNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    @Step("Заполнения поля email")
    public RegisterPageBurger fillingEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    @Step("Заполнение поля Пароль")
    public RegisterPageBurger fillingPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step("Клик по кнопке Зарегистрироваться на странице регистрации")
    public RegisterPageBurger clickRegisterButton() {
        driver.findElement(registerButton).click();
        return this;
    }
    @Step("Отображение ошибки Неккоректный Пароль")
    public boolean getPasswordError() {

        return driver.findElement(passwordError).isDisplayed();
    }
    @Step("Отображение кнопки Войти после регистрации")
    public boolean enterButtonIsDisplayed() {

        return driver.findElement(enterButton).isDisplayed();
    }
    @Step("Успешная регистрация")
    public RegisterPageBurger registration(String name, String email, String password) {
        clickEnterAccountButton();
        clickRegisterButtonLink();
        fillingNameField(name);
        fillingEmailField(email);
        fillingPasswordField(password);
        clickRegisterButton();
        enterButtonIsDisplayed();
        return this;
    }
    @Step("Ошибка при регистрации")
    public RegisterPageBurger registrationFailed(String name, String email, String password) {
        clickEnterAccountButton();
        clickRegisterButtonLink();
        fillingNameField(name);
        fillingEmailField(email);
        fillingPasswordField(password);
        clickRegisterButton();
        getPasswordError();
        return this;
    }
}
