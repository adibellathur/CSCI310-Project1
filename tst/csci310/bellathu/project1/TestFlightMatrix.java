package csci310.bellathu.project1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFlightMatrix {

    public static final String START = "init";
    public static final String DEST_1 = "A";
    public static final String DEST_2 = "B";
    public static final String DEST_3 = "C";
    public static final String STARTING_NODE_MAP = "init:\n";
    public static final String FOUR_NODE_MAP =
            "init:\n" +
            "\tA (0)\n" +
            "\tB (0)\n" +
            "\tC (0)\n";
    public static final String DUPLICATE_NODE_MAP =
            "init:\n" +
            "\tA (0)\n";

    @Test
    public void justStartingNode() {
        FlightMatrix matrix = new FlightMatrix(START);
        assertEquals(STARTING_NODE_MAP, matrix.toString());
    }

    @Test
    public void addMultiplePaths() {
        FlightMatrix matrix = new FlightMatrix(START);
        matrix.addPath(START, DEST_1, 0);
        matrix.addPath(START, DEST_2, 0);
        matrix.addPath(START, DEST_3, 0);
        assertEquals(FOUR_NODE_MAP, matrix.toString());
    }

    @Test
    public void addDuplicatePaths() {
        FlightMatrix matrix = new FlightMatrix(START);
        matrix.addPath(START, DEST_1, 0);
        matrix.addPath(START, DEST_1, 0);
        assertEquals(DUPLICATE_NODE_MAP, matrix.toString());
    }

    @Test
    public void getStartingNode() {
        FlightMatrix matrix = new FlightMatrix(START);
        assertEquals(START, matrix.getStartingNode());
    }

}
