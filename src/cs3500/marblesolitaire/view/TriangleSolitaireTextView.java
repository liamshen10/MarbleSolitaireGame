package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class TriangleSolitaireTextView implements MarbleSolitaireView{

  private final MarbleSolitaireModelState model;
  private final Appendable apObject;

  public TriangleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
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
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable apObject)
          throws IllegalArgumentException {
    if (model == null || apObject == null) {
      throw new IllegalArgumentException("This provided model or object is null");
    }
    this.apObject = apObject;
    this.model = model;
  }
  @Override
  public String toString() {

    return "";
  }

  @Override
  public void renderBoard() throws IOException {
    this.apObject.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.apObject.append(message);
  }
}
