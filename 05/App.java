import java.util.*;
public class App {
    static int pass = 0;
    public static void main(String[] args) {
        App a = new App();
        String data = Util.loadFile("input.txt");
        System.out.println(a.parseString(data).length());
        System.out.println(pass);
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String compress = new String();
        int count = 0;
        int min = 999999999;

        for (int i = 1; i < alphabet.length; i++) {
            count = 0;
            compress = a.removeChar(alphabet[i], data);
            count = a.parseString(compress).length();
            if (count < min) { 
                min = count;
            }
        }
        System.out.println(min);
    }

    public String removeChar(char input, String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (Character.toUpperCase(c[i]) != input) {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }

    public String parseString(String s) {
        char[] c = s.toCharArray();
        boolean found = false;
        boolean deleteNext = false;
        int x = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < c.length + 1; i++) {
            if (i == c.length) {
                if (deleteNext) {
                    break;
                } else {
                    sb.append(c[i-1]);
                    break;
                }
            }
            if (deleteNext) {
                deleteNext = false;
            } else {
                if (c[i-1] != c[i] && Character.toUpperCase(c[i-1]) == Character.toUpperCase(c[i])) {
                    found = true;
                    deleteNext = true;
                } else {
                    sb.append(c[i-1]);
                }
            }
        }
        if (!found) {
            return sb.toString();
        } else {
            pass++;
            return parseString(sb.toString());
        }
    }
}
