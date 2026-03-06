class User {
    private int age;

    public User(int age) {
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong the am");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [age=" + age + "]";
    }

}

public class Gioi3 {
    public static void main(String[] args) {
        User user = new User(3);
        System.out.println(user.toString());
    }
}
