package question4;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a genome string:");
        String e = in.nextLine();
        String g = "", a = "", b = "", c = "";
        int i;
        boolean x = false;
        for (String p : e.split("ATG")) {
            i = p.length();
            a = p.split("TAG")[0];
            b = p.split("TAA")[0];
            c = p.split("TGA")[0];
            if (a.length() != p.length() && a.length() % 3 == 0) {
                i = a.length();
                g = a;
            }
            if (b.length() != p.length() && b.length() % 3 == 0 && b.length() < i) {
                i = b.length();
                g = b;
            }
            if (c.length() != p.length() && c.length() % 3 == 0 && c.length() < i) {
                i = c.length();
                g = c;
            }
            if (i < p.length()) System.out.println(g);
        }
    }
}