import javax.swing.*;
import java.awt.*;

public class TTTBoard  extends JFrame
{
    static JButton[][] buttons; // 2D array of buttons
    static JButton quitButton;
    static char[][] board; // game board
    static char currentPlayer; // current player (X or O)
    static boolean gameOver; // game over flag

    public TTTBoard() {
        // initialize the game
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;

        // set up the JFrame
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        // create an array of buttons for the squares
        buttons = new JButton[3][3];

        // create and add the buttons to the panel
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 80));
                buttons[row][col].addActionListener(new Actions.ButtonListener(row, col));
                buttonPanel.add(buttons[row][col]);
            }
        }

        // create and add the quit button to the JFrame
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new Actions.QuitListener());
        add(quitButton, BorderLayout.SOUTH);

        // add the button panel to the JFrame
        add(buttonPanel, BorderLayout.CENTER);

        // set the size and make the JFrame visible
        setSize(800, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        TTTBoard frame = new TTTBoard();
        frame.setVisible(true);
    }
}
