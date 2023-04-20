import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions {
    // inner class for the quit button listener
    static class QuitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // inner class for the button listener
    static class ButtonListener implements ActionListener {
        private int row;
        private int col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (!TTTBoard.gameOver) {
                if (TTTBoard.board[row][col] == '\u0000') {
                    // set the square to the current player
                    TTTBoard.board[row][col] = TTTBoard.currentPlayer;
                    TTTBoard.buttons[row][col].setText(Character.toString(TTTBoard.currentPlayer));

                    // check for a win or a tie
                    if (Game.checkWin(TTTBoard.currentPlayer)) {
                        JOptionPane.showMessageDialog(null, "Player " + TTTBoard.currentPlayer + " wins!");
                        TTTBoard.gameOver = true;
                        Game.playAgain();

                    } else if (Game.checkTie()) {
                        JOptionPane.showMessageDialog(null, "Tie game!");
                        TTTBoard.gameOver = true;
                        Game.playAgain();
                    } else {
                        // switch to the other player
                        TTTBoard.currentPlayer = TTTBoard.currentPlayer == 'X' ? 'O' : 'X';
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Square already taken.");
                }
            }
        }
    }
}
