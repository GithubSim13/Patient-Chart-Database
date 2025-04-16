public class Utilities {
    public static String center(String text, int width) {
        if (text.length() >= width) return text.substring(0, width); // truncate if needed

        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;

        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }
}
