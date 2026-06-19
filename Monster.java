public class Monster extends Enemy {

    public Monster(int row, int col) {
        super(row, col, 20);
    }

    public void moveTowards(Player player, Grid grid) {

        int nextRow = row;
        int nextCol = col;

        if (Math.abs(player.getRow() - row) >
                Math.abs(player.getCol() - col)) {

            if (player.getRow() < row)
                nextRow--;
            else if (player.getRow() > row)
                nextRow++;

        } else {

            if (player.getCol() < col)
                nextCol--;
            else if (player.getCol() > col)
                nextCol++;

        }

        if (grid.getTile(nextRow, nextCol) == '.'
                || grid.getTile(nextRow, nextCol) == 'P') {

            grid.setTile(row, col, '.');

            row = nextRow;
            col = nextCol;

            grid.setTile(row, col, 'M');
        }

    }
}