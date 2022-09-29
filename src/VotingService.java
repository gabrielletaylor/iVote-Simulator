import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class VotingService {
	
	private int a, b, c, d, e = 0;
	private Question question;
	private ArrayList<String> choices;
	private Map<String, Integer> results = new LinkedHashMap<>();
	
	/** VotingService class constructor
	 * Configures given question type and its respective choices.
	 @param Question	Question to be configured for Voting Service. */
	public VotingService(Question question) {
		this.question = question;
		this.choices = question.getChoices();
	}
	
	/** Method to accept student answer submissions for the current question
	 * Saves results of each question to a hashmap that tallies how many students
	 * chose that specific choice for each choice that a question has.
	 @param student		List of students that will be submitting their answers. */
	public void acceptSubmissions(ArrayList<Student> student) {
		// Question is a single choice question
		if (question.onlyOneChoice()) {
			// Loop through all the students that are submitting an answer
			for (int i = 0; i < student.size(); i++) {
//				// Prevent multiple submissions from the same student
//				if (student.get(i).getNumberOfSubmissions() > 1) {
//					continue;
//				}
				// Student chose answer A, increase a count
				if (student.get(i).getAnswers().get(0).startsWith("A")) {
					a++;
				}
				// Student chose answer B, increase b count
				else {
					b++;
				}
			}
			// Add choice answers to hashmap with their respective count of
			// how many students chose that answer
			results.put(choices.get(0), a);
			results.put(choices.get(1), b);
		}
		// Question is a multiple choice question
		else {
			// Loop through all students that are submitting an answer
			for (int i = 0; i < student.size(); i++) {
//				// Prevent multiple submissions from the same student
//				if (student.get(i).getNumberOfSubmissions() > 1) {
//					continue;
//				}
				// Loop through student's answers chosen for question
				for (int j = 0; j < student.get(i).getAnswers().size(); j++) {
					// Student chose answer A, increase a count
					if (student.get(i).getAnswers().get(j).startsWith("A")) {
						a++;
					}
					// Student chose answer B, increase b count
					if (student.get(i).getAnswers().get(j).startsWith("B")) {
						b++;
					}
					// Student chose answer C, increase c count
					if (student.get(i).getAnswers().get(j).startsWith("C")) {
						c++;
					}
					// Student chose answer D, increase d count
					if (student.get(i).getAnswers().get(j).startsWith("D")) {
						d++;
					}
					// Student chose answer E, increase e count
					if (student.get(i).getAnswers().get(j).startsWith("E")) {
						e++;
					}
				}
			}
			// Add choice answers to hashmap with their respective count of
			// how many students chose that answer
			results.put(choices.get(0), a);
			results.put(choices.get(1), b);
			results.put(choices.get(2), c);
			results.put(choices.get(3), d);
			results.put(choices.get(4), e);
		}
	}
	
	/** Method that displays the result to the console 
	 * First the question is printed.
	 * Then the hashmap containing the results is printed. */
	public void displayResults() {
		System.out.println("Results:");
		System.out.println(question.getQuestion());
		for (String key: results.keySet()) {
			System.out.println("   " + key + ": " + results.get(key));
		}
		System.out.println();
	}
	
}
