package csci310.bellathu.project1;

import org.junit.Test;

public class TestFlightMap {

    public static final String STARTING_NODE = "init";

    @Test
    public void iniitialTest() {
        FlightMap map = new FlightMap(new FlightMatrix(STARTING_NODE));
        return;
    }
}
