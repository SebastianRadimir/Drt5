package hwr.oop;
import java.util.Arrays;

public class Darts {

    private static int maxPoints;
    private static int throwsPerRound;
    private final Player[] players;
    private int currentPlayer;
    private final int boardSize = 50;
    private final int[] slicePoints;

    public Darts(int playerAmount, int maxPoints, int throwsPerRound){

        slicePoints = new int[]{6,13,4,18,1,20,5,12,914,11,8,16,7,19,3,17,2,15,10};

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

        currentPlayer = 0;
        Darts.throwsPerRound = throwsPerRound;
        Darts.maxPoints = maxPoints;
        players = new Player[playerAmount];
        for (int i = 0; i < playerAmount; i++) {
            players[i] = new Player(intToStr(i));
        }

        printBoard();
    }

    public void printBoard(){
        double halfBoard = (double)boardSize/2;
        int[] borders = new int[]{boardSize/2,boardSize/3,1,2};
        Polar[] ps = new Polar[360*borders.length];
        for (int d = 0; d < borders.length; d++) {
            for (int i = 0; i < 360; i++) {
                ps[(borders.length*i)+d] = Polar.convertPolarToPos(new Polar(borders[d], i * Math.PI / 180));
            }
        }
        String[][] cs = new String[boardSize+1][boardSize+1];
        for (String[] c : cs) {
            Arrays.fill(c, "   ");
        }
        for (Polar p:ps) {
            if (p != null){
                cs[(int)p.getDistance()+(int)halfBoard][(int)p.getAngle()+(int)halfBoard] = "###";
            }
        }
        StringBuilder sbo = new StringBuilder();
        for (String[] c : cs) {
            StringBuilder sbi = new StringBuilder();
            for (String s : c) {
                sbi.append(s);
            }
            sbi.append("\n");
            sbo.append(sbi);
        }
        System.out.println(sbo);
    }

    public Player getPlayerByName(String name){
        for (Player p:players) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public int evaluatePointsFromThrow(double x, double y){
        Polar pos = Polar.convertPosToPolar(x, y);

        double octagonalBoardSize = ((double)boardSize)/8;

        double distance = pos.getDistance();
        int points = slicePoints[(int)(((pos.getAngle()+((360/slicePoints.length)/2))%360)/(360/slicePoints.length))];
        int pointMultiplyer = 1;

        if (distance>boardSize){
            return 0;
        }

        if (distance<=(octagonalBoardSize*2)){
            if(distance<octagonalBoardSize){
                return 50;
            }
            return 25;
        }
        if (boardSize<=octagonalBoardSize*8 && boardSize>octagonalBoardSize*7){
            pointMultiplyer = 2;
        }
        if (boardSize<=octagonalBoardSize*5 && boardSize>octagonalBoardSize*4){
            pointMultiplyer = 3;
        }
        return points*pointMultiplyer;
        //throw new IllegalStateException("\n - Position "+intToStr(x)+","+intToStr(y)+" could not be computed into points.");
    }

    public void printCurrentPlayerStats(Player p){
        System.out.println(p.toString());
    }

    public static int getMaxPoints(){
        return maxPoints;
    }

    public static int getThrowsPerRound(){
        return throwsPerRound;
    }

    public static String intToStr(int i){
        return Integer.toString(i);
    }
}