package csci310.bellathu.project1;

import java.util.HashMap;
import java.util.Map;

/**
 * The FlightMatrix class stores flight paths and the starting city. It also has helper
 * functions to aid in the finding of all paths from the starting city
 */
public class FlightMatrix {

    private String startingCity;

    private Map<String, Map<String, Integer>> matrix;

    /**
     * Creates adjacency matrix and inserts starting node into it.
     * @param startingNode String identifying city where all searches will begin on.
     */
    public FlightMatrix(String startingNode) {
        this.matrix = new HashMap<>();
        this.startingCity = startingNode;
        this.matrix.putIfAbsent(startingNode, new HashMap<>());
    }

    /**
     * Getter for starting city of map.
     * @return String identifying city where all searches will begin on.
     */
    public String getStartingCity() {
        return startingCity;
    }

    /**
     * Stores a new flight
     * @param startNode A string identifying starting city
     * @param endNode A string identifying destination city
     * @param price Integer price of flight
     */
    public void addPath(String startNode, String endNode, int price) {
        matrix.putIfAbsent(startNode, new HashMap<>());
        matrix.get(startNode).put(endNode, price);
    }

    /**
     * generates a formatted string with all the starting and ending cities along with prices.
     * format looks like this:
     *     StartingCity1:
     *         DestinationCity1 (Price),
     *         DestinationCity2 (Price)
     *     StartingCity2:
     *         DestinationCity3 (Price),
     *     ...
     *
     * @return String with formatted start and end locations of all flights
     */
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

    /**
     * Get all flights out of a given city
     *
     * @param currCity A city to get all existing flights from the city
     * @return Map containing destination city as key, price of flight as value
     */
    public Map<String, Integer> getAdjacentCities(String currCity) {
        if(matrix.get(currCity) == null) {
            return new HashMap<>();
        }
        return matrix.get(currCity);
    }

}
