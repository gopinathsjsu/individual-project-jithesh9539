package test;

import java.util.ArrayList;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Flight_UT_Test {
    @InjectMocks
    private Flight flightSUT;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    public class CalculateTotalPrice {
        @Test
        public void when_xx_then_success() throws Exception {

            int noOfSeatsInBooking = 1;

            //2.Act
            float CalculateTotalPriceRetReturnValue = flightSUT.CalculateTotalPrice(noOfSeatsInBooking);

            //3.Assert
            float sutExpected = 0.0F;
            assertEquals(sutExpected, CalculateTotalPriceRetReturnValue);
        }
    }

    @Nested
    public class modifySeats {
        @Test
        public void when_xx_then_success() throws Exception {
            int noOfSeatsInBooking = 1;

            //2.Act
            Boolean modifySeatsRetReturnValue = flightSUT.modifySeats(noOfSeatsInBooking);

            //3.Assert
            Boolean sutExpected = false;
            assertEquals(sutExpected, modifySeatsRetReturnValue);
        }
    }
}

