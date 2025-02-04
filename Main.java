import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Chasing Game");
            GameView gameView = new GameView();
            frame.add(gameView);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            GameThread gameThread = new GameThread(
                GameController.getInstance(), gameView);
            gameThread.start();
        });
    }
}