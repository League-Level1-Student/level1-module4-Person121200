package _08_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game_tools.Sound;

public class PigLatin_UI implements ActionListener {
	JFrame frame = new JFrame("Pig Latin Translator");
	JPanel panel = new JPanel();
	JTextField english = new JTextField(20);
	JTextField pigLatin = new JTextField(20);
	JButton to = new JButton(">>");
	JButton from = new JButton("<<");
	JButton speak = new JButton("Speak");
	
	
	
	public void hog() {
		frame.add(panel);
		panel.add(english);
		panel.add(to);
		panel.add(from);
		panel.add(pigLatin);
		panel.add(speak);
		to.addActionListener(this);
		from.addActionListener(this);
		speak.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String englishAsString = english.getText();
		String pigLatinAsString = pigLatin.getText();
		if(e.getSource() == to) {
			PigLatinTranslator.translateEnglishToPigLatin(englishAsString);
			pigLatin.setText(PigLatinTranslator.translateEnglishToPigLatin(englishAsString));

		}
		if(e.getSource() == from) {
			PigLatinTranslator.translatePigLatinToEnglish(pigLatinAsString);
			english.setText(PigLatinTranslator.translatePigLatinToEnglish(pigLatinAsString));

		}
		if(e.getSource() == speak) {
			Sound.speak(pigLatinAsString);

		}

		
	}


	
}
