package kha2;

public class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        return (double) (oldThermometer.getTemperatureFahrenheit() - 32) * 5 / 9;
    }

    public OldThermometer getOldThermometer() {
        return oldThermometer;
    }

    public void setOldThermometer(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

}
