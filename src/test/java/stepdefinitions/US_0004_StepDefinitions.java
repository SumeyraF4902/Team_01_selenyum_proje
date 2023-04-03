package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginStep;
import pages.US_0004Pages;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US_0004_StepDefinitions {
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    US_0004Pages serhat=new US_0004Pages(Driver.getDriver());
    LoginStep ls = new LoginStep(Driver.getDriver());

    // ortak stepler

    @When("Kullanici login butonuna tiklar ve gecerli bir email ve password girerek siteye giris yapar.")
    public void kullaniciGecerliBirEmailVePasswordGirer() {

        ls.driverGet("https://qa-gm3.quaspareparts.com/");
        ls.clickLogin();
        ls.typeUsername(ConfigReader.getProperty("Serhat_email"));
        ls.typePassword(ConfigReader.getProperty("Serhatpassword"));
        ls.clickSubBtn();

        System.out.println("Siteye giriş yapıldı.");


    }

    @And("Sagdaki Bussiness Owner butonuna tiklar.")
    public void sagdakiBussinessOwnerButonunaTiklar() {

        serhat.BusinessOwnerButton.click();

        System.out.println("Business Owner butonuna tıklandı.");
    }

    @And("Acilan pencereden Account Management sekmesine tiklar.")
    public void acilan_pencereden_account_management_sekmesine_tiklar() {
        serhat.AccountManagement.click();
        System.out.println("DropDown menusunden Account Management sekmesi secildi.");
    }
    @And("My Profile yazisini goruntuler.")
    public void myProfileYazisiniGoruntuler() {
        Assert.assertTrue(serhat.MyProfile.isDisplayed());

        System.out.println("My Profile yazisi goruntulendi.");
    }

    @Given("Change_ password butonuna tiklar")
    public void change_PasswordButonunaTiklar() {

        //ReusableMethods.waitFor(10);

        //ReusableMethods.waitUntilClickableAndClick(serhat.ChangePasswordButton);

        System.out.println("change password butonu tıklandı.");
    }

    @And("Kurallara uymayan bir {string} girisi yapar  .")
    public void kurallaraUymayanBirGirisiYapar(String password1) {


        serhat.NewPasswordButton1.sendKeys(password1);

    }

    @And("Dogrulamak icin Kurallara uymayan bir {string} girisi_yapar")
    public void dogrulamakIcinKurallaraUymayanBirGirisi_yapar(String password2) {

        serhat.NewPasswordButton2.sendKeys(password2);

    }
    @And("Confirm_ butonuna tiklar .")
    public void confirm_ButonunaTiklar() {
        serhat.ConfirmButton.click();
        System.out.println("confirm butonu tıklandı.");
    }
    @When("Hata {string} goruntuler.")
    public void hataGoruntuler(String mesaj) {
        Assert.assertTrue(mesaj.contains(serhat.ortakHata.getText()));
        System.out.println("Hata mesajı görüntülendi. ");
    }

    @Then("cancel_ butonuna tiklar.")
    public void cancel_ButonunaTiklar() {
        serhat.cancelButton.click();
    }

    // 2- E-mail değiştirilemediğini doğrulama
    @When("Sagdaki kalem ikonuna tiklar.")
    public void sagdakiKalemIkonunaTiklar() {

        //wait.until(ExpectedConditions.visibilityOf(serhat.kalemikonu));
        serhat.kalemikonu.click();
        System.out.println("kalem ikonu tıklandı.");
    }
    @When("E-mail butonuna tiklar.")
    public void eMailButonunaTiklar() {
        //wait.until(ExpectedConditions.visibilityOf(serhat.email));
        serhat.email.click();
        System.out.println("email butonu tıklandı.");
    }

    @Then("E-Mail butonunun degisim icin aktif olmadigini goruntuler.")
    public void eMailButonununDegisimIcinAktifOlmadiginiGoruntuler() {
        //wait.until(ExpectedConditions.visibilityOf(serhat.email));
        Assert.assertTrue(serhat.email.getText().contains("test1234@test.com"),"e-mail değişikliği yapılabiliyor.");
    }

// 3- Başarılı password değişikliği

    @When("Change Password butonuna tiklar.")
    public void changePasswordButonunaTiklar() {
        serhat.ChangePasswordButton.click();
        System.out.println("changepassword butonu tıklandı");
    }

    @And("Kurallara uyan yeni bir password olusturur.")
    public void kurallaraUyanYeniBirPasswordOlusturur() {

        serhat.NewPasswordButton1.sendKeys("test123TEST123..");
        serhat.NewPasswordButton2.sendKeys("test123TEST123..");
        System.out.println("yeni şifre girişi yapıldı");

    }

    @And("Confirm butonuna tiklar.")
    public void confirmButonunaTiklar() {
        serhat.ConfirmButton.click();
        System.out.println("confirm butonu tıklandı.");
    }

    @When ("My Profile_yazisini goruntuler.")
    public void MyProfile_YazisiniGoruntuler() {
        Assert.assertTrue(serhat.MyProfile.isDisplayed());
    }
}
