package designpatternassignments.CommandDesignPattern;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class CommandManger {
    
    JTextField textField;
    List<String> strings = new ArrayList<>();
    List<Command> commands = new ArrayList<>();
    int index = 0;
    
    public CommandManger(JTextField textField) {
        this.textField = textField;
    }
    
    public void addCommand(Command c) {
        commands.add(c);
        strings.add(textField.getText());
        index++;
    }

    public void undo() {
        if (index > 0) {
            index--;
            Command c = commands.get(index);
            textField.setText(strings.get(index));
            c.unexecute();
        }
    }

    public void redo() {
        if (index < commands.size()) {
            Command c = commands.get(index);
            c.execute();
            index++;
            if (index < strings.size()) {
                 textField.setText(strings.get(index));
            }else{
                 textField.setText("");
            }
        }
    }
}
