import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * The Snake class describes a snake.
 *
 * @author Mikhail Sedov
 */
public class Snake {
    /**
     * Constant value of the snake start size.
     */
    public static final int SNAKE_START_SIZE = 4;

    /**
     * Snake array. Every piece of snake is a Point.
     */
    private ArrayList<Point> snake;

    /**
     * Snake color.
     */
    private Color snakeColor;

    /**
     * Snake main direction.
     */
    private SnakeDirection snakeDirection;

    /**
     * Snake previous direction for calculation new (main) direction.
     */
    private SnakeDirection snakePreviousDirection;

    /**
     * Initializing fields and invokes initSnakeArray function.
     */
    public Snake() {
        snakeColor = Color.GREEN;
        snakeDirection = SnakeDirection.UP;
        snakePreviousDirection = snakeDirection;
        initSnakeArray();
    }

    /**
     * Updates snake movements and actions.
     */
    public void update() {
        snakeMove();
        snakeMoveBorders();
        checkSnakeCollision();
    }

    /**
     * Checks snake eating a fruit.
     *
     * @param fruit is a point which snake need to eat
     * @return true if snake ate a fruit and
     * return false if not
     */
    public boolean checkSnakeEatFruit(Fruit fruit) {
        int fruitX = fruit.getFruitX();
        int fruitY = fruit.getFruitY();
        Point snakeHead = snake.get(0);

        if (snakeHead.x == fruitX && snakeHead.y == fruitY) {
            Point addNewPoint = new Point(snake.get(snake.size() - 1));
            snake.add(addNewPoint);
            return true;
        }

        return false;
    }

    /**
     * Initializes snake array.
     */
    private void initSnakeArray() {
        snake = new ArrayList<>();
        for (int i = 0; i < SNAKE_START_SIZE; i++) {
            Point newPoint = new Point(10, i + 10);
            snake.add(newPoint);
        }
    }

    /**
     * Checks snake collisions with its tail.
     */
    private void checkSnakeCollision() {
        Point snakeHead = snake.get(0);
        for (int i = 1; i < snake.size(); i++) {
            if (snakeHead.x == snake.get(i).x && snakeHead.y == snake.get(i).y) {
                initSnakeArray();
            }
        }
    }

    /**
     * Describes snake move.
     */
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

    /**
     * Sets snake move borders.
     */
    private void snakeMoveBorders() {
        int maxWidth = GameWindow.WINDOW_WIDTH / GamePanel.CELL_SIZE;
        int maxHeight = GameWindow.WINDOW_HEIGHT / GamePanel.CELL_SIZE;
        Point snakeHead = snake.get(0);

        if (snakeHead.y == maxHeight) {
            snakeHead.y = 0;
        } else if (snakeHead.y < 0) {
            snakeHead.y = maxHeight;
        }

        if (snakeHead.x == maxWidth) {
            snakeHead.x = 0;
        } else if (snakeHead.x < 0) {
            snakeHead.x = maxWidth;
        }
    }

    /**
     * Draws a snake.
     */
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

    /**
     * Setter for snakeDirection.
     *
     * @param snakeDirection is a new direction for snake
     */
    public void setSnakeDirection(SnakeDirection snakeDirection) {
        this.snakePreviousDirection = this.snakeDirection;
        this.snakeDirection = snakeDirection;
    }
}

/**
 * SnakeDirection is enumeration which
 * describes snake direction.
 */
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