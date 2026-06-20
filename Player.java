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

    public void loseHealth(int damage) {

        health -= damage;

        if (health < 0)
            health = 0;

    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {

        score += points;

    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void pickUpKey() {

        hasKey = true;

    }

    public void setHasKey(boolean hasKey) {

        this.hasKey = hasKey;

    }

}