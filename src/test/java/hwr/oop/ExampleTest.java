package hwr.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class ExampleTest {

    //@BeforeEach
    //void setUp() {
    //    Darts d = new Darts(2,3,4);
    //}
    @Test
    void Darts_GameNotAllowedToBePlayedWithLessThanTwoPeople() {
        try {
            new Darts(1,1,3);
            fail("No error! (Not allowed to have less than 2 players)");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_GameNotAllowedHaveLessThanOnePointToReach() {
        try {
            new Darts(12,0,3);
            fail("No error! (Not allowed to have less than 1 point to reach in a game)");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    void Darts_GameNotAllowedHaveLessThanOneThrowPerPerRound() {
        try {
            new Darts(12,2,0);
            fail("No error! (Not allowed to have less than 1 Throw per round per player)");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    @ParameterizedTest(name = "test dart position out of bounds ( x:{0},y:0)")
    @ValueSource(ints = {-11,11,50,20,12})
    void Darts_testPrintedBoardSize20Error(int i) {
        Darts d = new Darts(12, 301, 3);
        if (d.getBoardSize() == 20) {
            try {
                d.getCharBoard(i, 0);
                fail("Dart Out of bounds");
            } catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("boardSize was not 20 => ignored Darts_testPrintedBoardSize20Error Test.");
        }
    }
    @ParameterizedTest(name = "test dart position out of bounds ( x:{0},y:0)")
    @ValueSource(ints = {-21,21,50,30,22})
    void Darts_testPrintedBoardSize40Error(int i) {
        Darts d = new Darts(12, 301, 3);
        if (d.getBoardSize() == 40) {
            try {
                d.getCharBoard(i, 0);
                fail("Dart Out of bounds");
            } catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        } else{
            System.out.println("boardSize was not 40 => ignored Darts_testPrintedBoardSize40Error Test.");
        }
    }
    @Test
    void Darts_testPrintedBoardSize20(){
        Darts d = new Darts(12,301,3);
        if (d.getBoardSize()==20){
            assertThat(d.getCharBoard(-3,-8)).isEqualTo(
                    "                              ###                              \n" +
                            "                  ###########################                  \n" +
                            "               ######<O>    # ### #       ######               \n" +
                            "         ######      #####################      ######         \n" +
                            "         ### # #########    # ### #    ######### # ###         \n" +
                            "      ###   ######   #####################   ######   ###      \n" +
                            "   ######   ###   ###########################   ###   ######   \n" +
                            "   ###   ###############    #  #  #    ###############   ###   \n" +
                            "   ###   ###   ######    #  # ### #  #    ######   ###   ###   \n" +
                            "   ### # ### # ###### #  # ######### #  # ###### # ### # ###   \n" +
                            "##################### # ############### # #####################\n" +
                            "   ### # ### # ###### #  # ######### #  # ###### # ### # ###   \n" +
                            "   ###   ###   ######    #  # ### #  #    ######   ###   ###   \n" +
                            "   ###   ###############    #  #  #    ###############   ###   \n" +
                            "   ######   ###   ###########################   ###   ######   \n" +
                            "      ###   ######   #####################   ######   ###      \n" +
                            "         ### # #########    # ### #    ######### # ###         \n" +
                            "         ######      #####################      ######         \n" +
                            "               ######       # ### #       ######               \n" +
                            "                  ###########################                  \n" +
                            "                              ###                              \n");
        }else{
            System.out.println("boardSize was not 20 => ignored Darts_testPrintedBoardSize20 Test.");
            assertThat(true).isTrue();
        }
    }
    @Test
    void Darts_testPrintedBoardSize40(){
        Darts d = new Darts(12,301,3);
        if (d.getBoardSize()==40){
            assertThat(d.getCharBoard(20,-20)).isEqualTo(
                    "                                                            ###                                                         <O>\n" +
                            "                                          #######################################                                          \n" +
                            "                                    #########          #           #          #########                                    \n" +
                            "                              #########                #           #                #########                              \n" +
                            "                           ######    #                 #           #                 #    ######                           \n" +
                            "                     ######             #              #           #              #             ######                     \n" +
                            "                  ######                #              #           #              #                ######                  \n" +
                            "               ###### #                    #           #    ###    #           #                    # ######               \n" +
                            "               ###       #                 #    ###########################    #                 #       ###               \n" +
                            "            ###             #             ######          #     #          ######             #             ###            \n" +
                            "         ######                #    ######    #           # ### #           #    ######    #                ######         \n" +
                            "         ###                     ######         ###########################         ######                     ###         \n" +
                            "      ###### #                ###### #       ######       #     #       ######       # ######                # ######      \n" +
                            "      ###       #  #          ###      ######       #     #     #     #       ######      ###          #  #       ###      \n" +
                            "   ######             #  # ###         ### #        #     #     #     #        # ###         ### #  #             ######   \n" +
                            "   ###                     ### #    ###       #        #    ###    #        #       ###    # ###                     ###   \n" +
                            "   ###                  ###      ######          #    ###############    #          ######      ###                  ###   \n" +
                            "   ###                  ###      ###    #  #       ###               ###       #  #    ###      ###                  ###   \n" +
                            "   ### #  #  #  #  #  # ###      ###          # ###                     ### #          ###      ### #  #  #  #  #  # ###   \n" +
                            "   ###                  ### #  # ### #  #  #    ###         ###         ###    #  #  # ### #  # ###                  ###   \n" +
                            "######               ######   ######         ######      #########      ######         ######   ######               ######\n" +
                            "   ###                  ### #  # ### #  #  #    ###         ###         ###    #  #  # ### #  # ###                  ###   \n" +
                            "   ### #  #  #  #  #  # ###      ###          # ###                     ### #          ###      ### #  #  #  #  #  # ###   \n" +
                            "   ###                  ###      ###    #  #       ###               ###       #  #    ###      ###                  ###   \n" +
                            "   ###                  ###      ######          #    ###############    #          ######      ###                  ###   \n" +
                            "   ###                     ### #    ###       #        #    ###    #        #       ###    # ###                     ###   \n" +
                            "   ######             #  # ###         ### #        #     #     #     #        # ###         ### #  #             ######   \n" +
                            "      ###       #  #          ###      ######       #     #     #     #       ######      ###          #  #       ###      \n" +
                            "      ###### #                ###### #       ######       #     #       ######       # ######                # ######      \n" +
                            "         ###                     ######         ###########################         ######                     ###         \n" +
                            "         ######                #    ######    #           # ### #           #    ######    #                ######         \n" +
                            "            ###             #             ######          #     #          ######             #             ###            \n" +
                            "               ###       #                 #    ###########################    #                 #       ###               \n" +
                            "               ###### #                    #           #    ###    #           #                    # ######               \n" +
                            "                  ######                #              #           #              #                ######                  \n" +
                            "                     ######             #              #           #              #             ######                     \n" +
                            "                           ######    #                 #           #                 #    ######                           \n" +
                            "                              #########                #           #                #########                              \n" +
                            "                                    #########          #           #          #########                                    \n" +
                            "                                          #######################################                                          \n" +
                            "                                                            ###                                                            \n");
        }else{
            System.out.println("boardSize was not 40 => ignored Darts_testPrintedBoardSize40 Test.");
            assertThat(true).isTrue();
        }
    }
    @Test
    void Darts_testPrintedBoardSize60(){
        Darts d = new Darts(12,301,3);
        if (d.getBoardSize()==60){
            assertThat(d.getCharBoard(15,10)).isEqualTo(
                    "                                                                                          ###                                                                                          \n" +
                            "                                                                     #############################################                                                                     \n" +
                            "                                                            ############       #          ###          #       ############                                                            \n" +
                            "                                                      ######         #############################################         ######                                                      \n" +
                            "                                                ######      ############       #                       #       ############      ######                                                \n" +
                            "                                          ######    # #########                #                       #                ######### # #########                                          \n" +
                            "                                       ######   #########                         #                 #                         #########   ######                                       \n" +
                            "                                    ###      ######       #                       #                 #                       #       ######      ###                                    \n" +
                            "                              ######   ######             #                       #                 #                       #             ######   ######                              \n" +
                            "                           ######   ######                   #                    #                 #                    #                   ######   ######                           \n" +
                            "                        ###### # ######                      #                    #       ###       #                    #                      ###### # ######                        \n" +
                            "                        ###   ######                            #       #######################################       #                            ######   ###                        \n" +
                            "                     ###   ######    #                          # #########          #           #          ######### #                          #    ######   ###                     \n" +
                            "                  ###   ######          #                   #########                #           #                #########                   #          ######   ###                  \n" +
                            "               ######   ###                #             ######    #                 #           #                 #    ######             #                ###   ######               \n" +
                            "               ###   ###                      #    ######             #              #    ###    #              #             ######    #                      ###   ###               \n" +
                            "            ###   ######                        ######                #    #################################    #                ######                        ############            \n" +
                            "            ### # ###                        ###### #                #########       #           #       #########                # ######                        ### # ###            \n" +
                            "         ###   ######                        ###       #          ###### #           #           #           # ######          #       ###                        ######   ###         \n" +
                            "         ###   ###    #  #                ###             # ######          #           #     #           #          ###### #             ###                #  #    ###   ###         \n" +
                            "      ###   ######          #  #       ######            ######             #           #     #           #             ######            ######       #  #          ######   ###      \n" +
                            "      ###   ###                   #  # ###               ###    #              #        #     #        #              #    ###               ### #  #                   ###   ###      \n" +
                            "      ###   ###                     ###### #          ###          #           #        #     #        #           #          ###          # ######                     ###   ###      \n" +
                            "   ############                     ###       #  # ######             #           #     # ### #     #           #             ###### #  #       ###                     ############   \n" +
                            "   ###   ###                     ######            ### #                 #       #####################       #                 # ###            ######                     ###   ###   \n" +
                            "   ###   ###                     ###            ######    #  #              # ######               ###### #              #  #    ######            ###                     ###   ###   \n" +
                            "   ### # ### #  #                ###            ###             #  #       ######                     ######       #  #             ###            ###                #  # ### # ###   \n" +
                            "   ###   ###       #  #  #  #  # ###            ###                   # ######                           ###### #                   ###            ### #  #  #  #  #       ###   ###   \n" +
                            "   ###   ###                     ### #  #  #  # ### #  #                ###                                 ###                #  # ### #  #  #  # ###                     ###   ###   \n" +
                            "   ###   ###                     ###            ###       #  #  #  #  # ###               ###               ### #  #  #  #  #       ###            ###                     ###   ###   \n" +
                            "############                  ######         ######                  ######            #########            ######                  ######         ######                  ############\n" +
                            "   ###   ###                     ###            ###       #  #  #  #  # ###               ###               ### #  #  #  #  #       ###            ###                     ###   ###   \n" +
                            "   ###   ###                     ### #  #  #  # ### #  #                ###                                 ###                #  # ### #  #  #  # ###                     ###   ###   \n" +
                            "   ###   ###       #  #  #  #  # ###            ###                   # ######                           ###### #                   ###            ### #  #  #  #  #       ###   ###   \n" +
                            "   ### # ### #  #                ###            ###             #  #       ######                     ######       #  #             ###            ###                #  # ### # ###   \n" +
                            "   ###   ###                     ###            ######    #  #              # ######               ###### #              #  #    ######            ###                     ###   ###   \n" +
                            "   ###   ###                     ######            ### #                 #       #####################       #                 # ###            ######                     ###   ###   \n" +
                            "   ############                     ###       #  # ######             #           #     # ### #     #           #             ###### #  #       ###                     ############   \n" +
                            "      ###   ###                     ###### #          ###          #           #        #     #        #           #          ###          # ######                     ###   ###      \n" +
                            "      ###   ###                   #  # ###               ###    #              #        #     #        #              #    ###               ### #  #                   ###   ###      \n" +
                            "      ###   ######          #  #       ######            ######             #           #     #           #             ######         <O>######       #  #          ######   ###      \n" +
                            "         ###   ###    #  #                ###             # ######          #           #     #           #          ###### #             ###                #  #    ###   ###         \n" +
                            "         ###   ######                        ###       #          ###### #           #           #           # ######          #       ###                        ######   ###         \n" +
                            "            ### # ###                        ###### #                #########       #           #       #########                # ######                        ### # ###            \n" +
                            "            ###   ######                        ######                #    #################################    #                ######                        ######   ###            \n" +
                            "               ###   ###                      #    ######             #              #    ###    #              #             ######    #                      ###   ###               \n" +
                            "               ######   ###                #             ######    #                 #           #                 #    ######             #                ###   ######               \n" +
                            "                  ###   ######          #                   #########                #           #                #########                   #          ######   ###                  \n" +
                            "                     ###   ######    #                          # #########          #           #          ######### #                          #    ######   ###                     \n" +
                            "                        ###   ######                            #       #######################################       #                            ######   ###                        \n" +
                            "                        ###### # ######                      #                    #       ###       #                    #                      ###### # ######                        \n" +
                            "                           ######   ######                   #                    #                 #                    #                   ######   ######                           \n" +
                            "                              ######   ######             #                       #                 #                       #             ######   ######                              \n" +
                            "                                    ###      ######       #                       #                 #                       #       ######      ###                                    \n" +
                            "                                       ######   #########                         #                 #                         #########   ######                                       \n" +
                            "                                          ######    # #########                #                       #                ######### # #########                                          \n" +
                            "                                                ######      ############       #                       #       ############      ######                                                \n" +
                            "                                                      ######         #############################################         ######                                                      \n" +
                            "                                                            ############       #          ###          #       ############                                                            \n" +
                            "                                                                     #############################################                                                                     \n" +
                            "                                                                                          ###                                                                                          \n");
        }else{
            System.out.println("boardSize was not 60 => ignored Darts_testPrintedBoardSize60 Test.");
            assertThat(true).isTrue();
        }
    }
    @Test
    void Darts_TestGetMaxPoints(){
        assertThat(new Darts(12,2,11).getMaxPoints()).isEqualTo(2);
        assertThat(new Darts(12,3,11).getMaxPoints()).isNotEqualTo(2);
    }
    @Test
    void Darts_TestGetThrowsPerRound(){
        assertThat(new Darts(12,40,10).getThrowsPerRound()).isEqualTo(10);
        assertThat(new Darts(12,40,4).getThrowsPerRound()).isNotEqualTo(5);
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
        for (int i = 9; i < 27; i++) {
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
        for (int i = 27; i < 45; i++) {
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
        for (int i = 45; i < 63; i++) {
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
        Darts d = new Darts(2,3,4);
        for (int i = 63; i < 81; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(1);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(1);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(1);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(1);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(2);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_20Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 81; i < 99; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(20);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(20);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(60);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(60);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(20);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(20);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(40);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(40);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_5Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 99; i < 117; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(5);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(5);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(15);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(15);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(5);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(5);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(10);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(10);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_12Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 117; i < 135; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(12);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(36);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(36);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(12);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(12);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(24);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(24);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_9Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 135; i < 153; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(9);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(9);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(27);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(27);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(9);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(9);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(18);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(18);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_14Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 153; i < 171; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(14);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(14);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(42);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(42);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(14);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(14);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(28);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(28);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_11Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 171; i < 189; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(11);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(11);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(33);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(33);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(11);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(11);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(22);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(22);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_8Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 189; i < 207; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(8);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(8);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(24);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(24);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(8);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(8);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(16);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(16);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_16Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 207; i < 225; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(16);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(16);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(48);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(48);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(16);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(16);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(32);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(32);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_7Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 225; i < 243; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(7);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(7);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(21);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(21);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(7);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(7);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(14);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(14);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_19Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 243; i < 261; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(19);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(19);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(57);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(57);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(19);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(19);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(38);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(38);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_3Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 261; i < 279; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(9);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(9);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(3);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(3);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(6);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_17Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 279; i < 297; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(17);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(17);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(51);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(51);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(17);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(17);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(34);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(34);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_2Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 297; i < 315; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(2);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(6);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(6);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(2);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(2);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(4);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(4);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_15Points() {
        Darts d = new Darts(2,3,4);
        for (int i =315; i < 333; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(15);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(15);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(45);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(45);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(15);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(15);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(30);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(30);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_10Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 333; i < 351; i++) {
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*2.1, i))).isEqualTo(10);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4, i))).isEqualTo(10);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*4.1, i))).isEqualTo(30);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5, i))).isEqualTo(30);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*5.1, i))).isEqualTo(10);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7, i))).isEqualTo(10);

            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*7.1, i))).isEqualTo(20);
            assertThat(d.evaluatePointsFromThrow(new Polar((d.getBoardSize()/8.0)*8, i))).isEqualTo(20);
        }
    }
    @Test
    void Darts_evaluatePointsFromThrow_6P2Points() {
        Darts d = new Darts(2,3,4);
        for (int i = 351; i < 369; i++) {
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
    void Darts_iterateToNextPlayerTestAndGetCurrentPlayerIndexTestScenario1(){
        Darts d = new Darts(2,100,2);
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(1);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(1);
    }
    @Test
    void Darts_iterateToNextPlayerTestAndGetCurrentPlayerIndexTestScenario2(){
        Darts d = new Darts(3,100,2);
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(1);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(2);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
    }
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

    @ParameterizedTest(name = "Testing unreachable points ({0} point(s)).")
    @ValueSource(ints={-1,-2,-4,-7,-9,61,62,63,80})
    void Player_TestUseThrowImpossiblePointsReached(int value){
        Player p = new Player("Player 1",4,9999);
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
    void Darts_GetPlayerByName(){
        Darts d = new Darts(3, 300, 3);
        assertThat(d.getPlayerByName("Player 0")).isNotEqualTo(null);
        assertThat(d.getPlayerByName("Player 1")).isNotEqualTo(null);
        assertThat(d.getPlayerByName("Player 2")).isNotEqualTo(null);
        assertThat(d.getPlayerByName("Player 3")).isEqualTo(null);
        assertThat(d.getPlayerByName("1321")).isEqualTo(null);
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
                        "Currently at 98 points");

        p.useThrow(51);
        p.useThrow(35);
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 10 points\n" +
                        " -throw 2 : 1 point\n" +
                        " -throw 3 : 51 points\n" +
                        " -throw 4 : 35 points\n" +
                        " -throw 5 : 0 points\n" +
                        "Currently at 98 points");

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
        p.resetPlayerTurn();
        assertThat(p.toString()).isEqualTo(
                "PLAYER:Player 1\n" +
                        " -throw 1 : 0 points\n" +
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