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

            if (rs.next()) {
                System.out.println("Patient found:");
                System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name"));
            }
            else {
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

            if (rs.next()) {
                System.out.println("Patient found:");
                System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name") + " " + rs.getString("middle_name"));
            }
            else {
                System.out.println("Patient not found.");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}