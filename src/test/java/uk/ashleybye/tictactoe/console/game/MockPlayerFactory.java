package uk.ashleybye.tictactoe.console.game;

import java.util.Arrays;
import java.util.List;
import uk.ashleybye.tictactoe.console.MockPlayer;
import uk.ashleybye.tictactoe.console.MockPlayerOneMark;
import uk.ashleybye.tictactoe.console.MockPlayerTwoMark;
import uk.ashleybye.tictactoe.core.player.Player;
import uk.ashleybye.tictactoe.core.player.PlayerConfiguration;

public class MockPlayerFactory extends ConsolePlayerFactory {

  public MockPlayerFactory() {
    super(null);
  }

  @Override
  public List<String> listPlayerTypes() {
    return Arrays.asList("human", "easy", "hard");
  }

  @Override
  public Player make(PlayerConfiguration playerConfiguration) {
    if (playerConfiguration.getPlayerType().equals("1")) {
      return new MockPlayer(new MockPlayerOneMark(), playerConfiguration.getPlayerName());
    } else {
      return new MockPlayer(new MockPlayerTwoMark(), playerConfiguration.getPlayerName());
    }
  }
}
