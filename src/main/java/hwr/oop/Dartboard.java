package hwr.oop;

import java.util.Arrays;

public class Dartboard {

    private final int boardSize;

    public Dartboard(int boardSize){
        this.boardSize = boardSize;

    }

    public void removeDart(Dart d){
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
