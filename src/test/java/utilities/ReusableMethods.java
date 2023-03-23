package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {
    public static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    public static Actions actions =new Actions(Driver.getDriver());

    public static Faker faker = new Faker();
    public static String getScreenShot(WebDriver driver, String name) throws IOException {
        String date = formatCurrentDate("yyyyMMdd_HHmmss");
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "\\test-output\\Screenshots\\"+name+date+".png";
        File file = new File(target);
        FileUtils.copyFile(source,file);
        return target;
    }

    public static String formatCurrentDate(String pattern){
        return new SimpleDateFormat(pattern).format(new Date());
    }


    //locate tıklar
    public static void click(WebElement element) {
        actions.scrollToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    //locate elemanına text gönderir
    public static void sendKeys(WebElement element, String text) {
        actions.scrollToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }



    }



