import java.util.Objects;
import java.util.Scanner;

public class Input {
    public void getMenuInput() {
        /*
        To-Do:
        - add input validation
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice : ");
        String choice = sc.next();

        switch (choice) {
            case "1":
                System.out.println("Moving to patient search engine...");
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
}
