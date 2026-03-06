class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class User {
    private int age;

    public User(int age) throws InvalidAgeException {
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [age=" + age + "]";
    }

}

public class XuatSac5 {
    public static void main(String[] args) {
        try {
            User user = new User(-1);
            System.out.println(user.toString());
        } catch (InvalidAgeException e) {
            System.out.println("Tuoi khong hop le");
        }
    }
}