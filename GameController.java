import java.util.Random;

public class GameController {
    private final GameState gameState;
    private static GameController instance;
    private static final int MAX_LEVEL = 5;

    private GameController() {
        gameState = new GameState(600, 600);
        initializeLevel();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void initializeLevel() {
        int level = gameState.getLevel();
        Random rand = new Random();

        gameState.setPlayer(new Player(50, 50));
        gameState.getRabbits().clear();
        gameState.getMonsters().clear();
        gameState.getWalls().clear();

        // Add rabbits based on level
        for (int i = 0; i < level + 2; i++) {
            gameState.getRabbits().add(new Rabbit(
                rand.nextInt(gameState.getWidth() - 40) + 20,
                rand.nextInt(gameState.getHeight() - 40) + 20
            ));
        }

        // Add monsters based on level
        for (int i = 0; i < level; i++) {
            gameState.getMonsters().add(new Monster(
                rand.nextInt(gameState.getWidth() - 40) + 20,
                rand.nextInt(gameState.getHeight() - 40) + 20,
                level
            ));
        }

        // Add walls based on level
        for (int i = 0; i < level; i++) {
            gameState.getWalls().add(new Wall(
                rand.nextInt(gameState.getWidth() - 100) + 50,
                rand.nextInt(gameState.getHeight() - 100) + 50,
                rand.nextBoolean()
            ));
        }
    }

    public void update() {
        if (gameState.isGameOver() || gameState.isVictory()) return;

        // Update all entities
        for (Monster monster : gameState.getMonsters()) {
            monster.move(gameState);
            if (CollisionDetector.checkCollision(gameState.getPlayer(), monster)) {
                gameState.setGameOver(true);
                return;
            }
        }

        gameState.getRabbits().removeIf(rabbit -> {
            rabbit.move(gameState);
            return CollisionDetector.checkCollision(gameState.getPlayer(), rabbit);
        });

        // Check level completion
        if (gameState.getRabbits().isEmpty()) {
            if (gameState.getLevel() < MAX_LEVEL) {
                gameState.setLevel(gameState.getLevel() + 1);
                initializeLevel();
            } else {
                gameState.setVictory(true);
            }
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}