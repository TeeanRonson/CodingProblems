import java.util.Random;

public class ConnectFour {

    private String[][] board;
    private int win;
    private int columns;
    private int rows;
    private boolean gameOver;

    public ConnectFour(int columns, int rows, int win) {
        this.board = new String[rows][columns];
        this.win = win;
        this.columns = columns;
        this.rows = rows;
        this.gameOver = false;
        this.initializeBoard();
    }

    /**
     * Initialize all positions with '.'
     */
    public void initializeBoard() {

        for(int i = this.rows - 1; i >= 0; i--) {
            for (int j = 0; j < this.columns; j++) {
                this.board[i][j] = ".";
            }
        }

        printBoard();
    }

    public void checkWin(int row, int column) {

        if (checkDiagonals(row, column) == true) {
            System.out.println("Win by diagonal");
            this.gameOver = true;
        }
        if (checkHorizontal(row, column) == true) {
            System.out.println("Win by Horizontal");
            this.gameOver = true;
        }
        if (checkVertical(row, column) == true) {
            System.out.println("Win by Vertical");
            this.gameOver = true;
        }
    }

    /**
     * Player makes a play in the game
     * @param column
     * @param player
     * @return
     */
    public boolean play(int column, String player) {

        System.out.println("Player: " + player);
        System.out.println("Column played: " + column);

        boolean complete = false;
        String element;
        int i = 0;

        if (player == "one") {
            element = "O";
        } else {
            element = "X";
        }

        while(i != this.rows) {
            if (this.board[i][column] == ".") {
                this.board[i][column] = element;
                complete = true;
                printBoard();
                checkWin(i, column);
//                if (checkDiagonals(i, column) == true || checkHorizontal(i, column) == true || checkVertical(i, column) == true) {
//                    this.gameOver = true;
//                }
                return complete;
            } else {
                i++;
            }
        }
        columnFull(i, complete);
        return complete;
    }

    /**
     * All positions are played
     * Game ends
     * @return
     */
    public boolean allPositionsFull() {

        for (int i = 0; i < this.columns; i++) {
            int j = this.rows - 1;
            if (this.board[j][i] == ".") {
                return false;
            }
        }
        return true;
    }

    /**
     * Column being played is full
     * @param i
     * @param complete
     * @return
     */
    private boolean columnFull(int i, boolean complete) {

        if(i == 6 && complete == false) {
//            System.out.println();
//            System.out.println("Column full");
//            System.out.println("Play different column");
//            System.out.println();
            return complete;
        }
        return false;
    }

    /**
     * Prints board
     * From top row down
     * from left to right
     */
    private void printBoard() {
        System.out.println();
        for(int i = this.rows - 1; i >= 0; i--) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }


    /**
     * Get game board columns
     * @return
     */
    public int getColumns() {
        return this.columns;
    }


    /**
     * Checks to see if player can win Horizontally
     * @param row
     * @param column
     * @return
     */
    private boolean checkHorizontal(int row, int column) {

        String symbol = this.board[row][column];
        int counter = 1;

        //Go right
        for (int i = column + 1; i < this.columns; i++) {
            if (this.board[row][i] != symbol) {
                break;
            }
            counter++;
        }

        //Go left
        for (int i = column - 1; i >= 0; i--) {
            if (this.board[row][i] != symbol) {
                break;
            }
            counter++;
        }

        if (counter == this.win) {
//            System.out.println("Checking H: " + symbol);
//            System.out.println("Row: " + row);
//            System.out.println("Column: " + column);
//            System.out.println("Counter H: " + counter);
//            System.out.println("Score to Win H: " + this.win);
            return true;
        }
        return false;
    }

    /**
     * Checks if player can win vertically
     * @param row
     * @param column
     * @return
     */
    private boolean checkVertical(int row, int column) {

        String symbol = this.board[row][column];
        int counter = 1;

        // Go down
        for (int i = row - 1; i >= 0; i--) {
            if (this.board[i][column] != symbol) {
                break;
            }
            counter++;
        }

        if (counter == this.win) {
//            System.out.println();
//            System.out.println("Checking V: " + symbol);
//            System.out.println("Row: " + row);
//            System.out.println("Column: " + column);
//            System.out.println("Counter V: " + counter);
//            System.out.println("Score to Win V: " + this.win);
            return true;
        }

        return false;
    }

    private boolean checkDiagonals(int row, int column) {

        String symbol = this.board[row][column];
        int NE = NE(symbol, row, column);
        int SW = SW(symbol, row, column);

        int NW = NW(symbol, row, column);
        int SE = SE(symbol, row, column);

//        System.out.println("NE: " + NE);
//        System.out.println("SW: " + SW);
//
//        System.out.println("NW " + NW);
//        System.out.println("SE " + SE);

        if ((NE+SW) == this.win || (NW+SE) == this.win) {
            return true;
        }

        return false;
    }


    private int NE(String symbol, int row, int column) {

        int counter = 0;
        int ver = row; //North
        int hor = column; //East

        while (ver < this.rows && hor < this.columns) {
            if (this.board[ver][hor] != symbol) {
                break;
            }
            counter++;
            ver++;
            hor++;
        }
        return counter;

    }

    private int SW(String symbol, int row, int column) {

        int counter = 0;
        int ver = row - 1; //South
        int hor = column - 1; //West

        while(ver >= 0 && hor >= 0) {
            if (this.board[ver][hor] != symbol) {
                break;
            }
            counter++;
            ver--;
            hor--;
        }
        return counter;
    }

    private int NW(String symbol, int row, int column) {

        int counter = 0;
        int ver = row; //North
        int hor = column; //West

        while(ver < this.rows && hor >= 0) {
            if (this.board[ver][hor] != symbol) {
                break;
            }
            counter++;
            ver++;
            hor--;
        }

        return counter;
    }

    /**
     * Checks South East
     * @param symbol
     * @param row
     * @param column
     * @return
     */
    private int SE(String symbol, int row, int column) {

        int counter = 0;
        int ver = row - 1; //South
        int hor = column + 1; //East

        while(ver >= 0 && hor < this.columns) {
            if (this.board[ver][hor] != symbol) {
                break;
            }
            counter++;
            ver--;
            hor++;
        }
        return counter;
    }

    /**
     * Returns game status
     * @return
     */
    public boolean gameStatus() {
        return this.gameOver;
    }



    public static void main(String[] args) {

        ConnectFour game = new ConnectFour(7, 6, 4);
        boolean gameOver = false;
        String one = "one";
        String two = "two";
        int turn = 0;
        int rounds = 0;
        boolean complete = false;

        while(true) {
            Random number = new Random();
            int column = number.nextInt(game.getColumns());
            if (turn % 2 == 0) {
                complete = game.play(column, one);
                if(complete == false) {
                    continue;
                }
            } else {
                complete = game.play(column, two);
                if (complete == false) {
                    continue;
                }
            }
            turn++;
            rounds++;

            if(game.gameStatus() == true) {
                System.out.println("Game over");
                break;
            }

            if (game.allPositionsFull() == true) {
                System.out.println("All positions full");
                System.out.println("Rounds played: " + rounds);
                break;
            }


        }

    }



}






