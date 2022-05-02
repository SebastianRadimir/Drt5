package hwr.oop;

public class Player {

    private int currentPoints;
    private int maxThrowCount;
    private int throwCount;
    private int[] pointsInRound;
    private final String name;

    public Player(String name){

        this.name = name;

        maxThrowCount = Darts.getThrowsPerRound();
        pointsInRound = new int[maxThrowCount];
        resetPlayerTurn();
        this.currentPoints = 0;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public void resetPlayerTurn(){

        currentPoints+=sumPoints();

        for (int i = 0; i < maxThrowCount; i++) {
            pointsInRound[i] = 0;
        }
        this.throwCount = maxThrowCount;

    }

    private int sumPoints(){
        int sum = 0;
        for (int i = 0; i < maxThrowCount; i++) {
            sum+=pointsInRound[i];
        }
        return sum;
    }

    public boolean endedTurn(){
        return throwCount == 0;
    }

    public int useThrow(int reachedPoints) {
        if (endedTurn()){
            throw new UnsupportedOperationException("\n - '"+name+"' has already used up all "+Darts.intToStr(maxThrowCount)+" throws.");
        }

        pointsInRound[maxThrowCount-throwCount] = reachedPoints;
        if (Darts.getMaxPoints()-(currentPoints+sumPoints())<0){
            throw new IllegalStateException("\n - '"+name+"' has reached less than 0 points ("+Darts.intToStr(Darts.getMaxPoints()-(currentPoints+sumPoints()))+" points reached).");
        }
        throwCount--;
        return throwCount;
    }

    public String getName(){
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("PLAYER:");
        sb.append(name);

        for (int i = 0; i < maxThrowCount; i++) {
            sb.append(" -throw ");
            sb.append(Darts.intToStr(i));
            sb.append(" : ");
            sb.append(Darts.intToStr(pointsInRound[i]));
            if (pointsInRound[i] == 1){
                sb.append(" point");
            }else {
                sb.append(" points");
            }
            sb.append("\n");
        }

        int aquiredPoints = Darts.getMaxPoints()-currentPoints;

        sb.append("Currently at ");
        sb.append(Darts.intToStr(aquiredPoints));
        if (aquiredPoints == 1 || aquiredPoints == -1){
            sb.append(" point");
        }else {
            sb.append(" points");
        }

        return sb.toString();
    }
}