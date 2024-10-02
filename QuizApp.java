import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    static class Question {
        String question;
        String answer;

        Question(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    private List<Question> questions;
    private int score;

    public QuizApp() {
        questions = new ArrayList<>();
        loadQuestions();
        score = 0;
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", "Paris"));
        questions.add(new Question("What is 2 + 2?", "4"));
        questions.add(new Question("What is the color of the sky?", "Blue"));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! You finished the quiz.");
                scanner.close();
                System.exit(0);
            }
        }, 30000); 

        for (Question q : questions) {
            System.out.println(q.question);
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(q.answer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer is: " + q.answer);
            }
        }

        timer.cancel();
        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApp quiz = new QuizApp();
        System.out.println("Welcome to the Quiz! You have 30 seconds to complete the quiz.");
        quiz.startQuiz();
    }
}