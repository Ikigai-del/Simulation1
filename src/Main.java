public class  Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation(20, 10);

        sim.addInitAction(new InitAction_PopulateWorld(20, 5, 3, 5, 3));
        sim.addTurnAction(new TurnAction_MakeMoves());

        sim.startSimulation();
    }
}
