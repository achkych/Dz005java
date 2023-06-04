import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;

public class QueensProblem {

    private int[] board = new int[8];
    private int counter = 1;

    public void solve() {
        placeQueen(0);
    }

    private boolean canPlaceQueen(int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i] == column || 
                board[i] - i == column - row ||
                board[i] + i == column + row) {
                return false;
            }
        }
        return true;
    }

    private void placeQueen(int row) {
        if (row == 8) {
            System.out.println("Solution #" + counter++);
            printBoard();
        } else {
            for (int i = 0; i < 8; i++) {
                if (canPlaceQueen(row, i)) {
                    board[row] = i;
                    placeQueen(row + 1);
                }
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueensProblem problem = new QueensProblem();
        problem.solve();
    }
}
