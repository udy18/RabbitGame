import java.util.ArrayList;
import java.util.List;

public class GameState {
    private Player player;
    private List<Rabbit> rabbits;
    private List<Monster> monsters;
    private List<Wall> walls;
    private int width;
    private int height;
    private int level;
    private boolean monstersFrozen;
    private boolean gameOver;
    private boolean victory;

    public GameState(int width, int height) {
        this.width = width;
        this.height = height;
        this.level = 1;
        this.monstersFrozen = false;
        this.gameOver = false;
        this.victory = false;
        this.rabbits = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public List<Rabbit> getRabbits() { return rabbits; }
    public List<Monster> getMonsters() { return monsters; }
    public List<Wall> getWalls() { return walls; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getLevel() { return level; }
    public boolean areMonstersFrozen() { return monstersFrozen; }
    public void setMonstersFrozen(boolean frozen) { this.monstersFrozen = frozen; }
    public void setLevel(int level) { this.level = level; }
    public boolean isGameOver() { return gameOver; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }
    public boolean isVictory() { return victory; }
    public void setVictory(boolean victory) { this.victory = victory; }
}