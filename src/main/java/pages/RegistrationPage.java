package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    @FindBy(xpath = "/html/body/div/form/div/h4/a")
    private WebElement registrationPageUrl;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"passwordConfirm\"]")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//*[@id=\"userForm\"]/button")
    private  WebElement registrationButton;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void getToRegistrationPage() {
        this.registrationPageUrl.click();
    }
    public void setUsername(String username) {
        this.username.sendKeys(username);
    }
    public void setPassword(String password) {
        this.password.sendKeys(password);
    }
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm.sendKeys(passwordConfirm);
    }
    public void clickOnRegistrationButton() {
        this.registrationButton.click();
    }
}
