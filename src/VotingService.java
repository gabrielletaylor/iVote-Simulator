import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class VotingService {
	
	private int a, b, c, d, e;
	private Question question;
	private Map<String, Integer> results = new LinkedHashMap<>();
	
	public void votingService(Question question, Student[] students) {
		a = 0; b = 0; c = 0; d = 0; e = 0;
		this.question = question;
		ArrayList<String> choices = question.getChoices();
		
		if (question.onlyOneChoice()) {
			for (int i = 0; i < students.length; i++) {
				if (students[i].getAnswers().get(0).startsWith("A")) {
					a++;
				}
				else {
					b++;
				}
			}
			results.put(choices.get(0), a);
			results.put(choices.get(1), b);
		}
		else {
			for (int i = 0; i < students.length; i++) {
				for (int j = 0; j < students[i].getAnswers().size(); j++) {
					if (students[i].getAnswers().get(j).startsWith("A")) {
						a++;
					}
					if (students[i].getAnswers().get(j).startsWith("B")) {
						b++;
					}
					if (students[i].getAnswers().get(j).startsWith("C")) {
						c++;
					}
					if (students[i].getAnswers().get(j).startsWith("D")) {
						d++;
					}
					if (students[i].getAnswers().get(j).startsWith("E")) {
						e++;
					}
				}
			}
			results.put(choices.get(0), a);
			results.put(choices.get(1), b);
			results.put(choices.get(2), c);
			results.put(choices.get(3), d);
			results.put(choices.get(4), e);
		}
	}
	
	public void displayResults() {
		System.out.println(question.getQuestion());
		for (String key: results.keySet()) {
			System.out.println("   " + key + ": " + results.get(key));
		}
		System.out.println();
		results.clear();
	}
	
}
