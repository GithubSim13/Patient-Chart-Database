public class Patient {
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String telephone;
    private int age;
    private String occupation;
    private String status;
    private String complain;

    public Patient (String lName, String fName, String mName, String address, String telephone, int age) {
        this.lastName = lName;
        this.firstName = fName;
        this.middleName = mName;
        this.address = address;
        this.telephone = telephone;
        this.age = age;
    }

    public void setOccupation() {
        this.occupation = occupation;
    }

    public void setStatus() {
        this.occupation = occupation;
    }

    public void setComplain() {
        this.occupation = occupation;
    }

    public String getLastName() {
        return lastName;
    }
}