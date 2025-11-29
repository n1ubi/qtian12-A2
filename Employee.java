/**
 * Employee class: Inherits from Person, manages information of personnel involved in the operation of amusement facilities
 * Add two exclusive attributes: employee ID and type of rides they are responsible for.
 */
public class Employee extends Person {
    // Exclusive instance variable
    private String employeeId;
    private String operateRideType;

    // Default constructor
    public Employee() {}

    // Parameterized constructor (initializes own properties + parent class properties)
    public Employee(String name, int age, String contact, String employeeId, String operateRideType) {
        super(name, age, contact); // Call the constructor of the parent class
        this.employeeId = employeeId;
        this.operateRideType = operateRideType;
    }

    // Getter and setter methods
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOperateRideType() {
        return operateRideType;
    }

    public void setOperateRideType(String operateRideType) {
        this.operateRideType = operateRideType;
    }

    // Rewrite the toString(): Integrate parent class and own attributes
    @Override
    public String toString() {
        return "Employee Information:[ " + super.toString() + ", Employee ID: " + employeeId + ", The type of responsibility: " + operateRideType + " ]";
    }
}