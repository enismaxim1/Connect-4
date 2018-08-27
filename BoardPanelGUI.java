package test;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class BoardPanelGUI extends JPanel {
	boolean done=false;
    JButton[] topButtons;
    ArrayList<Integer[]> redChips = new ArrayList<Integer[]>();
    ArrayList<Integer[]> yellowChips = new ArrayList<Integer[]>();
    Dimension size;
    GridLayout layout;
    final int squareLength = 70;
    Color chip = Color.red;
    private static final long serialVersionUID = 1L;
    public BoardPanelGUI() {
        System.out.println("Constructor Board Panel run");
        topButtons = new JButton[7];
        size = new Dimension(490, 490);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
    int k;
 
    public void addComponents() {
        System.out.println("addComponents");
        super.setLayout(null);
        //Adds top buttons to top row of frame
        for (k=0; k<7 ; k++) {
            ConnectFourButtonAgainGUI button;
            button = new ConnectFourButtonAgainGUI(k);
            button.setPreferredSize(new Dimension(70, 70));
            button.setBounds(k*70, 0, 70, 490);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Integer[] point = new Integer[2];
                    point[0] = button.x;
                    point[1] = ConnectFourAgainGUI.whichRow(button.x);// add y
                    if (point[1] != -1) {
                    	if (ConnectFourAgainGUI.gameEnd()==false) {
	                        if (ConnectFourAgainGUI.turn%2==0) {
	                            redChips.add(point);
	                        } else {
	                            yellowChips.add(point);
	                        }
	                        ConnectFourAgainGUI.nextTurn();
	                        repaint();
	                    } else if (done==false) {
	                    	if (ConnectFourAgainGUI.turn%2==0) {
	                            redChips.add(point);
	                        } else {
	                            yellowChips.add(point);
	                        }
	                    	repaint();
	                    	done=true;
	                    	
	                    }
                    }
                }
            });
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            topButtons[k] = button;
            super.add(topButtons[k]);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Paint component called");
        g.setColor(Color.black);
        System.out.println("Color set");

        for (int y_=0; y_<7; y_++) {
            // horizontal line
            g.drawLine(0, (y_)*squareLength, 490, y_*squareLength);
        }

        System.out.println("Horizontal 'drawn'");
        for (int x_=1; x_<7; x_++) {
            g.drawLine((x_)*squareLength, 0, x_*squareLength, 490);
        }

        System.out.println("Vertical 'drawn'");

        g.setColor(Color.gray);
        for (int y=1; y<7; y++) {
            for (int x=0; x<7; x++) {
                g.fillOval(x*squareLength, y*squareLength, squareLength, squareLength);
            }
        }

        //draw chips
        g.setColor(Color.red);
        for (Integer[] point : redChips) {
            g.fillOval(point[0]*squareLength, (point[1]+1)*squareLength, squareLength, squareLength);            
        }

        g.setColor(Color.yellow);
        for (Integer[] point : yellowChips) {
            g.fillOval(point[0]*squareLength, (point[1]+1)*squareLength, squareLength, squareLength);
        }
        System.out.println("End paint component");
    }
}