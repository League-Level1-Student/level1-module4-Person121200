package _09_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackaMole implements ActionListener {
	JFrame frame = new JFrame("Whack a Button for Fame and Glory");
	JPanel panel = new JPanel();
	JButton[] buttons = new JButton[24];
	int molesWhacked = 0;
	Random rand = new Random();
	int score = 0;
	Date startime = new Date();
	int moleIndex;
	String[] fortune = {"Wrong", "bad", "Incorrect"};
	String kahoot = "kahoot.wav";
	
	
	public void drawButtons() {
		moleIndex = rand.nextInt(24);
		for(int i = 0; i<24; i++) {
			buttons[i] = new JButton();
			panel.add(buttons[i]);
			buttons[i] .addActionListener(this);
			if(i == moleIndex) {
				buttons[i].setText("mole!");
			}

		}
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 320);
	}
	
	
    static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
    
    
    private void endGame(Date timeAtStart) { 
        Date timeAtEnd = new Date();
        JOptionPane.showMessageDialog(null, "Your whack rate is "
                + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                      + " moles per second.");
        JOptionPane.showMessageDialog(null, "You hit "+score+" correct buttons");
        System.exit(0);
    }
    
    private void playSound(String fileName) { 
        AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
        sound.play();
    }


	@Override
	public void actionPerformed(ActionEvent e) {
	
		for (int i = 0; i<24; i++) {
			if (e.getSource() == buttons[i]) {
				if(i != moleIndex) {
					int j = rand.nextInt(2);
					speak(fortune[j]);
					
				}
				else{
					score+=1;
					}
				}
		}
		panel.removeAll();
		frame.remove(panel);
		drawButtons();
		molesWhacked +=1;
		if(molesWhacked == 10) {
			endGame(startime);
		}
		playSound(kahoot);
	}
}

