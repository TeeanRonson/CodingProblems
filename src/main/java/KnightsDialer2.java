import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class KnightsDialer2 {

    LinkedList<String> result;
    public KnightsDialer2() {
        this.result = new LinkedList<>();
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

        dialHelper(start, length, dialpad, "");

        System.out.println("Result");
        for(String s: this.result) {
            System.out.println(s);
        }
    }

    public void dialHelper(int start, int length, HashMap<Integer, LinkedList<Integer>> dialpad, String path) {

        if (path == "") {
            path += String.valueOf(start);
        }

        if (length <= 1) {
            this.result.add(path);
        }

        for (Integer i: dialpad.get(start)) {
            System.out.println(i);
            dialHelper(i, length - 1, dialpad, path += String.valueOf(i));
        }
    }

    public static void main(String[] args) {

        KnightsDialer2 kd2 = new KnightsDialer2();
        kd2.dial(6, 3);


    }

}