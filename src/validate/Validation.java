package validate;

public class Validation {

    public static boolean validateString(String s) {
        return s == null || s.isBlank() || s.isEmpty();
    }
}
