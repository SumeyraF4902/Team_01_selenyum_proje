package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
    Faker faker = new Faker();
    static String FirstCilckableTeamName;
    static String newTeamName;
    WebDriver driver;
    public TeamsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Teams")
    WebElement teamsButton;
    @FindBy(xpath = "//div[@class='col-9']//a//b")
    public List<WebElement> teamsList;
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
    @FindBy(xpath = "(//div//span[@class='fw-bold'])[3]")
    WebElement saveBekleme;
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void addNewAndEditTeam() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOf(addNewAndEditTeamButton));
        addNewAndEditTeamButton.click();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(saveBekleme));
        newTeamName = faker.name().fullName();
        System.out.println(newTeamName);
        Actions act = new Actions(driver);
        act.moveToElement(inputTeam).click().sendKeys(Keys.BACK_SPACE+newTeamName+ Keys.TAB).sendKeys("Team0001"+Keys.TAB)
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOfAllElements(teamsList));
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                FirstCilckableTeamName = teamName.getText();
                System.out.println("FirstCilckableTeamName= "+FirstCilckableTeamName);
                wait.until(ExpectedConditions.elementToBeClickable(teamName));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", teamName);
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
        wait.withTimeout(Duration.ofSeconds(10));
        System.out.println("Team Names= ");
        String teams = " ";
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                teams += teamName.getText();
            }
        }
        System.out.println(teams);
        Assert.assertTrue(teams.contains(newTeamName));
    }
    public void editTeamAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOf(newTeamDetay));
        String newTeamNameText = newTeamDetay.getText();
        System.out.println(newTeamNameText);
        Assert.assertTrue(newTeamNameText.contains(newTeamName));
    }
    public void deleteTeamAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        wait.until(ExpectedConditions.visibilityOfAllElements(teamsList));
        for (WebElement teamName : teamsList) {
            if (teamName.getText().length() > 0){
                System.out.println(teamName.getText());
                Assert.assertTrue(!teamName.getText().equals(FirstCilckableTeamName));
                break;
            }
        }
    }
}
