package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class DropDownPage {


    WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='fw-bold']")
    WebElement DropdownMenu;



    @FindBy(xpath = "(//span[text()='group1@test.com'])[2]")
    WebElement UsernameText;

    @FindBy(xpath = "(//span[text()='Business Owner'])[2]")
    WebElement RoleText;

    @FindBy(linkText = "Account Management")
    WebElement AccountManagementButton;




    public void openDropdown(){
      waitUntilElement(DropdownMenu);
       DropdownMenu.click();
    }
    public void waitUntilElement(WebElement w){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(w));

    }

    public void AssertVisibiltyOfUsername(){
        waitUntilElement(UsernameText);
        assertTrue(UsernameText.isDisplayed());
    }
    public void AssertVisibilityOfRole(){
        waitUntilElement(RoleText);
        assertTrue(RoleText.isDisplayed());
    }

    public void AssertIfOnMarketPlace(){
        waitUntilElement(DropdownMenu);
        assertTrue(driver.getCurrentUrl().contains("mlm"));

    }

    public void ClickAccManagementButton(){
        waitUntilElement(AccountManagementButton);
       AccountManagementButton.click();

    }

 public void AssetIfOnAccManagementPage(){
     assertTrue(driver.getTitle().contains("Account"));

    }



}
