import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {

//	private ArrayList<String> correctAnswers;
	private boolean onlyOneChoice;
	
	/** Inherited class of class Question
	 * Supports multiple choice question; one or more choices can be chosen.
	 @param question	Question to be configured.
	 @param choices		Possible choices for the given question. */
	public MultipleChoiceQuestion(String question, ArrayList<String> choices) {
		super(question, choices);
		onlyOneChoice = false;
	}
	
	/** Method that overrides superclass function
	 @return false; question allows one or more choices to be chosen. */
	@Override
	public boolean onlyOneChoice() {
		return onlyOneChoice;
	}
	
}
