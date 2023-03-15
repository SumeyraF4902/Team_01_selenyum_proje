package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginStep {

    WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    @FindBy(id = "loginButton")
    WebElement login_button;

    @FindBy(id = "username")
    WebElement login_username;

    @FindBy(id = "password")
    WebElement login_password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement login_submit_btn;

    @FindBy(xpath = "//span[@class='fw-bold']")
    WebElement login_email;

    @FindBy(linkText = "Account Management")
    WebElement login_Account_mng;

    public void waitImplicit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void driverGet(String text){
        driver.get(text);
    }

    public void typeUsername(String email) {login_username.sendKeys(email);
    }

    public void typePassword(String password) {login_password.sendKeys(password);
    }

    public void clickLogin() {
        login_button.click();
    }

    public void clickSubBtn() {
        login_submit_btn.click();
    }

    public void clickprofile() {
        login_email.click();
    }

    public void clickAccount_mng() {
        login_Account_mng.click();
    }

}
