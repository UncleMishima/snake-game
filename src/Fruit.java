import java.awt.*;

public class Fruit {
    private int fruitX, fruitY;
    private Color fruitColor;

    public Fruit() {
        fruitX = fruitY = 0;
        fruitColor = Color.YELLOW;
    }

    public Fruit(int fruitX, int fruitY, Color fruitColor) {
        this.fruitX = fruitX;
        this.fruitY = fruitY;
        this.fruitColor = fruitColor;
    }

    void drawFruit(Graphics g) {
        int cellSize = GamePanel.CELL_SIZE;
        g.setColor(fruitColor);
        g.fillRect(fruitX * cellSize, fruitY * cellSize, cellSize, cellSize);

        g.setColor(Color.BLACK);
        g.drawRect(fruitX * cellSize, fruitY * cellSize, cellSize, cellSize);
    }
}
