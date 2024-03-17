package _10_slot_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class slotMachine implements ActionListener {
	Random ran = new Random();
	JFrame frame = new JFrame("Slot Machine");
	JPanel randomPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel moneyPanel = new JPanel();
	JLabel money = new JLabel();
	int moneyText = 0;
	JButton button = new JButton("SPIN");
	String images[] = {"cherry.png", "lime.png", "orange.png"};



	public void buttons() {
		frame.add(randomPanel);
		frame.add(buttonPanel);
		frame.add(moneyPanel);
		buttonPanel.add(button);
		button.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1000, 600);
		moneyPanel.add(money);
		money.setText("Money = "+ moneyText);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		randomPanel.setSize(new Dimension(1000/3, 600));
		buttonPanel.setSize(new Dimension(1000/3, 600));
		moneyPanel.setSize(new Dimension(1000/3, 600));
		frame.pack();
		
	}
	
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		randomPanel.removeAll();
			String newImages[] = new String[3];
			for(int i = 0; i<3; i+=1) {
				newImages[i] = images[ran.nextInt(3)];
				
			}		
						
			for(int j = 0; j<3; j+=1) {
				try {
					randomPanel.add(createLabelImage(newImages[j]));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

				
			
			if(e.getSource() == button) {
				if(newImages[0] == (newImages[1]) & newImages[0] == (newImages[2])) {
					moneyText += 500;
					money.setText("money = "+ moneyText);
					JOptionPane.showMessageDialog(null, "YOU WIN!!!");

				}
				frame.pack();
		}
	
	}
}

