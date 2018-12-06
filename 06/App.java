import java.util.*;
public class App {
    static int[][] grid = new int[500][500];
    public static void main(String[] args) {
        App a = new App();

        String data = Util.loadFile("input.txt");
        a.loadGrid(data);
        System.out.println(grid[250][72]);
   }
   
   public void loadGrid(String data) {
        String[] array = data.split("\n", -1);
        for (int i = 0; i < array.length; i++) {
            int x = Integer.valueOf(array[i].split(",")[0].trim());
            int y = Integer.valueOf(array[i].split(",")[1].trim());
            grid[x][y] = i + 1;
        }
   }

   public void printGrid() {
       for (var y = 0; y < 500; y++) {
           for (var x = 0; x < 500; x++) {
               System.out.print(grid[x][y] + " ");
           }
           System.out.print("\n");
       }
   }

   public int findClosestPoint(int x, int y) {
       int east;
       int south;
       int west;
       int north;
       if ((x+1) < 501) east = grid[x+1][y];
       if ((y+1) < 501) south = grid[x][y+1];
       if ((x-1) > -1) west = grid[x-1][y];
       if ((y-1) > -1) north = grid[x][y-1];

       if ((east + south + west + north) == 0) {
           // keep searching
       } else {
          // found one, return one and only one, or -1 for two or more
       } 
   }
}
