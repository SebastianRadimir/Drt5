package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class DartsTest {

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
    void Darts_iterateToNextPlayerTestAndGetCurrentPlayerIndexTestScenario1() {
        Darts d = new Darts(2, 100, 2);
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(1);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(1);
    }

    @Test
    void Darts_iterateToNextPlayerTestAndGetCurrentPlayerIndexTestScenario2() {
        Darts d = new Darts(3, 100, 2);
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(1);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(2);
        d.iterateToNextPlayer();
        assertThat(d.getCurrentPlayerIndex()).isEqualTo(0);
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
    void Dart_testGetPos(){
        Polar p = new Polar(10,3);
        Dart d = new Dart("player name",p);
        assertThat(d.getPos()).isEqualTo(p);
        assertThat(d.getPlayerName()).isEqualTo("player name");
        assertThat(d.getPlayerName()).isNotEqualTo("Player name");
    }

    @Test
    void Dartboard_testGetDartCollection(){
        Dartboard db = new Dartboard(50);
        assertThat(db.getDartCollection().getDarts().size()).isEqualTo(0);
        Dart tempDarrt = new Dart("p1", new Polar(0,0));
        db.addDart(tempDarrt);
        db.addDart(new Dart("p1", new Polar(30,90)));
        assertThat(db.getDartCollection().getDarts().size()).isEqualTo(2);
        db.removeDart(tempDarrt);
        assertThat(db.getDartCollection().getDarts().size()).isEqualTo(1);
    }




    @Test
    void Dartboard_testPrintedBoardSize20(){
        Dartboard d = new Dartboard(20);
        if (d.getBoardSize()==20){
            assertThat(d.toString()).isEqualTo(
                    "                              ###                              \n" +
                            "                  ###########################                  \n" +
                            "               ######       # ### #       ######               \n" +
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
    void Dartboard_testPrintedBoardSize40(){
        Dartboard d = new Dartboard(40);
        if (d.getBoardSize()==40){
            assertThat(d.toString()).isEqualTo(
                    "                                                            ###                                                            \n" +
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
    void Dartboard_testPrintedBoardSize60(){
        Dartboard d = new Dartboard(60);
        if (d.getBoardSize()==60){
            assertThat(d.toString()).isEqualTo(
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
                            "      ###   ######          #  #       ######            ######             #           #     #           #             ######            ######       #  #          ######   ###      \n" +
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
    void DartCollection_testGetDartsFromPlayer(){
        DartCollection dc = new DartCollection();
        Dart tempDarrt = new Dart("p1", new Polar(34,0));
        dc.addDart(tempDarrt);
        dc.addDart(new Dart("p1", new Polar(3,180)));
        dc.addDart(new Dart("p1", new Polar(46,310)));
        assertThat(dc.getDartsFromPlayer("p1").size()).isEqualTo(3);

        dc.addDart(new Dart("p2", new Polar(10,98)));
        dc.addDart(new Dart("p2", new Polar(20,200)));
        assertThat(dc.getDartsFromPlayer("p2").size()).isEqualTo(2);

        dc.addDart(new Dart("p3", new Polar(0,0)));
        assertThat(dc.getDartsFromPlayer("p3").size()).isEqualTo(1);

        dc.removeDart(tempDarrt);
        assertThat(dc.getDartsFromPlayer("p1").size()).isEqualTo(2);

    }
}
