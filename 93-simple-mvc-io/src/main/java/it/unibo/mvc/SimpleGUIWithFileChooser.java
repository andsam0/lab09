package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser{
    private final int PROPORTION = 2;
    private final JFrame frame = new JFrame("My second Java graphical interface");
    private Controller controller = new Controller();
    
    public SimpleGUIWithFileChooser(){
        final JPanel canvas = new JPanel();
        final JPanel innerCanvas = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JTextField actualPath = new JTextField(controller.getCurrentFilePath());
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.save(textArea.getText());
            }
        });

        final JButton browse = new JButton("Browse...");
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooseFile = new JFileChooser("Choose where to save");
                chooseFile.setSelectedFile(controller.getCurrentFile());
                final var result = chooseFile.showSaveDialog(canvas);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        controller.setCurrentFile(chooseFile.getSelectedFile());
                        actualPath.setText(controller.getCurrentFilePath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Something gone wrong!");
                        break;
                }
            }
        });
        
        actualPath.setEditable(false);
        canvas.setLayout(new BorderLayout());
        innerCanvas.setLayout(new BorderLayout());

        canvas.add(innerCanvas, BorderLayout.NORTH);
        innerCanvas.add(actualPath, BorderLayout.CENTER);
        innerCanvas.add(browse, BorderLayout.LINE_END);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

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
        new SimpleGUIWithFileChooser().display();
    }


}   
