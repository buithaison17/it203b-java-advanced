package gioi1;

import kha1.Light;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }

}
