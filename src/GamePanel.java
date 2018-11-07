import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The GamePanel class represents a game map for the snake game.
 * It implements ActionListener and KeyListener interfaces.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    /**
     * Cell size constant value.
     */
    public static final int CELL_SIZE = 25;

    /**
     * After eating a fruit by snake the game score increases on this constant value.
     */
    public static final int POINTS_PER_FRUIT = 50;

    /**
     * The Snake.
     */
    private Snake snake;

    /**
     * The Fruit.
     */
    private Fruit fruit;

    /**
     * Game score.
     */
    private int gameScore;

    /**
     * Set snake move speed.
     */
    private Timer snakeTimer;

    /**
     * The score label.
     */
    private JLabel scoreLabel;

    /**
     * Initializes fields and set GamePanel components.
     */
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

    /**
     * Adds the score label on the game panel.
     */
    private void addScoreLabel() {
        scoreLabel = new JLabel("SCORE: " + String.valueOf(gameScore));
        add(scoreLabel);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font(scoreLabel.getName(), Font.PLAIN, 15));
    }

    /**
     * Updates every move on the game panel.
     * @param e is ActionEvent parameter
     */
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

    /**
     * Changes snake direction depending on pressed key.
     * @param e KeyEvent parameter
     */
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

    /**
     * Unused. Declares because of KeyListener interface.
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Unused. Declares because of KeyListener interface.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Overrides JPanel paintComponent function for
     * changing background and drawing snake and fruit.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawGrid(g);
        fruit.drawFruit(g);
        snake.drawSnake(g);
    }

    /**
     * Draw a grid on the game panel.
     */
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
