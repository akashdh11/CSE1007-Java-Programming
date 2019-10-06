package question2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double sl;
        int a[][] = new int[4][];

        // input for number of slow learners from each batch
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter number of students slow learners from batch " + (i + 1) + ": ");
            sl = read.nextDouble();
            a[i] = new int[(int) Math.ceil(sl / 4)];
            for (int j = 0; j < a[i].length; j++) {
                if (sl >= 4)
                    a[i][j] = 4;
                else
                    a[i][j] = (int) sl;
                sl = sl - 4;
            }
        }

        // Displaying the values of 2D Jagged array
        int T4 = 0;
        System.out.println("Groups of slow learners:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
                if (a[i][j] == 4)
                    T4++;
            }
            System.out.println();
        }

        System.out.println("Number of tutors with 4 students are: " + T4);
    }
}
