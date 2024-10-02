import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        double totalScore = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter the score for subject " + i + ": ");
            double score = scanner.nextDouble();
            totalScore += score;
        }

        double averageScore = totalScore / numberOfSubjects;
        char grade = calculateGrade(averageScore);

        System.out.printf("Total Score: %.2f\n", totalScore);
        System.out.printf("Average Score: %.2f\n", averageScore);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static char calculateGrade(double averageScore) {
        if (averageScore >= 90) {
            return 'A';
        } else if (averageScore >= 80) {
            return 'B';
        } else if (averageScore >= 70) {
            return 'C';
        } else if (averageScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}