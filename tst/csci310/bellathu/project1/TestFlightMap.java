package csci310.bellathu.project1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestFlightMap {

    public static final String STARTING_NODE = "in";

    public static final String DEST_1 = "A";
    public static final int DEST_1_PRICE = 100;
    public static final String DEST_1_HISTORY = "in,A";

    public static final String TEST_INPUT_FILE = "tst/testinputfile.txt";

    public static final String INITIALTEST_SOLUTION =
            String.format("%-16s%-16s%-16s%n", "Destination", "Flight Route", "Cost") +
            String.format("%-16s%-16s%-16s%n", STARTING_NODE, STARTING_NODE, 0);

    public static final String TWOCITIESTEST_SOLUTION =
            String.format("%-16s%-16s%-16s%n", "Destination", "Flight Route", "Cost") +
            String.format("%-16s%-16s%-16s%n", STARTING_NODE, STARTING_NODE, 0) +
            String.format("%-16s%-16s%-16s%n", DEST_1, DEST_1_HISTORY, DEST_1_PRICE);

    public static final String TEST_INPUT_FILE_SOLUTION =
            String.format("%-16s%-16s%-16s%n", "Destination", "Flight Route", "Cost") +
            String.format("%-16s%-16s%-16s%n", "P", "P", 0) +
            String.format("%-16s%-16s%-16s%n", "R", "P,R", 300) +
            String.format("%-16s%-16s%-16s%n", "W", "P,W", 200) +
            String.format("%-16s%-16s%-16s%n", "X", "P,R,X", 500);

    @Test
    public void mapIniitialTest() {
        FlightMap map = new FlightMap(new FlightMatrix(STARTING_NODE));
        assertEquals(map.findAllPaths(), INITIALTEST_SOLUTION);
    }

    @Test
    public void mapTestWith2Cities() {
        FlightMatrix matrix = new FlightMatrix(STARTING_NODE);
        matrix.addPath(STARTING_NODE, DEST_1, DEST_1_PRICE);
        FlightMap map = new FlightMap(matrix);
        assertEquals(map.findAllPaths(), TWOCITIESTEST_SOLUTION);
    }

    @Test
    public void mapTestWithTestInputFile() throws IOException {
        SearchMap sm = new SearchMap(TEST_INPUT_FILE, "");
        FlightMatrix matrix = sm.readFile();
        FlightMap map = new FlightMap(matrix);
        assertEquals(map.findAllPaths(), TEST_INPUT_FILE_SOLUTION);
    }
}
