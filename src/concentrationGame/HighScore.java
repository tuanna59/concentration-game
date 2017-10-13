package concentrationGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFrame;

public class HighScore extends JFrame {

	public HighScore() {

	}

	public static void main(String[] args) throws FileNotFoundException {
		int n = 0;
		Scanner read = new Scanner(new File("data\\score"));
		String a = read.nextLine();
		Scanner reada = new Scanner(a);
		reada.next();
		System.out.println(reada.next());
		System.out.println(n);
	}
}
