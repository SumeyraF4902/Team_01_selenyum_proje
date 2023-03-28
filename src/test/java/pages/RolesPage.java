
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
        System.out.println("Rolles e tıklandığında 14 rol olduğu görüldü");
        System.out.println("rows.size() = " + rows.size());
        Assert.assertEquals(rows.size(), 14);

        System.out.println("Rollerin Listesi");
        for (int i = 0; i < rows.size(); i++) {
            System.out.println("rowsListele = " + i + "." + rows.get(i).getText());
        }
    }

    public void setAllRolesClickAndDogrula() {

        System.out.println( "Tüm roller tıklandı ve rollerin tıklanır olduğu kontrol edildi");

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
        System.out.println("Bütün roller tıklandığında  perrmission izinleri ve izinlerin sayısı  görüntülendi ");


        accountant.click();
        List<WebElement> accountantPermissions = Driver.getDriver().findElements(By.xpath("//div[@class='row mt-3']//input"));
        System.out.println("accountantPermissions.size() = " + accountantPermissions.size());
        Assert.assertTrue(accountantPermissions.size() > 0);
        roles2.click();

        customer.click();
        List<WebElement> customerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("customerPermisions.size() = " + customerPermisions.size());
        Assert.assertFalse(customerPermisions.size() > 0);
        roles2.click();

        businessOwner.click();
        List<WebElement> businessOwnerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("businessOwnerPermisions.size() = " + businessOwnerPermisions.size());
        Assert.assertTrue(businessOwnerPermisions.size() > 0);
        roles2.click();

        logisticsManager.click();
        List<WebElement> logisticsManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("logisticsManagerPermisions.size() = " + logisticsManagerPermisions.size());
        Assert.assertTrue(logisticsManagerPermisions.size() > 0);
        roles2.click();

        logisticsPersonnel.click();
        List<WebElement> logisticsPersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("logisticsPersonnelPermisions.size() = " + logisticsPersonnelPermisions.size());
        Assert.assertTrue(logisticsPersonnelPermisions.size() > 0);
        roles2.click();

        purchaseManager.click();
        List<WebElement> purchaseManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("purchaseManagerPermisions.size() = " + purchaseManagerPermisions.size());
        Assert.assertTrue(purchaseManagerPermisions.size() > 0);
        roles2.click();

        purchasePersonnel.click();
        List<WebElement> purchasePersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println(" purchasePersonnelPermisions.size() = " + purchasePersonnelPermisions.size());
        Assert.assertTrue(purchasePersonnelPermisions.size() > 0);
        roles2.click();

        qualityManager.click();
        List<WebElement> qualityManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("qualityManagerPermisions.size() = " + qualityManagerPermisions.size());
        Assert.assertTrue(qualityManagerPermisions.size() > 0);
        roles2.click();

        qualityController.click();
        List<WebElement> qualityControllerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("qualityControllerPermisions.size() = " + qualityControllerPermisions.size());
        Assert.assertTrue(qualityControllerPermisions.size() > 0);
        roles2.click();

        salesManager.click();
        List<WebElement> salesManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("salesManagerPermisions.size() = " + salesManagerPermisions.size());
        Assert.assertTrue(salesManagerPermisions.size() > 0);
        roles2.click();

        salesPersonnel.click();
        List<WebElement> salesPersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("salesPersonnelPermisions.size() = " + salesPersonnelPermisions.size());
        Assert.assertTrue(salesPersonnelPermisions.size() > 0);
        roles2.click();

        storeManager.click();
        List<WebElement> storeManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("storeManagerPermisions.size() = " + storeManagerPermisions.size());
        Assert.assertTrue(storeManagerPermisions.size() > 0);
        roles2.click();

        warehouseManager.click();
        List<WebElement> warehouseManagerPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("warehouseManagerPermisions.size() = " + warehouseManagerPermisions.size());
        Assert.assertTrue(warehouseManagerPermisions.size() > 0);
        roles2.click();

        warehousePersonnel.click();
        List<WebElement> warehousePersonnelPermisions = Driver.getDriver().findElements(By.xpath("//div[@class='row']//input"));
        System.out.println("warehousePersonnelPermisions.size() = " + warehousePersonnelPermisions.size());
        Assert.assertTrue(warehousePersonnelPermisions.size() > 0);
        roles2.click();
    }

    // 2 yol   20 usery story icin************************************************
/*

    @FindBy(xpath = "//div[@class='row mb-4']//a")
    public List<WebElement> allRoles;
    @FindBy(xpath = "//div[@class='row']//input")
    public List<WebElement> izinBox;
    @FindBy(xpath = "(//div[@class='col row-cols-1'])[2]")
    public WebElement rollName;
    @FindBy(xpath = "(//label[@class='form-label text-secondary'])[4]")
    public WebElement permissions;
    public void btnAllRoles(int index) {
        ReusableMethods.click(allRoles.get(index));
    }
    public void izinDogrulama() {//permissions'ların görüntülendiğini doğrular
        for (int i = 0; i < allRoles.size(); i++) {
            btnAllRoles(i);
            ReusableMethods.wait.until(ExpectedConditions.visibilityOf(permissions));
            Assert.assertTrue(permissions.isDisplayed());
            accountManagement.btnRoles();//geri gelme işlemi
        }
    }
    public void izinListeleme() {//her rolun permissions sayısını yazar
        for (int i = 0; i < allRoles.size(); i++) {
            String name=allRoles.get(i).getText();
            btnAllRoles(i);
            System.out.println( name+"'in izin sayısı :" + izinBox.size());
            accountManagement.btnRoles();//geri gelme işlemi
        }
    }
***************************************************************************************




 */





    /*
    DENENELER AMA CALISMADI
      // rows.forEach(WebElement::click);
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

     //  List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//div/a/button[@type='button']"));



       // ListIterator<WebElement> iter = rows.listIterator();



      /*  for (int i = 0; i < rows.size(); i++) {
            try
                {
                    rows.get(i).click();
                    driver.get("https://qa-gm3.quaspareparts.com/a3m/#/roles");

                }
                catch(StaleElementReferenceException elemetYok)
                {
                    System.out.println("element yok");
                }*/







    // for (WebElement row : rows) {
    //    row.click();
    //  Assert.assertTrue(row.isDisplayed());
    //    driver.navigate().back();}
    // driver.navigate().to("https://qa-gm3.quaspareparts.com/a3m/#/roles");}

    //   while (iter.hasNext()) {
    //     rows.listIterator().next().click();
    //   Thread.sleep(1000);
    // driver.navigate().back();}
    //wait.until(ExpectedConditions.visibilityOf(element)).click();

    // wait.until(ExpectedConditions.urlToBe("https://qa-gm3.quaspareparts.com/a3m/"));


/*
       Assert.assertTrue(rows.get(i).isDisplayed());
        }*/



/*
        for (WebElement row : rows) {

            Assert.assertTrue(row.isDisplayed());

        driver.navigate().to("https://qa-gm3.quaspareparts.com/a3m/#/roles");


    }*/
    // Tıklamadan sonra bekleyebilirsiniz
    // Örneğin, bir popup penceresi açıldığında beklemek için:
/*
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));
        wait.until(ExpectedConditions.visibilityOf(login2)).click();    // Bilgiler girildikten soonra Login butonuna click işlemi
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        List<WebElement> orders;

     */
}












