package by.bsu.drozd.page;

import by.bsu.drozd.model.UserData;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends AbstractPage {
    private final String PAYMENTPAGE_URL = "https://www.discovercars.com/en/reservation/payment/X8EmgDuOGrvRNHSelr2brY7-w7fUOhMCxu63mQSr360,/DC-1205374";
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public PaymentPage openPage() {
        driver.navigate().to(PAYMENTPAGE_URL);
        logger.info("Payment page opened");
        return this;
    }

    @FindBy(xpath = "//input[@id='ccNumber']")
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@id='ccName']")
    private WebElement nameOnCard;

    @FindBy(xpath = "//select[@id='ccExpMonth']")
    private WebElement expirationDateMonth;

    @FindBy(xpath = "//select[@id='ccExpYear']")
    private WebElement expirationDateYear;

    @FindBy(xpath = "//input[@id='ccName']")
    private WebElement cvcCVV;

    @FindBy(xpath = "//button[@id='ccForm']")
    private WebElement bookNow;


    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PaymentPage inputCardNumber(String cardNum) {
        cardNumber.sendKeys(cardNum);
        return this;
    }

    public PaymentPage inputNameOnCard(String nameCard) {
        nameOnCard.sendKeys(nameCard);
        return this;
    }

    public PaymentPage selectExpirationDateMonth(String dateMonth) {
        expirationDateMonth.sendKeys(dateMonth);
        return this;
    }

    public PaymentPage selectExpirationDateYear(String dateYear) {
        expirationDateYear.sendKeys(dateYear);
        return this;
    }

    public PaymentPage inputCvcCVV(String cvcCvv) {
        cvcCVV.sendKeys(cvcCvv);
        return this;
    }

    public PaymentPage clickBookNow() {
        bookNow.click();
        return this;
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }
}
