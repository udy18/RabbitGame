import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends MovableEntity {
    public Player(int x, int y) {
        super(x, y, 10);
    }

    public void move(int keyCode, GameState gameState) {
        int newX = x;
        int newY = y;

        switch (keyCode) {
            case KeyEvent.VK_LEFT: newX -= speed; break;
            case KeyEvent.VK_RIGHT: newX += speed; break;
            case KeyEvent.VK_UP: newY -= speed; break;
            case KeyEvent.VK_DOWN: newY += speed; break;
        }

        if (isValidMove(newX, newY, gameState)) {
            x = newX;
            y = newY;
        }
    }

    private boolean isValidMove(int newX, int newY, GameState gameState) {
        if (newX < 0 || newX > gameState.getWidth() - SIZE || 
            newY < 0 || newY > gameState.getHeight() - SIZE) {
            return false;
        }

        for (Wall wall : gameState.getWalls()) {
            if (CollisionDetector.checkCollision(newX, newY, SIZE, SIZE,
                wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void move(GameState gameState) {
        // Implemented in move(keyCode, gameState)
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, SIZE, SIZE);
    }
}
