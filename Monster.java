import java.awt.*;

public class Monster extends MovableEntity {
    public Monster(int x, int y, int level) {
        super(x, y, level);
    }

    @Override
    public void move(GameState gameState) {
        if (gameState.areMonstersFrozen()) return;

        int newX = x;
        int newY = y;

        Player player = gameState.getPlayer();
        if (x < player.getX()) newX += speed;
        if (x > player.getX()) newX -= speed;
        if (y < player.getY()) newY += speed;
        if (y > player.getY()) newY -= speed;

        // Check collision with other monsters
        boolean collision = false;
        for (Monster other : gameState.getMonsters()) {
            if (other != this && CollisionDetector.checkCollision(newX, newY, SIZE, SIZE, 
                    other.getX(), other.getY(), SIZE, SIZE)) {
                collision = true;
                break;
            }
        }

        if (!collision) {
            x = Math.max(0, Math.min(newX, gameState.getWidth() - SIZE));
            y = Math.max(0, Math.min(newY, gameState.getHeight() - SIZE));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, SIZE, SIZE);
    }
}