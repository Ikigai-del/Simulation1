import java.io.Serializable;

public class Herbivore extends Creature {

    public Herbivore(int x, int y, int hp, int speed) {
        super(x, y, hp, speed);
    }

    @Override
    public void makeMove(GameMap map) {
        Grass nearestGrass = map.findNearestGrass(x, y);
        if (nearestGrass != null) {
            int dx = Integer.compare(nearestGrass.getX(), x);
            int dy = Integer.compare(nearestGrass.getY(), y);

            int newX = x + dx;
            int newY = y + dy;

            // если пришёл на траву — ест
            if (map.getEntityAt(newX, newY) instanceof Grass) {
                ((Grass) map.getEntityAt(newX, newY)).consume();
                System.out.println("Травоядное животное ело траву (" + newX + "," + newY + ")");
            } else {
                map.moveEntity(this, newX, newY);
            }
        }
    }

    @Override
    public Serializable getSymbol() {
        return "\uD83D\uDC04";
    }
}
