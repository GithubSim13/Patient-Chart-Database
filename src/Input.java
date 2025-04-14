import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Input {
    private SearchEngine se;

    public Input(SearchEngine se) {
        this.se = se;
    }

    public void getMenuInput() {
        /*
        To-Do:
        - add input validation loop
         */
        System.out.println("MAIN MENU");
        System.out.println("[1] - Find Patient");
        System.out.println("[2] - View Charts");
        System.out.println("[3] - Close Application");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice : ");
        String choice = sc.next();

        switch (choice) {
            case "1":
                System.out.println("Moving to patient search engine...");
                System.out.println();
                se.displaySearchBar();
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
