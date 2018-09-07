package csci310.bellathu.project1;

import java.io.*;

public class SearchMap {

    private String inputFile;

    public SearchMap(String inputFile) {
        this.inputFile = inputFile;
    }

    public FlightMatrix readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        String startingNode = reader.readLine();
        FlightMatrix matrix = new FlightMatrix(startingNode);

        String line;
        while((line = reader.readLine()) != null) {
            String[] arr = line.split(" ");
            if(arr.length == 3) {
                System.out.println(arr[0] + arr[1] + arr[2]);
            } else {
                System.out.println("ERROR");
            }
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
