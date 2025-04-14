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
        System.out.println("LASTNAME, FIRSTNAME FIRSTNAME | ex: SIMBILLO, JOSE MIGUEL");
        System.out.print("Enter patient name : ");
        String name = sc.next();

        searchPatientByLastName(name);

//        boolean found = false;
//
//        while (!found) {
//            for (int i = 0; i < patientList.size(); i++) {
//                Patient patient = patientList.get(i);
//                if (name.equals(patient.getLastName())) {
//                    System.out.println("Patient found!");
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("Patient not in database.");
//                found = true;
//            }
//        }
    }

    public void searchPatientByLastName(String lastName) {
        try (Connection conn = DatabaseConnector.connect()) {
            String sql = "SELECT * FROM patients WHERE last_name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lastName);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Patient found:");
                System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name") + " " + rs.getString("middle_name"));
                // You can print other details as well
            } else {
                System.out.println("Patient not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}