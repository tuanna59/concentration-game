package concentrationGame;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ControlPanel extends JPanel {
	JLabel lbTitle = new JLabel("CONTROL CENTER");
	JLabel lbName = new JLabel("Player");
	JLabel lbTime = new JLabel("Time: ");
	JLabel lbScore = new JLabel("Score: ");
	
	JTextField tfName = new JTextField(4);
	JTextField tfTime = new JTextField("0");
	JTextField tfScore = new JTextField("0");
	
	JPanel temp;
	
	JButton btStart = new JButton("Start");
	JButton btEnd = new JButton("End");
	JButton btPause = new JButton("Pause");
	JButton btHighScore = new JButton("H.Score");
	JButton btExit = new JButton("Exit");
	

	public ControlPanel() {
		// Setup 
		setBackground(new Color(0,0,0,25));
		temp = new ImagePanel(new ImageIcon("data\\bg_pnl.jpg").getImage());
		setLayout(null);
		lbTitle.setFont(new Font("Courier", Font.BOLD,15));
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setBounds(20, 5, 150, 25);
		add(lbTitle);
		
		// Setup Button
		btStart.setBackground(new Color(14,77,108));
		btStart.setForeground(Color.white);
		btStart.setBounds(10, 30, 81, 25);
		btStart.setOpaque(false);
//		btStart.setContentAreaFilled(false);
//		btStart.setBorderPainted(false);
		
		btEnd.setBackground(new Color(14,77,108));
		btEnd.setForeground(Color.white);
		btEnd.setBounds(93, 30, 81, 25);
		btEnd.setEnabled(false);
		btEnd.setOpaque(false);
		
		btPause.setBackground(new Color(14,77,108));
		btPause.setForeground(Color.white);
		btPause.setBounds(50, 60, 81, 25);
		btPause.setEnabled(false);
		btPause.setOpaque(false);
		
		btHighScore.setBackground(new Color(14,77,108));
		btHighScore.setForeground(Color.white);
		btHighScore.setBounds(10, 90, 81, 25);
		btHighScore.setOpaque(false);
		
		btExit.setBackground(new Color(14,77,108));
		btExit.setForeground(Color.white);
		btExit.setBounds(93, 90, 81, 25);
		btExit.setOpaque(false);
		
		this.add(btStart);
		this.add(btEnd);
		this.add(btPause);
		this.add(btHighScore);
		this.add(btExit);
		
		// Setup Label
		JLabel lbSeparator = new JLabel("===============================");
		lbSeparator.setForeground(Color.white);
		
		lbTime.setText("Time");
		lbScore.setText("Score");
		lbSeparator.setBounds(0, 360, 200, 10);
		lbName.setBounds(10, 375, 35, 20);
		lbTime.setBounds(10, 400, 35, 18);
		lbScore.setBounds(90, 400, 35, 18);
		lbTime.setForeground(Color.white);
		lbScore.setForeground(Color.white);
		lbSeparator.setBackground(Color.BLUE);
		add(lbSeparator);
		add(lbTime);
		add(lbScore);
		
		// Setup TextField
		
		tfName.setBackground(new Color(14,77,108));
		tfName.setForeground(Color.white);
		tfTime.setBackground(new Color(14,77,108));
		tfTime.setForeground(Color.white);
		tfScore.setBackground(new Color(14,77,108));
		tfScore.setForeground(Color.white);
		tfName.setBounds(14, 375, 150, 18);
		tfTime.setBounds(40, 400, 20, 18);
		tfScore.setBounds(125, 400, 40, 18);
		tfName.setEditable(false);
		tfScore.setEditable(false);
		tfTime.setEditable(false);
		add(tfName);
		add(tfScore);
		add(tfTime);

		add(temp);
	}

	// Specify how big the panel should be.
	
	public Dimension getPreferredSize() {
		return new Dimension(185, 450);
	}

	class ImagePanel extends JPanel {

		private Image img;

		public ImagePanel(String img) {
			this(new ImageIcon(img).getImage());
		}

		public ImagePanel(Image img) {
			this.img = img;
			Dimension size = new Dimension(img.getWidth(null),
					img.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(new ControlPanel(), BorderLayout.CENTER);
		// Finally, set the size of the main window, and pop it up.
		frame.setSize(200, 470);
		frame.setVisible(true);
	}

}