package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class RolesPage {
    private WebDriver driver;

    public RolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Roles")
    WebElement roles;

    @FindBy(xpath = "//button[text()='Accountant']")
    public WebElement accountant;

    @FindBy(xpath = "//button[text()='Business Owner']")
    public WebElement businessOwner;

    @FindBy(xpath = "//button[text()='Customer']")
    public WebElement customer;

    @FindBy(xpath = "//button[text()='Logistics Manager']")
    public WebElement logisticsManager;

    @FindBy(xpath = "//button[text()='Logistics Personnel']")
    public WebElement logisticsPersonnel;

    @FindBy(xpath = "//button[text()='Purchase Manager']")
    public WebElement purchaseManager;

    @FindBy(xpath = "//button[text()='Purchase Personnel']")
    public WebElement purchasePersonnel;

    @FindBy(xpath = "//button[text()='Quality Controller']")
    public WebElement qualityController;

    @FindBy(xpath = "//button[text()='Quality Manager']")
    public WebElement qualityManager;

    @FindBy(xpath = "//button[text()='Sales Manager']")
    public WebElement salesManager;

    @FindBy(xpath = "//button[text()='Sales Personnel']")
    public WebElement salesPersonnel;

    @FindBy(xpath = "//button[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//button[text()='Warehouse Manager']")
    public WebElement warehouseManager;

    @FindBy(xpath = "//button[text()='Warehouse Personnel']")
    public WebElement warehousePersonnel;

    @FindBy(xpath = "(//a[text()='Roles'])[2]")
    public WebElement roles2;

    @FindBy(xpath = "(//label[@class='form-label text-secondary'])[4]")
    public WebElement permissions;

    public void clickRoles() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOf(roles)));
        roles.click();

    }

    public void allRollesGorunurMu() {
        System.out.println("Roller tıklandı ve tüm roller listelendi ");

        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//div[@class='row mb-4']//a"));

        Assert.assertEquals(rows.size(), 14);


    }

    public void setAllRolesClickAndDogrula() {



        accountant.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        customer.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        businessOwner.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        logisticsManager.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        logisticsPersonnel.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        purchaseManager.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        purchasePersonnel.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        qualityManager.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        qualityController.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        salesManager.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        salesPersonnel.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        storeManager.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        warehouseManager.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
        warehousePersonnel.click();
        Assert.assertTrue(permissions.isDisplayed());
        roles2.click();
    }





    public void allRolPermissionsList() {


        accountant.click();
        List<WebElement> accountantPermissions = Driver.getDriver().findElements(By.xpath("//div[@class='row mt-3']//input"));
        Assert.assertTrue(accountantPermissions.size() > 0);
        roles2.click();

        customer.click();
        List<WebElement> customerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertFalse(customerPermisions.size() > 0);
        roles2.click();

        businessOwner.click();
        List<WebElement> businessOwnerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(businessOwnerPermisions.size() > 0);
        roles2.click();

        logisticsManager.click();
        List<WebElement> logisticsManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(logisticsManagerPermisions.size() > 0);
        roles2.click();

        logisticsPersonnel.click();
        List<WebElement> logisticsPersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(logisticsPersonnelPermisions.size() > 0);
        roles2.click();

        purchaseManager.click();
        List<WebElement> purchaseManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(purchaseManagerPermisions.size() > 0);
        roles2.click();

        purchasePersonnel.click();
        List<WebElement> purchasePersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(purchasePersonnelPermisions.size() > 0);
        roles2.click();

        qualityManager.click();
        List<WebElement> qualityManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(qualityManagerPermisions.size() > 0);
        roles2.click();

        qualityController.click();
        List<WebElement> qualityControllerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(qualityControllerPermisions.size() > 0);
        roles2.click();

        salesManager.click();
        List<WebElement> salesManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(salesManagerPermisions.size() > 0);
        roles2.click();

        salesPersonnel.click();
        List<WebElement> salesPersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("salesPersonnelPermisions.size() = " + salesPersonnelPermisions.size());
        Assert.assertTrue(salesPersonnelPermisions.size() > 0);
        roles2.click();

        storeManager.click();
        List<WebElement> storeManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(storeManagerPermisions.size() > 0);
        roles2.click();

        warehouseManager.click();
        List<WebElement> warehouseManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(warehouseManagerPermisions.size() > 0);
        roles2.click();

        warehousePersonnel.click();
        List<WebElement> warehousePersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        Assert.assertTrue(warehousePersonnelPermisions.size() > 0);
        roles2.click();
    }
}









