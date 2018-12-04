package uk.ashleybye.tictactoe.console;

import uk.ashleybye.tictactoe.console.game.ConsoleGameConfiguration;
import uk.ashleybye.tictactoe.console.game.ConsolePlayerConfiguration;
import uk.ashleybye.tictactoe.core.board.Mark;

public class MockGameConfiguration extends ConsoleGameConfiguration {

  @Override
  public ConsolePlayerConfiguration getPlayerConfiguration(int player) {
    if (player == 1) {
      return new ConsolePlayerConfiguration() {
        @Override
        public String getPlayerType() {
          return "1";
        }

        @Override
        public String getPlayerName() {
          return "Player 1";
        }

        @Override
        public Mark getPlayerMark() {
          return new MockPlayerOneMark();
        }
      };
    } else {
      return new ConsolePlayerConfiguration() {
        @Override
        public String getPlayerType() {
          return "2";
        }

        @Override
        public String getPlayerName() {
          return "Player 2";
        }

        @Override
        public Mark getPlayerMark() {
          return new MockPlayerTwoMark();
        }
      };
    }
  }

  @Override
  public Mark getEmptyMark() {
    return new MockEmptyMark();
  }
}
