import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    private ArrayList<Patient> patientList;

    public void displaySearchBar() {
        /*
        To-Do:
        - add input validation loop
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Follow any of the naming formats below");
        System.out.println("LASTNAME | ex: SIMBILLO");
        System.out.println("LASTNAME, FIRSTNAME FIRSTNAME | ex: SIMBILLO, JOSE MIGUEL");
        System.out.print("Enter patient name : ");
        String name = sc.next();
    }
}