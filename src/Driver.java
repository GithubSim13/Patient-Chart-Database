public class Driver {
    public static void main(String[] args) {
        Patient patient1 = new Patient("SIMBILLO", "JOSE MIGUEL", "BANAN", "Manila", "09989590036", 19);

        System.out.println("MAIN MENU");
        System.out.println("[1] - Find Patient");
        System.out.println("[2] - View Charts");
        System.out.println("[3] - Close Application");

        Input mainMenuInput = new Input();
        mainMenuInput.getMenuInput();
    }
}