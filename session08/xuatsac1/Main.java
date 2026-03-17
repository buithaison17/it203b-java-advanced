package xuatsac1;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Light light = new Light();
        AirConditioner airConditioner = new AirConditioner();

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.attach(airConditioner);
        temperatureSensor.attach(fan);

        System.out.println("Che do ngu");
        SleepModeCommand sleepModeCommand = new SleepModeCommand(fan, light, airConditioner);
        sleepModeCommand.excute();

        System.out.println("Nhiet do lon hon 32");
        temperatureSensor.setTemperature(32);

    }
}
