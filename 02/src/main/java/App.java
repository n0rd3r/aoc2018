/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.Map.*;
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        App a = new App();
        String data = a.loadFile("/home/norder/dev/aoc2018/02/input1.txt");
        System.out.println(a.checkSum(data).toString());
        System.out.println(a.findString(data).toString());
    }

    public boolean checkRepeat(char[] input, Integer count) {
        Map<String, Object> hm = new HashMap<String, Object>();
        Object x = new Object();
        String y = new String();
        for (int i = 0; i < input.length; i++) {
            y = String.valueOf(input[i]);
            x = hm.get(y);
            if (x == null) {
                hm.put(y, new Integer(1));
            } else {
                hm.put(y, (Integer)x + 1);
            }
        }
        for(Map.Entry<String, Object> pair : hm.entrySet()) {
            if (count.equals((Integer)pair.getValue())) return true;
        }
        return false;
    }

    public Integer checkSum(String s) {
        String[] array = s.split("\n", -1);
        int dbl = 0;
        int tpl = 0;
        for (int i = 0; i < array.length; i++) {
            if (checkRepeat(array[i].toCharArray(), 2)) dbl++;
        }

        for (int i = 0; i < array.length; i++) {
            if (checkRepeat(array[i].toCharArray(), 3)) tpl++;
        }

        return (Integer)(dbl * tpl);
    }
    public String loadFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            lines.close();
            return data;
        } catch (Exception ex) {
            return "";
        }
    }

    public String findString(String data) {
        String[] array = data.split("\n", -1);
        int count = 0;
        int pos = -1;
        int v1 = -1;
        int v2 = -1;
        int finalPos = -1;
        for (int i = 0; i < array.length; i++) {
            char[] value1 = array[i].toCharArray();
            for (int x = 0; x < array.length; x++) {
                char[] value2 = array[x].toCharArray();
                count = 0;
                pos = -1;
                for (int y = 0; y < value1.length; y++) {
                    if (value1[y] != value2[y]) {
                        pos = y;
                        count++;
                    }
                }
                if (count == 1) {
                    System.out.println(array[i]);
                    System.out.println(array[x]);
                    
                    finalPos = pos;
                    v1 = i;
                    v2 = x;
                }
            }
        }
        System.out.println(v1);
        return array[v1].substring(0,finalPos) + array[v1].substring(finalPos+1);
    }

}
