package it.unibo.mvc;
import it.unibo.mvc.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    
    private final int PROPORTION = 2;
    private final JFrame frame = new JFrame("My first Java graphical interface");
    private Controller controller = new Controller();
    
    public SimpleGUI(){
        final JPanel canvas = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("SAVE");

        canvas.setLayout(new BorderLayout());
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.save(textArea.getText());
            }
            
        });
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
