package by.bsu.drozd.page;

import by.bsu.drozd.model.CarBookingCriteria;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

    private final String HOMEPAGE_URL = "https://www.discovercars.com/";
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Home page opened");
        return this;
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

    @FindBy(xpath = "//input[@id='driver-over-min-age']")
    private WebElement driversAgeButton;

    @FindBy(xpath = "//button[@id='document']")
    private  WebElement selectMyBooking;

    @FindBy(xpath = "//button[@id='my-booking-form']")
    private  WebElement selectSignIn;

    @FindBy(xpath = "//input[@id='my-booking-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='my-booking-number']")
    private WebElement bookingNumber;

    @FindBy(xpath = "//input[@id='sub-name']")
    private WebElement userName;

    @FindBy(xpath = "//button[@id='subscribeBtn']")
    private  WebElement subscribe;

    @FindBy(xpath = "//div[@id='showLoginErrorMessage']") //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private WebElement errorMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage clickToMyBooking(){
        selectSignIn.click();
        return this;
    }

    public HomePage inputEmail(String emailAdress){
        email.sendKeys(emailAdress);
        return this;
    }

    public HomePage inputBookingNumber(String userBookingNumber){
        bookingNumber.sendKeys(userBookingNumber);
        return this;
    }

    public CarSelectionPage bookingCar(CarBookingCriteria carBookingCriteria) {
        inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpTime(carBookingCriteria.getPickUpTime())
                .selectDropOffTime(carBookingCriteria.getDropOffDate())
                .redirectToCarSelectionPage();
        logger.log(Level.INFO, "Car selection page performed.");
        return new CarSelectionPage(driver);
    }

    public HomePage clickSignInButton(){
        selectSignIn.click();
        return this;
    }

    public String getLoginErrorMessage(){
        return errorMessage.getText();
    }


    public HomePage inputPickUpLocation(String pickLoc) {
        pickUpLocation.sendKeys(pickLoc);
        return this;
    }

    public HomePage inputDropOffLocation(String dropLoc) {
        dropOffLocationButton.click();
        pickUpLocation.sendKeys(dropLoc);
        return this;
    }

    public HomePage selectPickUpDate(String picDate) {
        dropOffDateButton.sendKeys(picDate);
        return this;
    }

    public HomePage selectDropOffDate(String dropDate) {
        dropOffDateButton.sendKeys(dropDate);
        logger.info("Filled 'Drop off date' field with " + dropDate);
        return this;
    }

    public CarSelectionPage redirectToCarSelectionPage() {
        searchButton.click();
        return new CarSelectionPage(driver);
    }

    public HomePage redirectToHomePage() {
        searchButton.click();
        logger.log(Level.INFO, "Car selection page performed.");
        return this;
    }

    public HomePage selectPickUpTime(String pickTime) {
        new Select(pickUpTimeButton).selectByValue(pickTime);
        return this;
    }

    public HomePage selectDropOffTime(String dropTime) {
        new Select(dropOffTimeButton).selectByValue(dropTime);
        return this;
    }

    public HomePage inputUserName(String uName) {
        userName.sendKeys(uName);
        logger.info("Filled 'User name' field with " + uName);
        return this;
    }

    public HomePage clickSubscribe(){
        subscribe.click();
        return this;
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }
}
