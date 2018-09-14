package csci310.bellathu.project1;

import java.io.*;

public class SearchMap {

    private String inputFile;

    public SearchMap(String inputFile) {
        this.inputFile = inputFile;
    }

    public FlightMatrix readFile() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        return createMatrix(reader);
    }

    public FlightMatrix createMatrix(BufferedReader reader) throws IOException {
        String startingNode = reader.readLine();
        FlightMatrix matrix = new FlightMatrix(startingNode);
        String line;
        while((line = reader.readLine()) != null) {
            addToMatrix(matrix, line.split(" "));
        }
        return matrix;
    }

    public void addToMatrix(FlightMatrix matrix, String[] arr) throws IOException {
        if(arr.length == 3) {
            matrix.addPath(arr[0], arr[1], Integer.parseInt(arr[2]));
        } else {
            throw (new IOException());
        }
    }

    public static void main(String[] args) {
        SearchMap program = new SearchMap("inputfile.txt");
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
