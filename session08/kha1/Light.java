package kha1;

public class Light implements Device {
    @Override
    public void turnOff() {
        System.out.println("Tat den");
    }

    @Override
    public void turnOn() {
        System.out.println("Bat den");
    }
}
