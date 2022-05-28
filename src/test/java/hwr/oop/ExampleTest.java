package hwr.oop;

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
    void Darts_evaluatePointsFromThrow_BULLSEYE() {
        Darts d = new Darts(2,3,4);
        for (int i = 0; i < 360; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)-1, i))).isEqualTo(50);
            assertThat(d.evaluatePointsFromThrow(new Polar(0, i))).isEqualTo(50);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0), i))).isNotEqualTo(50);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_NextToBullsEye() {
        Darts d = new Darts(2,3,4);
        for (int i = 0; i < 360; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2, i))).isEqualTo(25);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0), i))).isEqualTo(25);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isNotEqualTo(25);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)-1, i))).isNotEqualTo(25);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_OutOfBounds() {
        Darts d = new Darts(2,3,4);
        for (int i = 0; i < 360; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar(d.getBoardSize()+1, i))).isEqualTo(0);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_6Points() {
        Darts d = new Darts(2,3,4);
        for (int i = -9; i < 9; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(18);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(12);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_13Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 9; i < 9+18; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(13);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(13);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(39);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(39);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(13);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(13);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(26);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(26);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_4Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 9+18; i < 9+18+18; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(4);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(4);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(12);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(4);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(4);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(8);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(8);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_18Points() {
        int points = 18;
        Darts d = new Darts(2,3,4);
        for (int i = 9+18+18; i < 9+18+18+18; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_1Points() {
        int points = 1;
        Darts d = new Darts(2,3,4);
        for (int i = 9+18+18+18; i < 9+18+18+18+18; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_20Points() {
        int points = 20;
        int index = 4;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_5Points() {
        int points = 5;
        int index = 5;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_12Points() {
        int points = 12;
        int index = 6;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_9Points() {
        int points = 9;
        int index = 7;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_14Points() {
        int points = 14;
        int index = 8;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_11Points() {
        int points = 11;
        int index = 9;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_8Points() {
        int points = 8;
        int index = 10;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_16Points() {
        int points = 16;
        int index = 11;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_7Points() {
        int points = 7;
        int index = 12;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_19Points() {
        int points = 19;
        int index = 13;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_3Points() {
        int points = 3;
        int index = 14;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_17Points() {
        int points = 17;
        int index = 15;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_2Points() {
        int points = 2;
        int index = 16;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_15Points() {
        int points = 15;
        int index = 17;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_10Points() {
        int points = 10;
        int index = 18;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_6P2Points() {
        int points = 6;
        int index = 19;
        Darts d = new Darts(2,3,4);
        for (int i = 9+(18*index); i < 9+(18*(1+index)); i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(points*3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(points*3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(points);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(points);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(points*2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(points*2);
        }
    }
    @Test
    void isGameOver_FirstPlayerDoesNotWinAfterThreeTicsNotInARow_GameIsNotOver() {

        // when
        boolean over = true;
        // then
        assertThat(over).isTrue();
    }

    @Test
    void Darts_GameNotAllowedToBePlayedWithLessThanTwoPeople() {
        try {
            new Darts(1,1,3);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_GameNotAllowedHaveLessThanOnePointToReach() {
        try {
            new Darts(12,0,3);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_GameNotAllowedHaveLessThanOneThrowPerPerRound() {
        try {
            new Darts(12,2,0);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_TestIntToStringConversionForValue0() {
        assertThat(Darts.intToStr(0)).isEqualTo("0");
    }@Test
    void Darts_TestIntToStringConversionForValue1(){
        assertThat(Darts.intToStr(1)).isEqualTo("1");
    }@Test
    void Darts_TestIntToStringConversionForValue2(){
        assertThat(Darts.intToStr(2)).isEqualTo("2");
    }@Test
    void Darts_TestIntToStringConversionForValue3(){
        assertThat(Darts.intToStr(3)).isEqualTo("3");
    }@Test
    void Darts_TestIntToStringConversionForValue4(){
        assertThat(Darts.intToStr(4)).isEqualTo("4");
    }
    @Test
    void Darts_TestIntToStringConversionForValueMinus5(){
        assertThat(Darts.intToStr(-5)).isEqualTo("-5");
    }

    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates00(){
        Polar p = Polar.convertPosToPolar(0,0);
        assertThat(p.getDistance()).isEqualTo(0.0);
        assertThat(p.getAngle()).isEqualTo(0.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(0);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);

    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates10(){
        Polar p = Polar.convertPosToPolar(1,0);
        assertThat(Math.round(p.getDistance())).isEqualTo(1);
        assertThat(Math.round(p.getAngle())).isEqualTo(0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates01(){
        Polar p = Polar.convertPosToPolar(0,1);
        assertThat(p.getDistance()).isEqualTo(1.0);
        assertThat(p.getAngle()).isEqualTo(90.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(0);
        assertThat(Math.round(cp.getAngle())).isEqualTo(1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesMinus10(){
        Polar p = Polar.convertPosToPolar(-1,0);
        assertThat(p.getDistance()).isEqualTo(1.0);
        assertThat(p.getAngle()).isEqualTo(180.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(-1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates0Minus1(){
        Polar p = Polar.convertPosToPolar(0,-1);
        assertThat(p.getDistance()).isEqualTo(1.0);
        assertThat(p.getAngle()).isEqualTo(270.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(0);
        assertThat(Math.round(cp.getAngle())).isEqualTo(-1);
    }

    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates11(){
        Polar p = Polar.convertPosToPolar(1,1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(45.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesMinus11(){
        Polar p = Polar.convertPosToPolar(-1,1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(135.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(-1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesMinus1Minus1(){
        Polar p = Polar.convertPosToPolar(-1,-1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(225.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(-1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(-1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates1Minus1(){
        Polar p = Polar.convertPosToPolar(1,-1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(315.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(-1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesRandomVars1(){
        Polar p = Polar.convertPosToPolar(3,-0.1);
        assertThat(Math.round(p.getDistance())).isEqualTo(3);
        assertThat(Math.round(p.getAngle())).isEqualTo(358);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(3);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);
    }
}