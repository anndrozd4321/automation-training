package by.bsu.drozd.test;

import by.bsu.drozd.model.CarBookingCriteria;
import by.bsu.drozd.page.HomePage;
import by.bsu.drozd.service.CarBookingCreator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarSelectionPageTest extends CommonConditions {
    private HomePage homePage = new HomePage(driver);
    private final Logger logger = LogManager.getRootLogger();

    @Test
    public void noCarsAvailable() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        String infoMessage = homePage.bookingCar(carBookingCriteria).getInfoMessage();
        Assert.assertEquals("We're sorry, but we couldn't find any available cars" + carBookingCriteria.getPickUpLocation()+
                "don't have any cars available.", infoMessage);
    }

    @Test void rentAndReturnCarInTheSamePlace(){
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        Assert.assertTrue(homePage.bookingCar(carBookingCriteria).getCars());
    }
}
