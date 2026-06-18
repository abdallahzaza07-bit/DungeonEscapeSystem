public class Player {

    private int row;
    private int col;
    private int health;
    private int score;
    private boolean hasKey;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
        health = 100;
        score = 0;
        hasKey = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void pickUpKey() {
        hasKey = true;
    }
}