package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubscriptionsPage {

    WebDriverWait wait;
    WebDriver driver;

    public SubscriptionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (xpath = "//li[@id='link1']")
    public WebElement subscription;

    @FindBy (xpath = "//h5[@class='mb-0']")
    public WebElement subscriptionData;


    public void click(){
        subscription.click();
    }

    public void seeData(){
        Assert.assertTrue(subscriptionData.isDisplayed());
    }

}
