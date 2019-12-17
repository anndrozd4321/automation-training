import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HomePage {

    private final String HOMEPAGE_URL = "https://www.discovercars.com/";
    private final int WAIT_TIMEOUT_SECONDS = 30;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE d MMM yyyy", Locale.ENGLISH);

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(this.driver, this);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//input[@id='pick-up-location']")
    private WebElement pickUpLocation;

    @FindBy(xpath = "//input[@id='drop-off-location']")
    private WebElement dropOffLocation;

    @FindBy(xpath = "//input[@id='pick-date-ui']")
    private WebElement pickUpDateButton;

    @FindBy(xpath = "//input[@id='drop-date-ui']")
    private WebElement dropOffDateButton;

    @FindBy(xpath = "//select[@id='pick-time']")
    private WebElement pickUpTimeButton;

    @FindBy(xpath = "//select[@id='drop-time']")
    private WebElement dropOffTimeButton;

    @FindBy(xpath = "//button[@id='location-submit']")
    private WebElement searchButton;


    public void inputPickUpLocation(String pickLoc) {
        pickUpLocation.sendKeys(pickLoc);
    }

    public void inputPickUpDate(LocalDate picDate) {
        pickUpDateButton.sendKeys(picDate.format(dateFormatter));
    }

    public void selectDropOffDate(LocalDate dropDate) {
        dropOffDateButton.sendKeys(dropDate.format(dateFormatter));
    }

    public void selectSearchButton() {
        search.click();
    }


    public boolean errorMessageExpected() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.alertIsPresent()) != null;
    }

    public void selectPickUpTime(String picHour, String picMinute) {
        new Select(pickUpTimeButton).selectByValue(picTime);
    }

    public void selectDropOffTime(String dropHour, String dropMinute) {
        new Select(dropOffHour).selectByValue(dropTime);
    }


}
