import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    public Game() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Dungeon Escape System", 180, 60);

        drawGrid(g);
    }

    private void drawGrid(Graphics g) {

        int size = 60;

        for (int row = 0; row < 10; row++) {

            for (int col = 0; col < 10; col++) {

                g.setColor(Color.GRAY);

                g.drawRect(100 + col * size,
                           100 + row * size,
                           size,
                           size);
            }

        }

    }

}