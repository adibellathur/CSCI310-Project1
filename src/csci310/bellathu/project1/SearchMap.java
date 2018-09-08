package csci310.bellathu.project1;

import java.io.*;

public class SearchMap {

    private String inputFile;

    public SearchMap(String inputFile) {
        this.inputFile = inputFile;
    }

    public FlightMatrix readFile() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        String startingNode = reader.readLine();
        FlightMatrix matrix = new FlightMatrix(startingNode);

        String line;
        while((line = reader.readLine()) != null) {
            String[] arr = line.split(" ");
            if(arr.length == 3) {
                matrix.addPath(arr[0], arr[1], Integer.parseInt(arr[2]));
            } else {
                System.out.println("ERROR");
                throw (new IOException());
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SearchMap program = new SearchMap("inputfile.txt");
        FlightMatrix matrix;
        try {
            matrix = program.readFile();
            System.out.println(matrix);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input file. Please use valid inputfile.txt");
            e.printStackTrace();
        }
    }
}
