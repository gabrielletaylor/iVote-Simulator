import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Student {
	
	private String ID;
	private ArrayList<String> studentAnswers;
	
	/** Student class constructor
	 * Associates each unique ID to each student.
	 @param ID		Unique ID for each student. */
	public Student(int ID) {
		this.ID = String.valueOf(ID);
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = String.valueOf(ID);
	}
	
	public ArrayList<String> getAnswers() {
		return studentAnswers;
	}
	
	/** Method that submits an answer for either a multiple choice or
	 * single choice question.
	 @param question	Question for student to submit an answer for. */
	public void submitAnswer(Question question) {
		// Initialize empty array list to hold student's answers for question
		studentAnswers = new ArrayList<>();
		// Store possible choices for question in an array list
		ArrayList<String> choices = question.getChoices();
		// Randomize possible choices
		Collections.shuffle(choices);
		
		// Question is a single choice question
		if (question.onlyOneChoice()) {
			// Have student choose first choice in randomized choices as their answer
			studentAnswers.add(choices.get(0));
		}
		// Question is a multiple choice question
		else {
			// Generate random number of choices that student will select for 
			// multiple choice question, 1 to number of choices available, inclusive
			Random random = new Random();
			int randomChoice = random.nextInt(choices.size()) + 1;
			// Have student choose first randomChoices in randomized choice(s) as their answer 
			for (int i = 0; i < randomChoice; i++) {
				studentAnswers.add(choices.get(i));
			}
		}
		// Sort question's choices back to ascending order after being shuffled
		Collections.sort(choices);
	}
	
}
