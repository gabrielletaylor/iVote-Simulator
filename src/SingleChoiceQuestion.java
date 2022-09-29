import java.util.ArrayList;

public class SingleChoiceQuestion extends Question {
	
	private String correctAnswer;
	
	public SingleChoiceQuestion(String question, ArrayList<String> choices) {
		super(question, choices);
	}
	
	public SingleChoiceQuestion(String question, ArrayList<String> choices, String correctAnswer) {
		super(question, choices);
		this.correctAnswer = correctAnswer;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	@Override
	public boolean onlyOneChoice() {
		return true;
	}

}
