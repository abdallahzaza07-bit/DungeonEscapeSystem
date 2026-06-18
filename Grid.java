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