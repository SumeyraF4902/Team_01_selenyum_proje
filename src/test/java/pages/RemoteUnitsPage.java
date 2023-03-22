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

public class RemoteUnitsPage {


    WebDriver driver;

    public RemoteUnitsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "link4")
    WebElement remoteUnitsButton;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/div[2]/a/button")
    WebElement addNewRemoteUnitButton;

    @FindBy(id="name")
    WebElement nameButton;

    @FindBy(xpath = "//input[@name='short_name']")
    WebElement shortNameButton;

    @FindBy(css =  "div[class=' css-1xc3v61-indicatorContainer']")
    WebElement departmentTypeSelectDropdown;

    @FindBy(name = "description")
    WebElement departmentDescriptionButton;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div/div/div/div[2]/div[5]/div/span/div/button[1]")
    WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-dark']")
    WebElement edit11;







    @FindBy(xpath = "//*[@id=\"MainContent\"]/div[1]/div/a/button")
    WebElement editRemoteUnitButton;

    @FindBy(xpath = "//input[@name='short_name']")
    WebElement departmentShortName;


    @FindBy(xpath = "//input[@placeholder='Department Description']")
    WebElement departmentDescriptionButton2;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/div/div/div[2]/div[5]/div/span/div/button[1]")
    WebElement saveButton2;



    @FindBy(xpath = "(//div[@class='col-4'])[2]//a")
    WebElement randomUnitButton;

    @FindBy(xpath = "(//div[@class='col-4'])[3]//a")
    WebElement deleteUnitButtonr;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div[1]/div/a/button")
    WebElement editRemoteUnitButton2;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[2]/div/button")
    WebElement deleteDepartmentButton;














    public void waitUntilElement(WebElement w){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(w));

    }

    public void waitUntilClickableElement(WebElement w){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(w));

    }


    public void remoteUnitsButton(){
        waitUntilClickableElement(remoteUnitsButton);
        remoteUnitsButton.click();


    }

    public void assertRemoteUnits(){
        assertTrue(driver.getCurrentUrl().contains("remote"));


    }

    public void addNewRemoteUnitButton(){
        waitUntilClickableElement(addNewRemoteUnitButton);
        addNewRemoteUnitButton.click();

    }


    public void nameButton(){
        waitUntilClickableElement(nameButton);
        Faker faker = new Faker();
        nameButton.sendKeys(faker.internet().domainName());

    }


    public void shortNameButton(){
        waitUntilClickableElement(shortNameButton);
        shortNameButton.sendKeys();

    }


    public void departmentTypeSelectDropdown(){
        waitUntilClickableElement(departmentTypeSelectDropdown);
        Actions actions= new Actions(driver);
        actions.moveToElement(departmentTypeSelectDropdown).click(departmentTypeSelectDropdown).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();


    }


    public void departmentDescriptionButton(){
        waitUntilClickableElement(departmentDescriptionButton);
        departmentDescriptionButton.sendKeys();
    }


    public void saveButton(){
        waitUntilClickableElement(saveButton);
        saveButton.click();
    }

    public void assertNewRemote(){
        assertTrue(driver.getCurrentUrl().contains("new/remote"));

    }



    public void edit11(){
        waitUntilClickableElement(edit11);
        edit11.click();
    }




    public void editRemoteUnitButton(){
        waitUntilClickableElement(editRemoteUnitButton);
        editRemoteUnitButton.click();
    }

    public void departmentShortName(){
        waitUntilClickableElement(departmentShortName);
        Faker faker = new Faker();
        departmentShortName.sendKeys(faker.internet().domainName());
    }

    public void departmentDescriptionButton2(){
        waitUntilClickableElement(departmentDescriptionButton2);
        Faker faker = new Faker();
        departmentDescriptionButton2.sendKeys(faker.internet().domainWord());
    }

    public void saveButton2(){
        waitUntilClickableElement(saveButton2);
        saveButton2.click();
    }

    public void assertEditRemote(){
        assertTrue(driver.getCurrentUrl().contains("department/edit"));

    }




    public void randomUnitButton(){
        waitUntilClickableElement(randomUnitButton);
        randomUnitButton.click();
    }

    public void deleteUnitButtonr(){
        waitUntilClickableElement(deleteUnitButtonr);
        deleteUnitButtonr.click();
    }

    public void editRemoteUnitButton2(){
        waitUntilClickableElement(editRemoteUnitButton2);
        editRemoteUnitButton2.click();
    }

    public void deleteDepartmentButton(){
        waitUntilClickableElement(deleteDepartmentButton);
        deleteDepartmentButton.click();
    }

    public void acceptAllert(){
        driver.switchTo().alert().accept();
    }














}
