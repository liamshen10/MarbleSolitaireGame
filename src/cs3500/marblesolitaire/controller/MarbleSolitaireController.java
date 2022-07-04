package cs3500.marblesolitaire.controller;

/**
 * This interface represents operations that should be offered by
 * a controller for the Marble solitaire game.
 */
public interface MarbleSolitaireController {

  /**
   * Allows the play through of a marble solitaire game using user inputs
   * from the controller, model, and appendable object within the view class.
   *
   * @throws IllegalStateException if the if there are no more readable objects in user
   *                               input query, or if the output cannot be transmitted.
   */
  void playGame() throws IllegalStateException;
}
