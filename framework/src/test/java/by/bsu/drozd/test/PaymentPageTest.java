package by.bsu.drozd.test;

import by.bsu.drozd.model.CarBookingCriteria;
import by.bsu.drozd.model.UserData;
import by.bsu.drozd.page.PaymentPage;
import by.bsu.drozd.service.CarBookingCreator;
import by.bsu.drozd.service.UserDataCreator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentPageTest extends CommonConditions{
    private static final Logger logger = LogManager.getLogger(PaymentPageTest.class);
    private PaymentPage paymentPage = new PaymentPage(driver);

    @Test
    public void paymentWithWrongData() {
        UserData userData = UserDataCreator.paymentWithWrongData();
        paymentPage.openPage()
                .inputCardNumber(userData.getCardNumber())
                .inputNameOnCard(userData.getNameOnCard())
                .selectExpirationDateMonth(userData.getExpirationDateMonth())
                .selectExpirationDateYear(userData.getExpirationDateYear())
                .inputCvcCVV(userData.getCvcCVV())
                .clickBookNow();
        Assert.assertEquals("Invalid card number. Please check the card number and try again.", paymentPage.getAlertMessage());
    }
}
