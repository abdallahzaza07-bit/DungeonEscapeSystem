import java.util.Random;

public class MazeGenerator {

    private Random random = new Random();

    public void generate(char[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return;
        generateMaze(dungeon, 1, 1);
    }

    private void generateMaze(char[][] dungeon, int row, int col) {
        if (row <= 0 || row >= dungeon.length - 1) return;
        if (col <= 0 || col >= dungeon[0].length - 1) return;
        // only process unvisited cells ('.')
        if (dungeon[row][col] != '.') return;

        // mark cell as visited: either wall '#' or floor ' ' to avoid revisiting
        if (random.nextInt(100) < 25) {
            dungeon[row][col] = '#';
        } else {
            dungeon[row][col] = ' ';
        }

        generateMaze(dungeon, row + 1, col);
        generateMaze(dungeon, row - 1, col);
        generateMaze(dungeon, row, col + 1);
        generateMaze(dungeon, row, col - 1);
    }

}

