import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Student {
	
	private long ID;
	private ArrayList<String> studentAnswers;
	
	public Student() {
		ID = System.currentTimeMillis();
	}
	
	public long getID() {
		return ID;
	}
	
	public void setID() {
		ID = System.currentTimeMillis();
	}
	
	public ArrayList<String> getAnswers() {
		return studentAnswers;
	}
	
	public void submitAnswer(Question question) {
		studentAnswers = new ArrayList<>();
		ArrayList<String> choices = question.getChoices();
		Collections.shuffle(choices);
		
		if (question.onlyOneChoice()) {
			studentAnswers.add(choices.get(0));
		}
		else {
			Random random = new Random();
			int randomChoice = random.nextInt(choices.size()) + 1;
			for (int i = 0; i < randomChoice; i++) {
				studentAnswers.add(choices.get(i));
			}
		}
		Collections.sort(choices);
	}
	
}
