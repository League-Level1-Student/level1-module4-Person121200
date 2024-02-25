package _10_slot_machine;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class slotMachine {
	JFrame frame = new JFrame("Slot Machine");
	JPanel panel = new JPanel();
	JButton button = new JButton("SPIN");
	
	
	public void buttons() {
		frame.add(panel);
		panel.add(button);
		
		
	}
}
