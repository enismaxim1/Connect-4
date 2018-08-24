package test;
import javax.swing.*;
import java.util.*;
public class GUI {
    JFrame frame;
    BoardPanelGUI panel;
    
    /**
     * Creates the graphics pane
     */
    public GUI() {
        System.out.println("GUI Constructor");
    }

    public void createAndShowGUI() {
        System.out.println("createAndShGuiGUI");
        frame = new JFrame("Connect Four");
        panel = new BoardPanelGUI();
        panel.addComponents();
        frame.getContentPane().add(panel);
        frame.setSize(490, 490);
        frame.pack();
        frame.setVisible(true);
    }
}