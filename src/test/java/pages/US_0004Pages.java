package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class US_0004Pages {
    private WebDriver driver;





    public US_0004Pages(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);


    }


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



    @FindBy (xpath="(//*[text()='Business Owner'])[1]")
    public WebElement BusinessOwnerButton;

    @FindBy (xpath = "//a[contains(@href,'/a3m/')]")
    public WebElement AccountManagement;

    @FindBy(xpath = "(//button[@id='loginButton'])[2]")
    public WebElement ikinciaccountbutton;


    @FindBy(xpath="(//ul[@role='menu'])[2]")
    public WebElement DropDownMenu;

    @FindBy(xpath="//h4")
    public WebElement MyProfile;

    @FindBy(xpath = "//button[@id='changePasswordButton']")
    public WebElement ChangePasswordButton;

    @FindBy(xpath="//input[@id='newPassword']")
    public WebElement NewPasswordButton1;

    @FindBy(xpath="//input[@id='newPassword2']")
    public WebElement NewPasswordButton2;

    @FindBy(xpath="(//button[@type='button'])[5]")
    public WebElement ConfirmButton;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement cancelButton;

    // hatalı şifre girildiğinde alınan uyarılar

    @FindBy (xpath="//div[@role='alert']")
    public WebElement ortakHata;

    @FindBy(xpath="//*[contains(text(),'Password must contain at least one uppercase.')]")
    public WebElement buyukharficermeliHatasi;

    @FindBy(xpath = "//*[contains(text(),'Password must contain at least one lowercase')]")
    public WebElement kucukharficermeliHatasi;

    @FindBy(xpath = "//*[contains(text(),'Password must contain at least one digit')]")
    public WebElement rakamicermeliHatasi;

    @FindBy(xpath = "//*[contains(text(),'Password must contain special characters from .@#$%_&')]")
    public  WebElement ozelkaraktericermeliHatasi;

    @FindBy(xpath = "//*[contains(text(),'Password must be between 8 to 20 characters long')]")
    public WebElement uzunlukHatasi;

    //e-mail değişikliği için alınan locatorlar
    @FindBy(xpath = "(//*[contains(text(),'test1234@test.com')])[3]")
    public WebElement email;

    @FindBy(xpath = "//button[@class='btn btn-ghost-dark rounded-circle']")
    public WebElement kalemikonu;


}
