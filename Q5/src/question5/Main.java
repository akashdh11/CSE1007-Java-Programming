package question5;

import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

class Film {
    public String name, lang, lead_actor, category;
    public int dur;

    public Film() {
        name = "";
        lang = "";
        lead_actor = "";
        category = "";
        dur = 0;
    }

    public Film(String a, String b, String c, String d, int e) {
        this.set(a, b, c, d, e);
    }

    public void set(String a, String b, String c, String d, int e) {
        name = a;
        lang = b;
        lead_actor = c;
        category = d;
        dur = e;
    }

    public void prnt() {
        System.out.println(name + ", " + lang + ", " + lead_actor + ", " + category + ", " + dur);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vector<Film> v = new Vector<Film>();
        v.add(new Film("Terminator", "English", "Arnold", "action", 123));
        v.add(new Film("Apdi123", "Tamil", "Rajini", "comedy", 123));
        v.add(new Film("Terminator:outtakes", "English", "Arnold", "comedy", 11));
        Iterator<Film> it1 = v.iterator();
        Iterator<Film> it2 = v.iterator();
        Iterator<Film> it3 = v.iterator();
        System.out.println("\n\na. The English film(s) that has Arnold as its lead actor and that runs for shortest duration:");
        int s = 999;
        Film y = new Film();
        while (it1.hasNext()) {
            Film x = it1.next();
            if (x.lead_actor.equalsIgnoreCase("arnold") && x.dur < s) {
                s = x.dur;
                y = x;
            }
        }
        y.prnt();
        System.out.println("\n\nb. The Tamil film(s) with Rajini as lead actor:");
        while (it2.hasNext()) {
            Film x = it2.next();
            if (x.lead_actor.equalsIgnoreCase("rajini")) x.prnt();
        }
        System.out.println("\n\nc. All the comedy movies:");
        while (it3.hasNext()) {
            Film x = it3.next();
            if (x.category.equalsIgnoreCase("comedy")) x.prnt();
        }
    }
}