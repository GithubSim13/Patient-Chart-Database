public class Driver {
    public static void main(String[] args) {
        SearchEngine se = new SearchEngine();

        Input mainMenuInput = new Input(se);
        mainMenuInput.getMenuInput();
    }
}