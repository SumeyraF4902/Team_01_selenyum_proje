package pages;

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

    @FindBy(linkText = "Remote Units")
    WebElement remoteUnitsButton;

    @FindBy(linkText = "Add New Remote Unit")
    WebElement addNewRemoteUnitButton;

    @FindBy(id="name")
    WebElement nameButton;

    @FindBy(xpath = "//input[@name='short_name']")
    WebElement shortNameButton;

    @FindBy(css =  "div[class=' css-1xc3v61-indicatorContainer']")
    WebElement departmentTypeSelectDropdown;

    @FindBy(name = "description")
    WebElement departmentDescriptionButton;

    @FindBy(linkText = "Save")
    WebElement saveButton;

    @FindBy(xpath = "//a[@href='#/department/230']")
    WebElement ortakciEdit;


    @FindBy(linkText = "Edit Remote Unit")
    WebElement editRemoteUnitButton;

    @FindBy(xpath = "//input[@name='short_name']")
    WebElement departmentShortName;


    @FindBy(xpath = "//input[@placeholder='Department Description'")
    WebElement departmentDescriptionButton2;

    @FindBy(linkText = "Save")
    WebElement saveButton2;

    @FindBy(xpath = "//a[@href='#/department/212']")
    WebElement abcBirimButton;

    @FindBy(linkText = "Edit Remote Unit")
    WebElement editRemoteUnitButton2;

    @FindBy(linkText = "Delete Department")
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

    public void addNewRemoteUnitButton(){
        waitUntilClickableElement(addNewRemoteUnitButton);
        addNewRemoteUnitButton.click();

    }


    public void nameButton(){
        waitUntilClickableElement(nameButton);
        nameButton.sendKeys();

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


    public void ortakciEdit(){
        waitUntilClickableElement(ortakciEdit);
        ortakciEdit.click();
    }

    public void editRemoteUnitButton(){
        waitUntilClickableElement(editRemoteUnitButton);
        editRemoteUnitButton.click();
    }

    public void departmentShortName(){
        waitUntilClickableElement(departmentShortName);
        departmentShortName.sendKeys();
    }

    public void setDepartmentDescriptionButton2(){
        waitUntilClickableElement(departmentDescriptionButton2);
        departmentDescriptionButton2.sendKeys();
    }

    public void saveButton2(){
        waitUntilClickableElement(saveButton2);
        saveButton2.click();
    }

    public void abcBirimButton(){
        waitUntilClickableElement(abcBirimButton);
        abcBirimButton.click();
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
