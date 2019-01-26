import java.util.Random;

public class TicTacToe {

    private char[][] board;
    public TicTacToe(int size) {
        this.board = new char[size][size];
        fillBoard();
    }



    public boolean play(char shape) {

        Random r = new Random();
        while (true) {
            int row = r.nextInt(3);
            int col = r.nextInt(3);
            if (this.board[row][col] == '_') {
                this.board[row][col] = shape;
                printBoard();
                if (checkWin(shape, row, col)) {
                    System.out.println("WINNER is player: " + shape);
                    return true;
                }
                if (checkOver()) {
                    System.out.println("No Winner");
                    return true;
                }

                break;
            } else {
                continue;

            }
        }
        return false;
    }

    public void printBoard() {

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void fillBoard() {

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = '_';
            }
        }
    }

    public boolean checkOver() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char shape, int row, int col) {

        return checkVertical(shape, row, col) || checkHorizontal(shape, row, col);
    }

    private boolean checkHorizontal(char shape, int row, int col) {

        //check rightward
        int i = 1, right = col + 1, left = col - 1;
        while(right < this.board.length) {
            if (this.board[row][right] == shape) {
                i++;
            }
            right++;
        }

        //check leftward
        while (left >= 0) {
            if (this.board[row][left] == shape) {
                i++;
            }
            left--;
        }

        if (i == 3) return true;
        return false;
    }

    private boolean checkVertical(char shape, int row, int col) {

        int i = 1, up = row - 1, down = row + 1;
        //check upward
        while (up >= 0) {
            if (this.board[up][col] == shape) {
                i++;
            }
            up--;
        }

        //check downward
        while (down < this.board.length) {
            if (this.board[down][col] == shape) {
                i++;
            }
            down++;
        }
        if (i == 3) return true;
        return false;
    }


//    private boolean checkDiagonal(char shape, int row, int col) {
//
//        int i = 1;
//        //check NE
//        int N = row - 1, E = col + 1, S = row + 1, W = col - 1;
//        while(N >=0 && E < this.board.length) {
//
//        }
//        //check NW
//
//        //check SE
//
//        //check SW
//
//    }

    public static void main(String[] args) {

        int round = 0;
        char shape;
        TicTacToe game = new TicTacToe(3);
        while(true) {
            System.out.println(round);
            if (round % 2 == 0) {
                shape = 'X';
            } else {
                shape = 'O';
            }
            boolean over = game.play(shape);
            if(over == true) {
                break;
            }
            round++;
        }
        System.out.println("Game over");

    }
}
