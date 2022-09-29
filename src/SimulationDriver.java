import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final int NUM_QUESTIONS = 3;
		Question q1 = createQ1();
		Question q2 = createQ2();
		Question q3 = createQ3();
		
		Random random = new Random();
		final int NUM_STUDENTS = random.nextInt(61 - 30) + 30;
		Student[] students = new Student[NUM_STUDENTS];
		for (int i = 0; i < NUM_STUDENTS; i++) {
			students[i] = new Student();
		}
		
		System.out.println("iVote Simulator");
		System.out.println("Number of students participating in poll: " + NUM_STUDENTS);
		simulateResults(students, q1);
		simulateResults(students, q2);
		simulateResults(students, q3);

	}
	
	public static Question createQ1() {
		String question = "1. Have you ever been to Sunright Tea Studio?";
		ArrayList<String> choices = new ArrayList<>();
		choices.add("A. Yes");
		choices.add("B. No");
		SingleChoiceQuestion scq = new SingleChoiceQuestion(question, choices);
		return scq;
	}
	
	public static Question createQ2() {
		String question = "2. What is your favorite drink from Sunright Tea Studio?";
		ArrayList<String> choices = new ArrayList<>();
		choices.add("A. Sunright Boba Milk Tea");
		choices.add("B. Sunright Fruit Tea");
		choices.add("C. Creme Brulee Boba Milk");
		choices.add("D. Brulee Oat Latte - Matcha");
		choices.add("E. Oreo Brulee Boba Milk");
		MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(question, choices);
		return mcq;
	}

	public static Question createQ3() {
		String question = "3. What is the best topping to add to your drink?";
		ArrayList<String> choices = new ArrayList<>();
		choices.add("A. Brown Sugar Boba");
		choices.add("B. Pudding");
		choices.add("C. Grass Jelly");
		choices.add("D. Mochi");
		choices.add("E. Red Bean");
		MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(question, choices);
		return mcq;
	}
	
	public static void getStudentAnswers(Student[] s, Question q) {
		for (int i = 0; i < s.length; i++) {
			s[i].submitAnswer(q);
		}
	}
	
	public static void simulateResults(Student[] s, Question q) throws InterruptedException {
		System.out.println(q);
		System.out.println("Getting student answers...");
		Thread.sleep(5000);
		getStudentAnswers(s, q);
		VotingService iVoteService = new VotingService(q);
		iVoteService.acceptSubmissions(s);
		iVoteService.displayResults();
	}

}
