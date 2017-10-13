package etc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SamplePopup {
  public static void main(String args[]) {

    JFrame frame = new JFrame("Sample Popup");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton button = new JButton("Ask");
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        Component source = (Component) actionEvent.getSource();
        Object response = JOptionPane.showInputDialog(source,
            "Where would you like to go to lunch?",
            "Select a Destination", JOptionPane.QUESTION_MESSAGE,
            null, new String[] { "A", "B","C", "D", "E" },"B");
        if (response.equals("A"))
        	JOptionPane.showMessageDialog(null, "AAA");
        System.out.println("Response: " + response);
      }
    };
    button.addActionListener(actionListener);
    Container contentPane = frame.getContentPane();
    contentPane.add(button, BorderLayout.SOUTH);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}