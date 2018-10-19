import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class CheckerBoardChecker {


    private int[][] board;
    private int[][] clone;
    private int size;
    public CheckerBoardChecker(int square) {
        this.board = new int[square][square];
        this.clone = new int[square][square];
        this.size = square;

    }

    public void setBoard(int[] values) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = values[(size*i)+j];
                this.clone[i][j] = values[(size*i)+j];
            }
        }
        printBoard();
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(this.board[i][j] + "\t");
            }
        }
        System.out.println();

    }

    public LinkedList<Integer> maxDollars() {

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        if (this.board.length == 0 || this.board == null) {
            return null;
        }

        //rows
        for (int i = 1; i < size; i++) {
            //columns
            for (int j = 0; j < this.size; j++) {
                if (j == 0) {
                    //Top vs right
                    this.board[i][j] += Math.max(this.board[i-1][j], this.board[i-1][j+1]);
                } else if (j == this.size - 1) {
                    //Top vs left
                    this.board[i][j] += Math.max(this.board[i-1][j], this.board[i-1][j-1]);
                } else {
                    //Top vs sides
                    int side = Math.max(this.board[i-1][j-1], this.board[i-1][j+1]);
                    this.board[i][j] += Math.max(this.board[i-1][j], side);
                }

                //Find the max value from the last level
                if (i == size - 1) {
                    if (this.board[i][j] > max) {
                        max = this.board[i][j];
                        maxIndex = j;
                    }
                }
            }
            printBoard();
        }

        System.out.println();
        System.out.println("Max value: " + max);

        return findPath(maxIndex);

    }

    private LinkedList<Integer> findPath(int index) {

        LinkedList<Integer> path = new LinkedList<>();

        for (int i = this.size - 1; i > 0; i--) {
            path.add(index);
            if (index == 0) {
                index = this.board[i-1][index] > this.board[i-1][index+1] ? index : index + 1;
            } else if(index == this.size - 1) {
                index = this.board[i-1][index-1] > this.board[i-1][index] ? index - 1 : index;
            } else {
                int side = this.board[i-1][index-1] > this.board[i-1][index+1] ? index - 1 : index + 1;
                int greater = Math.max(this.board[i-1][index-1], this.board[i-1][index+1]);
                index = this.board[i-1][index] > greater ? index : side;
            }
        }
        path.add(index);

        return path;
    }


    public static void main(String[] args) {

        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] values1 = {1, 2, 3, 100, 5, 6, 100, 8, 9, 100, 11, 12, 100, 14, 15, 16};

        int[] values2 = {1, 7, 20, 5, 8, 4, 15, 8, 5};


//        CheckerBoardChecker cbc = new CheckerBoardChecker((int) Math.sqrt(values.length));
//        cbc.setBoard(values);
//        cbc.maxDollars();

        CheckerBoardChecker cbc1 = new CheckerBoardChecker((int) Math.sqrt(values1.length));
        cbc1.setBoard(values1);
        LinkedList<Integer> path = cbc1.maxDollars();

        for (int i: path) {
            System.out.print(i + " ");
        }



        ///O(n^2) algorithm using Dynamic Programming


    }




}
