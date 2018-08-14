import model.Condition;
import model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KodeMoroJava8 {

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

        //Del 2 - Java 8 style
        System.out.println("Java 8 style (Lambda):");
        //2.1: Sorter listen etter etternavn
        personer.sort(Comparator.comparing(Person::getEtternavn));

        //2.2: Lag en metode som printer alle elementene i listen
        System.out.println("Printer alle");
        print(personer, p -> true);
        System.out.println("");

        //2.3: Utvid print metoden til å benytte seg av vilkår (Condition) slik at man kan filtrere hva som printes
        // Print for eksempel ut alle med fornavn som starter på en bokstav eller som er over en gitt alder etc.
        System.out.println("Printer alle med fornavn som starter på C");
        print(personer, p -> p.getFornavn().startsWith("C"));
        System.out.println("");

        System.out.println("Printer alle som er over 67 år gamle");
        print(personer, p -> (p.getAlder() > 67));

    }

    private static void print (List<Person> personer, Condition vilkaar) {
        for(Person p : personer) {
            if(vilkaar.check(p))
                System.out.println(p);
        }
    }
}
