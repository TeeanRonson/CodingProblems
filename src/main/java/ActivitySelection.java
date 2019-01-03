import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class ActivitySelection {


    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    //  n   -->  Total number of activities
    //  s[] -->  An array that contains start time of all activities
    //  f[] -->  An array that contains finish time of all activities
    public static void printMaxActivities(int[] s, int[] f, int n) {


        LinkedList<Integer> result = new LinkedList();
        result.add(f[0]);
        int end = f[0];

        for (int i = 1; i < n; i++) {
            if (s[i] >= end) {
                System.out.print(s[i] + " ");
                result.add(f[i]);
                end = f[i];
            }

        }
        System.out.println();

        for (Integer i: result) {
            System.out.print(i + " ");
        }
    }


    public static void main(String[] args) {
        int s[] =  {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int f[] =  {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        int n = s.length;

        if (s.length == f.length) {
            printMaxActivities(s, f, n);
        }


    }
}
