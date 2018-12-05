public class GuardMax {
    String id;
    int maxNumber;
    int maxMinute;

    public GuardMax(String id, int maxNumber, int maxMinute) {
        this.id = id;
        this.maxNumber = maxNumber;
        this.maxMinute = maxMinute;
    }

    public String getId() {
        return id;
    }

    public int getMaxMinute() {
        return maxMinute;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}


