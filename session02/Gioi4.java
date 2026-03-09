import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

public class Gioi4 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Son", "Kien", "Tron", "Bui Son"));
        // () -> new User() (Tham chiếu Constructor).
        List<User> users = names.stream().map(User::new).toList();
        // (user) -> user.getUsername() (Tham chiếu instance method của đối tượng bất kỳ
        // thuộc kiểu cụ thể).
        List<String> fullNames = users.stream()
                .map(User::getFullName)
                .toList();
        fullNames.forEach(System.out::println);
    }
}
