
import java.util.HashMap;

public class HM_14_Itinerary_From_Tickets {

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Bombay", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // Step 1: Find the starting point
        String startCity = findStartCity(tickets);

        // Step 2: Print the itinerary
        System.out.println("Itinerary:");
        printItinerary(tickets, startCity);
    }
    // Function to find the starting city (a city that does not have an incoming flight)

    private static String findStartCity(HashMap<String, String> tickets) {
        HashMap<String, Boolean> destinationMap = new HashMap<>();

        // Mark all destinations
        for (String destination : tickets.values()) {
            destinationMap.put(destination, true);
        }

        // The starting city is the one that is not a destination
        for (String departure : tickets.keySet()) {
            if (!destinationMap.containsKey(departure)) {
                return departure;
            }
        }
        return null; // This case should not occur if the input is valid
    }

    // Function to print the itinerary from the starting city
    private static void printItinerary(HashMap<String, String> tickets, String startCity) {
        String currentCity = startCity;
        while (currentCity != null) {
            System.out.print(currentCity + " -> ");
            currentCity = tickets.get(currentCity);
        }
        System.out.print("End");
    }

}
