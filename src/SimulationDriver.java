import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Call methods to create and initialize 3 hard-coded Question objects
		Question q1 = createQ1();
		Question q2 = createQ2();
		Question q3 = createQ3();
		
		// Generate random number of students between 30 and 60, inclusive
		Random random = new Random();
		final int NUM_STUDENTS = random.nextInt(61 - 30) + 30;
		// Initialize empty array list to hold Student objects
		ArrayList<Student> students = new ArrayList<>();
		// Initialize each student with their own 9-digit unique ID starting with 100000000
		// and add each Student object to the array list
		final int ID_START = 100000000;
		for (int i = 0; i < NUM_STUDENTS; i++) {
			students.add(new Student(ID_START + (i * 9)));
		}
				
		// Simulate process and print results on the console
		System.out.println("iVote Simulator");
		System.out.println("Questions about Sunright Tea Studio");
		System.out.println("Number of students participating in poll: " + NUM_STUDENTS);
		simulateResults(students, q1);
		simulateResults(students, q2);
		simulateResults(students, q3);

	}
	
	// Single choice question q1
	public static Question createQ1() {
		String question = "1. Have you ever been to Sunright Tea Studio?";
		ArrayList<String> choices = new ArrayList<>();
		choices.add("A. Yes");
		choices.add("B. No");
		SingleChoiceQuestion scq = new SingleChoiceQuestion(question, choices);
		return scq;
	}
	
	// Multiple choice question q2
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

	// Multiple choice question q3
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
	
	// Method to iterate through Student object array list
	// Each student in the array list submits an answer for the designated question
	public static void getStudentAnswers(ArrayList<Student> s, Question q) {
		for (int i = 0; i < s.size(); i++) {
			s.get(i).submitAnswer(q);
		}
	}
	
	// Method to simulate the results of students answering the questions
	// Program pauses for 5 seconds to mimic waiting for students to answer question
	// Submit all the students' answers to iVote Service
	// Voting Service output function is called to display the results
	public static void simulateResults(ArrayList<Student> s, Question q) throws InterruptedException {
		System.out.println(q);
		System.out.println("Getting student answers...");
		Thread.sleep(5000);
		getStudentAnswers(s, q);
		VotingService iVoteService = new VotingService(q);
		iVoteService.acceptSubmissions(s);
		iVoteService.displayResults();
	}

}
