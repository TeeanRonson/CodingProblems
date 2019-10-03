import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class YelpOAXianan {


    public static ArrayList<Integer> findActiveBusinessIds(ArrayList<Event> input) {

        HashMap<String, TypeInfo> db = new HashMap<>();
        HashMap<String, Double> averages = new HashMap<>();
        storeInfo(db, input);
        findAverages(db, averages);

        return getActiveList(db, averages, input);
    }

    public static ArrayList<Integer> getActiveList(HashMap<String, TypeInfo> db, HashMap<String, Double> averages, ArrayList<Event> input){

        HashMap<Integer, Integer> countActive = new HashMap<>();

        for (Event e: input) {
            if (countActive.keySet().contains(e.id)) {
                if (e.occurences >= averages.get(e.eventType)) {
                    countActive.put(e.id, countActive.get(e.id) + 1);
                }
            } else {
                countActive.put(e.id, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer i: countActive.keySet()) {
            if (countActive.get(i) >= 2) {
                result.add(i);
            }
        }
        return result;
    }


    public static void findAverages(HashMap<String, TypeInfo> db, HashMap<String, Double> averages) {

        for (String eventType: db.keySet()) {
            averages.put(eventType, (double) db.get(eventType).sum/db.get(eventType).total);
        }

    }

    public static void storeInfo(HashMap<String, TypeInfo> db, ArrayList<Event> input) {

        for (Event e: input) {
            if (db.containsKey(e.eventType)) {
                if (e.occurences > 0) {
                    db.get(e.eventType).sum += e.occurences;
                    db.get(e.eventType).total++;
                }
            } else {
                db.put(e.eventType, new TypeInfo(e.occurences, 1));
            }
        }
    }



    static class TypeInfo{
        Integer sum;
        Integer total;

        public TypeInfo(Integer sum, Integer total) {
            this.sum = sum;
            this.total = total;
        }




    }

    static class Event{
        String eventType;
        Integer occurences;
        Integer id;

        public Event(String eventType, Integer occurences, Integer id) {
            this.eventType = eventType;
            this.occurences = occurences;
            this.id = id;
        }
    }


    public static void main(String[] args) {

        ArrayList<Event> input = new ArrayList<>();

        input.add(new Event("ads", 7, 3));
        input.add(new Event("ads", 8, 2));
        input.add(new Event("ads", 5, 1));
        input.add(new Event("pageViews", 11, 2));
        input.add(new Event("pageViews", 12, 3));
        input.add(new Event("photoViews", 10, 3));
        input.add(new Event("reviews", 7, 2));

        System.out.println(findActiveBusinessIds(input));

    }


}
