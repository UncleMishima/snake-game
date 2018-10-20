import java.awt.*;
import java.util.Random;

public class Fruit {
    private int fruitX, fruitY;
    private Color fruitColor;

    public Fruit() {
        this(0, 0, Color.YELLOW);
    }

    public Fruit(int fruitX, int fruitY, Color fruitColor) {
        this.fruitX = fruitX;
        this.fruitY = fruitY;
        this.fruitColor = fruitColor;
        generateFruitPosition();
    }

    public void generateFruitPosition() {
        Random random = new Random();
        int windowWidth = SnakeGame.WINDOW_WIDTH;
        int windowHeight = SnakeGame.WINDOW_HEIGHT;
        int cellSize = GamePanel.CELL_SIZE;
        fruitX = random.nextInt((windowWidth / cellSize) - 1);
        fruitY = random.nextInt((windowHeight / cellSize) - 1);
    }

    void drawFruit(Graphics g) {
        int cellSize = GamePanel.CELL_SIZE;
        g.setColor(fruitColor);
        g.fillRect(fruitX * cellSize, fruitY * cellSize, cellSize, cellSize);

        g.setColor(Color.BLACK);
        g.drawRect(fruitX * cellSize, fruitY * cellSize, cellSize, cellSize);
    }

    public int getFruitX() {
        return fruitX;
    }

    public int getFruitY() {
        return fruitY;
    }
}
