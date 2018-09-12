package csci310.bellathu.project1;

import java.util.HashMap;
import java.util.Map;

public class FlightMatrix {

    private String startingNode;

    private Map<String, Map<String, Integer>> matrix;

    public FlightMatrix(String startingNode) {
        this.matrix = new HashMap<>();
        this.startingNode = startingNode;
        this.matrix.putIfAbsent(startingNode, new HashMap<>());
    }

    public String getStartingNode() {
        return startingNode;
    }

    public void addPath(String startNode, String endNode, int price) {
        matrix.putIfAbsent(startNode, new HashMap<>());
        matrix.get(startNode).put(endNode, price);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        matrix.entrySet().stream().forEach(set -> {
            builder.append(set.getKey() + ":\n");
            set.getValue().entrySet().stream().forEach(innerset ->
               builder.append("\t" + innerset.getKey() + " (" + innerset.getValue() + ")\n")
            );
        });
        return builder.toString();
    }

}
