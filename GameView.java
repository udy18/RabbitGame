import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameView extends JPanel {
    private final GameController controller;
    private static final String FONT_NAME = "Arial";

    public GameView() {
        controller = GameController.getInstance();
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        setupKeyListener();
    }

    private void setupKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                GameState gameState = controller.getGameState();
                if (gameState.isGameOver() || gameState.isVictory()) return;

                Player player = gameState.getPlayer();
                player.move(e.getKeyCode(), gameState);
                
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameState.setMonstersFrozen(true);
                    new Timer(2000, evt -> {
                        gameState.setMonstersFrozen(false);
                        ((Timer)evt.getSource()).stop();
                    }).start();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameState gameState = controller.getGameState();

        // Draw game info
        g.setColor(Color.WHITE);
        g.setFont(new Font(FONT_NAME, Font.BOLD, 16));
        g.drawString("Level: " + gameState.getLevel(), 10, 20);
        g.drawString("Rabbits left: " + gameState.getRabbits().size(), 10, 40);
        
        if (gameState.areMonstersFrozen()) {
            g.drawString("MONSTERS FROZEN", getWidth()/2 - 60, 20);
        }

        // Draw game entities
        gameState.getPlayer().draw(g);
        for (Rabbit rabbit : gameState.getRabbits()) rabbit.draw(g);
        for (Monster monster : gameState.getMonsters()) monster.draw(g);
        for (Wall wall : gameState.getWalls()) wall.draw(g);

        // Draw game over/victory message
        if (gameState.isGameOver() || gameState.isVictory()) {
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font(FONT_NAME, Font.BOLD, 36));
            String message = gameState.isVictory() ? "Victory!" : "Game Over!";
            FontMetrics fm = g.getFontMetrics();
            g.drawString(message, 
                (getWidth() - fm.stringWidth(message)) / 2,
                getHeight() / 2);
        }
    }
}
