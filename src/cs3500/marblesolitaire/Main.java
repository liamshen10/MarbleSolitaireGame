package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Main class that contains the main method that runs the marble solitaire game.
 */
public class Main {
  /**
   * Main method that runs the english solitaire game, allowing users to play as well.
   *
   * @param args is an array Strings used to read inputs and output streams
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);
    Readable userInput = new InputStreamReader(System.in);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, view, userInput);
    controller.playGame();
  }
}





