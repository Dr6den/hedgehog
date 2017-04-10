package hedge.entity;

/**
 *
 * @author andrew
 */
public class AppleTreeCoordinates {
    private int numberOfApples;
    private int x;
    private int y;

    public AppleTreeCoordinates(int numberOfApples, int x, int y) {
        this.numberOfApples = numberOfApples;
        this.x = x;
        this.y = y;
    }

    public int getNumberOfApples() {
        return numberOfApples;
    }

    public void setNumberOfApples(int numberOfApples) {
        this.numberOfApples = numberOfApples;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }   
    
}
