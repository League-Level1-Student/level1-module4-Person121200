package _01_chuckle_clicker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker {
	public static void main(String[] args) {
		makeButtons();
	}
	
	public static makeButtons implements actionlistener() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton();
		JButton button1 = new JButton();
		frame.add(panel);
		panel.add(button1);
		panel.add(button);
		button.setText("joke");
		button1.setText("punchline");
		
	}
}
