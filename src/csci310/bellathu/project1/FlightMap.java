package csci310.bellathu.project1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * FlightMap finds all paths from the starting city to all other cities as specified in a
 * <a href="./FlightMatrix.html">FlightMatrix</a>
 */
public class FlightMap {

    private FlightMatrix matrix;

    /**
     * Constructor that takes <a href="./FlightMatrix.html">FlightMatrix</a> containing all flights to be searched.
     * @param matrix containing all flights from city to city and starting city to search from
     */
    public FlightMap(FlightMatrix matrix) {
        this.matrix = matrix;
    }

    /**
     * uses BFS to turn existing <a href="./FlightMatrix.html">FlightMatrix</a> into a table of all Paths
     * from the starting city to all other cities
     * @return String of a formatted table to be written to an output file or printed to console.
     */
    public String findAllPaths() {
        Queue<CityNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String output = String.format("%-16s%-16s%-16s%n", "Destination", "Flight Route", "Cost");

        queue.add(new CityNode(matrix.getStartingCity(), 0, null));

        while(!queue.isEmpty()) {
            CityNode currCity = queue.poll();
            visited.add(currCity.getCity());
            output += String.format("%-16s%-16s%-16s%n",
                    currCity.getCity(),
                    getPrevCityPath(currCity),
                    currCity.getCurrTotal());
            matrix.getAdjacentCities(currCity.getCity()).entrySet().stream()
                    .filter(entry -> !visited.contains(entry.getKey()))
                    .forEach(entry -> queue.add(
                                new CityNode(entry.getKey(), currCity.getCurrTotal() + entry.getValue(), currCity)
                            )
                    );
        }
        return output;
    }

    private String getPrevCityPath(CityNode node) {
        String cityPath = "";
        while(node != null) {
            cityPath = node.getCity() + "," + cityPath;
            node = node.getPrev();
        }
        return cityPath.substring(0, cityPath.length()-1);
    }

    private class CityNode {

        private String city;
        private int currTotal;
        private CityNode prev;

        private CityNode(String city, int currTotal, CityNode prev) {
            this.city = city;
            this.currTotal = currTotal;
            this.prev = prev;
        }

        private String getCity() {
            return city;
        }

        private int getCurrTotal() {
            return currTotal;
        }

        private CityNode getPrev() {
            return prev;
        }
    }


}
