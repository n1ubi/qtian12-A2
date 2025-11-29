public class Person {
    // Instance variable
    private String name;
    private int age;
    private String phoneNumber;

    // Default constructor
    public Person() {}

    // Parameterized constructor
    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //Data validation: The age must be a positive number.
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Corrected: The age must be a positive number!");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name:" + name + ", Age: " + age + ", PhoneNumber: " + phoneNumber;
    }

}
