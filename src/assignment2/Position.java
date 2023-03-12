package assignment2;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void reset(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    public float getDistance(Position p) {
        return (Math.abs((this.x - p.x) + Math.abs(this.y - p.y)));
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public void moveWest() {
        if (this.x - 1 >= 0) {
            this.x --;
        }
    }

    public void moveEast() {
        if (this.x + 1 <= Math.pow(2,31) - 1) {
            this.x ++;
        }
    }

    public void moveNorth() {
        if (this.y - 1 >= 0) {
            this.y --;
        }
    }

    public void moveSouth() {
        if (this.y - 1 <= Math.pow(2,31) - 1) {
            this.y ++;
        }
    }

    public  boolean equals(Object o) {

    }
}