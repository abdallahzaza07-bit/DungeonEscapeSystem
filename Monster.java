import java.awt.Point;

public class Monster extends Enemy {

    private Pathfinder pathfinder;

    public Monster(int row, int col) {

        super(row, col, 20);

        pathfinder = new Pathfinder();

    }

    public void moveTowards(Player player, Grid grid) {

        Point next = pathfinder.getNextMove(
                grid.getDungeon(),
                row,
                col,
                player.getRow(),
                player.getCol());

        if (next.x == row && next.y == col)
            return;

        char tile = grid.getTile(next.x, next.y);

        if (tile == '.' || tile == 'P') {

            grid.setTile(row, col, '.');

            row = next.x;
            col = next.y;

            grid.setTile(row, col, 'M');

        }

    }

}