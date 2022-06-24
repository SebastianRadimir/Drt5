package hwr.oop;
import java.util.Random;

public class Darts {

    private final int maxPoints;
    private final int throwsPerRound;
    private final Player[] players;
    private int currentPlayerIndex;
    private final int boardSize = 60;
    private final Dartboard dartboard;

    public Darts(int playerAmount, int maxPoints, int throwsPerRound){

        dartboard = new Dartboard(boardSize);


        if (playerAmount<=1 || maxPoints<=0 || throwsPerRound<=0){
            StringBuilder sb = new StringBuilder();
            if (playerAmount<=1) {
                sb.append("\n - 'playerAmount' cannot be less than 2.");
            }
            if (maxPoints<=0){
                sb.append("\n - 'maxPoints' is not allowed to be under 1 point.");
            }
            if (throwsPerRound<=0){
                sb.append("\n - 'throwsPerRound' is not allowed to be under 1.");
            }
            throw new IllegalArgumentException(sb.toString());
        }

        currentPlayerIndex = 0;
        this.throwsPerRound = throwsPerRound;
        this.maxPoints = maxPoints;
        players = new Player[playerAmount];
        for (int i = 0; i < playerAmount; i++) {
            players[i] = new Player("Player " + i, throwsPerRound, maxPoints);
        }

    }

    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }

    public void initGameLoop(){

        boolean inGame = true;
        while (inGame) {

            System.out.println("It is currently " + players[currentPlayerIndex].getName() + "'s turn.");
            for (int i = 0; i < this.throwsPerRound; i++) {
                try {
                    Random r = new Random();
                    players[currentPlayerIndex].useThrow(dartboard.evaluatePointsFromThrow(new Polar(r.nextInt((boardSize + 1)), r.nextInt((360)))));
                } catch (IllegalStateException e){
                    System.out.println(players[currentPlayerIndex].getName() + " has reached a lower score than 0!");
                    resetIllegalThrow(null);
                    break;
                } catch (UnsupportedOperationException e){
                    System.out.println(players[currentPlayerIndex].getName() + " has used up all their throws!");
                    break;
                }
                if (players[currentPlayerIndex].hasWon()){
                    System.out.println(players[currentPlayerIndex].getName() + " has WON the match!");
                    inGame = false;
                }
            }
            printPlayerStats(players[currentPlayerIndex]);
            iterateToNextPlayer();
        }
        System.out.println();
    }

    public void resetIllegalThrow(Dart d){
        players[currentPlayerIndex].resetLastPoint();
        dartboard.getDartCollection().removeDart(d);
    }
    public void iterateToNextPlayer(){
        players[currentPlayerIndex].resetPlayerTurn();
        currentPlayerIndex = (currentPlayerIndex + 1)%players.length;
    }

    public Player getPlayerByName(String name){
        for (Player p:players) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public void printPlayerStats(Player p){
        System.out.println(p.toString());
    }

    public int getMaxPoints(){
        return maxPoints;
    }

    public int getThrowsPerRound(){
        return throwsPerRound;
    }

}