package hwr.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Dartboard {

    private int boardSize;
    private final int[] slicePoints;
    private ArrayList<Dart> thrownDarts = new ArrayList<>();

    public Dartboard(int boardSize){
        this.slicePoints = new int[]{6,13,4,18,1,20,5,12,9,14,11,8,16,7,19,3,17,2,15,10};
        this.boardSize = boardSize;
    }

    void addDart(Dart d){
        thrownDarts.add(d);
    }
    public void removeDart(Dart d){
        thrownDarts.remove(d);
    }

    public int getBoardSize(){
        return boardSize;
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

    @Override
    public String toString(){
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
        //cs[y+(int)halfBoard][x+(int)halfBoard] = "<O>";
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

}
