package question3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Coefficient {
    public static String extractCoeff(String str) {
        String pattern = "^\\d";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        if (m.find()) {
            return m.group(0);
        } else {
            return "1";
        }
    }

    public static String removeCoeff(String str) {
        String pattern = "[^\\d](.*)";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        if (m.find()) {
            return m.group(0);
        } else {
            return str;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        int i;
        Scanner read = new Scanner(System.in);
        System.out.print("Enter equation: ");
        String eq = read.nextLine();

        //RE for splitting reactants and products
        String arrow = "(\\s->\\s)|(\\s->)|(->\\s)|(->)";

        // splitting into reactants and products
        String[] words = eq.split(arrow);
        String[] reactant = words[0].split("\\+");
        String[] product = words[1].split("\\+");
        String[] rmoles = new String[10];
        String[] pmoles = new String[10];

        for (i = 0; i < reactant.length; i++) {
            reactant[i] = reactant[i].replaceAll("\\s+", "");
            rmoles[i] = Coefficient.extractCoeff(reactant[i]);
        }

        for (i = 0; i < product.length; i++) {
            product[i] = product[i].replaceAll("\\s+", "");
            pmoles[i] = Coefficient.extractCoeff(product[i]);
        }

        System.out.print("Reactants are ");
        if (reactant.length > 1) {
            for (i = 0; i < reactant.length; i++) {
                if (i == 0)
                    System.out.print(rmoles[i] + " mole/s of " + Coefficient.removeCoeff(reactant[i]));
                else if (i == reactant.length - 1)
                    System.out.print(" and " + rmoles[i] + " mole/s of "
                            + Coefficient.removeCoeff(reactant[i]));
                else
                    System.out.print(", " + rmoles[i] + " mole/s of " + Coefficient.removeCoeff(reactant[i]));
            }
        } else {
            System.out.print(rmoles[0] + " mole/s of "
                    + Coefficient.removeCoeff(reactant[0]));
        }
        System.out.println();
        System.out.print("Products are ");
        if (product.length > 1) {
            for (i = 0; i < product.length; i++) {
                if (i == 0)
                    System.out.print(pmoles[i] + " mole/s of " + Coefficient.removeCoeff(product[i]));
                else if (i == product.length - 1)
                    System.out.print(" and " + pmoles[i] + " mole/s of " + Coefficient.removeCoeff(product[i]));
                else
                    System.out.print(", " + pmoles[i] + " mole/s of " + Coefficient.removeCoeff(product[i]));
            }
        } else {
            System.out.print(pmoles[0] + " mole/s of " + Coefficient.removeCoeff(product[0]));
        }
    }
}

