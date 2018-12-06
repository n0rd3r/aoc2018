import java.util.*;
public class App {
    static final int X = 359;
    static final int Y = 351;
    //static final int X = 10;
    //static final int Y = 10;
    static final int MAX = 10000;
    static int[][] grid = new int[X][Y];
    static List<Point> listPoints = new ArrayList<Point>();
    static Set<Integer> borderPatrol = new HashSet<Integer>();
    static Map<Integer, Integer> mapCounter = new HashMap<Integer, Integer>();
    
    public static void main(String[] args) {
        App a = new App();

        String data = Util.loadFile("input.txt");
        //String data = Util.loadFile("test.txt");
        a.loadPoints(data);
        a.loadGrid();
        //System.out.println(grid[10][10]);
        //a.printGrid();
        a.loadBorderPatrol();
        System.out.println(a.findHighNumber());
        System.out.println(a.searchMinDistance());
   }

   public int findTotalDistance(int x, int y) {
       int distance = 0;
       for (Point p : listPoints) {
           distance += Math.abs(p.x - x) + Math.abs(p.y - y);
       }
       return distance;
   }


   public int searchMinDistance() {
       int i = 0;
       for (var y = 0; y < Y; y++) {
           for (var x = 0; x < X; x++) {
               if (this.findTotalDistance(x, y) < MAX) {
                   i++; 
               }
           }
       }
       return i;
   }
 
   public Integer findHighNumber() {
       Integer v;
       Integer k;
       for (var y = 1; y < Y; y++) {
           for (var x = 1; x < X; x++) {
               k = Integer.valueOf(grid[x][y]);
               if (mapCounter.get(k) == null) {
                   mapCounter.put(k, 1);
               } else {
                   v = mapCounter.get(k) + 1;
                   mapCounter.put(k, v);
               }
           }
       }
       Integer max = Integer.valueOf(0);
       for (Integer key : mapCounter.keySet()) {
           if (mapCounter.get(key) > max && !borderPatrol.contains(key)) { 
               max = mapCounter.get(key);
           }
       }
       return max;

   }
   
   public void loadBorderPatrol() {
       for (int i = 0; i < X; i++) {
           borderPatrol.add((grid[i][0]));
           borderPatrol.add((grid[i][Y-1]));

       }
       for (int i = 0; i < Y; i++) {
           borderPatrol.add((grid[0][i]));
           borderPatrol.add((grid[X-1][i]));
       }
   }
   
   public void loadPoints(String data) {
        Point point;    
        String[] array = data.split("\n", -1);
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < array.length; i++) {
            point = new Point(Integer.valueOf(array[i].split(",")[0].trim()), Integer.valueOf(array[i].split(",")[1].trim()));
            listPoints.add(point);
            int x = Integer.valueOf(array[i].split(",")[0].trim());
            int y = Integer.valueOf(array[i].split(",")[1].trim());

            if (x > maxX) maxX = x;
            if (y > maxY) maxY = y;

        }
        System.out.println("Max X: " + maxX);
        System.out.println("Max Y: " + maxY);
   }

   public int findClosest(int x, int y) {
       int i = 0;
       int distance = 0;
       int minDistance = 9999999;
       int locationId = -1;
       boolean foundTwo = false;
       for (Point p : listPoints) {
           distance = Math.abs(p.x - x) + Math.abs(p.y - y);
           if (distance == minDistance) foundTwo = true;
           if (distance < minDistance) {
              foundTwo = false;
              minDistance = distance;
              locationId = i;
           } 
           i++;
       }
       if (foundTwo) {
           return -1;
       } else {
           return locationId;
       }
   }

   public void loadGrid() {
       for (var y = 0; y < Y; y++) {
           for (var x = 0; x < X; x++) {
               grid[x][y] = this.findClosest(x, y); 
           }
       }
   }

   public void printGrid() {
       for (var y = 0; y < Y; y++) {
           for (var x = 0; x < X; x++) {
               System.out.print(grid[x][y] + " ");; 
           }
           System.out.print("\n");; 
       }
   }
}
