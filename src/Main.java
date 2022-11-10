import java.util.Scanner;

public class Main {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int moveCount;
        String player;
        boolean finished;
        boolean playing;
        int row;
        int column;
        final int winMoves = 5;
        final int tieMoves = 7;

        do {
            moveCount = 0;
            player = "X";
            playing = true;
            clearboard();

            do {

                do {
                    display();
                    System.out.println("Enter a move " + player);
                    row = Safeinput.getRangedInt(in, "Enter a row ", 1, 3);
                    column = Safeinput.getRangedInt(in, "Enter a column ", 1, 3);
                    row--; column--; }
                while (!isValidMove(row, column));
                board[row][column] = player;
                moveCount++;

                if (moveCount >= winMoves) {
                    if (isWin(player)) {
                        display();
                        System.out.println("Player " + player + " wins!");
                        playing = false;}
                }
                if (moveCount >= tieMoves) {
                    if (isTie()) {
                        display();
                        System.out.println("Scratch!");
                        playing = false;}
                }
                if (player.equals("X")) {
                    player = "O";
                }
                else {
                    player = "X";}

            } while (playing);

            finished = Safeinput.getYNConfirm(in, "Play Again?");
        } while (!finished);
    }

    private static void clearboard() {

        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COL; column++) {
                board[row][column] = "";
            }
        }
    }

    private static void display() {
        for (int row = 0; row < ROW; row++) {
            System.out.print("| ");
            for (int column = 0; column < COL; column++) {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int column)
    {
        return board[row][column].equals("");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColumnWin(player) || isDiagonalWin(player);
    }
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equalsIgnoreCase(player) &&
                    board[row][1].equalsIgnoreCase(player) &&
                    board[row][2].equalsIgnoreCase(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isColumnWin(String player) {
        for (int column = 0; column < COL; column++) {
            if (board[0][column].equalsIgnoreCase(player) &&
                    board[1][column].equalsIgnoreCase(player) &&
                    board[2][column].equalsIgnoreCase(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[0][2].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][0].equalsIgnoreCase(player))
        {
            return true;
        }
        return board[0][0].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player);
    }

    private static boolean isTie() {
        boolean Xflag = false;
        boolean Oflag = false;

        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equalsIgnoreCase("X") ||
                    board[row][1].equalsIgnoreCase("X") ||
                    board[row][2].equalsIgnoreCase("X")) {
                Xflag = true;
            }
            if (board[row][0].equalsIgnoreCase("O") ||
                    board[row][1].equalsIgnoreCase("O") ||
                    board[row][2].equalsIgnoreCase("O")) {
                Oflag = true;
            }

            if (!(Xflag && Oflag)) {
                return false;
            }
            Xflag = Oflag = false;
        }
        for (int column = 0; column < COL; column++) {
            if (board[0][column].equalsIgnoreCase("X") ||
                    board[1][column].equalsIgnoreCase("X") ||
                    board[2][column].equalsIgnoreCase("X")) {
                Xflag = true;
            }
            if (board[0][column].equalsIgnoreCase("O") ||
                    board[1][column].equalsIgnoreCase("O") ||
                    board[2][column].equalsIgnoreCase("O"))
            {
                Oflag = true;
            }

            if (!(Xflag && Oflag))
            {
                return false;
            }
        }
        Xflag = Oflag = false;

        if (board[0][2].equalsIgnoreCase("X") ||
                board[1][1].equalsIgnoreCase("X") ||
                board[2][0].equalsIgnoreCase("X")) {
            Xflag = true;
        }

        if (board[0][0].equalsIgnoreCase("O") ||
                board[1][1].equalsIgnoreCase("O") ||
                board[2][2].equalsIgnoreCase("O")) {
            Oflag = true;
        }
        if (!(Xflag && Oflag)) {
            return false;
        }
        Xflag = Oflag = false;

        if (board[0][0].equalsIgnoreCase("X") ||
                board[1][1].equalsIgnoreCase("X") ||
                board[2][2].equalsIgnoreCase("X")) {
            Xflag = true;
        }
        if (board[0][0].equalsIgnoreCase("O") ||
                board[1][1].equalsIgnoreCase("O") ||
                board[2][2].equalsIgnoreCase("O")) {
            Oflag = true;
        }
        return Xflag && Oflag;
    }
}
