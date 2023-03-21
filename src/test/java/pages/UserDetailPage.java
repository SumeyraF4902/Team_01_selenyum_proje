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
import utilities.Driver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
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
    static private List<String> userList = new ArrayList<>();
    static private String mainPage;
    static private String username = "";
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

    @FindBy(xpath = "//input[@role='combobox']")
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

    @FindBy(xpath = "//table//tbody//td[2]/a")
    private List<WebElement> userCell;


    public void verifiedEmailsAndNotVerifiedEmailsCount() {

        verifiedEmailsSize = (driver.findElements(By.cssSelector("path[fill='#08875D']"))).size();
        notVerifiedEmailsSize = (driver.findElements(By.cssSelector("path[fill='none']"))).size();
    }

    public void navigateToUserModul() {

        usersButton.click();
        verifiedEmailsAndNotVerifiedEmailsCount();

    }

    public void addNewUser() throws IOException, UnsupportedFlavorException {


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

        email.sendKeys(mailAdress);


        registerButton.click();
        registerWindowCloseButton.click();


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

    public void verifyEmail() throws InterruptedException {

        Set<String> windowsHandles = driver.getWindowHandles();
        for (String value : windowsHandles) {
            driver.switchTo().window(value);
            if (!value.equals(mainPage))
                break;
        }

        //mail in ulasmasi icin bekleme süresi
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".prim-btn")).click();


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='A3M Email Verification']"))));
        action.moveToElement(driver.findElement(By.xpath("//div[text()='A3M Email Verification']"))).click().perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.switchTo().frame("fullmessage");
        driver.findElement(By.linkText("Click to verify your email")).click();
        driver.switchTo().window(mainPage);
    }

    public boolean IsUserNotVerified() {
        return notVerifiedEmailsSize == notVerifiedEmails.size() - 1;
    }

    public boolean IsUserVerified() {
        return verifiedEmailsSize == verifiedEmails.size() - 1;
    }

    public void selectUser() {
        action.sendKeys(Keys.PAGE_DOWN).perform();
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

    public void isDefaultRolePassiv() throws InterruptedException {

        List<WebElement> aktifRol = driver.findElements(By.cssSelector(".active-roles-box svg"));
        wait.until(ExpectedConditions.visibilityOf(aktifRol.get(0)));
        boolean flag = false;
        System.out.println("aktifRol.size() = " + aktifRol.size());
        for(int i = 0; i<aktifRol.size(); i++){
            if(aktifRol.get(i).getAttribute("class").contains("text-danger")){
                System.out.println("aktifRol.get(i).getAttribute(\"class\") = " + aktifRol.get(i).getAttribute("class"));
                flag = true;
                break;
            }

        }
        Assert.assertFalse("Default Role Enabled durumdadir", flag);
    }

    public void isMailAddressPassiv() {
        sa.assertTrue(email.getAttribute("type") == null);
        sa.assertAll("Mail adresi pasif degil");

    }

    public void isUsernameBlankable() {
        sa.assertEquals(alertMessage.getText(),"Username cannot be empty");
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
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(characters.size() - 1);
            username += characters.get(number);
        }
        userName.sendKeys(username);

    }

    public void isUsernameEditableWithSpecialCharacters() {
        sa.assertEquals("Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._", alertMessage.getText());
    }

    public void renameUsernameWithValidUsername() {
        userName.clear();
        username = faker.name().username();
        userName.sendKeys(username);

    }

    public void isEditSuccessfull() {
        wait.until((ExpectedConditions.visibilityOf(saveAlertMessage)));
        Assert.assertEquals("Kullanici bilgileri güncellenemedi", "User information updated successfully", saveAlertMessage.getText());
    }

    public void isEditedUserDisplayed() {
        usersButton.click();
        for (WebElement value : userCell) {
            userList.add(value.getText());
        }
        Assert.assertTrue(userList.contains(username));
    }

    public void resetPassword() {
        changePasswordButton.click();
        resetPasswordConfirmButton.click();
    }

    public void isResetPasswordSuccessfull() {
        Assert.assertEquals("Sifre degistirilemedi", "Reset password successfully", driver.findElement(By.tagName("p")).getText());

    }

    public void addNewRoleToUser() {
        actualRoleSize = addedRoles.size();
        addRoleButton.click();

        action.moveToElement(driver.findElement(By.xpath("//div[text()='Select Role']"))).click().perform();
        driver.findElement(By.xpath("//div[contains(@id,'option')]")).click();

        saveRoleButton.click();


    }

    public void isNewRoleAdded() throws InterruptedException {
        Thread.sleep(2000);
        int actualRolSize = driver.findElements(By.xpath("//span[contains(@class,'roles')]")).size();
        Assert.assertEquals("Rol eklenmedi", actualRoleSize + 1, actualRolSize);
    }

    public void addBlankUsername() {
        action.click(userName).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE).perform();
    }

    public void isUsernameEditableWithNumbers() {
        sa.assertTrue(alertMessage.isDisplayed());
    }

    public void saveEditable() {
        saveEditButton.click();
        List<WebElement> saveButton = driver.findElements(By.xpath("//p[text()='User information updated successfully']"));
        sa.assertFalse(saveButton.size()==1);
        sa.assertAll("Kullanici invalid Username olusturabilmektedir");
    }


}
