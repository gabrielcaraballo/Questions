import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
	QuestionNode root;

	public QuestionsGame() {
		// root = new QuestionNode("computer");
	}

	public void read(Scanner input) {
		root = read(root, input);
	}

	public QuestionNode read(QuestionNode node, Scanner input) {
		if (root == null) {
			input.nextLine();
			node = new QuestionNode(input.nextLine());
		}

		if (input.nextLine().equals("Q")) {
			node.left = read(node.left, input);
		}

		return node;
	}

	public void write(PrintStream output) {

	}

	public void askQuestions() {

	}

	public boolean yesTo(String prompt) {
		System.out.println(prompt + " (y/n)");
		Scanner scanner = new Scanner(System.in);
		String response = "";
		while (!(response.equals("y") || response.equals("n"))) {
			response = scanner.next();
		}
		scanner.close();
		return response.equals("y");
	}

	private static class QuestionNode {
		String data;
		QuestionNode left; // left
		QuestionNode right; // right

		public QuestionNode(String data) {
			this.data = data;
		}

		public String toString() {
			return data;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		QuestionsGame q = new QuestionsGame();
		// System.out.println(q.yesTo("test"));
		q.read(new Scanner(new File("spec-questions.txt")));
		System.out.println(q.root);
	}
}
