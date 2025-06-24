
import java.util.*;

public class Simulation {
    private GameMap map;
    private int turnCounter = 0;
    private List<Action> initActions = new ArrayList<>();
    private List<Action> turnActions = new ArrayList<>();
    private boolean running = false;

    public Simulation(int width, int height) {
        this.map = new GameMap(width, height);
    }

    public void addInitAction(Action action) {
        initActions.add(action);
    }

    public void addTurnAction(Action action) {
        turnActions.add(action);
    }

    public void startSimulation() {
        System.out.println("🟢 симуляция начинается...");
        for (Action action : initActions) {
            action.execute(map);
        }

        running = true;
        while (running) {
            nextTurn();

            try {
                Thread.sleep(5000); // чтобы визуально наблюдать за происходящим
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextTurn() {
        turnCounter++;
        System.out.println("\n===== круг " + turnCounter + " =====");

        for (Action action : turnActions) {
            action.execute(map);
        }

        map.render();
    }



    public GameMap getMap() {
        return map;
    }
}
