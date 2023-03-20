package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;

import java.util.*;
import java.util.List;

public class UserDetailPage {
    WebDriver driver;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Faker faker = new Faker();
    Actions action = new Actions(Driver.getDriver());
    SoftAssert sa = new SoftAssert();

    static private int notVerifiedEmailsSize;
    static private int verifiedEmailsSize;
    static private String mailAdress;
    static private List<String> mailList;
    static private String mainPage;
    static private String username;
    static private int actualRoleSize;

    public UserDetailPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-ghost-dark")
    private WebElement editButton;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "changePasswordButton")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//img[@class='ms-2']")
    private WebElement addRoleButton;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement selectRoleDropdownButton;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveRoleButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement saveEditButton;

    @FindBy(id = "link6")
    private WebElement usersButton;

    @FindBy(xpath = "//table/tbody/tr/td[2]/a")
    private List<WebElement> users;

    @FindBy(xpath = "//span[@class='active-roles-box']")
    private WebElement defaultRoleButton;

    @FindBy(xpath = "//span[@class='text-danger']")
    private WebElement alertMessage;

    @FindBy(xpath = "//p[text()='User information updated successfully']")
    private WebElement saveAlertMessage;

    @FindBy(xpath = "//span[contains(@class,'roles')]")
    private List<WebElement> addedRoles;

    @FindBy(xpath = "//button[text()='+ New User Registration']")
    private WebElement newUserRegistrationButton;

    @FindBy(id = "react-select-2-input")
    private WebElement selectRoleButton;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElement registerWindowCloseButton;

    @FindBy(css = ".btn.btn-transparent.p-0")
    private WebElement userActionButton;

    @FindBy(linkText = "Resend Verify Email")
    private WebElement sendVerifyEmailButton;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/span")
    private List<WebElement> registratedMails;

    @FindBy(css = "path[fill='none']")
    private List<WebElement> notVerifiedEmails;
    @FindBy(css = "path[fill='#08875D']")
    private List<WebElement> verifiedEmails;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement resetPasswordConfirmButton;



    public void verifiedEmailsAndNotVerifiedEmailsCount() {

        verifiedEmailsSize = (driver.findElements(By.cssSelector("path[fill='#08875D']"))).size();
        notVerifiedEmailsSize = (driver.findElements(By.cssSelector("path[fill='none']"))).size();
    }


    public void navigateToUserModul() {

        usersButton.click();
        verifiedEmailsAndNotVerifiedEmailsCount();


    }

    public void addNewUser() throws AWTException, IOException, UnsupportedFlavorException {


        mainPage = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tempmailo.com/");
        driver.findElement(By.cssSelector(".iconx")).click();
        mailAdress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        while (mailAdress.contains(".biz") || mailAdress.contains(".live")) {
            driver.findElement(By.xpath("//span[text()='Change']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
            driver.findElement(By.cssSelector(".iconx")).click();
            mailAdress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        }


        driver.switchTo().window(mainPage);


        notVerifiedEmailsSize = notVerifiedEmails.size();
        verifiedEmailsSize = verifiedEmails.size();

        newUserRegistrationButton.click();
        selectRoleButton.click();
        selectRoleButton.sendKeys("Store Manager" + Keys.ENTER);

        email.click();
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);
        rbt.keyRelease(KeyEvent.VK_V);
        rbt.keyRelease(KeyEvent.VK_CONTROL);

        registerButton.click();
        registerWindowCloseButton.click();
        driver.navigate().refresh();


    }


    public boolean isNewlyAddedUserDisplayed() {
        navigateToUserModul();
        String body = driver.findElement(By.xpath("//table//tbody")).getText();
        return body.contains(mailAdress);

    }

    public void sendVerifyEmailToUser() {

        userActionButton.click();
        sendVerifyEmailButton.click();


    }

    public void verifyEmail() {

        Set<String> windowsHandles = driver.getWindowHandles();
        for (String value : windowsHandles) {
            driver.switchTo().window(value);
            if (!value.equals(mainPage))
                break;
        }


        driver.findElement(By.cssSelector(".prim-btn")).click();

        WebElement emailClick = driver.findElement(By.xpath("//div[text()='A3M Email Verification']"));
        wait.until(ExpectedConditions.visibilityOf(emailClick));
        action.moveToElement(emailClick).click().perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.switchTo().frame("fullmessage");
        driver.findElement(By.linkText("Click to verify your email")).click();
    }

    public boolean IsUserNotVerified() {
        return notVerifiedEmailsSize == notVerifiedEmails.size() - 1;
    }

    public boolean IsUserVerified() {
        return verifiedEmailsSize == verifiedEmails.size() - 1;
    }

    public void selectUser() {

        for (WebElement value : users) {
            if (value.getText().length() > 1) {
                wait.until(ExpectedConditions.elementToBeClickable(value));
                action.moveToElement(value).click().perform();
                break;
            }
        }

    }

    public void editDetailsSelectedUser() {
        editButton.click();

    }

    public void isDefaultRolePassiv() {
        Assert.assertFalse("Default Role Enabled durumdadir",defaultRoleButton.isEnabled());
    }

    public void isMailAddressPassiv() {
        sa.assertFalse(email.isEnabled());
        sa.assertAll("Mail adresi pasif degil");

    }

    public void isUsernameBlankable() {

        Assert.assertEquals("Username cannot be empty", alertMessage.getText());

    }

    public void saveEdit() {
        saveEditButton.click();

    }

    public void enterUsernameWithNumber() {
        userName.clear();
        username = faker.phoneNumber().cellPhone();
        userName.sendKeys(username);
    }

    public void enterUsernameWithSpecialCharacter() {

        userName.clear();
        List<String> characters = new ArrayList<>(Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "{", "}", ":", "<", ">", "?", "=", "[", "]", ";", "'", ",", "/"));
        Random random = new Random();
        int number = random.nextInt(characters.size() - 1);
        userName.sendKeys(characters.get(number));

    }

    public void isUsernameEditableWithSpecialCharacters() {

        sa.assertEquals("Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._", alertMessage.getText());
        sa.assertAll();

    }

    public void renameUsernameWithValidUsername() {
        userName.clear();

        username = faker.name().username();
        userName.sendKeys(username);

    }

    public void isEditSuccessfull() {
        wait.until((ExpectedConditions.visibilityOf(saveAlertMessage)));

        Assert.assertEquals("uyari mesaji görüntülenemedi", "User information updated successfully", saveAlertMessage.getText());
    }

    public void isEditedUserDisplayed() {
        usersButton.click();
        driver.navigate().refresh();

        Assert.assertTrue(driver.findElement(By.xpath("//table//tbody")).toString().contains(username));
    }

    public void resetPassword() {
        changePasswordButton.click();
        resetPasswordConfirmButton.click();
    }

    public void isResetPasswordSuccessfull() {
        Assert.assertEquals("Sifre degistirilemedi", "Reset password successfully", driver.findElement(By.tagName("p")).getText());

    }

    public void addNewRoleToUser() throws InterruptedException {
        actualRoleSize = addedRoles.size();
        addRoleButton.click();


        action.moveToElement(driver.findElement(By.xpath("//div[text()='Select Role']"))).click().perform();
        //  action.moveToElement(driver.findElement(By.xpath("//input[@aria-expanded='false']"))).click().perform();
        driver.findElement(By.xpath("//div[contains(@id,'option')]")).click();

       //WebElement roller = driver.findElement(By.cssSelector("div[class=' css-1xc3v61-indicatorContainer']"));
       //action.moveToElement(roller).click().sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        saveRoleButton.click();


    }

    public void isNewRoleAdded() throws InterruptedException {
        Thread.sleep(2000);
        int actualRolSize = driver.findElements(By.xpath("//span[contains(@class,'roles')]")).size();

        Assert.assertEquals("Rol eklenmedi", actualRoleSize + 1, actualRolSize);
    }

    public void addBlankUsername() {
        action.moveToElement(userName).click().perform();
        userName.clear();
        userName.sendKeys("");
    }

    public void isUsernameEditableWithNumbers() {
        SoftAssert sa = new SoftAssert();
       // sa.assertTrue();
    }

    public void saveEditable() {
        sa.assertFalse(saveEditButton.isEnabled());
        sa.assertAll("Kullanici invalid Username olusturabilmektedir");
    }
}
