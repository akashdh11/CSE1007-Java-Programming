package question7;

import java.util.Scanner;
import primespackage.Primes;

public class TwinPrimes {
    public static void main(String args[]) {
        int i;


        Scanner read = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = read.nextInt();
        System.out.print("Enter second number: ");
        int n2 = read.nextInt();

        System.out.println("Twin prime numbers are: ");

        for(i = n1; i <= n2; i++) {
            if(prime.checkPrime(i) & prime.checkPrime(i+2) & i > 1)
            {
                System.out.println("(" + i + "," + (i+2) + ")");
            }
        }
    }
}

