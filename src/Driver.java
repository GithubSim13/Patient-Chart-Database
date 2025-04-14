public class Driver {
    public static void main(String[] args) {
        Patient patient1 = new Patient();

        System.out.println("MAIN MENU");
        System.out.println("[1] - Find Patient");
        System.out.println("[2] - View Charts");
        System.out.println("[3] - Close Application");

        Input mainMenuInput = new Input();
        mainMenuInput.getMenuInput();
    }
}