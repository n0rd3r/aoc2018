import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.Map.*;
public class Util {
    public static String loadFile(String fileName) {
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
}
