package cs3500.marblesolitaire.controller;


import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Returns a Marble Solitaire Controller based off of MarbleSolitaireController interface,
 * that implements the model, view, and a user input as a MarbleSolitaireModel,
 * MarbleSolitaireView, and Readable, respectively.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView output;
  private final Readable input;

  /**
   * Returns the controller of the main method, taking in the model, output, and input.
   *
   * @param model  is a MarbleSolitaireModel
   * @param output is an appendable object within the MarbleSolitaireView
   * @param input  is a Readable user input.
   * @throws IllegalArgumentException if model, output, or input equals null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView output, Readable input)
          throws IllegalArgumentException {
    if (model == null || output == null || input == null) {
      throw new IllegalArgumentException("Object is null");
    }
    this.model = model;
    this.output = output;
    this.input = input;
  }

  /**
   * Controls the play game based off of the user inputs.
   *
   * @throws IllegalStateException if there are no more readable objects in user input query,
   *                               or if the output cannot be transmitted.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(this.input);
    int index = 0;
    int[] moveCoordinates = new int[4];
    boolean quit = false;

    while (!this.model.isGameOver() && !quit) {
      this.renderBoardHelper();
      this.addScore();

      while (index < 4) {
        if (!scan.hasNext()) {
          throw new IllegalStateException("No more readable objects");
        }
        String baseString = scan.next();
        try {
          int base = Integer.parseInt(baseString);
          if (base > 0) {
            moveCoordinates[index] = base - 1;
            index = index + 1;

          } else {
            this.renderMessageHelper("Not a valid positive input. Try again!");
          }
        } catch (NumberFormatException e) {
          if (baseString.equalsIgnoreCase("q")) {
            this.isQuit();
            quit = true;
            break;
          }
        }
      }
      if (index == 4) {
        try {
          this.model.move(moveCoordinates[0], moveCoordinates[1],
                  moveCoordinates[2], moveCoordinates[3]);
        } catch (IllegalArgumentException e) {
          this.renderMessageHelper("Invalid move chump, try again!\n");
        }
        index = 0;
      }
      if (model.isGameOver()) {
        this.renderMessageHelper("Game over!\n");
        this.renderBoardHelper();
        this.addScore();
      }
    }
  }


  private void isQuit() {
    try {
      this.output.renderMessage("Game quit!\n");
      this.output.renderMessage("State of game when quit:\n");
      this.output.renderBoard();
      this.output.renderMessage("\n");
      this.addScore();
    } catch (IOException e) {
      throw new IllegalStateException("Output cannot be transmitted");
    }
  }

  private void renderMessageHelper(String input) {
    try {
      this.output.renderMessage(input);
    } catch (IOException e) {
      throw new IllegalStateException("Output cannot be transmitted");
    }
  }

  private void renderBoardHelper() {
    try {
      this.output.renderBoard();
      this.renderMessageHelper("\n");
    } catch (IOException e) {
      throw new IllegalStateException("Output cannot be transmitted");
    }
  }

  private void addScore() {
    try {
      String baseScore = "Score: " + this.model.getScore() + "\n";
      this.output.renderMessage(baseScore);
      this.renderMessageHelper("\n");
    } catch (IOException x) {
      throw new IllegalStateException("Output cannot be transmitted");
    }
  }
}









