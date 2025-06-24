import java.io.Serializable;

public class Rock extends Entity {

    public Rock(int x, int y) {
        super(x, y);
    }

    @Override
    public Serializable getSymbol() {
        return "\uD83E\uDDF1";
    }
}
