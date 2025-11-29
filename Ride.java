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

    //Default constructor
    public Ride() {
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
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
        System.out.println("Successfully removed the visitor '" + removed.getVisitorId() +"' from the waiting queue[" + rideName + "]");
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
        System.out.println("Visitor[" + visitor.getVisitorId() + "]in ride history[" + rideName + "]：" + message);
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Total number of visitors in history[" + rideName + "]: " + count);
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
    /**
     * Sort the ride history using a custom Comparator
     */
    public void sortRideHistory(VisitorComparator comparator) {
        if (comparator == null) {
            System.out.println("Error: The comparator is empty!");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history[" + rideName + "]sorting completed!");
    }
}