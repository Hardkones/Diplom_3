package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePageBurgerTest {
    private WebDriver driver;
    private HomePageBurger objHomePage;

    @Before
    public void testCreateOrder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage = new HomePageBurger(driver);
    }
    @Test
    @DisplayName("Переход на раздел с Булками")
    public void transitionOnBunsSection() {
        String actual = objHomePage.getClassNameBunsSection();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Переход на раздел с Соусами")
    public void transitOnSaucesSection() {
        objHomePage.clickSaucesSection();
        String actual = objHomePage.getClassNameSaucesSection();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Переход на раздел с Начинками")
    public void transitOnFillingSection() {
        objHomePage.clickFillingSection();
        String actual = objHomePage.getClassNameFillingSection();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        assertEquals(expected, actual);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
