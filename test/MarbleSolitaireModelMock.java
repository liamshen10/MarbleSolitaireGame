import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * MarbleSolitaireModelMock that implements MarbleSolitaireModel and is a mock of the model,
 * that takes in a string builder.
 */
public class MarbleSolitaireModelMock implements MarbleSolitaireModel {

  private final StringBuilder baseString;

  MarbleSolitaireModelMock(StringBuilder baseString) {
    this.baseString = Objects.requireNonNull(baseString);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    baseString.append(fromRow + " " + fromCol + " " + toRow + " " + toCol + " ");
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
