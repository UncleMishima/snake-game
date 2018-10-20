import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int CELL_SIZE = 25;
    private Snake snake;
    private Fruit fruit;
    private Timer snakeTimer;

    public GamePanel() {
        setBackground(Color.DARK_GRAY);
        snake = new Snake();
        fruit = new Fruit();
        snakeTimer = new Timer(200, this);
        snakeTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.update();
        if (snake.checkSnakeEatFruit(fruit)) {
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
