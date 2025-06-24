import java.io.Serializable;

public class Grass extends Entity {
    private boolean isConsumed = false;

    public Grass(int x, int y) {
        super(x, y);
    }

    public boolean isConsumed() {
        return isConsumed;
    }

    public void consume() {
        isConsumed = true;
    }

    @Override
    public Serializable getSymbol() {

        return isConsumed ? "." : "\uD83C\uDF3F";
    }
}

