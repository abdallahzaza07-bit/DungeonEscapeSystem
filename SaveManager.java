import java.io.*;

public class SaveManager {

    public void save(Player player, Monster monster) {

        try {

            PrintWriter writer = new PrintWriter(new FileWriter("save.txt"));

            writer.println(player.getRow());
            writer.println(player.getCol());
            writer.println(player.getHealth());
            writer.println(player.getScore());
            writer.println(player.hasKey());

            writer.println(monster.getRow());
            writer.println(monster.getCol());

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void load(Player player, Monster monster) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("save.txt"));

            int playerRow = Integer.parseInt(reader.readLine());
            int playerCol = Integer.parseInt(reader.readLine());

            int health = Integer.parseInt(reader.readLine());
            int score = Integer.parseInt(reader.readLine());

            boolean hasKey = Boolean.parseBoolean(reader.readLine());

            int monsterRow = Integer.parseInt(reader.readLine());
            int monsterCol = Integer.parseInt(reader.readLine());

            player.setPosition(playerRow, playerCol);
            player.setHealth(health);
            player.setScore(score);
            player.setHasKey(hasKey);

            monster.setPosition(monsterRow, monsterCol);

            reader.close();

        } catch (IOException e) {

            System.out.println("No save file found.");

        }

    }

}