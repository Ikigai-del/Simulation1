import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GameMap {
    private int width;
    private int height;
    private HashMap<Point, Entity> entities = new HashMap<>();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Entity getEntityAt(int x, int y) {
        return entities.get(new Point(x, y));
    }

    public void addEntity(Entity entity) {
        entities.put(new Point(entity.getX(), entity.getY()), entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(new Point(entity.getX(), entity.getY()));
    }

    public void moveEntity(Entity entity, int newX, int newY) {
        Point oldPos = new Point(entity.getX(), entity.getY());
        Point newPos = new Point(newX, newY);
        if (!isOccupied(newX, newY)) {
            entities.remove(oldPos);
            entity.setPosition(newX, newY);
            entities.put(newPos, entity);
        }
    }

    public boolean isOccupied(int x, int y) {
        return entities.containsKey(new Point(x, y));
    }

    public List<Entity> getAllEntities() {
        return new ArrayList<>(entities.values());
    }

    public Grass findNearestGrass(int x, int y) {
        return (Grass) entities.values().stream()
                .filter(e -> e instanceof Grass && !((Grass) e).isConsumed())
                .min(Comparator.comparingInt(e -> distance(e.getX(), e.getY(), x, y)))
                .orElse(null);
    }

    public Herbivore findNearestHerbivore(int x, int y) {
        return (Herbivore) entities.values().stream()
                .filter(e -> e instanceof Herbivore)
                .min(Comparator.comparingInt(e -> distance(e.getX(), e.getY(), x, y)))
                .orElse(null);
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Entity e = getEntityAt(x, y);
                System.out.print(e != null ? e.getSymbol() : '.');
            }
            System.out.println();
        }
    }
}
