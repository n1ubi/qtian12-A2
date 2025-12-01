public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();

        // The demonstrations of all the Parts
        System.out.println("\n* -----==================== Part3 – Waiting line ====================----- *\n");
        demo.partThree();

        System.out.println("\n\n* -----==================== Part4A – Ride history ====================----- *\n");
        demo.partFourA();

        System.out.println("\n\n* -----==================== Part4B – Sorting the ride history ====================----- *\n");
        demo.partFourB();

        System.out.println("\n\n* -----==================== Part5 – Run a ride cycle ====================----- *\n");
        demo.partFive();

        System.out.println("\n\n* -----==================== Part6 – Writing to a file ====================----- *\n");
        demo.partSix();

        System.out.println("\n\n* -----==================== Part7 – Reading from a file ====================----- *\n");
        demo.partSeven();
    }

    public void partThree() {
        // 1. Create an employee
        Employee operator1 = new Employee("Adam", 30, "13820250001", "Emp1001", "Roller coaster");
        // 2. Create a ride
        Ride rollerCoaster = new Ride("Thunderstorm", "Roller coaster", operator1, 10);

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
        System.out.println("\n ---After removing one visitor:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // 1. Create a ride
        Ride bumperCars = new Ride("Go-kart", "Parent-Child Program", null, 8);

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
        Ride ferrisWheel = new Ride("Ferris wheel", "Tourism attractions", null, 6);

        // 2. Add 5 Visitors
        ferrisWheel.addVisitorToHistory(new Visitor("Aaron", 30, "18600001111", "Vis2011", true));
        ferrisWheel.addVisitorToHistory(new Visitor("Baird", 20, "18600002222", "Vis2013", false));
        ferrisWheel.addVisitorToHistory(new Visitor("Carey", 25, "18600003333", "Vis2012", true));
        ferrisWheel.addVisitorToHistory(new Visitor("Dave", 35, "18600004444", "Vis2015", false));
        ferrisWheel.addVisitorToHistory(new Visitor("Ed", 25, "18600005555", "Vis2014", true));

        // 3. Print all Visitors in the collection.
        System.out.println("\n ---Before sorting:");
        ferrisWheel.printRideHistory();

        // 4. Sort the collection
        ferrisWheel.sortRideHistory(new VisitorComparator());

        // 5. Print all Visitors in the collection again to show that the collection has been sorted.
        System.out.println("\n ---After sorting (with or without fast pass → ascending order by age → ascending order by visitor ID):");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        // 1. Create an employee
        Employee operator2 = new Employee("Anni", 28, "12800128000", "Emp1002", "Water-based activities");
        // 2. Create a ride
        Ride rapids = new Ride("Shoot the Rapids", "Water-based activities", operator2, 5);

        // 3. Use a loop to add 10 visitors to the queue
        for (int i = 0; i < 10; i++) {
            rapids.addVisitorToQueue(new Visitor("Visitor0" + (i+1), 20 + i, "1270012700" + i, "Vis10" + (16+i), i%2==0));
        }

        // 4. Print the queue before running
        System.out.println("\n ---Pre-run waiting queue:");
        rapids.printQueue();

        // 5. Run one cycle
        rapids.runOneCycle();

        // 6. Print the queue after running
        System.out.println("\n ---The waiting queue after one cycle of operation: ");
        rapids.printQueue();

        // 7. Print out the ride history
        System.out.println("\n ---Current ride history: ");
        rapids.printRideHistory();
    }

    public void partSix() {
        // 1. Create a ride and add 5 visitors
        Ride carousel = new Ride("Merry-go-round", "Rotation type", null, 5);
        carousel.addVisitorToHistory(new Visitor("George", 8, "12600126000", "Vis1026", true));
        carousel.addVisitorToHistory(new Visitor("Harry", 7, "12500125000", "Vis1027", false));
        carousel.addVisitorToHistory(new Visitor("John", 9, "12400124000", "Vis1028", true));
        carousel.addVisitorToHistory(new Visitor("Kyle", 6, "12300123000", "Vis1029", false));
        carousel.addVisitorToHistory(new Visitor("Evan", 10, "12200122000", "Vis1030", true));

        // 2. Export to CSV file
        carousel.exportRideHistory("ride_history.csv");
    }


    public void partSeven() {
        // 1. Create a ride
        Ride importedRide = new Ride("Testing facilities-(importing files)", "Testing items", null, 10);

        // 2. Import the file exported from Part 6
        importedRide.importRideHistory("ride_history.csv");

        // 3. Print out the total number of people
        importedRide.numberOfVisitors();

        // 4. Print all the visitor information
        importedRide.printRideHistory();
    }

}