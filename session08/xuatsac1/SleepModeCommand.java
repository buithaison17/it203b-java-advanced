package xuatsac1;

import gioi1.Command;

public class SleepModeCommand implements Command {
    private Fan fan;
    private Light light;
    private AirConditioner airConditioner;

    public SleepModeCommand(Fan fan, Light light, AirConditioner airConditioner) {
        this.fan = fan;
        this.light = light;
        this.airConditioner = airConditioner;
    }

    @Override
    public void excute() {
        light.turnOff();
        fan.setSpeed("low");
        airConditioner.setTemperature(28);
    }

    @Override
    public void undo() {
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

}