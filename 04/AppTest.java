import java.util.*;
public class AppTest {
    public static void main(String[] args) {
        App a = new App();

        System.out.println("ID 1234: " + a.processId("[1518-11-01 23:58] Guard #1234 begins shift"));
        System.out.println("Minute 58: " + a.processMinute("[1518-11-01 23:58] Guard #1234 begins shift"));
        System.out.println("Max 10: " + a.processMaxMinute("1:10,10:20,10:30"));

        Guard g1 = new Guard("1", 10, 20);
        Guard g2 = new Guard("2", 10, 15);
        Guard g3 = new Guard("3", 10, 16);
        Guard g4 = new Guard("1", 20, 26);
        List<Guard> lg = new ArrayList<Guard>();
        lg.add(g1);
        lg.add(g2);
        lg.add(g3);
        lg.add(g4);

        Map<String, Integer> m = a.processList(lg);
        int max = 0;
        String maxId = new String();
        for (String key : m.keySet()) {
            if (m.get(key) > max) {
                max = m.get(key);
                maxId = key;
            }
        }
        System.out.println("Guard 1: 16: " + m.get("1"));
        System.out.println("Max ID 1: " + maxId);
    }
}
