package gioi1;

import kha1.AirConditioner;

public class ACSetTemperatureCommand implements Command {
    private int newTemperature;
    private int oldTemperature;
    private AirConditioner airConditioner;

    public ACSetTemperatureCommand(int newTemperature, AirConditioner airConditioner) {
        this.newTemperature = newTemperature;
        this.airConditioner = airConditioner;
    }

    @Override
    public void excute() {
        oldTemperature = newTemperature;
        airConditioner.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        airConditioner.setTemperature(oldTemperature);
    }

    public int getNewTemperature() {
        return newTemperature;
    }

    public void setNewTemperature(int newTemperature) {
        this.newTemperature = newTemperature;
    }

    public int getOldTemperature() {
        return oldTemperature;
    }

    public void setOldTemperature(int oldTemperature) {
        this.oldTemperature = oldTemperature;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

}
