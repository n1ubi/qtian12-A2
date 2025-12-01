import java.io.*;
import java.util.*;

public class Ride implements RideInterface{
    private String rideName;       // Name of the amusement facility
    private String rideType;       // Facility type
    private Employee operator;     // Operations Staff (Employee Type)

    // Part3 – Waiting line
    private Queue<Visitor> waitingQueue;

    // Part4A – Ride history
    private LinkedList<Visitor> rideHistory;

    // Part 5 – Run a ride cycle
    private int maxRider;         // Maximum number of passengers for a single run
    private int numOfCycles;      // Number of cycles (default: 0)

    //Default constructor
    public Ride() {
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this();
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider > 0 ? maxRider : 1;
        this.numOfCycles = 0;
    }

    // Getter and setter methods
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider > 0) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Error: The maximum number of passengers that can be carried at one time must be greater than 0!");
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }


    // -------------------------- Part3 – Waiting line --------------------------
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.offer(visitor); // The method for adding to the queue
            System.out.println("Successfully added visitor '" + visitor.getVisitorId() + "' to Queue [" + rideName + "]" );
        } else {
            System.out.println("Error: The visitor object is empty!");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: The waiting queue["  + rideName +  "] is empty!");
            return;
        }
        Visitor removed = waitingQueue.poll(); // Remove the element at the head of the queue
        System.out.println("\n Successfully removed the visitor '" + removed.getVisitorId() +"' from the waiting queue[" + rideName + "]");
    }

    @Override
    public void printQueue() {
        System.out.println("\n Waiting queue[" + rideName + "] (Current number of people: " + waitingQueue.size() + "):");
        if (waitingQueue.isEmpty()) {
            System.out.println("No tourists in the queue.");
            return;
        }
        // Traverse the queue (while maintaining the order)
        int index = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // -------------------------- Part4A – Ride history --------------------------
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully added visitor '" + visitor.getVisitorId() + "' to Ride history [" + rideName + "]" );
        } else {
            System.out.println("Error: The visitor object is empty!");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: The visitor object is empty, unable to query!");
            return false;
        }
        boolean exists = rideHistory.contains(visitor);
        // Rewrite the equals method of the Visitor class
        String message = exists ? "Existence" : "Does not exist";
        System.out.println("\n Visitor[" + visitor.getVisitorId() + "]in ride history[" + rideName + "]：" + message);
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("\n Total number of visitors in history[" + rideName + "]: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.println("\n Ride history[" + rideName + "] (Total number of people:" + rideHistory.size() + "):");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitor records exist in the history.");
            return;
        }
        // Using Iterator for traversal
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // -------------------------- Part 4B – Sorting the ride history --------------------------
    public void sortRideHistory(VisitorComparator comparator) {
        if (comparator == null) {
            System.out.println("\n Error: The comparator is empty!");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("\n Ride history[" + rideName + "]sorting completed!");
    }

    // -------------------------- Part 5 – Run a ride cycle --------------------------
    @Override
    public void runOneCycle() {
        System.out.println("\n***** Start running[" + rideName + "] cycle-" + (numOfCycles + 1) + " *****");
        // Verification 1: Are there any operation personnel?
        if (operator == null) {
            System.out.println("Operation failed: [" + rideName + "] No operational staff assigned!");
            return;
        }
        // Verification 2: Check if there are any visitors in the waiting queue
        if (waitingQueue.isEmpty()) {
            System.out.println("Operation failed: [" + rideName + "] The waiting queue is empty!");
            return;
        }
        // Take the maxRider number of visitors from the queue and add them to the historical record.
        int takeCount = 0;
        while (takeCount < maxRider && !waitingQueue.isEmpty()) {
            Visitor visitor = waitingQueue.poll();
            addVisitorToHistory(visitor);
            takeCount++;
        }

        numOfCycles++;
        System.out.println("***** [" + rideName + "] cycle-" + numOfCycles + " Operation successful! Tt carried " + takeCount + " people *****");
    }

    // -------------------------- Part 6 – Writing to a file --------------------------
    public void exportRideHistory(String filePath) {
        System.out.println("\n***** Start exporting [" + rideName + "] ride history to file: " + filePath + " *****");
        // Exception handling
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Traverse the historical records and write them out in CSV format (fields: name, age, phone number, visitor ID, fast pass)
            for (Visitor visitor : rideHistory) {
                String line = String.join(",",
                        visitor.getName(),
                        String.valueOf(visitor.getAge()),
                        visitor.getPhoneNumber(),
                        visitor.getVisitorId(),
                        String.valueOf(visitor.isHasFastPass())
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Export successful! A total of " + rideHistory.size() + " tourist records were exported.");
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    // -------------------------- Part 7 – Reading from a file --------------------------
    public void importRideHistory(String filePath) {
        System.out.println("\n***** Start importing ride history from the file: " + filePath + " *****");
        // Exception handling
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int importCount = 0;
            // Read the CSV file line by line
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Skip the blank line
                // Split field (comma-separated)
                String[] fields = line.split(",");
                if (fields.length != 5) {
                    System.out.println("Skip invalid rows (incorrect number of fields): " + line);
                    continue;
                }
                // Create a visitor object
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                String contact = fields[2];
                String visitorId = fields[3];
                boolean hasFastPass = Boolean.parseBoolean(fields[4]);
                // Add to history record
                Visitor visitor = new Visitor(name, age, contact, visitorId, hasFastPass);
                rideHistory.add(visitor);
                importCount++;
            }
            System.out.println("Import successful! A total of " + importCount + " visitor records was imported.");
        } catch (FileNotFoundException e) {
            System.out.println("Import failed: The file does not exist - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Import failed: Incorrect data format - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Import failed: IO exception - " + e.getMessage());
        }
    }
}