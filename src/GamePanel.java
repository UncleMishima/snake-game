import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

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
