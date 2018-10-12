import java.util.concurrent.locks.Lock;

public class LockerOpenClose {


    /**
     * Imagine there are a 100 lockers that can either be open or close
     *
     * All lockers are closed to begin with
     *
     * 100 people come through and open and close depending on which number of person
     * they are
     *
     * eg. 1st person opens every door
     * 2nd person tocuhes only multiples of 2
     * 3rd person touches only multiples of 3
     *
     *
     */

    private String[] lockers;
    private int size;

    public LockerOpenClose(int size) {
        this.lockers = new String[size];
        this.size = size;
        initializeLockers();
    }


    public void initializeLockers() {

        for (int i = 1; i < size; i++) {
            this.lockers[i] = "closed";
        }

        printLockers();
    }

    public void runTeaser() {

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j = j + i) {
                if (this.lockers[j].equals("closed")) {
                    this.lockers[j] = "opened";
                } else {
                    this.lockers[j] = "closed";
                }
            }
        }
        printLockers();
    }

    private void printLockers() {

        for (int i = 1; i < size; i++) {
            if (lockers[i].equals("opened")) {
                System.out.println((i) + " " + lockers[i]);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {

        LockerOpenClose loc = new LockerOpenClose(1001);

        loc.runTeaser();

    }
}

