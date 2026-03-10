import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class User {
    String username;

    public User(String username) {
        this.username = username;
    }

}

class UserRepository {
    static List<User> users = new ArrayList<>();

    static Optional<User> findUserByUsername(String username) {
        return users.stream().filter((u) -> u.username.equals(username)).findFirst();
    }
}

public class Gioi3 {
    public static void main(String[] args) {
        User user = new User("alice");
        UserRepository.users.add(user);

        UserRepository.findUserByUsername("alice").ifPresentOrElse(u -> {
            System.out.println("welcome " + u.username);
        }, () -> {
            System.out.println("Guest login");
        });
    }
}
