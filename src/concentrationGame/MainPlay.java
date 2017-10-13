package concentrationGame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPlay extends JFrame implements ActionListener {
	JButton[] button = new JButton[n];
	private ImageIcon[] card = new ImageIcon[n];
	private int[] index = new int[n];
	
	int counter = 30;
	int score = 0;
	boolean isPause = true;
	boolean isStart = true;
	static String name;
	static int n = 32;
	private String fileLocation = new String();
	
	private JPanel plMain = new JPanel();;
	private ImageIcon icon;
	
	Timer time;
	Random rd = new Random();
	ControlPanel conpnl = new ControlPanel();
	
	
	public MainPlay() throws IOException {

		// Basic
		super("Concentration Game");
//		this.setIconImage(new ImageIcon("data\\icon.jpg").getImage());
		this.setSize(950, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		// End Initialize

		// Create Default Icon
		BufferedImage image = ImageIO.read(new File("data\\df_icon.png"));
		icon = new ImageIcon(image.getScaledInstance(200, 100,image.SCALE_SMOOTH));
		// End Icon
		
		// Panel Game
		plMain = new ImagePanel(new ImageIcon("data\\bg.jpg").getImage());
		plMain.setLayout(new GridLayout(4, 4, 4, 4));
		
		
		// Get images
		for (int i = 0; i < card.length; i++) {
			if (n==32){
				fileLocation = "data\\1\\" + (i < 16 ? (i + 1) : (i - 15)) + ".jpg";
			}
			else if(n==24){
				fileLocation = "data\\2\\" + (i < 12 ? (i + 1) : (i - 11)) + ".jpg";
			}else
				fileLocation = "data\\3\\" + (i < 8 ? (i + 1) : (i - 7)) + ".jpg";
			card[i] = new ImageIcon(fileLocation);
		}

		// Add Cards
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(icon);
			button[i].addActionListener(this);
			plMain.add(button[i]);
			button[i].setVisible(false);
			button[i].setBackground(new Color(9,65,112));;
		}
		
//		name = JOptionPane.showInputDialog("Enter your name");
		conpnl.tfName.setText(name);

		randomIndex();
		
		this.add(plMain, "Center");
		this.add(conpnl, "East");
		this.setVisible(true);


//============= Setup Action Listener For ControlPanel's Button ===============
		conpnl.btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isStart == true) {
					start();
					conpnl.btStart.setText("Restart");
					isStart = false;
				} else {
					time.stop();
					int a = JOptionPane.showConfirmDialog(null,
							"Do you want restart?");
					if (a == 0) {
						isPause = true;
						conpnl.btPause.setText("Pause");
						start();
					} else if (conpnl.btEnd.isEnabled() == false) {
						;
					} else
						time.start();
				}
			}
		});

		conpnl.btEnd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				time.stop();
				int a = JOptionPane.showConfirmDialog(null,
						"Do you want finish?");
				if (a == 0) {
					for (int i = 0; i < button.length; i++)
						button[i].setVisible(false);
					c = 0;
					score = 0;
					conpnl.btPause.setEnabled(false);
					conpnl.btEnd.setEnabled(false);
					conpnl.tfTime.setText("0");
					conpnl.tfScore.setText("0");
				} else
					time.start();
			}
		});

		conpnl.btPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPause == true){
					time.stop();
					conpnl.btPause.setText("Resume");
					for (int i = 0; i < button.length; i++)
						button[i].setEnabled(false);
					plMain = new ImagePanel(new ImageIcon("data\\tbg3.jpg").getImage());
					isPause = false;
				}
				else{
					time.start();
					conpnl.btPause.setText("Pause");
					for (int i = 0; i < button.length; i++)
						button[i].setEnabled(true);
					isPause = true;
				}
			}
		});

		conpnl.btExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				if (isStart==false){
//					time.stop();
//				}
				int a = JOptionPane.showConfirmDialog(null,
						"Do you want back to Welcome Menu?");
				if (a == 0) {
					dispose();
					try {
						Welcome fi = new Welcome();
//						time.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (a == 1){
					dispose();
//					time.stop();
				}
//				else if (isStart == false)
//					time.start();
			}
		});
		
		conpnl.btHighScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sorry!\nThis function not yet completed.\nIt's coming soon.");
			}
		});

