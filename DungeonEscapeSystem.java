import javax.swing.*;

public class DungeonEscapeSystem {

    public static void main(String[] args) {

        JFrame window = new JFrame("Dungeon Escape System");

        Game game = new Game();

        window.add(game);

        window.setSize(800, 800);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}