import javax.swing.*;

public class Game {
    static boolean checkWin(char player) {
        // check rows
        for (int row = 0; row < 3; row++) {
            if (TTTBoard.board[row][0] == player && TTTBoard.board[row][1] == player && TTTBoard.board[row][2] == player) {
                return true;
            }
        }

        // check columns
        for (int col = 0; col < 3; col++) {
            if (TTTBoard.board[0][col] == player && TTTBoard.board[1][col] == player && TTTBoard.board[2][col] == player) {
                return true;
            }
        }

        // check diagonals
        if (TTTBoard.board[0][0] == player && TTTBoard.board[1][1] == player && TTTBoard.board[2][2] == player) {
            return true;
        }
        if (TTTBoard.board[0][2] == player && TTTBoard.board[1][1] == player && TTTBoard.board[2][0] == player) {
            return true;
        }

        // no winner
        return false;
    }


    // check for a tie


    static boolean checkTie() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (TTTBoard.board[row][col] == '\u0000') { //if == null (\u0000)
                    // there is an empty square, game is not over
                    return false;
                }
            }
        }
        // all squares are filled and no winner, it's a tie
        return true;
    }

    static void playAgain() {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // reset board
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    TTTBoard.board[row][col] = '\u0000';
                    TTTBoard.buttons[row][col].setText("");
                    TTTBoard.buttons[row][col].setEnabled(true);
                }
            }
            TTTBoard.currentPlayer = 'X';
            TTTBoard.gameOver = false;
        } else {
            System.exit(0);
        }
    }

}
