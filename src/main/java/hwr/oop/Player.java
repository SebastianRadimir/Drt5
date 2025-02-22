package hwr.oop;

public class Player {

    private int currentPoints;
    private int throwCount;
    private final int[] pointsInRound;
    private final String name;
    private final int maxThrowCount;
    private final int maxGamePoints;


    public Player(String name, int maxThrowCount, int maxPoints){
        if (maxPoints<=0 || maxThrowCount<=0){
            StringBuilder sb = new StringBuilder();
            if (maxPoints<=0){
                sb.append("\n - 'maxPoints' is not allowed to be under 1 point.");
            }
            if (maxThrowCount<=0){
                sb.append("\n - 'throwsPerRound' is not allowed to be under 1.");
            }
            throw new IllegalArgumentException(sb.toString());
        }

        this.name = name;
        this.maxGamePoints = maxPoints;
        this.maxThrowCount = maxThrowCount;
        pointsInRound = new int[maxThrowCount];
        resetPlayerTurn();
        this.currentPoints = 0;
    }

    public void resetPlayerTurn(){

        currentPoints+=sumRoundPoints();

        for (int i = 0; i < maxThrowCount; i++) {
            pointsInRound[i] = 0;
        }
        this.throwCount = maxThrowCount;

    }
    public int[] getPointArray(){
        return pointsInRound;
    }

    private int sumRoundPoints(){
        int sum = 0;
        for (int i = 0; i < maxThrowCount; i++) {
            sum+=pointsInRound[i];
        }
        return sum;
    }

    void resetLastPoint(){
        if (throwCount>=maxThrowCount){
            throw new UnsupportedOperationException("Cant reset a throw if there is no throw to reset!");
        }
        pointsInRound[(maxThrowCount-throwCount)-1] = 0;
    }

    public boolean hasWon(){
        return maxGamePoints-(currentPoints+sumRoundPoints())==0;
    }

    public boolean endedTurn(){
        return throwCount == 0;
    }

    public void useThrow(int reachedPoints) {
        if (reachedPoints >= 61 || reachedPoints <= -1){
            throw new IllegalStateException("\n - the throw of '"+name+"' is "+reachedPoints+" points, which isn't possible.");
        }
        if (endedTurn()){
            throw new UnsupportedOperationException("\n - '"+name+"' has already used up all "+maxThrowCount+" throw(s).");
        }
        if (maxGamePoints-(currentPoints+(sumRoundPoints()+reachedPoints))<0){
            throw new IllegalStateException("\n - '"+name+"' has reached less than 0 points ("+(maxGamePoints-(currentPoints+(sumRoundPoints()+reachedPoints)))+" points reached).");
        }
        pointsInRound[maxThrowCount-throwCount] = reachedPoints;
        throwCount--;
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
        sb.append("\n");

        for (int i = 0; i < maxThrowCount; i++) {
            sb.append(" -throw ");
            sb.append(i+1);
            sb.append(" : ");
            sb.append(pointsInRound[i]);
            if (pointsInRound[i] == 1){
                sb.append(" point");
            }else {
                sb.append(" points");
            }
            sb.append("\n");
        }

        int acquiredPoints = maxGamePoints-(currentPoints+sumRoundPoints());

        sb.append("Currently at ");
        sb.append(acquiredPoints);
        if (acquiredPoints == 1 || acquiredPoints == -1){
            sb.append(" point");
        }else {
            sb.append(" points");
        }

        return sb.toString();
    }
}