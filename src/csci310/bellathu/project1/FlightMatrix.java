package csci310.bellathu.project1;

import java.util.HashMap;
import java.util.Map;

public class FlightMatrix {

    private String startingNode;

    private Map<String, Map<String, Integer>> matrix;

    public FlightMatrix(String startingNode) {
        this.matrix = new HashMap<>();
        this.startingNode = startingNode;
    }

    public String getStartingNode() {
        return startingNode;
    }

}
