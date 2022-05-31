package hwr.oop;

public class Dart {

    private final Polar pos;
    private final String playerName;

    public Dart(String throwFromPlayer, Polar p){
        pos = p;
        playerName = throwFromPlayer;
    }

    public Polar getPos(){
        return this.pos;
    }

    public String getPlayerName(){
        return this.playerName;
    }
}
