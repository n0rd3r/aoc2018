public class Coord {
    int startX;
    int startY;
    int width;
    int height;

    public Coord(String input) {
        int i = input.indexOf("@");
        int y = input.indexOf(":");
        int z = input.indexOf(",");
        int x = input.indexOf("x");
        startX = Integer.parseInt(input.substring(i+1, z).trim());
        startY = Integer.parseInt(input.substring(z+1, y).trim());
        width = Integer.parseInt(input.substring(y+1, x).trim());
        height = Integer.parseInt(input.substring(x+1).trim());
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
