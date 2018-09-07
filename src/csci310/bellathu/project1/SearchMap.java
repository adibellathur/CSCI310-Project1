package csci310.bellathu.project1;

import java.io.*;

public class SearchMap {

    private String inputFile;

    public SearchMap(String inputFile) {
        this.inputFile = inputFile;
    }

    public FlightMatrix readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        String line;
        String total = "";
        String startingNode = reader.readLine();
        FlightMatrix matrix = new FlightMatrix(startingNode);
        while((line = reader.readLine()) != null) {
            total += line + "\n";
        }
        return matrix;
    }

    public static void main(String[] args) {
        SearchMap program = new SearchMap("inputfile.txt");
        try {
            System.out.println(program.readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
