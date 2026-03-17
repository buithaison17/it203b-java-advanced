package kha1;

public class Fan implements Device {
    private String speed = "low";

    @Override
    public void turnOff() {
        System.out.println("Tat quat");
    }

    @Override
    public void turnOn() {
        System.out.println("Bat quat");
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
        System.out.println("Da chinh toc do quat: " + speed);
    }
}
