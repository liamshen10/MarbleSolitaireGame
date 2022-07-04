package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Represents a MarbleSolitaireModelStateTextView that takes in a model,
 * and an appendable object.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private final MarbleSolitaireModelState model;
  private final Appendable apObject;


  /**
   * Represents a MarbleSolitaireTextView that
   * takes in a MarbleSolitaireModelState, with a destination of System.out.
   *
   * @param model represents a MarbleSolitaireModelState
   * @throws IllegalArgumentException if the given MarbleSolitaireModelState
   *                                  is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    this(model, System.out);
  }

  /**
   * Represents a MarbleSolitaireTextView that
   * takes in a MarbleSolitaireModelState, as well as an
   * Appendable object.
   *
   * @param model    represents a MarbleSolitaireModelState
   * @param apObject represents an appendable object
   * @throws IllegalArgumentException if the model or the appendable is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable apObject)
          throws IllegalArgumentException {
    if (model == null || apObject == null) {
      throw new IllegalArgumentException("This provided model or object is null");
    }
    this.apObject = apObject;
    this.model = model;
  }

  @Override
  public String toString() {
    int size = model.getBoardSize();
    int armThickness = (size + 2) / 3;
    int armGap = (size - armThickness) / 2;
    StringBuilder base = new StringBuilder();
    for (int rowNumb = 0; rowNumb < size; rowNumb++) {
      for (int colNumb = 0; colNumb < size; colNumb++) {
        if (model.getSlotAt(rowNumb, colNumb) == SlotState.Marble) {
          base.append("O");
        }
        if (model.getSlotAt(rowNumb, colNumb) == SlotState.Empty) {
          base.append("_");
        }
        if (model.getSlotAt(rowNumb, colNumb) == SlotState.Invalid) {
          base.append(" ");
        }
        if (this.checkRightCorners(rowNumb, colNumb, size, armGap)) {
          break;
        }
        base.append(" ");
      }
      if (rowNumb > size - 2) {
        break;
      }
      base.append("\n");
    }
    return base.toString();
  }

  @Override
  public void renderBoard() throws IOException {
    this.apObject.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.apObject.append(message);
  }

  private boolean checkRightCorners(int rowNumb, int colNumb, int size, int armGap) {
    return (((rowNumb >= size - armGap) && colNumb >= size - armGap - 1)
            || (rowNumb < armGap && colNumb >= size - armGap - 1)
            || colNumb > size - 2);
  }
}

