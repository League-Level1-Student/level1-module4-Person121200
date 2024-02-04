package _06_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
	JFrame frame = new JFrame();
	JPanel text = new JPanel();
	JPanel buttons = new JPanel();
	double answer;
	JButton add = new JButton("add");
	JButton sub = new JButton("sub");
	JButton mul = new JButton("mul");
	JButton div = new JButton("div");
	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();
	Double input1AsDouble = Double.parseDouble(input1.getText());
	Double input2AsDouble = Double.parseDouble(input2.getText());


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== add) {
			answer = input1AsDouble+input2AsDouble;
		}
		if(e.getSource()== sub) {
			answer = input1AsDouble-input2AsDouble;
		}
		if(e.getSource()== mul) {
			answer = input1AsDouble*input2AsDouble;
		}
		if(e.getSource()== div) {
			answer = input1AsDouble/input2AsDouble;
		}
		
	}

	public void showButton() {
		frame.add(text);
		text.add(input1);
		text.add(input2);
		buttons.add(add);
		buttons.add(sub);
		buttons.add(mul);
		buttons.add(div);
		text.add(buttons);
		text.add(buttons);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
	}

}
