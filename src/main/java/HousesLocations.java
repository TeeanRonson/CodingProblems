package java.codingproblems.cs686;

public class HousesLocations {



    public HousesLocations() {

    }

    public int[] solution(int[] stores, int[] houses) {


        int[] result = new int[houses.length];

        if (stores == null || houses == null || stores.length == 0 || houses.length == 0) {
            return result;
        }


        for (int i = 0; i < houses.length; i++) {
            int closest = Integer.MAX_VALUE;
            int closestStore = Integer.MAX_VALUE;
            int currHouse = houses[i];
            for (int j = 0; j < stores.length; j++) {
                int minDistance = Math.abs(stores[j] - currHouse);
                if (minDistance < closest) {
                    closest = minDistance;
                    closestStore = stores[j];
                } else if (minDistance == closest) {
                    closestStore = Math.min(stores[j], closestStore);
                }
            }
            result[i] = closestStore;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = {1, 5, 20, 11, 16, 17, 17};
        int[] b = {5, 10, 17};

        HousesLocations hl = new HousesLocations();

        int[] result = hl.solution(a, b);

        for (Integer c: result) {
            System.out.print(c + " ");
        }

    }




}
