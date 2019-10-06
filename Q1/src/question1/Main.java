package question1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter first name:");
        String fname = read.nextLine();
        System.out.println("Enter last name:");
        String lname = read.nextLine();
        System.out.println("Enter your weight(in kgs):");
        float weight = read.nextFloat();
        System.out.println("Enter your hieght(in mtrs):");
        float hieght = read.nextFloat();
        float bmi = weight / (hieght * hieght);
        String c;
        if (bmi < 18.5)
            c = "Underweight";
        else if (bmi < 25)
            c = "Normal";
        else if (bmi < 30)
            c = "overweight";
        else
            c = "obese";
        System.out.println("Name: " + fname + " " + lname + "\nCategory: " + c);
    }
}
