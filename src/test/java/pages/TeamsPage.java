package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class TeamsPage {
    String FirstCilckableTeamName;
    WebDriver driver;
    public TeamsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Teams")
    WebElement teamsButton;
    @FindBy(xpath = "//div[@class='col-9']//a")
    public List<WebElement> teamsList;
    @FindBy(xpath = "(//div[@class='col-9']//a)[15]")
    WebElement aTeam;
    @FindBy(xpath = "//span[.='team007']")
    WebElement teamDetay;
    @FindBy(xpath = "//div[@class='row mt-2 mb-2']")
    WebElement department;
    @FindBy(xpath = "//button[@class='btn btn-info float-end text-white']")
    WebElement addNewAndEditTeamButton;
    @FindBy(xpath = "//label[@id='name']")
    WebElement newTeamDetay;
    @FindBy(xpath = "//input[@id='name']")
    WebElement inputTeam;
    @FindBy(xpath = "//button[@class='btn btn-danger text-light fw-bold']")
    WebElement deleteTeamButton;
    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveTeamButton;
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void addNewAndEditTeam() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
    wait.until(ExpectedConditions.visibilityOf(addNewAndEditTeamButton));
    addNewAndEditTeamButton.click();
    }
    public void saveTeam(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.elementToBeClickable(saveTeamButton));
        saveTeamButton.click();
    }
    public void deleteTeam(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.elementToBeClickable(deleteTeamButton));
        deleteTeamButton.click();
    }
    public void teamsPage(){
        teamsButton.click();
    }
    public void inputInfo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOf(teamDetay));
    Actions act = new Actions(driver);
    act.moveToElement(inputTeam).click().sendKeys(Keys.BACK_SPACE+"Team0001"+ Keys.TAB).sendKeys("Team0001"+Keys.TAB)
            .sendKeys("Team"+Keys.ENTER+Keys.TAB).sendKeys("Team0001"+Keys.TAB)
            .sendKeys("Business"+Keys.ENTER+Keys.ESCAPE+Keys.TAB+Keys.ENTER).perform();
    }
    public void showTeamList(){
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                System.out.println(teamName.getText());
            }
        }
    }
    public void clickFirstTeam(){
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                FirstCilckableTeamName = teamName.getText();
                System.out.println("FirstCilckableTeamName= "+FirstCilckableTeamName);
                teamName.click();
                break;
            }
        }
    }
    public void listAssertion(){
        Assert.assertTrue(teamsList.size() > 0);
    }
    public void teamInfoAssertion(){
        Assert.assertTrue(department.getText().toLowerCase().contains("department"));
    }
    public void newTeamListAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOf(aTeam));
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                System.out.println("New Team Name= " +teamName.getText());
                Assert.assertTrue(teamName.getText().contains("Team0001"));
                break;
            }
        }
    }
    public void editTeamAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOf(newTeamDetay));
        System.out.println(newTeamDetay.getText());
        Assert.assertTrue(newTeamDetay.getText().contains("Team0001"));
    }
    public void deleteTeamAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOfAllElements(teamsList));
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                System.out.println(teamName.getText());
                Assert.assertTrue(!teamName.getText().contains(FirstCilckableTeamName));
            }
        }
    }
}
