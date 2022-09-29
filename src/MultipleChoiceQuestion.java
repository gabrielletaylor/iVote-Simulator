import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {

	private ArrayList<String> correctAnswers;
	
	public MultipleChoiceQuestion(String question, ArrayList<String> choices) {
		super(question, choices);
	}
	
	public MultipleChoiceQuestion(String question, ArrayList<String> choices, ArrayList<String> correctAnswers) {
		super(question, choices);
		this.correctAnswers = correctAnswers;
	}
	
	public ArrayList<String> getCorrectAnswers() {
		return correctAnswers;
	}
	
	public void setCorrectAnswers(ArrayList<String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
	@Override
	public boolean onlyOneChoice() {
		return false;
	}
	
}
