public abstract class MovableEntity extends Entity {
    protected int speed;

    public MovableEntity(int x, int y, int speed) {
        super(x, y);
        this.speed = speed;
    }

    public abstract void move(GameState gameState);
}