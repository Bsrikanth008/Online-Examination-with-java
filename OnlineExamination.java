
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Exam {
    private String[] questions;
    private String[][] options;
    private int[] answers;

    public Exam(String[] questions, String[][] options, int[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
    }

    public void displayQuestions() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.println("Options: ");
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }
            System.out.println();
        }
    }

    public int calculateScore(int[] userAnswers) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (userAnswers[i] == answers[i]) {
                score++;
            }
        }
        return score;
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Login
        System.out.println("Welcome to Online Examination!");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);

        // Update Profile and Password
        System.out.println("Profile details:");System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.print("Do you want to update profile and password? (yes/no): ");
        String updateChoice = scanner.nextLine();
        if (updateChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new username: ");
            username = scanner.nextLine();
            System.out.print("Enter new password: ");
            password = scanner.nextLine();
            user = new User(username, password);
            System.out.println("Profile updated successfully!");
        }

        // Online Examination
        String[] questions = {
                "What is the capital of France?",
                "Which is the largest planet in our solar system?",
                "Who wrote the play 'Romeo and Juliet'?",
                "What is the chemical symbol for gold?"
        };
        String[][] options = {
                {"London", "Paris", "Berlin", "Rome"},
                {"Jupiter", "Mars", "Earth", "Saturn"},
                {"William Shakespeare", "George Orwell", "Jane Austen", "Charles Dickens"},
                {"Au", "Ag", "Hg", "Fe"}
        };
        int[] answers = {2, 1, 1, 1};
        Exam exam = new Exam(questions, options, answers);

        System.out.println("Starting Online Examination...");
        System.out.println("You have 60 seconds to complete the exam.");

        exam.displayQuestions();

        int[] userAnswers = new int[questions.length];
        for (int i = 0; i < questions.length; i++) {
            System.out.print("Enter your answer for Question " + (i + ": "));
            userAnswers[i] = scanner.nextInt();
        }

        int score = exam.calculateScore(userAnswers);
        System.out.println("Exam completed!");

        System.out.println("Your score: " + score + " out of " + questions.length);

        scanner.close();
    }

}