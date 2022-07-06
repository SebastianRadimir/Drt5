package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointEvalTest {

    @Test
    void Darts_evaluatePointsFromThrow_BULLSEYE() {
        Dartboard d = new Dartboard(60);
        for (int i = 0; i < 360; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) - 1, i))).isEqualTo(50);
            assertThat(d.evaluatePointsFromThrow(new Polar(0, i))).isEqualTo(50);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0), i))).isNotEqualTo(50);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_NextToBullsEye() {
        Dartboard d = new Dartboard(60);
        for (int i = 0; i < 360; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2, i))).isEqualTo(25);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0), i))).isEqualTo(25);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isNotEqualTo(25);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) - 1, i))).isNotEqualTo(25);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_OutOfBounds() {
        Dartboard d = new Dartboard(60);
        for (int i = 0; i < 360; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar(d.getBoardSize() + 1, i))).isEqualTo(0);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_6Points() {
        Dartboard d = new Dartboard(60);
        for (int i = -9; i < 9; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(18);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(12);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_13Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 9; i < 27; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(13);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(13);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(39);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(39);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(13);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(13);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(26);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(26);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_4Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 27; i < 45; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(4);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(4);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(12);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(4);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(4);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(8);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(8);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_18Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 45; i < 63; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(18);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(54);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(54);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(18);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(36);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(36);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_1Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 63; i < 81; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(1);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(1);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(1);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(1);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(2);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_20Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 81; i < 99; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(20);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(20);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(60);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(60);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(20);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(20);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(40);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(40);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_5Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 99; i < 117; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(5);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(5);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(15);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(15);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(5);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(5);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(10);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(10);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_12Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 117; i < 135; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(12);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(36);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(36);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(12);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(24);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(24);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_9Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 135; i < 153; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(9);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(9);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(27);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(27);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(9);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(9);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(18);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_14Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 153; i < 171; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(14);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(14);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(42);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(42);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(14);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(14);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(28);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(28);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_11Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 171; i < 189; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(11);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(11);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(33);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(33);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(11);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(11);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(22);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(22);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_8Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 189; i < 207; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(8);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(8);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(24);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(24);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(8);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(8);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(16);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(16);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_16Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 207; i < 225; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(16);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(16);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(48);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(48);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(16);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(16);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(32);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(32);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_7Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 225; i < 243; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(7);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(7);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(21);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(21);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(7);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(7);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(14);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(14);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_19Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 243; i < 261; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(19);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(19);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(57);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(57);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(19);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(19);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(38);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(38);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_3Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 261; i < 279; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(9);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(9);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(6);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_17Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 279; i < 297; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(17);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(17);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(51);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(51);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(17);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(17);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(34);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(34);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_2Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 297; i < 315; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(2);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(2);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(4);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(4);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_15Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 315; i < 333; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(15);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(15);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(45);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(45);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(15);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(15);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(30);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(30);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_10Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 333; i < 351; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(10);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(10);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(30);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(30);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(10);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(10);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(20);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(20);
        }
    }

    @Test
    void Darts_evaluatePointsFromThrow_6P2Points() {
        Dartboard d = new Dartboard(60);
        for (int i = 351; i < 369; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 2.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 4.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5, i))).isEqualTo(18);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 5.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 7.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize() / 8.0) * 8, i))).isEqualTo(12);
        }
    }
}