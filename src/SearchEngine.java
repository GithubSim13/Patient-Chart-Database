import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class SearchEngine {
    private ArrayList<Patient> patientList;

    public SearchEngine() {
        patientList = new ArrayList<>();
    }

    public void addPatient(Patient newPatient) {
        patientList.add(newPatient);
    }

    public void displaySearchBar() {
        /*
        To-Do:
        - add input validation loop
        - add input segregation for different input formats
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Follow any of the naming formats below");
        System.out.println("LASTNAME | ex: SIMBILLO");
        System.out.println("LASTNAME FIRSTNAME FIRSTNAME | ex: SIMBILLO JOSE MIGUEL");
        System.out.print("Enter patient name : ");
        String name = sc.nextLine();

        if (name.contains(" ")) {
            String[] nameParts = name.split("\\s+");
            String lastName = nameParts[0];
            String firstName = String.join(" ", java.util.Arrays.copyOfRange(nameParts, 1, nameParts.length)).trim();
            searchPatientByFirstName(lastName, firstName);
        }
        else {
            searchPatientByLastName(name);
        }
    }

    public void searchPatientByLastName(String lastName) {
        try (Connection conn = DatabaseConnector.connect()) {
            String sql = "SELECT * FROM patients WHERE last_name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lastName);

            ResultSet rs = stmt.executeQuery();

            boolean found = false;
            int i = 1;

            while (rs.next()) {
                if (!found) {
                    System.out.println("Patients found:");
                }
                System.out.println("[" + i + "] - " + rs.getString("last_name") + ", " + rs.getString("first_name") + " " + rs.getString("middle_name"));
                found = true;
                i++;
            }
            if (!found) {
                System.out.println("Patient not found.");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchPatientByFirstName(String lastName, String firstName) {
        try (Connection conn = DatabaseConnector.connect()) {
            String sql = "SELECT * FROM patients WHERE last_name = ? AND first_name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lastName);  // Set last name parameter
            stmt.setString(2, firstName); // Set first name parameter

            ResultSet rs = stmt.executeQuery();

            ArrayList<Patient> matches = new ArrayList<>();
            boolean found = false;
            int i = 1;

            while (rs.next()) {
                if (!found) {
                    System.out.println("Patients found:");
                }
                String lName = rs.getString("last_name");
                String fName = rs.getString("first_name");
                String mName = rs.getString("middle_name");
                String address = rs.getString("address");
                String phone = rs.getString("telephone");
                int age = rs.getInt("age");
                String occupation = rs.getString("occupation");
                String status = rs.getString("status");
                String complaint = rs.getString("complain");

                Patient p = new Patient(lName, fName, mName, address, phone, age, occupation, status, complaint);
                matches.add(p);

                System.out.println("[" + i + "] - " + lName + ", " + fName + " " + mName);
                found = true;
                i++;
            }
            if (!found) {
                System.out.println("Patient not found.");
            }

            Scanner sc = new Scanner(System.in);
            /*
            Fix this part so that it uses int choice = sc.nextInt instead
             */
            int choice = -1;

            while (choice < 1 || choice > matches.size()) {
                System.out.print("Select a patient : ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                }
                else {
                    sc.next();
                    System.out.println("Invalid input. Try again.");
                }
            }

            Patient selected = matches.get(choice - 1);
            System.out.println("Selected patient:");
            System.out.println(selected.getLastName() + ", " + selected.getFirstName() + " " + selected.getMiddleName());
            // TODO: Do something with the selected patient, like show full chart or modify data
            System.out.println("Retrieving patient chart...");
            System.out.println();
            selected.displayPatientChart();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}