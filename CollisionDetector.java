public class CollisionDetector {
    public static boolean checkCollision(Entity a, Entity b) {
        return checkCollision(a.getX(), a.getY(), Entity.SIZE, Entity.SIZE,
                            b.getX(), b.getY(), Entity.SIZE, Entity.SIZE);
    }

    public static boolean checkCollision(int x1, int y1, int w1, int h1,
                                       int x2, int y2, int w2, int h2) {
        return x1 < x2 + w2 && x1 + w1 > x2 &&
               y1 < y2 + h2 && y1 + h1 > y2;
    }
}