import java.util.List;

record User(String id, String fullName, String status) {
}

public class Kha1 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("1", "alice", "active"),
                new User("2", "bob", "inactive"),
                new User("3", "charlie", "active"));

        users.forEach(System.out::println);
    }
}
