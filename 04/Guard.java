public class Guard {
    String id;
    int falls;
    int wakes;
    public Guard(String id, int falls, int wakes) {
        this.id = id;
        this.falls = falls;
        this.wakes = wakes;
    }

    public String getId() {
        return id;
    }

    public int totalMinutes() {
        return wakes - falls;
    }

    public String range() {
        return falls + ":" + wakes;
    }
}


