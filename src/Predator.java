import java.io.Serializable;

public class Predator extends Creature {
    private int attackPower;

    public Predator(int x, int y, int hp, int speed, int attackPower) {
        super(x, y, hp, speed);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(GameMap map) {
        Herbivore target = map.findNearestHerbivore(x, y);
        if (target != null) {
            int dx = Integer.compare(target.getX(), x);
            int dy = Integer.compare(target.getY(), y);

            int newX = x + dx;
            int newY = y + dy;

            if (map.getEntityAt(newX, newY) instanceof Herbivore) {
                Herbivore victim = (Herbivore) map.getEntityAt(newX, newY);
                victim.takeDamage(attackPower);
                System.out.println("Хищник нападает на травоядное животное (" + newX + "," + newY + ")");
                if (!victim.isAlive()) {
                    map.removeEntity(victim);
                    System.out.println("Травоядное животное умерло в(" + newX + "," + newY + ")");
                }
            } else {
                map.moveEntity(this, newX, newY);
            }
        }
    }

    @Override
    public Serializable getSymbol() {
        return "\uD83D\uDC06";
    }
}

