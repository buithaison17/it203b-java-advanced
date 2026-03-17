package gioi2;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.attach(new Fan());
        temperatureSensor.attach(new Humidifier());
        temperatureSensor.setTemperature(19);
        temperatureSensor.setTemperature(23);
        temperatureSensor.setTemperature(30);
    }
}
