public class GameThread extends Thread {
    private final GameController controller;
    private final GameView view;
    private volatile boolean running;
    private static final long FRAME_TIME = 50;

    public GameThread(GameController controller, GameView view) {
        this.controller = controller;
        this.view = view;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            controller.update();
            view.repaint();
            
            try {
                Thread.sleep(FRAME_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopGame() {
        running = false;
    }
}
