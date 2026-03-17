package kha1;

public class AirConditioner implements Device {
    private int temperature = 28;

    @Override
    public void turnOff() {
        System.out.println("Tat dieu hoa");
    }

    @Override
    public void turnOn() {
        System.out.println("Bat dieu hoa");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Da chinh dieu hoa " + temperature + " do");
    }

}
