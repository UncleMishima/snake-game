import javax.swing.*;

public class SnakeGame extends JFrame {
    public static final int WINDOW_WIDTH = GamePanel.CELL_SIZE * 36 + 17;
    public static final int WINDOW_HEIGHT = GamePanel.CELL_SIZE * 36 + 15;

    private GamePanel gamePanel = new GamePanel();

    public SnakeGame() {
        setTitle("Snake");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setContentPane(gamePanel);
        addKeyListener(gamePanel);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
