public class Enemy {

    protected int row;
    protected int col;
    protected int damage;

    public Enemy(int row, int col, int damage) {
        this.row = row;
        this.col = col;
        this.damage = damage;
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

    public int getDamage() {
        return damage;
    }
}