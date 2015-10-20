package CrownAndAnchorGame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Bug 2: Player cannot reach betting limit.
 */
public class TestBug2
{
  @Test
  public void balanceFiveAndLimitOfZero_betFiveLoseFive_balanceIsZero()
  {
    // Given a game that has 3 dice with the same value
    // different value
    Dice d1 = new Dice();
    Game game = new Game(d1, d1, d1);
    // and a player with a starting balance of $5
    Player player = new Player("Fred", 5);
    // who bets $5
    int bet = 5;
    // with a limit of 0
    int limit = 0;
    player.setLimit(limit);
    // who unfortunately picks a different value to the 3 dice rolled
    DiceValue pick;
    do {
      pick = new Dice().getValue();
    }
    while (pick.toString().equals(d1.getValue().toString()));

    // when the player loses round
    game.playRound(player, pick, bet);

    // then player's balance should be equal to limit, which is zero
    int finalBalance = player.getBalance();
    assertThat(finalBalance).isEqualTo(limit).isEqualTo(0);
  }
}
