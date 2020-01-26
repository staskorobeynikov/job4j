package ru.job4j.tictactoegame;

import java.util.List;

/**
 * Class launches game TicTacToeGame difficult level.
 *
 * @author STAS KOROBEYNIKOV.
 * @since 18.01.2020.
 */
public class HardTicTacToeGame extends TicTacToeGame {

    HardTicTacToeGame(Input input, Field field, Game game, List<Gamer> gamers) {
        super(input, field, game, gamers);
    }

    /**
     * Method for launch game.
     */
    @Override
    public void startGame() {
        int userWins = 0;
        int computerWins1 = 0;
        int computerWins2 = 0;
        do {
            game.initGame(input, field);
            boolean result = field.isFreeCell();
            while (result) {
                for (Gamer gamer : gamers) {
                    game.completeMove(input, field, gamer, gamer.setUseSymbol());
                    if (field.checkCombination(gamer.setUseSymbol())) {
                        System.out.println(String.format("Winner is: %s.", gamer.getName()));
                        if (gamer.getName().equals("User")) {
                            userWins++;
                            if (userWins == 5) {
                                System.out.println(String.format("In the game won 5 times: %s.", gamer.getName()));
                            }
                        } else if (gamer.getName().equals(gamers.get(0).getName())) {
                            computerWins1++;
                            if (computerWins1 == 5) {
                                System.out.println(String.format("In the game won 5 times: %s.", gamer.getName()));
                            }
                        } else {
                            computerWins2++;
                            if (computerWins2 == 5) {
                                System.out.println(String.format("In the game won 5 times: %s.", gamer.getName()));
                            }
                        }
                        result = false;
                        break;
                    }
                    if (!field.isFreeCell()) {
                        System.out.println("Draw.");
                        result = false;
                        break;
                    }

                }
            }
        } while (userWins != 5 && computerWins1 != 5 && computerWins2 != 5);
    }

    public static void main(String[] args) {
        new HardTicTacToeGame(
                new ValidateInput(new ConsoleInput()),
                new PlayingField(),
                new SimpleGame(),
                List.of(new User(), new Computer("Computer1", "O"))).startGame();
    }

}
