package hwr.oop;
import java.util.Arrays;

public class Darts {

    private final int maxPoints;
    private final int throwsPerRound;
    private final Player[] players;
    private int currentPlayerIndex;
    private final int boardSize = 60;
    private final int[] slicePoints;

    public Darts(int playerAmount, int maxPoints, int throwsPerRound){

        slicePoints = new int[]{6,13,4,18,1,20,5,12,9,14,11,8,16,7,19,3,17,2,15,10};

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
            players[i] = new Player("Player " + intToStr(i), throwsPerRound, maxPoints);
        }

    }

    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }

    public void iterateToNextPlayer(){
        printPlayerStats(players[currentPlayerIndex]);
        players[currentPlayerIndex].resetPlayerTurn();
        currentPlayerIndex = (currentPlayerIndex + 1)%players.length;
    }

    public String getCharBoard(int x, int y){
        double halfBoard = (double)boardSize/2;
        int[] borders = new int[]{boardSize/2,boardSize/3,1,(boardSize)/8,((boardSize)/4),((boardSize)/8)*4};
        Polar[] ps = new Polar[360*borders.length];
        for (int d = 0; d < borders.length; d++) {
            for (int i = 0; i < 360; i++) {
                ps[(borders.length*i)+d] = Polar.convertPolarToPos(new Polar(borders[d], i));
            }
        }
        Polar[] ps2 = new Polar[20*boardSize];
        for (int d = 0; d < 20; d++) {
            for (int i = ((boardSize)/8); i < halfBoard; i++) {
                ps2[(20*i)+d] = Polar.convertPolarToPos(new Polar(i, (d*18)+9));
            }
        }
        String[][] cs = new String[boardSize+1][boardSize+1];
        for (String[] c : cs) {
            Arrays.fill(c, "   ");
        }
        for (Polar p:ps2) {
            if (p != null){
                cs[(int)p.getDistance()+(int)halfBoard][(int)p.getAngle()+(int)halfBoard] = " # ";
            }
        }
        for (Polar p:ps) {
            if (p != null){
                cs[(int)p.getDistance()+(int)halfBoard][(int)p.getAngle()+(int)halfBoard] = "###";
            }
        }
        cs[y+(int)halfBoard][x+(int)halfBoard] = "<O>";
        StringBuilder sbo = new StringBuilder();
        for (String[] c : cs) {
            StringBuilder sbi = new StringBuilder();
            for (String s : c) {
                sbi.append(s);
            }
            sbi.append("\n");
            sbo.append(sbi);
        }
        return sbo.toString();
    }

    public Player getPlayerByName(String name){
        for (Player p:players) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    //public int evaluatePointsFromThrow(double x, double y) {
    //    return evaluatePointsFromThrow(Polar.convertPosToPolar(x, y));
    //}
    public int evaluatePointsFromThrow(Polar pos){

        double octagonalBoardSize = ((double)boardSize)/8;

        double distance = pos.getDistance();

        if (distance>boardSize){
            return 0;
        }

        if (distance<=octagonalBoardSize*2) {
            if (distance < octagonalBoardSize) {
                return 50;
            }
            return 25;
        }

        double angle = pos.getAngle();
        if (angle<0){
            angle = 360+angle;
        }
        int pointMultiplier = 1;
        if (distance>octagonalBoardSize*7){
            pointMultiplier = 2;
        }
        if (distance<=octagonalBoardSize*5 && distance>octagonalBoardSize*4){
            pointMultiplier = 3;
        }
        return slicePoints[(int)((((angle+((360.0/slicePoints.length)/2.0))%360))/(360.0/slicePoints.length))]*pointMultiplier;
    }

    public int getBoardSize(){
        return boardSize;
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

    public static String intToStr(int i){
        return Integer.toString(i);
    }
}