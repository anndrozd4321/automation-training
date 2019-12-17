package by.bsu.drozd.service;

import by.bsu.drozd.model.CarBookingCriteria;
import by.bsu.drozd.model.UserData;

public class UserDataCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_BOOKING_NUMBER = "testdata.user.booking.number";
    public static final String TESTDATA_USER_CARD_NUMBER = "testdata.user.card.number";
    public static final String TESTDATA_USER_NAME_ON_CARD = "testdata.user.name.on.card";
    public static final String TESTDATA_USER_EXPIRATION_DATE_MONTH = "testdata.user.expiration.date.month";
    public static final String TESTDATA_USER_EXPIRATION_DATE_YEAR ="testdata.user.expiration.date.year";
    public static final String TESTDATA_USER_CVC_CVV = "testdata.user.cvc.cvv";


    public static UserData withCorrectData() {
        return new UserData(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_BOOKING_NUMBER));
    }

    public static UserData paymentWithWrongData(){
        return new UserData(TestDataReader.getTestData(TESTDATA_USER_CARD_NUMBER),
                TestDataReader.getTestData(TESTDATA_USER_NAME_ON_CARD),
                TestDataReader.getTestData(TESTDATA_USER_EXPIRATION_DATE_MONTH),
                TestDataReader.getTestData(TESTDATA_USER_EXPIRATION_DATE_YEAR),
                TestDataReader.getTestData(TESTDATA_USER_CVC_CVV));

    }
}
