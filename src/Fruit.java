import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * The Fruit class describes the special food
 * for a snake.
 *
 * @author Mikhail Sedov
 */
public class Fruit {
    /**
     * Fruit x and y coordinates.
     */
    private int fruitX, fruitY;

    /**
     * Fruit color.
     */
    private Color fruitColor;

    /**
     * Initializes fields by invoking the Fruit constructor with arguments.
     */
    public Fruit() {
        this(0, 0, Color.YELLOW);
    }

    /**
     * Initializes fields.
     *
     * @param fruitX new x fruit coordinate
     * @param fruitY new y fruit coordinate
     * @param fruitColor new fruit color
     */
    public Fruit(int fruitX, int fruitY, Color fruitColor) {
        this.fruitX = fruitX;
        this.fruitY = fruitY;
        this.fruitColor = fruitColor;
        generateFruitPosition();
    }

    /**
     * Generates a new fruit on the random point
     * on the game panel.
     */
    public void generateFruitPosition() {
        Random random = new Random();
        int windowWidth = GameWindow.WINDOW_WIDTH;
        int windowHeight = GameWindow.WINDOW_HEIGHT;
        int cellSize = GamePanel.CELL_SIZE;
        fruitX = random.nextInt((windowWidth / cellSize) - 1);
        fruitY = random.nextInt((windowHeight / cellSize) - 1);
    }

    /**
     * Draws a fruit.
     */
    void drawFruit(Graphics g) {
        int cellSize = GamePanel.CELL_SIZE;
        g.setColor(fruitColor);
        g.fillRect(fruitX * cellSize, fruitY * cellSize, cellSize, cellSize);

        g.setColor(Color.BLACK);
        g.drawRect(fruitX * cellSize, fruitY * cellSize, cellSize, cellSize);
    }

    /**
     * Getter for fruit x coordinate.
     * @return current fruit x coordinate
     */
    public int getFruitX() {
        return fruitX;
    }

    /**
     * Getter for fruit y coordinate.
     * @return current fruit y coordinate
     */
    public int getFruitY() {
        return fruitY;
    }
}
