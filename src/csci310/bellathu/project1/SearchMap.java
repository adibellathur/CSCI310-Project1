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
    private String outputFile;

    public SearchMap(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
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

    /**
     * Takes a string and writes it to the output file as specified in the constructor
     * @param input String to be written to the file
     * @throws IOException
     */
    public void writeToFile(String input)  throws IOException {
        PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
        writer.print(input);
        writer.close();
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Please specify input and output files");
            return;
        }
        SearchMap program = new SearchMap(args[0], args[1]);
        FlightMatrix matrix;
        FlightMap map;
        try {
            matrix = program.readFile();
            map = new FlightMap(matrix);
            program.writeToFile(map.findAllPaths());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input or output file");
            e.printStackTrace();
        }
    }
}
