import java.util.ArrayList;
import java.util.Scanner;

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

        boolean found = false;

        while (!found) {
            for (int i = 0; i < patientList.size(); i++) {
                Patient patient = patientList.get(i);
                if (name.equals(patient.getLastName())) {
                    System.out.println("Patient found!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Patient not in database.");
                found = true;
            }
        }

    }
}