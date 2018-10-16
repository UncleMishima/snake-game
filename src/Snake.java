import java.awt.*;
import java.util.ArrayList;

public class Snake {
    public static final int SNAKE_START_SIZE = 4;

    private ArrayList<Point> snake = new ArrayList<>();
    private Color snakeColor;
    private int snakeSize = SNAKE_START_SIZE;

    public Snake() {
        initSnakeArray();
        snakeColor = Color.GREEN;
    }

    private void initSnakeArray() {
        for (int i = 0; i < snakeSize; i++) {
            snake.add(new Point(0, i));
        }
    }

    public void drawSnake(Graphics g) {
        g.setColor(snakeColor);
        for (int i = 0; i < snakeSize; i++) {
            int snakeX = snake.get(i).x;
            int snakeY = snake.get(i).y;
            g.fillRect(snakeX * 25, snakeY * 25, 25, 25);
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < snakeSize; i++) {
            int snakeX = snake.get(i).x;
            int snakeY = snake.get(i).y;
            g.drawRect(snakeX * 25, snakeY * 25, 25, 25);
        }
    }
}
