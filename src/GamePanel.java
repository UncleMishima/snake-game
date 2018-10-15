import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
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
