import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Pathfinder {

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public Point getNextMove(char[][] dungeon,
                             int monsterRow,
                             int monsterCol,
                             int playerRow,
                             int playerCol) {

        boolean[][] visited = new boolean[dungeon.length][dungeon[0].length];

        Point[][] parent = new Point[dungeon.length][dungeon[0].length];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(monsterRow, monsterCol));
        visited[monsterRow][monsterCol] = true;

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            if (current.x == playerRow && current.y == playerCol) {
                break;
            }

            for (int i = 0; i < 4; i++) {

                int nr = current.x + dr[i];
                int nc = current.y + dc[i];

                if (nr < 0 || nr >= dungeon.length) continue;
                if (nc < 0 || nc >= dungeon[0].length) continue;

                if (visited[nr][nc]) continue;

                if (dungeon[nr][nc] == '#') continue;

                visited[nr][nc] = true;
                parent[nr][nc] = current;

                queue.add(new Point(nr, nc));
            }
        }

        Point step = new Point(playerRow, playerCol);

        while (parent[step.x][step.y] != null &&
               !(parent[step.x][step.y].x == monsterRow &&
                 parent[step.x][step.y].y == monsterCol)) {

            step = parent[step.x][step.y];
        }

        return step;
    }

}