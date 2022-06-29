package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //@FindBy(xpath = "//*[@id=\"root\"]/div/nav/nav/ul/li[1]/a")
    //private WebElement loginPageUrl;
    @FindBy(xpath = "/html/body/div/form/div/input[1]")
    private  WebElement username;
    @FindBy(xpath = "/html/body/div/form/div/input[2]")
    private WebElement password;
    @FindBy(xpath = "/html/body/div/form/div/button")
    private  WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void setUsername(String username) {
        this.username.sendKeys(username);
    }
    public void setPassword(String password) {
        this.password.sendKeys(password);
    }
    public void clickOnLoginButton() {
        this.loginButton.click();
    }
}
