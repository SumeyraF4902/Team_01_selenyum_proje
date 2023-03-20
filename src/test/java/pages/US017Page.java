package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Driver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class US017Page {

    WebDriver driver;

    public US017Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


   // @FindBy (linkText = "Users")
    @FindBy(id = "link6")
    WebElement userModuleButton;

    @FindBy (xpath = "//div[@class='col-8' ]//button[2]")
    WebElement newUserRegButton;

    @FindBy (xpath = "//div[@class='col-8' ]//button[1]")
    WebElement newUserInvButton;

    @FindBy(css = "div[class=' css-1xc3v61-indicatorContainer']")
    WebElement regRoleSelectDropdown;

    @FindBy (xpath = "//input[@id='email']")
    WebElement regEmailInputBox;

    @FindBy (xpath = "//button[@class='btn btn-info text-white float-end']")
    WebElement registerationbutton;

    @FindBy (xpath = "//div[@class='toast-body']")
    WebElement userRegSuccessAlert;


    @FindBy (xpath = "//span[@class='text-danger']")
    WebElement pleaseEnterAValidMailText;

    @FindBy (xpath = "//div[@class='toast-body']")
    WebElement invitationSentText;

    @FindBy (xpath = "//button[@class='btn btn-info text-white float-end']")
    WebElement sendInvButton;

    public void waitUntilElement(WebElement w){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(w));

    }

    public void waitUntilClickableElement(WebElement w){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(w));

    }
    public void clickUserModule()  {

        waitUntilClickableElement(userModuleButton);
        userModuleButton.click();
    }
    public void assertIfAccManagementPage(){

        assertTrue(driver.getCurrentUrl().contains("com/a3m"));

    }

    public void clickNewUserRegistration(){
        waitUntilClickableElement(newUserRegButton);
        newUserRegButton.click();
    }
    public void clickNewUserInvitation(){
        waitUntilClickableElement(newUserInvButton);
        newUserInvButton.click();
    }
    public void clickSendInvitation(){
        waitUntilClickableElement(sendInvButton);
        sendInvButton.click();
    }
    public void chooseARole(){
        waitUntilClickableElement(regRoleSelectDropdown);
        Actions actions=new Actions(driver);
        actions.moveToElement(regRoleSelectDropdown).click(regRoleSelectDropdown).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();



    }

    public void enterAnValidEmail() {
        waitUntilElement(regEmailInputBox);
        Faker faker=new Faker();
       regEmailInputBox.sendKeys(faker.internet().emailAddress());

    }

    public void RolAndenterAnInvalidEmail(){
        chooseARole();
        waitUntilElement(regEmailInputBox);
        regEmailInputBox.sendKeys("testmailgmail.com");

    }
    public void clickRegButton(){
        waitUntilClickableElement(registerationbutton);
        registerationbutton.click();
    }

    public void assertUserRegSuccessAlert(){
        waitUntilElement(userRegSuccessAlert);
        assertTrue(userRegSuccessAlert.getText().contains("successful"));
    }
    public void assertInvalidMailAlert(){
        waitUntilElement(pleaseEnterAValidMailText);
        assertTrue(pleaseEnterAValidMailText.getText().contains("valid email"));
    }
    public void mailSentAlert(){
        waitUntilElement(invitationSentText);
        assertTrue(invitationSentText.isDisplayed());
    }













}
