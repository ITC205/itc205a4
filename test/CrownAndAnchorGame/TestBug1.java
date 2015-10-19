package CrownAndAnchorGame;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestBug1
{

  @Test
  public void winningWithOneMatch_increasesBalanceByWinnings()
  {
    // Given a game that has 2 dice with the same value, and a third with a
    // different value
    Dice d1 = new Dice();
    Dice d2 = d1;
    Dice d3;
    do {
      d3 = new Dice();
    }
    while (d3.getValue().toString().equals(d1.getValue().toString()));
    Game game = new Game(d1, d2, d3);
    // and a player with a starting balance of $100 who bets $5
    Player player = new Player("Fred", 100);
    int bet = 5;
    int startingBalance = player.getBalance(); // = $100

    // when the player rolls a match to the third dice
    DiceValue pick = d3.getValue();
    int winnings = game.playRound(player, pick, bet);

    // then player's balance should be increased by the amount of the winnings
    int finalBalance = player.getBalance();
    assertThat(finalBalance).isEqualTo(startingBalance + winnings);
  }
}
