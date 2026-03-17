package kha2;

import kha1.AirConditioner;
import kha1.Fan;
import kha1.Light;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();

        OldThermometer oldThermometer = new OldThermometer(airConditioner.getTemperature());
        ThermometerAdapter thermometerAdapter = new ThermometerAdapter(oldThermometer);

        System.out.println("Nhiet do hien tai: " + thermometerAdapter.getTemperatureCelsius() + " do c");

        SmartHomeFacade smartHome = new SmartHomeFacade(light, fan, airConditioner);
        smartHome.leaveHome();
        smartHome.sleepMode();
        smartHome.getCurrentTemperature();
    }
}
