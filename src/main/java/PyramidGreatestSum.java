import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * Find the greatest sum and the path from the top node to the bottom node
 * 75
 * 95 64
 * 17 47 82
 *
 *
 *
 */
public class PyramidGreatestSum {

    private int[][] board;
    private int rowMax;
    private int currChild;
    private List<Integer> path;

    public PyramidGreatestSum() {
        this.rowMax = 0;
        this.currChild = 0;
        this.path = new LinkedList<>();

    }

    /**
     * Set size of the board
     * @param list
     */
    private void setBoard(List<Integer> list) {

        int size = (int) Math.sqrt(2*list.size());

        for (int i = 0; i < size + 1; i++) {
            list.add(0);
        }

        this.board = new int[size + 1][size + 1];

//        this.board = new int[listSize][listSize];


    }

    /**
     * Read a list of numbers
     * @param document
     * @return
     */
    private List<Integer> readDocument(String document) {

        List<Integer> numbers = new ArrayList<>();
        String currentLine;
        int i = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(document))) {

            while ((currentLine = reader.readLine()) != null) {

                String[] a = currentLine.split("\\s+");

                for (String value: a) {
                    numbers.add(Integer.parseInt(value));
                }
            }

        } catch(IOException e){
            e.printStackTrace();
            System.out.println("File Input Unsuccessful");
            System.exit(0);
        }

        return numbers;
    }

    /**
     * Adds numbers into the 2D matrix
     * @param list
     */
    private void readNums(List<Integer> list) {

        int k = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j <= i; j++) {
                this.board[i][j] = list.get(k);
                k++;
            }
        }
        printBoard();
    }

    /**
     * Prints the 2D matrix
     */
    private void printBoard() {

        for (int i = 0; i < this.board.length; i++) {
            System.out.println();
            for (int j = 0; j < this.board.length; j++) {
                System.out.print(this.board[i][j] + "\t");
            }
        }
        System.out.println();
        System.out.println();
    }


    /**
     * Find the path that delivers the largest number
     * @return
     */
    public Integer findLargestSum() {

        if (this.board == null || this.board.length == 0) {
            return null;
        }

        int k = 2;
        for (int i = this.board.length - 2; i >= 0; i--) {
            this.rowMax = 0;
            for (int j = 0; j <= this.board.length - k; j++) {
                int curr = this.board[i][j];
                int child1 = this.board[i + 1][j];
                int child2 = this.board[i + 1][j + 1];
                this.board[i][j] = Math.max(curr + child1, curr + child2);
            }
            k++;
        }

        printBoard();
        return this.board[0][0];
    }


    private void findPath(int total) {

        // Start from top left. As we move down, we subtract the
        // largest child value from the parent.
        // And add the value into a List
        int top = total;
        int next = 0;

        for (int i = 1; i < this.board.length; i++) {
            int largest = 0;
            for (int j = 0; j <= i; j++) {
                if (this.board[i][j] > largest) {
                    largest = this.board[i][j];
                }
            }
            next = top - largest;
            top = top - next;
            path.add(next);
        }
    }


    /**
     * Run program to find largest sum
     * @param newTriangle
     */
    private void runProgram(String newTriangle) {

        List<Integer> setA = new LinkedList<>();

        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        setA.add(6);

//        System.out.println(setA);
//        setBoard(3);
//        readNums(setA);

        List<Integer> list = readDocument(newTriangle);
        setBoard(list);
        readNums(list);
        int result = findLargestSum();
        System.out.println("Greatest sum: " + result);
        findPath(result);
        System.out.println(this.path);
        int sum = 0;
        for (Integer value: this.path) {
            sum += value;
        }
        System.out.println("Check sum: " + sum);


    }


    public static void main(String[] args) {

        List<Integer> setA = new LinkedList<>();

        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        setA.add(6);



        PyramidGreatestSum pgs = new PyramidGreatestSum();
//        PyramidGreatestSum pgsII = new PyramidGreatestSum();


        pgs.runProgram("Pyramid1.txt");
//        pgsII.runProgram("big_triangle.txt");










    }
}
