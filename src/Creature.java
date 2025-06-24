import java.io.Serializable;

public abstract class Creature extends Entity {
    protected int hp;
    protected int speed;

    public Creature(int x, int y, int hp, int speed) {
        super(x, y);
        this.hp = hp;
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void makeMove(GameMap map);

    @Override
    public abstract Serializable getSymbol();
}
