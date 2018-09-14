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
            "Destination\t\tFlight Route\t\tCost\n" +
            STARTING_NODE + "\t\t\tin\t\t\t0\n";

    public static final String TWOCITIESTEST_SOLUTION =
            "Destination\t\tFlight Route\t\tCost\n" +
            STARTING_NODE + "\t\t\tin\t\t\t0\n" +
            DEST_1 + "\t\t\t" + DEST_1_HISTORY + "\t\t\t" + DEST_1_PRICE + "\n";

    public static final String TEST_INPUT_FILE_SOLUTION =
            "Destination\t\tFlight Route\t\tCost\n" +
            "P\t\t\tP\t\t\t0\n" +
            "R\t\t\tP,R\t\t\t300\n" +
            "W\t\t\tP,W\t\t\t200\n" +
            "X\t\t\tP,R,X\t\t\t500\n";

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
        SearchMap sm = new SearchMap(TEST_INPUT_FILE);
        FlightMatrix matrix = sm.readFile();
        FlightMap map = new FlightMap(matrix);
        assertEquals(map.findAllPaths(), TEST_INPUT_FILE_SOLUTION);
    }
}
