public class WateringFlowers {


    public static int wateringFlowers(int[] flowers, int cap) {

        boolean[] filled = new boolean[flowers.length];
        int size = flowers.length;
        int steps = 0;

        while (!filled[size - 1]) {
            int i = 0;
            int capacity = cap;
            while (i < size && capacity - flowers[i] >= 0) {
                if (filled[i] == true) {
                    i++;
                    steps++;
                } else {
                    while (i < size && capacity - flowers[i] >= 0) {
                        System.out.println(i);
                        capacity -= flowers[i];
                        System.out.println("Cap: " + capacity);
                        steps++;
                        filled[i] = true;
                        i++;
                    }
                }
            }
            if (!filled[size - 1]) {
                steps += i;
            }
            System.out.println("steps:" + steps);
        }

        return steps;
    }

    public static int wateringPlantsLeetCode(int[] plants, int capacity) {

        int currentCapacity = capacity;
        int currentSteps = 0;
        for (int i = 0; i < plants.length; i++) {
            if (currentCapacity < plants[i]) {
                currentCapacity = capacity;
                currentSteps += 2*i;
            }
            currentCapacity -= plants[i];
            currentSteps++;
        }
        return currentSteps;
    }

    public static void main(String[] args) {

        int[] input = new int[] {2, 4, 5, 1, 2};
        int[] input1 = new int[] {1, 1, 2};

        int cap = 6;
        int cap1 = 3;


        System.out.println(wateringPlantsLeetCode(input, cap));
//        System.out.println(wateringFlowers(input1, cap1));


    }

}
