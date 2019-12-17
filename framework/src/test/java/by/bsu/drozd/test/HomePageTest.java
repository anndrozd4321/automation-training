package by.bsu.drozd.test;

import by.bsu.drozd.model.CarBookingCriteria;
import by.bsu.drozd.model.UserData;
import by.bsu.drozd.page.HomePage;
import by.bsu.drozd.service.CarBookingCreator;
import by.bsu.drozd.service.UserDataCreator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends CommonConditions{
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    private HomePage homePage = new HomePage(driver);

    @Test
    public void bookingDropOffTimeEarlierThanPickUpTime() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        homePage.openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPickUpTime())
                .selectDropOffTime(carBookingCriteria.getDropOffTime())
                .redirectToHomePage();
        Assert.assertEquals("There must be at least one hour between pick-up and drop-off", homePage.getAlertMessage());
    }

    @Test
    public void bookingCarWithEmptyDropOffLocation() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withEmptyDropOffLocation();
        homePage.openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .inputDropOffLocation(carBookingCriteria.getDropOffLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .redirectToHomePage();
        Assert.assertEquals("Select a drop-off location", homePage.getAlertMessage());

    }

    @Test
    public void pickUpTimeStartsInFewMinutes() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withCurrentTime();
        homePage.openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPickUpTime())
                .selectDropOffTime(carBookingCriteria.getDropOffTime())
                .redirectToHomePage();
        Assert.assertEquals("We're sorry, but we couldn't find any available cars", homePage.getAlertMessage());
    }

    @Test
    public void pickUpDateAndTimeCoincidesWithDropOff() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withSameTime();
        homePage.openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPickUpTime())
                .selectDropOffTime(carBookingCriteria.getDropOffTime())
                .redirectToHomePage();
        Assert.assertEquals("There must be at least one hour between pick-up and drop-off", homePage.getAlertMessage());
    }

    @Test
    public void searchNonexistentBooking() {
        UserData userData = UserDataCreator.withCorrectData();
        homePage.openPage()
                .clickToMyBooking()
                .inputBookingNumber(userData.getBookingNumber())
                .inputEmail(userData.getEmail())
                .clickSignInButton();
        Assert.assertEquals("Booking not found\n" +
                        "Something is broken. Please navigate to another page or search below!", homePage.getLoginErrorMessage());
    }

    @Test
    public void subscribe() {
        UserData userData = UserDataCreator.withCorrectData();
        homePage.openPage()
                .inputUserName(userData.getUserName())
                .inputEmail(userData.getEmail())
                .clickSubscribe();
        Assert.assertEquals("Thanks for signing up! !!!!!!!!!!!!!!", homePage.getLoginErrorMessage());
    }

    @Test
    public void impossiblePlacesForBooking() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withImpossibleLocation();
        homePage.openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .inputDropOffLocation(carBookingCriteria.getDropOffLocation())
                .redirectToHomePage();
        Assert.assertEquals("Unable to find any location. Select a pick-up location", homePage.getAlertMessage());
    }


}
