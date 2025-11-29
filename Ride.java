public class Ride {
    private String rideName;       // Name of the amusement facility
    private String rideType;       // Facility type
    private Employee operator;     // Operations Staff (Employee Type)

    //Default constructor
    public Ride() {
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

}
