package test;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import test.Flight;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

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

public class FlightRepository_UT_Test {
    @Mock
    private ArrayList<Flight> flightsMock;
    @Mock
    private Flight currentFlightMock;
    @InjectMocks
    private FlightRepository flightRepositorySUT;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }



    @Nested
    public class loadFlightDetails {
        @Test
        public void when_xx_then_success() throws Exception {
            String file = "C:\\Users\\jithe\\OneDrive\\Desktop\\System_Engineering_Requirements\\Test1\\flights.csv";

//
//            boolean addReturnValue = false;
//            when(flightsMock.add(new Flight())).thenReturn(addReturnValue);
            Flight mflight = new Flight();


            //2.Act
            flightRepositorySUT.loadFlightDetails(file);
            flightsMock = flightRepositorySUT.getAllFlights();

            //3.Assert
            assertEquals(flightsMock.get(0), null);
        }
    }

    @Nested
    public class getFlight {
        @Test
        public void when_xx_then_success() throws Exception {

            String flightNumber = "flightNumber";
            String category = "category";

            //2.Act
            Flight getFlightRetReturnValue = flightRepositorySUT.getFlight(flightNumber, category);

            //3.Assert
            Flight sutExpected = new Flight();
            assertEquals(sutExpected, getFlightRetReturnValue);
        }
    }

    @Nested
    public class isFlightExist {
        @Test
        public void when_xx_then_success() throws Exception {

            String flightNumber = "flightNumber";
            String seatCategory = "seatCategory";


            //2.Act
            Boolean isFlightExistRetReturnValue = flightRepositorySUT.isFlightExist(flightNumber, seatCategory);

            //3.Assert
            Boolean sutExpected = false;
            assertEquals(sutExpected, isFlightExistRetReturnValue);
        }
    }
}

