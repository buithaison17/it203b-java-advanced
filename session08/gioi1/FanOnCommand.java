package gioi1;

import kha1.Fan;

public class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void excute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

}
