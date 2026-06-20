public class Grid {

    private char[][] dungeon = {

        {'#','#','#','#','#','#','#','#','#','#'},
        {'#','P','.','.','.','.','.','.','K','#'},
        {'#','.','#','#','.','.','#','.','.','#'},
        {'#','.','.','.','.','.','.','.','.','#'},
        {'#','.','.','M','.','.','.','.','.','#'},
        {'#','.','.','.','.','.','T','.','.','#'},
        {'#','.','#','#','#','.','.','.','.','#'},
        {'#','.','.','.','.','.','.','.','E','#'},
        {'#','.','.','.','.','.','.','.','.','#'},
        {'#','#','#','#','#','#','#','#','#','#'}

    };

    public Grid() {

        MazeGenerator maze = new MazeGenerator();

        maze.generate(dungeon);

        dungeon[1][1] = 'P';
        dungeon[4][3] = 'M';
        dungeon[1][8] = 'K';
        dungeon[5][6] = 'T';
        dungeon[7][8] = 'E';

    }

    public char[][] getDungeon() {
        return dungeon;
    }

    public char getTile(int row, int col) {
        return dungeon[row][col];
    }

    public void setTile(int row, int col, char value) {
        dungeon[row][col] = value;
    }

    public int getRows() {
        return dungeon.length;
    }

    public int getCols() {
        return dungeon[0].length;
    }

}