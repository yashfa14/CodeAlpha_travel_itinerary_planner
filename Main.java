import java.text.*;
import java.util.*;
class Destination {
    String name;
    Date date;

    public Destination(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}

class TravelPlanner {
    private final ArrayList<Destination> destinations;

    public TravelPlanner() {
        this.destinations = new ArrayList<>();
    }

    public void addDestination(String name, Date date) {
        Destination destination = new Destination(name, date);
        destinations.add(destination);
    }

    public void generate() {
        System.out.println("Generating Itinerary...");
        for (int i = 0; i < destinations.size(); i++) {
            Destination destination = destinations.get(i);
            System.out.println("Day " + (i + 1) + ": " + destination.name + " - " + destination.date);
            displayWeather(destination.name, destination.date);
            displayMaps(destination.name);
            System.out.println("\n");
        }
    }

    private void displayMaps(String destination) {
        System.out.println("Displaying maps for " + destination);
    }

    private void displayWeather(String destination, Date date) {

        System.out.println("Displaying weather for " + destination + " on " + date);
    }

    public void calculate() {
        System.out.println("Calculating and displaying budget");
    }
}

public class Main {
    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Destination");
            System.out.println("2. Generate Itinerary");
            System.out.println("3. Calculate Budget");
            System.out.println("4. Exit");

            System.out.print("Enter your choice ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter destination: ");
                    String destinationName = sc.next();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateString = sc.next();
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = dateFormat.parse(dateString);
                        planner.addDestination(destinationName, date);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                    }
                    break;
                case 2:
                    planner.generate();
                    break;
                case 3:
                    planner.calculate();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
