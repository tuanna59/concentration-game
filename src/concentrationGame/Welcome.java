package concentrationGame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Welcome extends JFrame{
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	JPanel panel;
	JButton btBegin = new JButton();
	JButton btAbout = new JButton();
	JButton btAppear = new JButton("Choose Level");
	JTextField tfName = new JTextField();
	JTextField tfSet = new JTextField();
	JLabel lbName = new JLabel("Enter your name");
	JRadioButton rb1;
	JRadioButton rb2;
	JRadioButton rb3;
	ButtonGroup bg = new ButtonGroup();
	
	public Welcome() throws IOException{
		icon = new ImageIcon("data\\bg1.jpg");
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		MainPlay.n = 16;
		
		setContentPane( panel );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		panel.setLayout(null);

		
		tfName.setBounds(266, 225,100,20);
		add(tfName);
		tfName.setOpaque(false);
		tfName.setForeground(Color.WHITE);;
		
		lbName.setBounds(270, 210, 100, 15);
		lbName.setForeground(Color.WHITE);
		add(lbName);

		rb1 = new JRadioButton("Easy");
		rb1.setBounds(288, 270, 52, 20);
		rb1.setBackground(Color.CYAN);
		rb1.setForeground(Color.WHITE);
		add(rb1);
		rb1.setSelected(true);
		rb1.setVisible(false);
		rb1.setOpaque(false);
		rb1.setContentAreaFilled(false);
		rb1.setBorderPainted(false);
		
		rb2 = new JRadioButton("Average");
		rb2.setBounds(288, 290, 77, 20);
		rb2.setForeground(Color.WHITE);
		add(rb2);
		rb2.setVisible(false);
		rb2.setOpaque(false);
		rb2.setContentAreaFilled(false);
		rb2.setBorderPainted(false);


		
		rb3 = new JRadioButton("Hard");
		rb3.setBounds(288, 310, 52, 20);
		rb3.setForeground(Color.WHITE);
		add(rb3);
		rb3.setVisible(false);
		rb3.setOpaque(false);
		rb3.setContentAreaFilled(false);
		rb3.setBorderPainted(false);
		
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		btAppear.setBounds(261, 250, 110, 20);
		btAppear.setForeground(Color.CYAN);
		btAppear.setOpaque(false);
		btAppear.setContentAreaFilled(false);
		
		btAppear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btBegin.setBounds(240, 330, 150, 40);
				rb1.setVisible(true);
				rb2.setVisible(true);
				rb3.setVisible(true);
			}
		});
		add(btAppear);
		
		
		BufferedImage image = ImageIO.read(new File("data\\go.png"));
		ImageIcon icon2 = new ImageIcon(image.getScaledInstance(150, 40,image.SCALE_SMOOTH));
		BufferedImage image2 = ImageIO.read(new File("data\\go3.png"));
		ImageIcon icon3 = new ImageIcon(image2.getScaledInstance(20, 20,image.SCALE_SMOOTH));
		btBegin.setBounds(240, 275, 150, 40);
		btBegin.setIcon(icon2);
		btBegin.setOpaque(false);
		btBegin.setContentAreaFilled(false);
		btBegin.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please enter your name first. Thank you!");
				} else {
					dispose();
					try {
						if (rb1.isSelected() == true) {
							MainPlay.n = 16;
						} else if (rb2.isSelected() == true) {
							MainPlay.n = 24;
						} else
							MainPlay.n = 32;
						MainPlay.name = tfName.getText();
						MainPlay obj = new MainPlay();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel.add(btBegin);
		
		btAbout.setBackground(new Color(39,8,39));
		btAbout.setBounds(625, 0, 20, 20);
		btAbout.setIcon(icon3);
		btAbout.setOpaque(false);
		btAbout.setContentAreaFilled(false);
		btAbout.setBorderPainted(false);
		btAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This program maked by Nguyen Anh Tuan and Do Pham Hoang Minh");
			}
		});
		add(btAbout);
		setVisible(true);
	}

	public static void main(String [] args) throws IOException{

		Welcome frame = new Welcome();
	}
}