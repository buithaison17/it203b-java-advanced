package gioi2;

public class Humidifier implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("May tao am: dieu chinh nhiet do " + temperature);
    }

}
