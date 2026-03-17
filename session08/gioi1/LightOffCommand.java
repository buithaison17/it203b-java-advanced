package gioi1;

import kha1.Light;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

}