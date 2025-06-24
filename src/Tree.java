import java.io.Serializable;

public class Tree extends Entity {

    public Tree(int x, int y) {
        super(x, y);
    }

    @Override
    public Serializable getSymbol() {
        return "\uD83C\uDF33";
    }
}
