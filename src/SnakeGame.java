import javax.swing.*;

public class SnakeGame extends JFrame {

    private GamePanel gamePanel = new GamePanel();

    public SnakeGame() {
        setTitle("Snake");
        setSize(917, 915);
        setContentPane(gamePanel);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
