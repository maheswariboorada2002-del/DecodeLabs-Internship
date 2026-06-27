import java.util.*;

class DecodeLabs_Java_P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("             Welcome to the Grade Calculator !");
        System.out.println("=============================================================");
        System.out.print("Enter the number of subjects: ");
        int n = sc.nextInt();
        int total = 0;
        double average = 0;
        double percentage = 0;
        String grade;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            try {
                if (marks < 0 || marks > 100) {
                    throw new InputMismatchException("Marks should be between 0 and 100");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                i--; // Retry for the same subject
                continue;
            }
            total += marks;
        }
        average = (double) total / n;
        percentage = (double) (total * 100) / (n * 100);
        System.out.println("=============================================================");
        System.out.println("=======================Student Report =======================");
        System.out.println("=============================================================");
        System.out.println("Total marks :        " + total);
        System.out.println("Average marks   :      " + String.format("%.1f", average));
        System.out.println("Percentage  :         " + String.format("%.1f", percentage));
        if (percentage >= 90) {
            grade = "A";
            System.out.println("Grade   :      " + grade);
        } else if (percentage >= 80) {
            grade = "B";
            System.out.println("Grade   :      " + grade);
        } else if (percentage >= 70) {
            grade = "C";
            System.out.println("Grade   :      " + grade);
        } else if (percentage >= 60) {
            grade = "D";
            System.out.println("Grade   :      " + grade);
        } else if (percentage >= 50) {
            grade = "E";
            System.out.println("Grade   :      " + grade);
        }

        else {
            grade = "F";
            System.out.println("Grade   :      " + grade);
        }
        int result = (percentage >= 40) ? 1 : 0;
        if (result == 1) {
            System.out.println("Result:  Pass");
        } else {
            System.out.println("Result:  Fail");
        }
        System.out.println("=============================================================");
        sc.close();
    }
}