package gioi2;

public class Fan implements Observer {

    @Override
    public void update(int temperature) {
        if (temperature < 20) {
            System.out.println("Tat quat");
        } else if (temperature < 25) {
            System.out.println("Quat chay trung binh");
        } else {
            System.out.println("Quat chay manh");
        }
    }
}
