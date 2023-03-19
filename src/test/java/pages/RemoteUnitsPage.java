package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RemoteUnitsPage {


    WebDriver driver;

    public RemoteUnitsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }








}
