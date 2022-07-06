package hwr.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PlayerTest {

    @Test
    void Player_PlayerNotAllowedHaveLessThanOnePointToReach() {
        try {
            new Player("Player 1",4,0);
            fail("No error! (Not allowed to have less than 1 point to reach in a game)");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    void Player_PlayerNotAllowedHaveLessThanOneThrowPerPerRound() {
        try {
            new Player("Player 1",0,100);
            fail("No error! (Not allowed to have less than 1 Throw per round per player)");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    void Player_TestEndedTurn(){
        Player p = new Player("Player 1",2,111);
        assertThat(p.endedTurn()).isFalse();

        p.useThrow(10);
        assertThat(p.endedTurn()).isFalse();

        p.useThrow(10);
        assertThat(p.endedTurn()).isTrue();
    }
    @Test
    void Player_TestUseThrowExceedThrowLimitException(){
        Player p = new Player("Player 1",2,100);
        p.useThrow(10);
        p.useThrow(10);
        try {
            p.useThrow(10);
            fail("No error! (Player exceeded the 2 throws in one round)");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }
    @Test
    void Player_TestUseThrowExceedPointsLimitException(){
        Player p = new Player("Player 1",4,21);
        p.useThrow(10);
        p.useThrow(9);
        try {
            p.useThrow(3);
            fail("No error! (Player exceeded the max points of the Game)");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest(name = "Testing unreachable points ({0} points.")
    @ValueSource(ints={-1,-2,-4,-7,-9,61,62,63,80})
    void Player_TestUseThrowImpossiblePointsReached(int value){
        Player p = new Player("Player 1",4,501);
        try {
            p.useThrow(value);
            fail("No error! (Player acquired an impossible amount of points)");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
    @Test
    void Player_TestGetNameTest(){
        assertThat(new Player("Player Test Name",4,21).getName()).isEqualTo("Player Test Name");
        assertThat(new Player("Player Test not Name",4,21).getName()).isNotEqualTo("Player Test Name");
    }
    @Test
    void Player_TestGetPointArray() {
        Player p = new Player("Player 1",4,300);
        assertThat(p.getPointArray()).isEqualTo(new int[]{0,0,0,0});
        p.useThrow(10);
        assertThat(p.getPointArray()).isEqualTo(new int[]{10,0,0,0});
        p.useThrow(9);
        assertThat(p.getPointArray()).isEqualTo(new int[]{10,9,0,0});
        p.useThrow(0);
        assertThat(p.getPointArray()).isEqualTo(new int[]{10,9,0,0});
        p.useThrow(35);
        assertThat(p.getPointArray()).isEqualTo(new int[]{10,9,0,35});
    }
    @Test
    void Player_getCurrentPointsTestScenario1(){
        Player p = new Player("P 1",1, 301);
        p.useThrow(9);
        assertThat(p.getCurrentPoints()).isEqualTo(0);
        p.resetPlayerTurn();
        assertThat(p.getCurrentPoints()).isEqualTo(9);
    }
    @Test
    void Player_getCurrentPointsTestScenario2(){
        Player p = new Player("P 1",2, 301);
        assertThat(p.getCurrentPoints()).isEqualTo(0);
        p.useThrow(9);
        assertThat(p.getCurrentPoints()).isEqualTo(0);
        p.useThrow(10);
        p.resetPlayerTurn();
        assertThat(p.getCurrentPoints()).isEqualTo(19);
    }
    @Test
    void Player_testToString(){
        Darts d = new Darts(3, 98, 5);
        Player p = d.getPlayerByName("Player 1");
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 0 points\n" +
                        " -throw 2 : 0 points\n" +
                        " -throw 3 : 0 points\n" +
                        " -throw 4 : 0 points\n" +
                        " -throw 5 : 0 points\n" +
                        "Currently at 98 points");

        p.useThrow(10);
        p.useThrow(1);
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 10 points\n" +
                        " -throw 2 : 1 point\n" +
                        " -throw 3 : 0 points\n" +
                        " -throw 4 : 0 points\n" +
                        " -throw 5 : 0 points\n" +
                        "Currently at 87 points");

        p.useThrow(51);
        p.useThrow(35);
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 10 points\n" +
                        " -throw 2 : 1 point\n" +
                        " -throw 3 : 51 points\n" +
                        " -throw 4 : 35 points\n" +
                        " -throw 5 : 0 points\n" +
                        "Currently at 1 point");

        p.resetPlayerTurn();
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 0 points\n" +
                        " -throw 2 : 0 points\n" +
                        " -throw 3 : 0 points\n" +
                        " -throw 4 : 0 points\n" +
                        " -throw 5 : 0 points\n" +
                        "Currently at 1 point");

        p.useThrow(1);
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 1 point\n" +
                        " -throw 2 : 0 points\n" +
                        " -throw 3 : 0 points\n" +
                        " -throw 4 : 0 points\n" +
                        " -throw 5 : 0 points\n" +
                        "Currently at 0 points");



    }

    @Test
    void Player_TestHasWonScenario1(){
        Player p = new Player("P 1",2, 10);
        p.useThrow(9);
        assertThat(p.hasWon()).isFalse();
        p.useThrow(1);
        assertThat(p.hasWon()).isTrue();
    }
    @Test
    void Player_TestHasWonScenario2(){
        Player p = new Player("P 1",1, 10);
        p.useThrow(9);
        assertThat(p.hasWon()).isFalse();
        p.resetPlayerTurn();
        p.useThrow(1);
        assertThat(p.hasWon()).isTrue();
        p.resetPlayerTurn();
        try {
            p.useThrow(4);
            fail("No error! (Player exceeded the max points of the Game)");
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
    }
    @Test
    void Player_TestHasWonScenario3(){
        Player p = new Player("P 1",2, 14);
        p.useThrow(9);
        assertThat(p.hasWon()).isFalse();
        p.useThrow(1);
        assertThat(p.hasWon()).isFalse();
        p.resetPlayerTurn();
        try {
            p.useThrow(8);
            fail("No error! (Player exceeded the max points of the Game)");
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        p.useThrow(4);
        assertThat(p.hasWon()).isTrue();
    }

    @Test
    void Player_tetResetLastThrow(){
        Player p = new Player("p1",3 ,56);
        try {
            p.resetLastPoint();
            fail("No error! (cannot reset a throw if there was no throw)");
        }catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        p.useThrow(6);
        assertThat(p.toString()).isEqualTo(
                "PLAYER:p1\n" +
                        " -throw 1 : 6 points\n" +
                        " -throw 2 : 0 points\n" +
                        " -throw 3 : 0 points\n" +
                        "Currently at 50 points");
        p.resetLastPoint();
        p.useThrow(20);
        assertThat(p.toString()).isEqualTo(
                "PLAYER:p1\n" +
                        " -throw 1 : 0 points\n" +
                        " -throw 2 : 20 points\n" +
                        " -throw 3 : 0 points\n" +
                        "Currently at 36 points");
    }
}
