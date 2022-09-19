package pageobjects;

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
    public String getClassNameBunsSection() {

        return driver.findElement(bunsSection).getAttribute("class");
    }
    public HomePageBurger clickSaucesSection() {
        driver.findElement(saucesSection).click();
        return this;
    }
    public String getClassNameSaucesSection() {

        return driver.findElement(saucesSection).getAttribute("class");
    }
    public HomePageBurger clickFillingSection() {
        driver.findElement(fillingSection).click();
        return this;
    }
    public String getClassNameFillingSection() {

        return driver.findElement(fillingSection).getAttribute("class");
    }
}
