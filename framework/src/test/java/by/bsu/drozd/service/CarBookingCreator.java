package by.bsu.drozd.service;

import by.bsu.drozd.model.CarBookingCriteria;

import java.time.LocalDate;

public class CarBookingCreator {

    public static final String TESTDATA_PICKUP_LOCATION = "testdata.pickup.location";
    public static final String TESTDATA_DROPOFF_LOCATION = "testdata.dropoff.location";
    public static final String TESTDATA_PICKUP_DATE = "testdata.pickup.date";
    public static final String TESTDATA_DROPOFF_DATE = "testdata.dropoff.date";
    public static final String TESTDATA_PICKUP_TIME = "testdata.pickup.time";
    public static final String TESTDATA_DROPOFF_TIME = "testdata.dropoff.time";
    public static final String TESTDATA_CURRENT_PICKUP_DATE = "testdata.current.pickup.date";
    public static final String TESTDATA_CURRENT_PICKUP_TIME = "testdata.current.pickup.time";


    public static CarBookingCriteria withEmptyDropOffLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                null,
                TestDataReader.getTestData(TESTDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_DATE));
    }

    public static CarBookingCriteria withCurrentTime(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESTDATA_CURRENT_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_CURRENT_PICKUP_TIME),
                TestDataReader.getTestData(TESTDATA_DROPOFF_TIME));
    }

    public static CarBookingCriteria withoutDropOffLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESTDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_TIME),
                TestDataReader.getTestData(TESTDATA_DROPOFF_TIME));
    }

    public static CarBookingCriteria withSameTime(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESTDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_TIME),
                TestDataReader.getTestData(TESTDATA_DROPOFF_TIME));
    }

    public static CarBookingCriteria withImpossibleLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESTDATA_DROPOFF_LOCATION));
    }




}
