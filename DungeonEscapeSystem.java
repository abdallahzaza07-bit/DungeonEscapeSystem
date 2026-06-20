import javax.swing.*;

public class DungeonEscapeSystem {

    public static void main(String[] args) {

        String choice = JOptionPane.showInputDialog(
                null,
                "Choose Difficulty:\nEasy\nMedium\nHard");

        if (choice != null) {

            if (choice.equalsIgnoreCase("Easy")) {
                Difficulty.setSpeed(1000);
            }

            else if (choice.equalsIgnoreCase("Hard")) {
                Difficulty.setSpeed(400);
            }

            else {
                Difficulty.setSpeed(700);
            }
        }
JOptionPane.showMessageDialog(
        null,
        "DUNGEON ESCAPE SYSTEM\n\n"
        + "Goal:\n"
        + "- Find the key.\n"
        + "- Reach the green exit.\n"
        + "- Avoid the monster.\n"
        + "- Collect treasure for points.\n\n"
        + "Controls:\n"
        + "WASD or Arrow Keys\n\n"
        + "Good luck!"
);
        JFrame window = new JFrame("Dungeon Escape System");

        Game game = new Game();

        window.add(game);

        window.setSize(800, 800);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.setVisible(true);

        game.requestFocusInWindow();
    }
}