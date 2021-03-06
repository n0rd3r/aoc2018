/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.Map.*;

public class App {
    public int[][] grid;
    public int count;
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        App a = new App();
        String data = a.loadFile("/home/norder/dev/aoc2018/03/input.txt");
        a.processFile(data);
        System.out.println(a.count);
        String output = a.processReadFile(data);
        System.out.println(output);
    }

    public App() {
        grid = new int[2000][2000];
    }

    public void fillGrid(Coord c) {
        for (int x = c.getStartX(); x < c.getStartX() + c.getWidth(); x++) {
            for (int y = c.getStartY(); y < c.getStartY() + c.getHeight(); y++) {
                grid[x][y]++;
                if (grid[x][y] == 2) {
                    count++;
                }
            }
        }
    }
    
    public boolean readGrid(Coord c) {
        for (int x = c.getStartX(); x < c.getStartX() + c.getWidth(); x++) {
            for (int y = c.getStartY(); y < c.getStartY() + c.getHeight(); y++) {
                if (grid[x][y] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void processFile(String data) {
        String[] array = data.split("\n", -1);
        for (int i = 0; i < array.length; i++) {
            Coord c = new Coord(array[i]);
            this.fillGrid(c);
        }
    }

    public String processReadFile(String data) {
        String[] array = data.split("\n", -1);
        for (int i = 0; i < array.length; i++) {
            Coord c = new Coord(array[i]);
            if (this.readGrid(c)) return c.getId();
        }
        return "Not Found";
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


}
