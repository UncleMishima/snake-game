import java.awt.*;
import java.security.PrivateKey;
import java.util.ArrayList;

public class Snake {
    public static final int SNAKE_START_SIZE = 4;

    private ArrayList<Point> snake = new ArrayList<>();
    private Color snakeColor;
    private int snakeSize;
    private SnakeDirection snakeDirection;

    public Snake() {
        snakeColor = Color.GREEN;
        snakeSize = SNAKE_START_SIZE;
        snakeDirection = SnakeDirection.UP;

        initSnakeArray();
    }

    private void initSnakeArray() {
        for (int i = 0; i < snakeSize; i++) {
            snake.add(new Point(10, i + 10));
        }
    }

    public void update() {
        snakeMove();
        snakeMoveBorders();
    }

    private void snakeMove() {
        Point firstPiece = snake.get(0);

        for (int i = snakeSize - 1; i >= 1; --i) {
            Point currentPiece = new Point(snake.get(i - 1));
            snake.set(i, currentPiece);
        }

        switch (snakeDirection) {
            case UP:
                firstPiece.y--;
                break;
            case DOWN:
                firstPiece.y++;
                break;
            case LEFT:
                firstPiece.x--;
                break;
            case RIGHT:
                firstPiece.x++;
                break;
        }

        snake.set(0, firstPiece);
    }

    private void snakeMoveBorders() {
        int maxWidth = SnakeGame.WINDOW_WIDTH / GamePanel.CELL_SIZE;
        int maxHeight = SnakeGame.WINDOW_HEIGHT / GamePanel.CELL_SIZE;
        Point snakeHead = snake.get(0);

        if (snakeHead.y > maxHeight) {
            snakeHead.y = 0;
        } else if (snakeHead.y < 0) {
            snakeHead.y = maxHeight;
        }

        if (snakeHead.x > maxWidth) {
            snakeHead.x = 0;
        } else if (snakeHead.x < 0) {
            snakeHead.x = maxWidth;
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

    public void setSnakeDirection(SnakeDirection snakeDirection) {
        this.snakeDirection = snakeDirection;
    }
}

enum SnakeDirection {
    UP (0),
    DOWN (1),
    LEFT (2),
    RIGHT (3);

    public int snakeDirection;

    SnakeDirection(int snakeDirection) {
        this.snakeDirection = snakeDirection;
    }
}