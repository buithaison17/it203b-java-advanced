package gioi1;

public class RemoteControl {
    private Command[] commands = new Command[10];
    private UndoManager history = new UndoManager();

    public void setButton(int index, Command cmd) {
        commands[index] = cmd;
        System.out.println("Da ganh lenh tai nut: " + index);
    }

    public void press(int index) {
        Command command = commands[index];
        if (command != null) {
            command.excute();
            history.push(command);
        }
    }

    public void undo() {
        history.undo();
    }
}
