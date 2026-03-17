package gioi1;

import java.util.Stack;

public class UndoManager {
    private Stack<Command> history = new Stack<>();

    public void push(Command command) {
        history.push(command);
    }

    public void undo() {
        if (history.isEmpty()) {
            return;
        }
        Command cmd = history.pop();
        cmd.undo();
    }

}
