package uk.ashleybye.tictactoe.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uk.ashleybye.tictactoe.core.Game;
import uk.ashleybye.tictactoe.core.GameReport;
import uk.ashleybye.tictactoe.core.board.Board.InvalidSquareNumber;
import uk.ashleybye.tictactoe.core.board.Board.SquareUnavailable;

public class MockGame extends Game {

  private List<Boolean> isGameOver = new ArrayList<>();
  private int numberOfTimesIsGameOverCalled = 0;
  private int getNumberOfTimesGenerateGameReportCalled = 0;
  private boolean throwInvalidSquareNumber = false;
  private boolean throwSquareUnavailable = false;

  public MockGame() {
    super(null, null, new MockEmptyMark());
  }

  @Override
  public List<Integer> listOpenPositions() {
    return Arrays.asList(4, 5, 6);
  }

  @Override
  public Game playNextTurn() {
    if (throwInvalidSquareNumber) {
      throw new InvalidSquareNumber();
    }
    if (throwSquareUnavailable) {
      throw new SquareUnavailable();
    }
    return this;
  }

  @Override
  public boolean isGameOver() {
    return isGameOver.get(numberOfTimesIsGameOverCalled++);
  }

  @Override
  public GameReport generateGameReport() {
    getNumberOfTimesGenerateGameReportCalled++;
    return new GameReport();
  }

  public void addIsGameOver(Boolean isGameOver) {
    this.isGameOver.add(isGameOver);
  }

  public void setThrowInvalidSquareNumber() {
    throwInvalidSquareNumber = true;
  }

  public void setThrowSquareUnavailable() {
    throwSquareUnavailable = true;
  }

  public int getNumberOfTimesIsGameOverCalled() {
    return numberOfTimesIsGameOverCalled;
  }

  public int getNumberOfTimesGenerateGameReportCalled() {
    return getNumberOfTimesGenerateGameReportCalled;
  }
}
