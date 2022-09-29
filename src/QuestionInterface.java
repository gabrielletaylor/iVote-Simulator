import java.util.ArrayList;

public interface QuestionInterface {
	
	public String getQuestion();
	
	public ArrayList<String> getChoices();
	
	public void setQuestion(String question);
	
	public void setChoices(ArrayList<String> choices);
	
	public boolean onlyOneChoice();
	
}
