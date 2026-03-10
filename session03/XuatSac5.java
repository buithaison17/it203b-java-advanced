import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record User(String name) {
};

public class XuatSac5 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("son"),
                new User("bob"),
                new User("charlie"),
                new User("alexander"),
                new User("charlotte"),
                new User("Benjamin")));
        users.sort(Comparator.comparingInt(u -> ((User) u).name().length()).reversed());
        users.stream().limit(3).forEach(System.out::println);
    }
}
