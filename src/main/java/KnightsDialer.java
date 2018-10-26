import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class KnightsDialer {

    HashSet<LinkedList> result;
    public KnightsDialer() {
        this.result = new HashSet<>();
    }

    public HashMap<Integer, LinkedList<Integer>> fillPad() {

        HashMap<Integer, LinkedList<Integer>> dialpad = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            switch (i) {
                case 0:
                    list.add(4);
                    list.add(6);
                    break;
                case 1:
                    list.add(6);
                    list.add(8);
                    break;
                case 2:
                    list.add(7);
                    list.add(9);
                    break;
                case 3:
                    list.add(4);
                    list.add(8);
                    break;
                case 4:
                    list.add(3);
                    list.add(9);
                    list.add(0);
                    break;
                case 5:
                    break;
                case 6:
                    list.add(1);
                    list.add(7);
                    list.add(0);
                    break;
                case 7:
                    list.add(2);
                    list.add(6);
                    break;
                case 8:
                    list.add(1);
                    list.add(3);
                    break;
                case 9:
                    list.add(2);
                    list.add(4);
                    break;
            }
            dialpad.put(i, list);
        }

        for (Map.Entry<Integer, LinkedList<Integer>> i: dialpad.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }

        return dialpad;
    }

    public void dial(int start, int length) {

        if (start < 0 || start > 9 || length <= 0) {
            return;
        }

        HashMap<Integer, LinkedList<Integer>> dialpad = fillPad();
        LinkedList<Integer> path = new LinkedList();
        dialHelper(start, length, dialpad, path);

        System.out.println("Result");
        for(LinkedList ll: this.result) {
            System.out.println(ll);
        }
    }

    public void dialHelper(int start, int length,  HashMap<Integer, LinkedList<Integer>> dialpad, LinkedList<Integer> path) {


        if (length <= 0) {
          result.add(new LinkedList<>(path));
            return;
        }

        path.add(start);

        for (Integer i: dialpad.get(start)) {
            dialHelper(i, length - 1, dialpad, path);
        }
        int a = path.removeLast();
        System.out.println("Remove: " + a);


    }

    public static void main(String[] args) {

        KnightsDialer kd = new KnightsDialer();
        kd.dial(6, 3);

    }

}
