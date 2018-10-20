import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int CELL_SIZE = 25;
    public static final int POINTS_PER_FRUIT = 50;
    private Snake snake;
    private Fruit fruit;
    private int gameScore;
    private Timer snakeTimer;
    private JLabel scoreLabel;

    public GamePanel() {
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        snake = new Snake();
        fruit = new Fruit();
        gameScore = 0;
        snakeTimer = new Timer(200, this);
        snakeTimer.start();
        addScoreLabel();
    }

    private void addScoreLabel() {
        scoreLabel = new JLabel("SCORE: " + String.valueOf(gameScore));
        add(scoreLabel);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font(scoreLabel.getName(), Font.PLAIN, 15));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.update();
        if (snake.checkSnakeEatFruit(fruit)) {
            gameScore += POINTS_PER_FRUIT;
            scoreLabel.setText("SCORE: " + String.valueOf(gameScore));
            fruit = new Fruit();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                snake.setSnakeDirection(SnakeDirection.UP);
                break;
            case KeyEvent.VK_S:
                snake.setSnakeDirection(SnakeDirection.DOWN);
                break;
            case KeyEvent.VK_A:
                snake.setSnakeDirection(SnakeDirection.LEFT);
                break;
            case KeyEvent.VK_D:
                snake.setSnakeDirection(SnakeDirection.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawGrid(g);
        fruit.drawFruit(g);
        snake.drawSnake(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i <= getWidth(); i += CELL_SIZE) {
            g.drawLine(i, getHeight(), i, 0);
        }

        for (int i = 0; i <= getHeight(); i += CELL_SIZE) {
            g.drawLine(getWidth(), i, 0, i);
        }
    }
}
