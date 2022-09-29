import java.util.ArrayList;

public class Question implements QuestionInterface {
	
	private String question;
	private ArrayList<String> choices;
	
	/** Question superclass
	 * Supports 2 types of questions: multiple choice question and
	 * single choice question.
	 @param question	Question to be configured.
	 @param choices		Possible choices for the given question. */
	public Question(String question, ArrayList<String> choices) {
		this.question = question;
		this.choices = choices;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public ArrayList<String> getChoices() {
		return choices;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
	
	/** Method that flags if a question allows multiple choices to be chosen
	 * or only one choice can be chosen. 
	 @return If question allows only one choice to be chosen. */
	public boolean onlyOneChoice() {
		return true | false;
	}
	
	/** Method that prints the question followed by each of its respective
	 * choices each indented and on a separate line. */
	public String toString() {
		String choicesFormatted = "";
		for (int i = 0; i < choices.size(); i++) {
			choicesFormatted += "   " + choices.get(i) + "\n";
		}
		return "\n" + question + "\n" + choicesFormatted;
	}

}
