package _03_typing_tutor;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	int totalCount;
	int score;
	char currentLetter;
	
	
	void setup(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		char currentLetter = new TypingTutor_Runner().generateRandomLetter();
		label.setText(String.valueOf(currentLetter));
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.addKeyListener(this);
		panel.add(label);
		frame.add(panel);
		frame.pack();

		
	}
	



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("You typed: "+e.getKeyChar());
		if(e.getKeyChar() == currentLetter) {
			panel.setBackground(Color.GREEN);
			score+=1;
			totalCount+=1;
		}
		else {
			panel.setBackground(Color.RED);
			totalCount+=1;
		}
		if(totalCount >= 30) {
			showTypingSpeed();
		}
		
	}




	@Override
	public void keyReleased(KeyEvent e) {
		currentLetter = new TypingTutor_Runner().generateRandomLetter();
		label.setText(String.valueOf(currentLetter));
		
	}
	

	long timeAtStart = System.currentTimeMillis();
	private void showTypingSpeed() {
	    long timeAtEnd = System.currentTimeMillis();
	    long gameDuration = timeAtEnd - timeAtStart;
	    long gameInSeconds = (gameDuration / 1000) % 60;
	    double charactersPerSecond = ((double) score / (double) gameInSeconds);
	    int charactersPerMinute = (int) (charactersPerSecond * 60);
	    JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	    JOptionPane.showMessageDialog(null, "You typed "+score+ " words correct.");
	    System.exit(0);
	} 
}
