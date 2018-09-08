package csci310.bellathu.project1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestSearchMap {

    public static final String TEST_INPUT_FILE = "tst/testinputfile.txt";
    public static final String TEST_INPUT_TOO_MANY_LINES_FILE = "tst/invalidtestinputfile.txt";
    public static final String TEST_INPUT_INVALID_PRICE_FILE = "tst/invalidpricetestinputfile.txt";
    public static final String NOT_TEST_INPUT_FILE = "tst/nottestinputfile.txt";
    public static final String TEST_INPUT_MATRIX_STRING =
            "P:\n" +
            "\tR (300)\n" +
            "\tW (200)\n" +
            "R:\n" +
            "\tX (200)\n";

    @Test
    public void TestReadFileWithRealInput() throws IOException {
        SearchMap map = new SearchMap(TEST_INPUT_FILE);
        FlightMatrix matrix = map.readFile();
        assertEquals(TEST_INPUT_MATRIX_STRING,matrix.toString());
    }

    @Test(expected = IOException.class)
    public void TestReadFileWithTooLongLineInput() throws IOException {
        SearchMap map = new SearchMap(TEST_INPUT_TOO_MANY_LINES_FILE);
        map.readFile();
    }

    @Test(expected = NumberFormatException.class)
    public void TestReadFileWithInvalidPriceInput() throws IOException {
        SearchMap map = new SearchMap(TEST_INPUT_INVALID_PRICE_FILE);
        map.readFile();
    }

    @Test(expected = IOException.class)
    public void TestReadFileWithNoInput() throws IOException {
        SearchMap map = new SearchMap(NOT_TEST_INPUT_FILE);
        map.readFile();
    }

}