import model.Condition;
import model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KodeMoroJava7 {

    public static void main(String[] args) {
        List<Person> personer = Arrays.asList(
                new Person("Buzz", "Aldrin", 88),
                new Person("Neil", "Armstrong", 82),
                new Person("Jurij", "Gagarin", 34),
                new Person("Alan", "Shepard", 66),
                new Person("Jim", "Lovell", 90),
                new Person("Chris", "Hadfield", 58),
                new Person("Sally", "Ride", 61),
                new Person("Valentina", "Teresjkova", 81)
        );


        //Del 1 - Java 7 style
        System.out.println("Java 7 style:");
        //1.1: Sorter listen etter etternavn
        Collections.sort(personer, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getEtternavn().compareTo(p2.getEtternavn());
            }
        });

        //1.2: Lag en metode som printer alle elementene i listen
        System.out.println("Liste sortert på etternavn:");
        print(personer, new Condition() {
            @Override
            public boolean check(Person p) {
                return true;
            }
        });
        System.out.println("");

        //1.3: Utvid print metoden til å benytte seg av vilkår (Condition) slik at man kan filtrere hva som printes
        // Print for eksempel ut alle med fornavn som starter på en bokstav eller som er over en gitt alder etc.
        System.out.println("Personer med fornavn som starter på C");
        print(personer, new Condition() {
            @Override
            public boolean check(Person p) {
                return p.getFornavn().startsWith("C");
            }
        });
        System.out.println("");

        System.out.println("Personer som er over 67 år");
        print(personer, new Condition() {
            @Override
            public boolean check(Person p) {
                return p.getAlder() > 67;
            }
        });
    }

    private static void print(List<Person> personer, Condition vilkaar) {
        for(Person p : personer) {
            if(vilkaar.check(p)) {
                System.out.println(p);
            }
        }
    }
}
