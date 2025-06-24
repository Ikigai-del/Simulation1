import java.util.List;

public class TurnAction_MakeMoves implements Action {
    @Override
    public void execute(GameMap map) {
        List<Entity> entities = map.getAllEntities();
        for (Entity e : entities) {
            if (e instanceof Creature creature && creature.isAlive()) {
                creature.makeMove(map);
            }
        }
    }
}
