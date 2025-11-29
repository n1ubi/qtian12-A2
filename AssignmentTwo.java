public class AssignmentTwo {
    public static void main(String[] args) {

    }

    public void partThree() {
        // 1. Create a staff object
        Employee operator1 = new Employee("Adam", 30, "13820250001", "Emp1001", "Roller coaster");
        // 2. Create a ride
        Ride rollerCoaster = new Ride("Thunderstorm", "Roller coaster", operator1);

        // 3. Add 5 Visitors to the Queue.
        rollerCoaster.addVisitorToQueue(new Visitor("Jack", 25, "13900001001", "Vis1001", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Peter", 35, "13900001002", "Vis1002", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Mary", 22, "13900001003", "Vis1003", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Alan", 28, "13900001004", "Vis1004", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Bill", 32, "13900001005", "Vis1005", false));

        // 4. Print all Visitors in the Queue.
        rollerCoaster.printQueue();

        // 5. Remove a Visitor from the Queue.
        rollerCoaster.removeVisitorFromQueue();

        // 6. Print out the queue after removing the visitor
        System.out.println("\n After removing one visitor:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // 1. Create a ride
        Ride bumperCars = new Ride("Merry-go-round", "Rotation type", null);

        // 2. Add 5 Visitors to the Ride history
        Visitor v1 = new Visitor("Bard", 18, "13100882001", "Vis1006", false);
        Visitor v2 = new Visitor("Carter", 24, "13100882002", "Vis1007", true);
        Visitor v3 = new Visitor("Duke", 30, "13100882003", "Vis1008", false);
        Visitor v4 = new Visitor("Eden", 26, "13100882004", "Vis1009", true);
        Visitor v5 = new Visitor("Daniel", 22, "13100882005", "Vis1010", false);

        bumperCars.addVisitorToHistory(v1);
        bumperCars.addVisitorToHistory(v2);
        bumperCars.addVisitorToHistory(v3);
        bumperCars.addVisitorToHistory(v4);
        bumperCars.addVisitorToHistory(v5);

        // 3. Check if a Visitor is in the collection.
        bumperCars.checkVisitorFromHistory(v3);
        bumperCars.checkVisitorFromHistory(new Visitor("BB-8", 20, "123456", "Vis9999", false)); // Non-existent object

        // 4. Print the number of Visitors in the collection.
        bumperCars.numberOfVisitors();

        // 5. Print all Visitors in the collection.
        bumperCars.printRideHistory();
    }

    public void partFourB() {
        // 1. Create a ride
        Ride ferrisWheel = new Ride("Ferris wheel", "Tourism attractions", null);

        // 2. Add 5 Visitors
        ferrisWheel.addVisitorToHistory(new Visitor("Aaron", 30, "111", "Vis2011", true));
        ferrisWheel.addVisitorToHistory(new Visitor("Baird", 20, "222", "Vis2013", false));
        ferrisWheel.addVisitorToHistory(new Visitor("Carey", 25, "333", "Vis2012", true));
        ferrisWheel.addVisitorToHistory(new Visitor("Dave", 35, "444", "Vis2015", false));
        ferrisWheel.addVisitorToHistory(new Visitor("Ed", 25, "555", "Vis2014", true));

        // 3. Print all Visitors in the collection.
        System.out.println("Before sorting:");
        ferrisWheel.printRideHistory();

        // 4. Sort the collection
        ferrisWheel.sortRideHistory(new VisitorComparator());

        // 5. Print all Visitors in the collection again to show that the collection has been sorted.
        System.out.println("\n After sorting (with or without fast pass → ascending order by age → ascending order by visitor ID):");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}