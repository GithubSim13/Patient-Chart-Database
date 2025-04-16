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
        System.out.println(" ");

//        System.out.print("|");
//        System.out.print("   Date   ");
//        System.out.print("|");
//        System.out.print(" No. ");
//        System.out.print("|");
//        System.out.print("       Description       ");
//        System.out.print("  Time  ");
//        System.out.print("|");
//        System.out.print("  Debit  ");
//        System.out.print("|");
//        System.out.print(" CreditDate ");
//        System.out.print("|");
//        System.out.print(" CreditAmt ");
//        System.out.print("|");
//        System.out.print("  Balance  ");
//        System.out.println("|");
//
//        System.out.print("|");
//        System.out.print("          ");
//        System.out.print("|");
//        System.out.print("     ");
//        System.out.print("|");
//        System.out.print("                         ");
//        System.out.print("        ");
//        System.out.print("|");
//        System.out.print("         ");
//        System.out.print("|");
//        System.out.print("            ");
//        System.out.print("|");
//        System.out.print("           ");
//        System.out.print("|");
//        System.out.print("           ");
//        System.out.print("|");

        String[] headers = {
                "Date", "No.", "Description", "Time", "Debit", "CreditDate", "CreditAmt", "Balance"
        };
        int[] widths = {10, 5, 25, 8, 9, 12, 11, 10};

// Print header row
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.print(Utilities.center(headers[i], widths[i]));
            System.out.print("|");
        }
        System.out.println();

        String[][] visitRows = {
                {"2025-04-14", "1", "Tooth Extraction", "14:00", "1500", "2025-04-16", "1500", "0"},
                {"2025-04-15", "2", "Filling", "10:30", "800", "2025-04-18", "800", "0"}
        };

        for (String[] row : visitRows) {
            System.out.print("|");
            for (int i = 0; i < row.length; i++) {
                System.out.print(Utilities.center(row[i], widths[i]));
                System.out.print("|");
            }
            System.out.println();
        }
    }
}