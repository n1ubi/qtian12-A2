/**
 * Tourist class: Inherits from Person, manages information of visitors to the theme park
 * Two exclusive attributes have been added: the new visitor number and whether a quick pass was purchased.
 */
public class Visitor extends Person {
    // Exclusive instance variable
    private String visitorId;
    private boolean hasFastPass;

    // Default constructor
    public Visitor() {}

    // Parameterized constructor
    public Visitor(String name, int age, String contact, String visitorId, boolean hasFastPass) {
        super(name, age, contact);
        this.visitorId = visitorId;
        this.hasFastPass = hasFastPass;
    }

    // Getter and setter methods
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public boolean isHasFastPass() {
        return hasFastPass;
    }

    public void setHasFastPass(boolean hasFastPass) {
        this.hasFastPass = hasFastPass;
    }

    //Rewrite the toString() method
    @Override
    public String toString() {
        return "Visitor Information:[ " + super.toString() + ", Visitor ID:" + visitorId + ", Fast Pass:" + (hasFastPass ? "Yes" : "No") + " ]";
    }
}