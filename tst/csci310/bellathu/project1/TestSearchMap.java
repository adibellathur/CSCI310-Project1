package csci310.bellathu.project1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TestSearchMap {

    public static final String TEST_INPUT_FILE = "tst/testinputfile.txt";
    public static final String NOT_TEST_INPUT_FILE = "tst/nottestinputfile.txt";
    public static final String TEST_INPUT_STRING = "this\nis\na\ntest\n";

    @Test
    public void TestReadFileWithRealInput() throws IOException {
        SearchMap map = new SearchMap(TEST_INPUT_FILE);
        assertTrue(map.readFile().equals(TEST_INPUT_STRING));
    }

    @Test(expected = IOException.class)
    public void TestReadFileWithNoInput() throws IOException {
        SearchMap map = new SearchMap(NOT_TEST_INPUT_FILE);
        map.readFile();
    }

}