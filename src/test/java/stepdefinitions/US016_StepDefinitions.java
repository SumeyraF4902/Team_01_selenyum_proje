package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.UserDetailPage;

public class US016_StepDefinitions {
    UserDetailPage userDetailPage = new UserDetailPage();
    @And("Kullanici bilgilerini düzenlemek istedigi kullaniciyi secer")
    public void kullaniciBilgileriniDüzenlemekIstedigiKullaniciyiSecer() {
        userDetailPage.selectUser();


    }

    @When("Kullanici bilgilerini düzenlemek icin edit butonuna basar")
    public void kullaniciBilgileriniDüzenlemekIcinEditButonunaBasar() {
        userDetailPage.editDetailsSelectedUser();
    }

    @Then("Kullanici bilgilerinde Default Role ün pasif durumda oldugunu dogrular")
    public void kullaniciBilgilerindeDefaultRoleÜnPasifDurumdaOldugunuDogrular(){
        userDetailPage.isDefaultRolePassiv();
    }

    @Then("Kullanici bilgilerinde Mail Adresinin pasif durumda oldugunu dogrular")
    public void kullaniciBilgilerindeMailAdresininPasifDurumdaOldugunuDogrular() {
        userDetailPage.isMailAddressPassiv();
    }



    @Then("Username in bos birakilamayacigina dair uyari görmelidir")
    public void usernameInBosBirakilamayaciginaDairUyariGörmelidir() {
        userDetailPage.isUsernameBlankable();
    }

    @And("Kullanici yaptigi islemi kayit altina alamamalidir")
    public void kullaniciYaptigiIslemiKayitAltinaAlamamalidir() {
        userDetailPage.saveEditable();

    }

    @And("Username kismina rakam ile giris yapmaya baslar")
    public void usernameKisminaRakamIleGirisYapmayaBaslar() {
        userDetailPage.enterUsernameWithNumber();
    }

    @Then("Username in kisminin rakam ile baslayamayacagina dair uyari görmelidir")
    public void usernameInKismininRakamIleBaslayamayacaginaDairUyariGörmelidir() {
        userDetailPage.isUsernameEditableWithNumbers();
    }

    @And("Username kismina ozel karakterler ile giris yapmaya baslar")
    public void usernameKisminaOzelKarakterlerIleGirisYapmayaBaslar() {
        userDetailPage.enterUsernameWithSpecialCharacter();
    }

    @Then("Username in kisminin ozel karakterler ile baslayamayacagina dair uyari görmelidir")
    public void usernameInKismininOzelKarakterlerIleBaslayamayacaginaDairUyariGörmelidir() {
        userDetailPage.isUsernameEditableWithSpecialCharacters();

    }

    @And("Username kisminda gecerli bir username ekler")
    public void usernameKismindaGecerliBirUsernameEkler() {
        userDetailPage.renameUsernameWithValidUsername();
    }

    @And("Kullanici yaptigi degisiklikleri kaydeder")
    public void kullaniciYaptigiDegisiklikleriKaydeder() {
        userDetailPage.saveEdit();
    }

    @Then("Kullanici yaptigi degisikligin gerceklestigine dair uyari mesaji görüntüler")
    public void kullaniciYaptigiDegisikliginGerceklestigineDairUyariMesajiGörüntüler() {
        userDetailPage.isEditSuccessfull();
    }

    @And("Yeni kullaniciyi user modulde görüntüler")
    public void yeniKullaniciyiUserModuldeGörüntüler() {
        userDetailPage.isEditedUserDisplayed();

    }

    @When("Kullanici sifre resetleme icin reset Password butonuna tiklar")
    public void kullaniciSifreResetlemeIcinResetPasswordButonunaTiklar() {
        userDetailPage.resetPassword();
    }

    @Then("Kullanici ekranda sifrenin basarili bir sekilde degisitirildigine dair mesaj görüntüler")
    public void kullaniciEkrandaSifreninBasariliBirSekildeDegisitirildigineDairMesajGörüntüler() {
        userDetailPage.isResetPasswordSuccessfull();
    }

    @When("Kullanici sectigi kullaniciya yeni bir rol atar")
    public void kullaniciSectigiKullaniciyaYeniBirRolAtar(){

        userDetailPage.addNewRoleToUser();
    }

    @Then("Kullanici yeni rolun eklendigini dogrular")
    public void kullaniciYeniRolunEklendiginiDogrular(){
        userDetailPage.isNewRoleAdded();
    }

    @And("Username kismini bos birakir")
    public void usernameKisminiBosBirakir() {
        userDetailPage.addBlankUsername();
    }
}
