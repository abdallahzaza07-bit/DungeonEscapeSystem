import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Pathfinder {

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public Point getNextMove(char[][] dungeon,
                             int monsterRow,
                             int monsterCol,
                             int playerRow,
                             int playerCol) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Point[][] parent = new Point[rows][cols];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(monsterRow, monsterCol));
        visited[monsterRow][monsterCol] = true;

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            if (current.x == playerRow && current.y == playerCol)
                break;

            for (int i = 0; i < 4; i++) {

                int nr = current.x + dr[i];
                int nc = current.y + dc[i];

                if (nr < 0 || nr >= rows)
                    continue;

                if (nc < 0 || nc >= cols)
                    continue;

                if (visited[nr][nc])
                    continue;

                if (dungeon[nr][nc] == '#')
                    continue;

                visited[nr][nc] = true;
                parent[nr][nc] = current;

                queue.add(new Point(nr, nc));
            }
        }

        Point step = new Point(playerRow, playerCol);

        if (parent[playerRow][playerCol] == null)
            return new Point(monsterRow, monsterCol);

        while (parent[step.x][step.y] != null &&
               !(parent[step.x][step.y].x == monsterRow &&
                 parent[step.x][step.y].y == monsterCol)) {

            step = parent[step.x][step.y];
        }

        return step;
    }
}