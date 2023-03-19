package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class TeamsPage {
    WebDriver driver;
    public TeamsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Teams")
    WebElement teamsButton;
    @FindBy(xpath = "//div[@class='col-9']//a")
    public List<WebElement> teamsList;
    @FindBy(xpath = "//div[@class='col-10']")
    WebElement teamDetay;
    @FindBy(xpath = "//div[@class='btn btn-info float-end text-white']")
    WebElement addNewAndEditTeamButton;
    @FindBy(xpath = "//div[@class='col-md-10']")
    WebElement newTeamDetay;
    @FindBy(xpath = "//input[@id='name']")
    WebElement inputTeam;
    @FindBy(xpath = "//div[@class='btn btn-danger text-light fw-bold']")
    WebElement deleteTeamButton;
    @FindBy(xpath = "//button[@class='btn btn-info text-white px-3']")
    WebElement saveTeamButton;
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void addNewAndEditTeam(){
        addNewAndEditTeamButton.click();
    }
    public void saveTeam(){
        saveTeamButton.click();
    }
    public void deleteTeam(){
        deleteTeamButton.click();
    }
    public void teamsPage(){
        teamsButton.click();
    }
    public void inputInfo(){
    inputTeam.click();//////////////

    }
    public void showTeamInfo(){


    }
    public void showNewTeamInfo(){


    }
    public void showTeamList(){


    }
    public void clickFistTeam(){


    }


}
