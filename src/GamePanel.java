import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Snake snake = new Snake();
    private Timer snakeTimer;

    public GamePanel() {
        setBackground(Color.DARK_GRAY);
        snakeTimer = new Timer(200, this);
        snakeTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.update();
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
        drawGrid(g);
        snake.drawSnake(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i <= getWidth(); i += 25) {
            g.drawLine(i, getHeight(), i, 0);
        }

        for (int i = 0; i <= getHeight(); i += 25) {
            g.drawLine(getWidth(), i, 0, i);
        }
    }
}
