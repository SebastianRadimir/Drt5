package hwr.oop;

import java.util.ArrayList;

public class DartCollection{

    private ArrayList<Dart> thrownDarts;

    DartCollection(){
        this.thrownDarts = new ArrayList<>();
    }

    public ArrayList<Dart> getDarts(){
        return thrownDarts;
    }

    public ArrayList<Dart> getDartsFromPlayer(String playerName){
        ArrayList<Dart> listDarts = new ArrayList<>();
        for (Dart d:thrownDarts){
            if (d.getPlayerName().equals(playerName)){
                listDarts.add(d);
            }
        }
        return listDarts;
    }
    void addDart(Dart d){
        thrownDarts.add(d);
    }
    public void removeDart(Dart d){
        thrownDarts.remove(d);
    }
}
