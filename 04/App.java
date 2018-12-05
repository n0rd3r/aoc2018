import java.util.*;
public class App {
    public static void main(String[] args) {
        App a = new App();
        String data = Util.loadFile("sort.txt");
        List<Guard> l = a.processData(data);
        Map<String, Integer> m = a.processList(l);
        Map<String, String> mRange = a.processRange(l);
        Integer max = 0;
        String maxId = new String();
        for (String key : m.keySet()) {
            if (m.get(key) > max) {
                max = m.get(key);
                maxId = key;
            }
        }
        //System.out.println(maxId);
        //int minute = a.processMaxMinute(mRange.get(maxId));
        //System.out.println(mRange.get(maxId));
        //System.out.println(minute);
        //System.out.println(minute * Integer.valueOf(maxId));
        System.out.println(a.processGuardMaxMinute(mRange)); 

    }

    public String processGuardMaxMinute(Map<String, String> m) {
        String output = new String();
        String[] array;
        String id = new String();
        int max = 0;
        int count = 0;
        int number = 0;
        int minute = 0;
        for (String key : m.keySet()) {
            output = this.processMaxMinute(m.get(key));
            array = output.split(":", -1);
            count = Integer.parseInt(array[1]);
            number = Integer.parseInt(array[0]);
            if(count > max) {
                id = key;
                minute = number;
                max = count;
            }
        }
        return "Answer: " + (minute * Integer.parseInt(id));

    }

    public String processMaxMinute(String s) {
        String[] array = s.split(",", -1);
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int start;
        int end;
        for(int i = 0; i < array.length; i++) {
            String[] a2 = array[i].split(":", -1);
            start = Integer.parseInt(a2[0]);
            end = Integer.parseInt(a2[1]);
            for(int x = start; x < end + 1; x++) {
                if(m.get(x) == null) {
                    m.put(x, 0);
                } else {
                    m.put(x, m.get(x) + 1);
                }
            }
        }
        int max = 0;
        int maxKey = 0;
        for (Integer key : m.keySet()) {
            if (m.get(key) > max) {
                max = m.get(key);
                maxKey = key;
            }
        }
        return maxKey + ":" + max;
    }

    public App() {
    }

    public List<Guard> processData(String s) {
        String[] array = s.split("\n", -1);
        String id = new String();
        int falls = 0;
        int wakes = 0;
        Guard guard; 
        List<Guard> guardList = new ArrayList<Guard>();

        for (int i = 0; i < array.length; i++) {
            if (array[i].indexOf("#") > -1) {
                id = this.processId(array[i]);
            } else if (array[i].indexOf("falls") > -1) {
                falls = this.processMinute(array[i]);
            } else if (array[i].indexOf("wakes") > -1) {
                wakes = this.processMinute(array[i]);
                guard = new Guard(id, falls, wakes);
                guardList.add(guard);
            }
        }
        return guardList;
    }

    public Map<String, Integer> processList(List<Guard> l) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(Guard g : l){
           if (m.get(g.getId()) == null) {
               m.put(g.getId(), g.totalMinutes());
           } else {
               m.put(g.getId(), m.get(g.getId()) + g.totalMinutes());
           }
        }
        return m;
    }

    public Map<String, String> processRange(List<Guard> l) {
        Map<String, String> m = new HashMap<String, String>();
        for(Guard g : l){
           if (m.get(g.getId()) == null) {
               m.put(g.getId(), g.range());
           } else {
               m.put(g.getId(), m.get(g.getId()) + "," + g.range());
           }
        }
        return m;
    }

    public String processId(String s) {
        int start = 0;
        int end = 0;
        start = s.indexOf("#");
        end = s.indexOf("b");
        return s.substring(start + 1, end - 1);
    }

    public Integer processMinute(String s) {
        return Integer.valueOf(s.substring(15, 17));
    }
}
