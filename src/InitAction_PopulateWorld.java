import java.util.Random;
import java.util.function.Supplier;

public class InitAction_PopulateWorld implements Action {
    private int grassCount;
    private int rockCount;
    private int treeCount;
    private int herbivoreCount;
    private int predatorCount;

    public InitAction_PopulateWorld(int grass, int rock, int tree, int herbivores, int predators) {
        this.grassCount = grass;
        this.rockCount = rock;
        this.treeCount = tree;
        this.herbivoreCount = herbivores;
        this.predatorCount = predators;
    }

    @Override
    public void execute(GameMap map) {
        Random random = new Random();

        placeEntities(map, grassCount, () -> new Grass(10,10));
        placeEntities(map, rockCount, () -> new Rock(10,10));
        placeEntities(map, treeCount, () -> new Tree(10,10));
        placeEntities(map, herbivoreCount, () -> new Herbivore(5,5,10,1));
        placeEntities(map, predatorCount, () -> new Predator(5,5, 15, 1 ,5));
    }

    private void placeEntities(GameMap map, int count, Supplier<Entity> supplier) {
        Random random = new Random();
        int width = 10; // или map.getWidth()
        int height = 10;

        for (int i = 0; i < count; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(height);
            } while (map.isOccupied(x, y));
            Entity e = supplier.get();
            e.setPosition(x, y);
            map.addEntity(e);
        }
    }
}
