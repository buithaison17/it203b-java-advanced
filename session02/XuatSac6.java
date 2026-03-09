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

@FunctionalInterface
interface UserProcessor {
    String process(User u);
}

class UserUtils {
    public static String convertToUpperCase(User u) {
        return u.getFullName().toUpperCase();
    }
}

public class XuatSac6 {
    public static void main(String[] args) {
        User user = new User("son");
        UserProcessor userProcessor = UserUtils::convertToUpperCase;
        System.out.println(userProcessor.process(user));
    }
}
