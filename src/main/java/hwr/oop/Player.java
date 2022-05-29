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

    public boolean hasWon(){
        return maxGamePoints-(currentPoints+sumRoundPoints())==0;
    }

    public boolean endedTurn(){
        return throwCount == 0;
    }

    public void useThrow(int reachedPoints) {
        if (reachedPoints >= 61 || reachedPoints <= -1){
            throw new IllegalStateException("\n - '"+name+"' has reached "+reachedPoints+" points, which isn't possible).");
        }
        if (endedTurn()){
            throw new UnsupportedOperationException("\n - '"+name+"' has already used up all "+maxThrowCount+" throw(s).");
        }

        pointsInRound[maxThrowCount-throwCount] = reachedPoints;
        if (maxGamePoints-(currentPoints+sumRoundPoints())<0){
            throw new IllegalStateException("\n - '"+name+"' has reached less than 0 points ("+(maxGamePoints-(currentPoints+sumRoundPoints()))+" points reached).");
        }
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
            sb.append(Darts.intToStr(i+1));
            sb.append(" : ");
            sb.append(Darts.intToStr(pointsInRound[i]));
            if (pointsInRound[i] == 1){
                sb.append(" point");
            }else {
                sb.append(" points");
            }
            sb.append("\n");
        }

        int acquiredPoints = maxGamePoints-currentPoints;

        sb.append("Currently at ");
        sb.append(Darts.intToStr(acquiredPoints));
        if (acquiredPoints == 1 || acquiredPoints == -1){
            sb.append(" point");
        }else {
            sb.append(" points");
        }

        return sb.toString();
    }
}