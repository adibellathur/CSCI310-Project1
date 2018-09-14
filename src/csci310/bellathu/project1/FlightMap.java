package csci310.bellathu.project1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FlightMap {

    private FlightMatrix matrix;

    public FlightMap(FlightMatrix matrix) {
        this.matrix = matrix;
    }

    public String findAllPaths() {
        Queue<CityNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String output = "Destination\t\tFlight Route\t\tCost\n";

        queue.add(new CityNode(matrix.getStartingNode(), 0, null));

        while(!queue.isEmpty()) {
            CityNode currCity = queue.poll();
            visited.add(currCity.getCity());
            output += currCity.getCity()+"\t\t\t"+getPrevCityPath(currCity)+"\t\t\t"+currCity.getCurrTotal()+"\n";
            matrix.getAdjacentCities(currCity.getCity()).entrySet().stream()
                    .filter(entry -> !visited.contains(entry.getKey()))
                    .forEach(entry -> queue.add(
                                new CityNode(entry.getKey(), currCity.getCurrTotal() + entry.getValue(), currCity)
                            )
                    );
        }
        return output;
    }

    public String getPrevCityPath(CityNode node) {
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

        public CityNode(String city, int currTotal, CityNode prev) {
            this.city = city;
            this.currTotal = currTotal;
            this.prev = prev;
        }

        public String getCity() {
            return city;
        }

        public int getCurrTotal() {
            return currTotal;
        }

        public CityNode getPrev() {
            return prev;
        }
    }


}
