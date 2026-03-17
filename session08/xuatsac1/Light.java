package xuatsac1;

import kha1.Device;

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
