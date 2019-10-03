public class RefillWateringPlants {


    public static int solution(int[] plants, int capacity1, int capacity2) {


//        int refill = 2;
//        int cap1 = capacity1;
//        int cap2 = capacity2;
//        int i = 0;
//        int j = plants.length - 1;
//
//        while (i <= j) {
//            if (i == j) {
//                int sumBoth = cap1 + cap2;
//                if (sumBoth - plants[i] >= 0) {
//                    return refill;
//                } else {
//                    cap1 += capacity1;
//                    cap2 += capacity2;
//                    refill += 2;
//                }
//            } else {
//                if (cap1 - plants[i] >= 0) {
//                    cap1 -= plants[i];
//                    System.out.println("Cap1:" + cap1);
//                    i++;
//                } else {
//                    cap1 = capacity1;
//                    refill++;
//                    continue;
//                }
//
//                if (cap2 - plants[j] >= 0) {
//                    cap2 -= plants[j];
//                    System.out.println("Cap2:" + cap2);
//                    j--;
//                } else {
//                    cap2 = capacity2;
//                    refill++;
//                    continue;
//                }
//            }
//        }
//        return refill;
//
//    }
        if (plants == null || plants.length == 0) return 0;

        int refill = 0;
        int cap1 = 0;
        int cap2 = 0;
        int i = 0;
        int j = plants.length - 1;

        while (i < j) {
            if (cap1 < plants[i]) {
                cap1 = capacity1;
                refill++;
            }
            cap1 -= plants[i];
            i++;

            if (cap2 < plants[j]) {
                cap2 = capacity2;
                refill++;
            }
            cap2 -= plants[j];
            j--;
        }

        if (i == j) {
            int sumBoth = cap1 + cap2;
            if (sumBoth >= plants[i]) {
                return refill;
            } else {
                refill += 2;
            }
        }
        return refill;
    }


    public static void main(String[] args) {

        int[] test = new int[] {2, 4, 5, 1, 2};
        System.out.println(solution(test, 5, 7));


    }
}
