package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(xpath = "//button[text()='+ Register New User']")
    private WebElement newUserRegistrationButton;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement selectRoleButton;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//button[text()='Close']")
    // @FindBy(css = "div[class=' css-1xc3v61-indicatorContainer']")
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
        driver.navigate().refresh();
        usersButton.click();
        verifiedEmailsAndNotVerifiedEmailsCount();

    }

    public void addNewUser() throws IOException, UnsupportedFlavorException {


        mainPage = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mail.tm/en/");
        driver.findElement(By.xpath("//button[@mode='primary']")).click();
        driver.findElement(By.id("DontUseWEBuseAPI")).click();
        mailAdress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

//ikincil mail adresi
     //   driver.get("https://tempail.com/");
     //   driver.findElement(By.xpath("//p[text()='Consent']")).click();
     //   mailAdress = driver.findElement(By.className("adres-input")).getAttribute("value");
     //   System.out.println("mailAdress = " + mailAdress);
//birincil mail adresi
        //  driver.get("https://tempmailo.com/");
        //  driver.findElement(By.cssSelector(".iconx")).click();
        //  mailAdress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        //   while (mailAdress.contains(".biz") || mailAdress.contains(".live")|| mailAdress.contains(".wiki")) {
        //       driver.findElement(By.xpath("//span[text()='Change']")).click();
        //       driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
        //       driver.findElement(By.cssSelector(".iconx")).click();
        //       mailAdress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        //   }


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


    public void isNewlyAddedUserDisplayed() {
        navigateToUserModul();

        boolean flag = false;
        for(WebElement value : registratedMails){
            if(value.getText().equals(mailAdress)){
                flag=true;
                break;
            }
        }
        Assert.assertTrue("Eklenmek istenen kullanici users Modulde görünmedi", flag);

    }

    public void sendVerifyEmailToUser() {

        By userAction = By.xpath("(//button[@tabindex='0'])[2]");
        WebElement action = driver.findElement(userAction);
        action.click();
        sendVerifyEmailButton.click();


    }

    public void verifyEmail() {

        Set<String> windowsHandles = driver.getWindowHandles();
        for (String value : windowsHandles) {
            driver.switchTo().window(value);
            if (!value.equals(mainPage))
                break;
        }

        driver.findElement(By.xpath("(//a[@href='/en/'])[2]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'A3M Email Verification')]")).click();
        driver.switchTo().frame("iFrameResizer0");
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[text()='Click to verify your email']")).click();
       // action.moveToElement(driver.findElement(By.xpath("//a[text()='Click to verify your email']"))).click().perform();


//ikincil mail adresi
       // driver.findElement(By.cssSelector(".fa.fa-reload")).click();
       // driver.findElement(By.xpath("//div[text()='A3M Email Verification']")).click();
       // driver.switchTo().frame("iframe");
       // driver.findElement(By.linkText("Click to verify your email")).click();

        //birincil mail adresi
        //  WebElement refreshButton = driver.findElement(By.cssSelector(".prim-btn"));
        //  for(int i = 0; i<5;i++){
        //      refreshButton.click();
        //  }

        //  ReusableMethodsEllyHocam.
        //          fluentWait(driver.findElement(By.xpath("//div[text()='A3M Email Verification']")),5);

        //  WebElement mail = driver.findElement(By.xpath("//div[text()='A3M Email Verification']"));

        //  action.moveToElement(mail).click().perform();
        //  action.sendKeys(Keys.PAGE_DOWN).perform();
        //  driver.switchTo().frame("fullmessage").findElement(By.linkText("Click to verify your email")).click();

        //  WebElement verifyEmail = driver.findElement(By.linkText("Click to verify your email"));
        //  action.moveToElement(verifyEmail).click(verifyEmail).perform();


        driver.switchTo().window(mainPage);


    }

    public void IsUserNotVerified() {
        Assert.assertEquals(notVerifiedEmails.size() - 1, notVerifiedEmailsSize);
    }

    public void IsUserVerified() {
        driver.navigate().refresh();
        usersButton.click();

      //  driver.findElement(By.linkText("#/users")).click();
        Assert.assertEquals(verifiedEmailsSize + 1, verifiedEmails.size());
    }

    public void selectUser() {
      //  action.sendKeys(Keys.PAGE_DOWN).perform();
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

        List<WebElement> aktifRol = driver.findElements(By.cssSelector(".active-roles-box svg"));
        wait.until(ExpectedConditions.visibilityOf(aktifRol.get(0)));
        boolean flag = false;
        System.out.println("aktifRol.size() = " + aktifRol.size());
        for (WebElement webElement : aktifRol) {
            if (webElement.getAttribute("class").contains("text-danger")) {
                flag = true;
                break;
            }

        }
        Assert.assertFalse("Default Role Enabled durumdadir", flag);
    }

    public void isMailAddressPassiv() {
        Assert.assertNull(email.getAttribute("type"));


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

    public void
    enterUsernameWithSpecialCharacter() {
        userName.clear();
        List<String> characters = new ArrayList<>(Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "{", "}", ":", "<", ">", "?", "=", "[", "]", ";", "'", ",", "/"));
        Random random = new Random();
        int character;
        for (int i = 0; i < 5; i++) {
            character = random.nextInt(characters.size() - 1);
            username += characters.get(character);
        }
        userName.sendKeys(username);

    }

    public void isUsernameEditableWithSpecialCharacters() {
        Assert.assertEquals("Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._", alertMessage.getText());
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

    public void isNewRoleAdded() {
        driver.navigate().refresh();
        int actualRolSize = driver.findElements(By.xpath("//span[contains(@class,'roles')]")).size();
       Assert.assertEquals("Rol eklenmedi", actualRoleSize + 1, actualRolSize);
    }

    public void addBlankUsername() {
        action.click(userName).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE).perform();
    }

    public void isUsernameEditableWithNumbers() {
        Assert.assertTrue(alertMessage.isDisplayed());
    }

    public void saveEditable() {
        saveEditButton.click();
        List<WebElement> saveButton = driver.findElements(By.xpath("//p[text()='User information updated successfully']"));
        Assert.assertNotEquals("Kullanici invalid Username olusturabilmektedir", 1, saveButton.size());

    }


}
