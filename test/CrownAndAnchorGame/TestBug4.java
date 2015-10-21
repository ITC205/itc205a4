package CrownAndAnchorGame;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Bug 4: Simulation turns are not random.
 */
public class TestBug4
{
  @Test
  public void tenRounds_diceValuesShouldBeDifferent()
  {
    // given 10 rounds
    int rounds = 10;
    int matches = 0;
    String[] valuesFromRounds = new String[rounds];

    // with similar setup to Main (game simulation)
    Dice d1 = new Dice();
    Dice d2 = new Dice();
    Dice d3 = new Dice();

    Player player = new Player("Fred", 100);
    Game game = new Game(d1, d2, d3);
    List<DiceValue> cdv = game.getDiceValues();

    for (int i = 0; i < rounds; i++) {
      int bet = 5;
      DiceValue pick = DiceValue.getRandom();

      int winnings = game.playRound(player, pick, bet);
      cdv = game.getDiceValues();

      // when evaluate dice values in each round
      valuesFromRounds[i] = String.format("Rolled %s, %s, %s\n",
                                          cdv.get(0), cdv.get(1), cdv.get(2));

    }

    for (int j = 1; j < rounds; j++) {
      if (valuesFromRounds[0].equals(valuesFromRounds[j])) {
        matches++;
      }
    }

    // then the same values should not be rolled in all rounds
    // note there are 9 potential matches to first round values
    assertThat(matches).isLessThan(rounds - 1);
  }

}

