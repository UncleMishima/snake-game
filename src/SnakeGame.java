import javax.swing.*;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        setTitle("Snake");
        setSize(900, 900);

        this.setResizable(false);
        this.setVisible(true);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
