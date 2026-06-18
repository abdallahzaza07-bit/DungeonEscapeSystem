public class Player {

    private int row;
    private int col;
    private int health;
    private int score;
    private boolean hasKey;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
        this.health = 100;
        this.score = 0;
        this.hasKey = false;
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

    public void loseHealth(int amount) {
        health -= amount;

        if (health < 0) {
            health = 0;
        }
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