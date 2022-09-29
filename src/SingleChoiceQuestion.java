import java.util.ArrayList;

public class SingleChoiceQuestion extends Question {
	
//	private String correctAnswer;
	private boolean onlyOneChoice;
	
	/** Inherited class of class Question
	 * Supports single choice question; only one choice can be chosen.
	 @param question	Question to be configured.
	 @param choices		Possible choices for the given question. */
	public SingleChoiceQuestion(String question, ArrayList<String> choices) {
		super(question, choices);
		onlyOneChoice = true;
	}
	
//	public SingleChoiceQuestion(String question, ArrayList<String> choices, String correctAnswer) {
//		super(question, choices);
//		this.correctAnswer = correctAnswer;
//	}
//	
//	public String getCorrectAnswer() {
//		return correctAnswer;
//	}
//	
//	public void setCorrectAnswer(String correctAnswer) {
//		this.correctAnswer = correctAnswer;
//	}
	
	/** Method that overrides superclass function
	 @return true; question allows only one choice to be chosen. */
	@Override
	public boolean onlyOneChoice() {
		return onlyOneChoice;
	}

}
