import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {

    private Grid grid;
    private Player player;
    private Monster monster;
    private Timer monsterTimer;

    public Game() {

        setBackground(Color.BLACK);

        grid = new Grid();

        int playerRow = 0;
        int playerCol = 0;

        int monsterRow = 0;
        int monsterCol = 0;

        for (int r = 0; r < grid.getRows(); r++) {

            for (int c = 0; c < grid.getCols(); c++) {

                if (grid.getTile(r, c) == 'P') {
                    playerRow = r;
                    playerCol = c;
                }

                if (grid.getTile(r, c) == 'M') {
                    monsterRow = r;
                    monsterCol = c;
                }

            }

        }

        player = new Player(playerRow, playerCol);
        monster = new Monster(monsterRow, monsterCol);

        monsterTimer = new Timer(700, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                monster.moveTowards(player, grid);

                if (monster.getRow() == player.getRow()
                        && monster.getCol() == player.getCol()) {

                    player.loseHealth(monster.getDamage());

                    if (player.getHealth() <= 0) {

                        JOptionPane.showMessageDialog(null,
                                "Game Over!");

                        System.exit(0);

                    }

                }

                repaint();

            }

        });

        monsterTimer.start();

        setFocusable(true);
        addKeyListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));

        g.drawString("Health: " + player.getHealth(), 20, 30);
        g.drawString("Score: " + player.getScore(), 220, 30);
        g.drawString("Key: " + (player.hasKey() ? "Yes" : "No"), 420, 30);

        drawGrid(g);

    }

    private void drawGrid(Graphics g) {

        int size = 60;

        for (int row = 0; row < grid.getRows(); row++) {

            for (int col = 0; col < grid.getCols(); col++) {

                int x = 100 + col * size;
                int y = 80 + row * size;

                char tile = grid.getTile(row, col);

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

        char nextTile = grid.getTile(newRow, newCol);

        // Wall
        if (nextTile == '#') {
            return;
        }

        // Treasure
        if (nextTile == 'T') {
            player.addScore(100);
        }

        // Key
        if (nextTile == 'K') {
            player.pickUpKey();
        }

        // Exit
        if (nextTile == 'E') {

            if (player.hasKey()) {

                JOptionPane.showMessageDialog(this,
                        "Congratulations!\nYou escaped the dungeon!");

                System.exit(0);

            } else {

                JOptionPane.showMessageDialog(this,
                        "You need the key first!");

                return;
            }
        }

        grid.setTile(player.getRow(), player.getCol(), '.');

        player.setPosition(newRow, newCol);

        grid.setTile(newRow, newCol, 'P');

        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int row = player.getRow();
        int col = player.getCol();

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                movePlayer(row - 1, col);
                break;

            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                movePlayer(row + 1, col);
                break;

            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                movePlayer(row, col - 1);
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                movePlayer(row, col + 1);
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}