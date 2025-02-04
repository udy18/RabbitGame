import java.awt.Graphics;
import java.io.Serializable;

public abstract class Entity implements Drawable, Serializable {
    protected int x;
    protected int y;
    protected static final int SIZE = 20;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override
    public abstract void draw(Graphics g);
}