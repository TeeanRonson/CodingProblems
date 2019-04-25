import java.util.LinkedList;
import java.util.TreeMap;

public class GoogleOA2018 {



    public GoogleOA2018() {




    }

    public int solution(int[] A) {

//
//        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
//        LinkedList list = new LinkedList();
//        map.put(0, list);
//
//        for (int i: A) {
//            if (map.lastKey() >= i) {
//                map.get(map.firstKey()).add(i);
//            } else {
//                LinkedList<Integer> newList = new LinkedList<>();
//                newList.add(i);
//                map.put(i, newList);
//            }
//        }
//
//        return map.size() - 1;

        if (A == null || A.length == 0) {
            return 0;
        }

        int highest = Integer.MIN_VALUE;
        int rows = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > highest) {
                highest = A[i];
                rows++;
            }
        }
        return rows;
    }


    public static void main(String[] args) {

        int[] A = {5, 4, 3, 6, 1};


        int[] B = {7, 6, 4, 3, 2, 7, 10, 11};

        GoogleOA2018 oa = new GoogleOA2018();

        System.out.println(oa.solution(A));

    }

}
