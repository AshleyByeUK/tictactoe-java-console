package uk.ashleybye.tictactoe.console;

import java.util.Objects;
import uk.ashleybye.tictactoe.core.Game;
import uk.ashleybye.tictactoe.core.board.Mark;
import uk.ashleybye.tictactoe.core.player.Player;
import uk.ashleybye.tictactoe.core.player.PlayerType;

public class MockPlayer implements Player {

  private final Mark mark;
  private final String name;

  public MockPlayer(Mark mark, String name) {
    this.mark = mark;
    this.name = name;
  }

  @Override
  public Mark getMark() {
    return mark;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int takeTurn(Game game) {
    return 0;
  }

  @Override
  public PlayerType getType() {
    return PlayerType.USER;
  }

  @Override
  public String toString() {
    return "MockPlayer{" + "mark=" + mark + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MockPlayer that = (MockPlayer) o;
    return Objects.equals(mark, that.mark) &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mark, name);
  }
}