//=============================================================================		
	}
	//End GUI

	
	JButton b;
	JButton preButton;
	String iconDescribe;
	boolean is2Button = false;
	boolean isMore2bt = false;
	int c = 0;

	Timer t1 = new Timer(500, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			b.setVisible(false);
			preButton.setVisible(false);
			score += 50;
			conpnl.tfName.setText(name);
			isMore2bt = false;
			is2Button = false;

			c++;
			if (c == button.length / 2) {
				time.stop();
				score += counter * 30;
				conpnl.tfScore.setText("" + score);
				JOptionPane.showMessageDialog(null, "Congratulation!\nYour Score: " + score);
				conpnl.btPause.setEnabled(false);
				conpnl.btEnd.setEnabled(false);
				conpnl.tfScore.setText("0");
				conpnl.tfTime.setText("0");
			}
		}

	});

	Timer t2 = new Timer(500, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			b.setIcon(icon);
			preButton.setIcon(icon);
			isMore2bt = false;
			is2Button = false;
		}
	});

	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		for (i = 0; i < button.length; i++) {
			if (isMore2bt == false) {
				b = (JButton) e.getSource();
				if (b == button[i]) {
					button[i].setIcon(card[index[i]]);

					if (is2Button == false) {
						iconDescribe = card[index[i]].toString();
						is2Button = true;
						preButton = b;
					} else if (is2Button == true && !preButton.equals(b)) {
						isMore2bt = true;
						if (iconDescribe.equals(card[index[i]].toString())) {
							t1.setRepeats(false);
							t1.start();
						} else {
							t2.setRepeats(false);
							t2.start();
						}
					}
				}
			}
		}
	}

	// Method Random Index Array
	public void randomIndex() {
		int temp = rd.nextInt(n-2) + 1;
		index[0] = temp;
		for (int i = 1; i < index.length; i++) {
			temp = rd.nextInt(n);
			for (int j = 0; j < i; j++) {
				if (index[j] == temp) {
					i--;
					break;
				} else {
					index[i] = temp;
				}
			}
		}
	}

	// Method Start
	public void start() {
		c = 0;
		if (n == 32)
			counter = 60;
		else if(n==24)
			counter = 40;
		else
			counter =30;
		score = 0;
		conpnl.tfTime.setText("" + counter);
		conpnl.tfScore.setText("" + score);
		for (int i = 0; i < button.length; i++) {
			button[i].setEnabled(true);
			button[i].setVisible(true);
		}
		conpnl.btStart.setEnabled(false);
		conpnl.btEnd.setEnabled(false);
//		conpnl.btPause.setEnabled(true);
		randomIndex();
		for (int i = 0; i < button.length; i++)
			button[i].setIcon(card[index[i]]);
		Timer t = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				conpnl.btStart.setEnabled(true);
				conpnl.btEnd.setEnabled(true);
				conpnl.btPause.setEnabled(true);
				for (int i = 0; i < button.length; i++)
					button[i].setIcon(icon);
				try {
					theTimer();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		t.start();
		t.setRepeats(false);
	}

	
	public void theTimer() throws IOException {
		ActionListener aTime = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				--counter;
				conpnl.tfTime.setText("" + counter);
				conpnl.tfScore.setText("" + score);
				if (counter == 0) {
					JOptionPane.showMessageDialog(null,
							"Time Over!\nYour Score: " + score);
					time.stop();
					conpnl.btPause.setEnabled(false);
					conpnl.btEnd.setEnabled(false);
					for (int i = 0; i < button.length; i++){
						button[i].setIcon(card[index[i]]);
						button[i].setEnabled(false);
					}
				}
			}
		};
		time = new Timer(1000, aTime);
		time.start();

	}
	
	public static void main(String[] args) throws IOException {
		MainPlay conpnl = new MainPlay();
		System.out.println(conpnl.button[1].getWidth());
		System.out.println(conpnl.button[1].getHeight());
	}
}




// Class Create Image for Panel
class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
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