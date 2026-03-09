import java.util.function.Function;
import java.util.function.Predicate;

class User {
    private String fullName;
    private String role;

    public User(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

public class Kha1 {
    public static void main(String[] args) {
        User user = new User("Son", "user");
        // Kiểm tra xem một User có phải là Admin hay không (trả về true/false).
        Predicate<User> isAdmin = (u) -> u.getRole().equals("admin");
        System.out.println(isAdmin.test(user) ? "Admin" : "User");

        // Chuyển đổi một đối tượng User thành một chuỗi String chứa thông tin username.
        Function<User, String> studentToStr = (u) -> "Ten nguoi dung: " + u.getFullName();
        System.out.println(studentToStr.apply(user));
    }
}