public class Driver {
    public static void main(String[] args) {
        SearchEngine se = new SearchEngine();
        Patient patient1 = new Patient("SIMBILLO", "JOSE MIGUEL", "BANAN", "Manila", "09989590036", 19);
        se.addPatient(patient1);

        Input mainMenuInput = new Input(se);
        mainMenuInput.getMenuInput();
    }
}