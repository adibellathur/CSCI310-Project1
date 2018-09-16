package csci310.bellathu.project1;

import java.io.*;

/**
 * The SearchMap class provides utilities for the main(), such as converting files to adjacency
 * matrices and outputting resulting table to output file.
 *
 * @author Adithya Bellathur
 */
public class SearchMap {

    private String inputFile;

    public SearchMap(String inputFile) {
        this.inputFile = inputFile;
    }

    /**
     *
     * @return A <a href="./FlightMatrix.html">FlightMatrix</a> containing all the flight connections
     * specified in the input file.
     * @throws IOException given input text file is not able to be read. Likely causes: missing file,
     * improper formatting.
     * @throws NumberFormatException connection specified in file does not have integer value for cost.
     */
    public FlightMatrix readFile() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        return createMatrix(reader);
    }

    private FlightMatrix createMatrix(BufferedReader reader) throws IOException {
        String startingNode = reader.readLine();
        FlightMatrix matrix = new FlightMatrix(startingNode);
        String line;
        while((line = reader.readLine()) != null) {
            addToMatrix(matrix, line.split(" "));
        }
        return matrix;
    }

    private void addToMatrix(FlightMatrix matrix, String[] arr) throws IOException {
        if(arr.length == 3) {
            matrix.addPath(arr[0], arr[1], Integer.parseInt(arr[2]));
        } else {
            throw (new IOException());
        }
    }

    public static void main(String[] args) {

        SearchMap program = new SearchMap(args[0]);
        FlightMatrix matrix;
        FlightMap map;

        try {
            matrix = program.readFile();
            map = new FlightMap(matrix);
            System.out.println(map.findAllPaths());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input file. Please use valid inputfile.txt");
            e.printStackTrace();
        }
    }
}
