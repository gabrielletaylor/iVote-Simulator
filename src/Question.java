import java.util.ArrayList;

public class Question implements QuestionInterface {
	
	private String question;
	private ArrayList<String> choices;
	
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
	
	public boolean onlyOneChoice() {
		return true | false;
	}
	
	public String toString() {
		String choicesFormatted = "";
		for (int i = 0; i < choices.size(); i++) {
			choicesFormatted += "   " + choices.get(i) + "\n";
		}
		return "\n" + question + "\n" + choicesFormatted;
	}

}
