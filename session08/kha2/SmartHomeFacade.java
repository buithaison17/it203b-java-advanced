package kha2;

import kha1.AirConditioner;
import kha1.Fan;
import kha1.Light;

public class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;

    public SmartHomeFacade(Light light, Fan fan, AirConditioner airConditioner) {
        this.light = light;
        this.fan = fan;
        this.airConditioner = airConditioner;
    }

    public void leaveHome() {
        light.turnOff();
        fan.turnOff();
        airConditioner.turnOff();
    }

    public void sleepMode() {
        light.turnOff();
        fan.setSpeed("low");
        airConditioner.setTemperature(28);
    }

    public void getCurrentTemperature() {
        OldThermometer oldThermometer = new OldThermometer(airConditioner.getTemperature());
        ThermometerAdapter thermometerAdapter = new ThermometerAdapter(oldThermometer);
        System.out.println("Nhiet do hien tai: " + thermometerAdapter.getTemperatureCelsius());
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
}
