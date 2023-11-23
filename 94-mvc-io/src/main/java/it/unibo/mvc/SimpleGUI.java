package it.unibo.mvc;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final static int PROPORTION = 4;
    private final JFrame frame = new JFrame("Print App");
    private Controller controller = new SimpleController();

    SimpleGUI(){
        JPanel canvas = new JPanel();
        JPanel canvas2 = new JPanel();

        JButton print = new JButton("Print");
        JButton history = new JButton("Show history");
        JTextArea textArea = new JTextArea();
        JTextField currentString = new JTextField();
        canvas.setLayout(new BorderLayout());

        canvas.add(currentString, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(canvas2, BorderLayout.SOUTH);

        canvas2.add(print);
        canvas2.add(history);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.setNextString(currentString.getText());
                controller.printString();
            }
        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                for (String string : controller.getHistory()) {
                    textArea.append(string + " ");
                }
            }
            
        });

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
    
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
