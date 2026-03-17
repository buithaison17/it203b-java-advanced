package gioi1;

import kha1.Fan;

public class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void excute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOn();
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

}
