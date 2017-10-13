package etc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import concentrationGame.MainPlay;

public class chooseLevel extends JFrame implements ActionListener{
	JRadioButton abt,abt2,abt3;
	
	public chooseLevel(){
		setSize(200, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		abt = new JRadioButton("Easy");
		abt.addActionListener(this);
		abt2 = new JRadioButton("Average");
		abt2.addActionListener(this);
		abt3 = new JRadioButton("Hard");
		abt3.addActionListener(this);
		
		JPanel pnl = new JPanel(new FlowLayout());
		pnl.add(abt);
		pnl.add(abt2);
		pnl.add(abt3);

		this.add(pnl);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		chooseLevel b = new chooseLevel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((JRadioButton)e.getSource()==abt){
			dispose();
			JOptionPane.showMessageDialog(null, "Level Easy");
			try {
				MainPlay a = new MainPlay();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
			
	}
}
