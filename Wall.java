// Wall.java
import java.awt.*;

public class Wall extends Entity {
    private final boolean horizontal;
    private final int width;
    private final int height;

    public Wall(int x, int y, boolean horizontal) {
        super(x, y);
        this.horizontal = horizontal;
        this.width = horizontal ? 50 : 10;
        this.height = horizontal ? 10 : 50;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public boolean isHorizontal() { return horizontal; } // Added getter for horizontal

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
    }
}