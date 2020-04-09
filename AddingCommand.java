
package designpatternassignments.CommandDesignPattern;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class AddingCommand implements Command{
    private String text;
    private JList jlist;
    private DefaultListModel<String> model;

    public AddingCommand(String text, JList jlist, DefaultListModel<String> model) {
        this.text = text;
        this.jlist = jlist;
        this.model = model;
    }
    

    @Override
    public void execute() {
        model.addElement(text+"");
        jlist.setModel(model);    
    }

    @Override
    public void unexecute() {
        int index=jlist.getLastVisibleIndex();
        model.remove(index);
    }
    
}
