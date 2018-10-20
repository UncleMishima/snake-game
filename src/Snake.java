import java.awt.*;
import java.util.ArrayList;

public class Snake {
    public static final int SNAKE_START_SIZE = 4;

    private ArrayList<Point> snake = new ArrayList<>();
    private Color snakeColor;
    private SnakeDirection snakeDirection;
    private SnakeDirection snakePreviousDirection;

    public Snake() {
        snakeColor = Color.GREEN;
        snakeDirection = SnakeDirection.UP;
        snakePreviousDirection = snakeDirection;

        initSnakeArray();
    }

    private void initSnakeArray() {
        for (int i = 0; i < SNAKE_START_SIZE; i++) {
            snake.add(new Point(10, i + 10));
        }
    }

    public void update() {
        snakeMove();
        snakeMoveBorders();
        checkSnakeCollision();
    }

    private void checkSnakeCollision() {
        Point snakeHead = snake.get(0);
        for (int i = snake.size() - 1; i > 0; i--) {
            if (snakeHead.x == snake.get(i).x && snakeHead.y == snake.get(i).y) {
                //game over
            }
        }
    }

    private void snakeMove() {
        Point firstPiece = snake.get(0);
        for (int i = snake.size() - 1; i >= 1; --i) {
            Point currentPiece = snake.get(i - 1);
            snake.get(i).x = currentPiece.x;
            snake.get(i).y = currentPiece.y;
        }

        if (snakePreviousDirection == SnakeDirection.UP && snakeDirection == SnakeDirection.DOWN ||
                snakePreviousDirection == SnakeDirection.DOWN && snakeDirection == SnakeDirection.UP ||
                snakePreviousDirection == SnakeDirection.RIGHT && snakeDirection == SnakeDirection.LEFT ||
                snakePreviousDirection == SnakeDirection.LEFT && snakeDirection == SnakeDirection.RIGHT) {
            snakeDirection = snakePreviousDirection;
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
        int cellSize = GamePanel.CELL_SIZE;
        g.setColor(snakeColor);
        for (int i = 0; i < snake.size(); i++) {
            int snakeX = snake.get(i).x;
            int snakeY = snake.get(i).y;
            g.fillRect(snakeX * cellSize, snakeY * cellSize, cellSize, cellSize);
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < snake.size(); i++) {
            int snakeX = snake.get(i).x;
            int snakeY = snake.get(i).y;
            g.drawRect(snakeX * cellSize, snakeY * cellSize, cellSize, cellSize);
        }
    }

    public void setSnakeDirection(SnakeDirection snakeDirection) {
        this.snakePreviousDirection = this.snakeDirection;
        this.snakeDirection = snakeDirection;
    }

    public ArrayList<Point> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Point> snake) {
        this.snake = snake;
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