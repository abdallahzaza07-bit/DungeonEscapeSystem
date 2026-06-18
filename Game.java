import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {

    private Grid grid;
    private Player player;

    public Game() {

        setBackground(Color.BLACK);

        grid = new Grid();

        char[][] dungeon = grid.getDungeon();

        int startRow = 0;
        int startCol = 0;

        // Find player in the grid
        for (int r = 0; r < dungeon.length; r++) {
            for (int c = 0; c < dungeon[r].length; c++) {

                if (dungeon[r][c] == 'P') {
                    startRow = r;
                    startCol = c;
                }

            }
        }

        player = new Player(startRow, startCol);

        setFocusable(true);
        addKeyListener(this);
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

        char[][] dungeon = grid.getDungeon();

        int size = 60;

        for (int row = 0; row < dungeon.length; row++) {

            for (int col = 0; col < dungeon[row].length; col++) {

                int x = 100 + col * size;
                int y = 100 + row * size;

                char tile = dungeon[row][col];

                switch (tile) {

                    case '#':
                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(x, y, size, size);
                        break;

                    case '.':
                        g.setColor(Color.LIGHT_GRAY);
                        g.fillRect(x, y, size, size);
                        break;

                    case 'P':
                        g.setColor(Color.BLUE);
                        g.fillOval(x + 10, y + 10, 40, 40);
                        break;

                    case 'M':
                        g.setColor(Color.RED);
                        g.fillOval(x + 10, y + 10, 40, 40);
                        break;

                    case 'K':
                        g.setColor(Color.YELLOW);
                        g.fillOval(x + 20, y + 20, 20, 20);
                        break;

                    case 'T':
                        g.setColor(Color.ORANGE);
                        g.fillRect(x + 20, y + 20, 20, 20);
                        break;

                    case 'E':
                        g.setColor(Color.GREEN);
                        g.fillRect(x + 10, y + 10, 40, 40);
                        break;
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, size, size);

            }
        }
    }

    private void movePlayer(int newRow, int newCol) {

        char[][] dungeon = grid.getDungeon();

        if (dungeon[newRow][newCol] == '#') {
            return;
        }

        dungeon[player.getRow()][player.getCol()] = '.';

        player.setPosition(newRow, newCol);

        dungeon[newRow][newCol] = 'P';

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int row = player.getRow();
        int col = player.getCol();

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                movePlayer(row - 1, col);
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                movePlayer(row + 1, col);
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                movePlayer(row, col - 1);
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                movePlayer(row, col + 1);
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}