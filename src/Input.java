import java.util.Objects;
import java.util.Scanner;

public class Input {
    public void getMenuInput() {
        /*
        To-Do:
        - add input validation loop
        - move search engine into separate class that stores
            an arraylist of patients?
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice : ");
        String choice = sc.next();

        switch (choice) {
            case "1":
                System.out.println("Moving to patient search engine...");
                System.out.println();
                patientSearchEngine();
                break;
            case "2":
                System.out.println("Moving to chart database...");
                break;
            case "3":
                System.out.println("Closing application...");
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void patientSearchEngine() {
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
