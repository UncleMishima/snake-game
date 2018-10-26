import javax.swing.*;

/**
 * The <code>GameWindow</code> class represents a
 * window for snake game.
 *
 * @author Mikhail Sedov
 */

public class GameWindow extends JFrame {
    /**
     * The constant width value for snake game window.
     */
    public static final int WINDOW_WIDTH = GamePanel.CELL_SIZE * 36 + 17;

    /**
     * The constant height value for snake game window.
     */
    public static final int WINDOW_HEIGHT = GamePanel.CELL_SIZE * 36 + 15;

    /**
     * Main panel of the snake game.
     */
    private GamePanel gamePanel;

    /**
     * Initializing gamePanel field and set
     * other values of the snake game window
     */
    public GameWindow() {
        gamePanel = new GamePanel();

        setTitle("Snake");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setContentPane(gamePanel);
        addKeyListener(gamePanel);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates <code>GameWindow</> object and runs the snake game application.
     * @param args
     */
    public static void main(String[] args) {
        new GameWindow();
    }
}
