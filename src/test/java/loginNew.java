import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

import java.time.Duration;

public class loginNew extends BaseClass {

    @AfterEach
    void tearDown() {
        chrome.quit();
    }

    @Test
    void login() {
        LoginPage loginPage = new LoginPage(chrome);
        loginPage.setUsername("test1");
        loginPage.setPassword("test1");
        loginPage.clickOnLoginButton();

        WebElement loginResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/ul[2]/a")));
        String expected = "Logout, test1";
        String actual = loginResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void loginFail() {
        LoginPage loginPage = new LoginPage(chrome);
        loginPage.setUsername("test");
        loginPage.setPassword("test");
        loginPage.clickOnLoginButton();

        WebElement loginFailedResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/div/span[2]")));
        String expected = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actual = loginFailedResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void registrationSuccessful() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(chrome);
        registrationPage.getToRegistrationPage();
        registrationPage.setUsername("test14");
        registrationPage.setPassword("test14");
        registrationPage.setPasswordConfirm("test14");
        registrationPage.clickOnRegistrationButton();

        WebElement registrationResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/ul[2]/a")));
        String expected = "Logout, test11";
        String actual = registrationResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void registrationFail() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(chrome);
        registrationPage.getToRegistrationPage();
        registrationPage.setUsername("test6");
        registrationPage.setPassword("test6");
        registrationPage.setPasswordConfirm("test6");
        registrationPage.clickOnRegistrationButton();

        WebElement registrationFailResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"username.errors\"]")));
        String expected = "Toks vartotojo vardas jau egzistuoja";
        String actual = registrationFailResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void logoutSuccessful() throws InterruptedException {
        LoginPage loginPage = new LoginPage(chrome);
        loginPage.setUsername("test1");
        loginPage.setPassword("test1");
        loginPage.clickOnLoginButton();
        Thread.sleep(1000);
        Assertions.assertEquals("Skaičiuotuvas", chrome.getTitle( ));

        WebElement logoutButton = chrome.findElement(By.xpath("/html/body/nav/div/ul[2]/a"));
        logoutButton.click();
        Thread.sleep(1000);

        Assertions.assertEquals("Prisijungimas", chrome.getTitle( ));
    }



}
