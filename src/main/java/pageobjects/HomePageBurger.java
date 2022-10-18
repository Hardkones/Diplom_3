package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBurger {
    private WebDriver driver;
    public HomePageBurger(WebDriver driver) {

        this.driver = driver;
    }
    private final By bunsSection = By.xpath(".//span[text()='Булки']/..");
    private final By saucesSection = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingSection = By.xpath(".//span[text()='Начинки']/..");
    @Step("Проверка активности вкладки Булки")
    public String getClassNameBunsSection() {

        return driver.findElement(bunsSection).getAttribute("class");
    }
    @Step("Переключение на вкладку Соусы")
    public HomePageBurger clickSaucesSection() {
        driver.findElement(saucesSection).click();
        return this;
    }
    @Step("Проверка активности вкладки Соусы")
    public String getClassNameSaucesSection() {

        return driver.findElement(saucesSection).getAttribute("class");
    }
    @Step("Переключение на вкладку Начинки")
    public HomePageBurger clickFillingSection() {
        driver.findElement(fillingSection).click();
        return this;
    }
    @Step("Проверка активности вкладки Начинки")
    public String getClassNameFillingSection() {

        return driver.findElement(fillingSection).getAttribute("class");
    }
}
