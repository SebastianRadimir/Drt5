package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

// TODO Delete this placeholder test.
class ExampleTest {

    //@BeforeEach
    //void setUp() {
    //    Darts d = new Darts(2,3,4);
    //}

    @Test
    void get_IsTrue() {
        Example example = new Example();
        boolean result = example.get();
        Assertions.assertThat(result).isTrue();
    }


    @Test
    void newGame_NoTicksYet_AllFieldsAreZero() {
        int[] squares = new int[9];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int targetIndex = y * 3 + x;
                squares[targetIndex] = 0;
            }
        }
        assertThat(squares).containsOnly(0);
    }

    @Test
    void evaluatePointsFromThrow_BULLSEYE() {
        Darts d = new Darts(2,3,4);
        assertThat(d.evaluatePointsFromThrow(0,0)).isEqualTo(50);
    }
    @Test
    void evaluatePointsFromThrow_NextToBullsEye() {
        Darts d = new Darts(2,3,4);
        assertThat(d.evaluatePointsFromThrow(7,-7)).isEqualTo(25);
    }
    @Test
    void evaluatePointsFromThrow_OutOfBounds() {
        Darts d = new Darts(2,3,4);
        assertThat(d.evaluatePointsFromThrow(0,-51)).isEqualTo(0);
    }
    @Test
    void isGameOver_FirstPlayerDoesNotWinAfterThreeTicsNotInARow_GameIsNotOver() {

        // when
        boolean over = true;
        // then
        assertThat(over).isFalse();
    }

    @Test
    void Darts_GameNotAllowedToBePlayedWithLessThanTwoPeople() {
        try {
            Darts d = new Darts(1,1,3);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_GameNotAllowedHaveLessThanOnePointToReach() {
        try {
            Darts d = new Darts(12,0,3);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_GameNotAllowedHaveLessThanOneThrowPerPerRound() {
        try {
            Darts d = new Darts(12,2,0);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}