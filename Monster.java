public class Monster extends Enemy {

    public Monster(int row, int col) {
        super(row, col, 20);
    }

    public void moveTowards(Player player, Grid grid) {

        int newRow = row;
        int newCol = col;

        if (Math.abs(player.getRow() - row) >= Math.abs(player.getCol() - col)) {

            if (player.getRow() < row)
                newRow--;
            else if (player.getRow() > row)
                newRow++;

        } else {

            if (player.getCol() < col)
                newCol--;
            else if (player.getCol() > col)
                newCol++;

        }

        char tile = grid.getTile(newRow, newCol);

        if (tile == '.' || tile == 'P') {

            grid.setTile(row, col, '.');

            row = newRow;
            col = newCol;

            grid.setTile(row, col, 'M');
        }
    }
}