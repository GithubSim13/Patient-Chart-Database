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

    public Patient (String lName, String fName, String mName, String address, String telephone, int age, String occupation, String status, String complain) {
        this.lastName = lName;
        this.firstName = fName;
        this.middleName = mName;
        this.address = address;
        this.telephone = telephone;
        this.age = age;
        this.occupation = occupation;
        this.status = status;
        this.complain = complain;
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

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void displayPatientChart() {
        /*
        Most of this will be removed eventually once I start working
            on the gui and stuff.
        Will need to add another table in the DB called visits for all
            the visits each patient has had
         */
        System.out.print("[|][|][|][|][|][|][|][|][|][|][|][|][|][|][|][|]");
        System.out.print("     ");
        System.out.println("Name : " + lastName + ", " + firstName + " " + middleName);

        System.out.print("[|][|][|][|][|][|][|][|][|][|][|][|][|][|][|][|]");
        System.out.print("     ");
        System.out.println("Address : " + address);

        System.out.print("[|][|][|][|][|][|][|][|][|][|][|][|][|][|][|][|]");
        System.out.print("     ");
        System.out.print("Telephone : " + telephone);
        System.out.print("   ");
        System.out.println("Age : " + age);

        System.out.print("[|][|][|][|][|][|][|][|][|][|][|][|][|][|][|][|]");
        System.out.print("     ");
        System.out.println("Occupation : " + occupation);

        System.out.print("                                                ");
        System.out.print("     ");
        System.out.println("Status : " + status);

        System.out.print("                                                ");
        System.out.print("     ");
        System.out.println("Complain : " + complain);
    }
}