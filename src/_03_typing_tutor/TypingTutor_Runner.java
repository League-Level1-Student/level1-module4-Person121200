package _03_typing_tutor;

import java.util.Random;

public class TypingTutor_Runner {
	public static void main(String[] args) {
		TypingTutor tutor = new TypingTutor();
		tutor.setup();
		
		
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
}


}
