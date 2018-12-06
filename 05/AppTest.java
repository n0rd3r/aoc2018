import java.util.*;
public class AppTest {
    public static void main(String[] args) {
        App a = new App();

        System.out.println(a.parseString("dabAcCaCBAcCcaDA"));
        System.out.println("dabAaCBAcaDA");

        System.out.println(a.parseString("abcCde"));
        System.out.println("abde");

        System.out.println(a.removeChar('A', "abcdefgABCDEFG"));
        System.out.println("bcdefgBCDEFG");

   }
}
