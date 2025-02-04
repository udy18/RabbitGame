import java.awt.*;
import java.util.Random;

public class Rabbit extends MovableEntity {
    private int counter;
    private static final int STEP_LIMIT = 15;
    private static final Random rand = new Random();
    private static final char RABBIT_ICON = '@';

    public Rabbit(int x, int y) {
        super(x, y, 5);
        this.counter = 0;
    }

    private boolean isPositionOccupied(int newX, int newY, GameState gameState) {
        // Simplified collision detection matching C version
        for (Rabbit other : gameState.getRabbits()) {
            if (other != this && other.getX() == newX && other.getY() == newY) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(GameState gameState) {
        Player player = gameState.getPlayer();
        
        // Check if rabbit caught the player
        if (x == player.getX() && y == player.getY()) {
            gameState.setGameOver(true);  // Assuming you have this method
            return;
        }

        // Only move after counter reaches step limit
        if (counter < STEP_LIMIT) {
            counter++;
            return;
        }

        counter = 0;
        
        // Move away from player one step at a time
        if (x < player.getX()) x--;  // Run left if player is to the right
        else if (x > player.getX()) x++;  // Run right if player is to the left
        
        if (y < player.getY()) y--;  // Run up if player is below
        else if (y > player.getY()) y++;  // Run down if player is above

        // Handle boundary conditions
        if (x <= 0 || x >= gameState.getWidth() - SIZE) {
            x = rand.nextInt(gameState.getWidth() - SIZE);
        }
        if (y <= 0 || y >= gameState.getHeight() - SIZE) {
            y = rand.nextInt(gameState.getHeight() - SIZE);
        }

        // No need to explicitly update display position as in C version
        // The game loop will handle rendering
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        // Using the same square representation but could be modified to use text
        g.fillRect(x, y, SIZE, SIZE);
    }
}