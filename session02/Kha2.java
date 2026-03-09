@FunctionalInterface
interface PasswordValidator {
    boolean isValid(String password);
}

public class Kha2 {
    public static void main(String[] args) {
        PasswordValidator checkPassword = (password) -> password.length() < 6;
        System.out.println(checkPassword.isValid("123456"));
    }
}
