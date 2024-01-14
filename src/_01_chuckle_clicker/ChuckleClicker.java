package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button1 = new JButton();
	
	public static void main(String[] args) {
	}

	public void makeButton() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button);
		button.addActionListener(this);
		button1.addActionListener(this);
		button.setText("joke");
		button1.setText("punchline");
		frame.show();
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			JOptionPane.showMessageDialog(null, "hi");
			JOptionPane.showMessageDialog(null, "Why did the chicken cross the road?");
		}
		if (e.getSource() == button1) {
			JOptionPane.showMessageDialog(null, "To eat at Chick-fill-A.");
		}
		
	}

}
