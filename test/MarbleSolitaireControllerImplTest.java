import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * MarbleSolitaireControllerImplTest class that tests the MarbleSolitaireControllerImpl
 * using an appendable object, model, view, and user input.
 */
public class MarbleSolitaireControllerImplTest {
  private Appendable apObject;
  private MarbleSolitaireModel model;
  private MarbleSolitaireView output;
  private Readable userInput;
  private MarbleSolitaireController controller1;

  @Before
  public void initialConditions() {
    apObject = new StringBuilder();
    model = new EnglishSolitaireModel();
    output = new MarbleSolitaireTextView(model, apObject);
  }

  @Test
  public void testNullInput() {
    try {
      Readable userInput = null;
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();
    } catch (IllegalArgumentException e) {
      //If it reaches here, the input is not null.
    }
  }

  @Test
  public void testNullModel() {
    try {
      userInput = new StringReader("6 2 1 3 q");
      MarbleSolitaireModel model = null;
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();
    } catch (IllegalArgumentException e) {
      //If it reaches here, the model is not null.
    }
  }

  @Test
  public void testNullAppendableObject() {
    try {
      userInput = new StringReader("3 4 2 4 q");
      Appendable apObject = null;
      MarbleSolitaireView output = new MarbleSolitaireTextView(model, apObject);
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      fail();
    } catch (IllegalArgumentException e) {
      //If it reaches here, the model is not null.
    }
  }

  @Test
  public void testNullAll() {
    try {
      Readable userInputNull = null;
      Appendable apObjectNull = null;
      MarbleSolitaireModel modelNull = null;
      MarbleSolitaireView outputNull = new MarbleSolitaireTextView(model, apObjectNull);
      controller1 = new MarbleSolitaireControllerImpl(modelNull, outputNull, userInputNull);
      controller1.playGame();
      fail();
    } catch (IllegalArgumentException e) {
      ////If it reaches here, the model or appendable is not null.
    }
  }

  @Test
  public void testNoQuitInputtingMoves() {
    try {
      userInput = new StringReader("2 4 4 4");
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();

    } catch (IllegalStateException e) {
      // If it reaches this code, the move is invalid, hence failing the move.
    }

    try {
      userInput = new StringReader(" 3 5 5 3");
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();

    } catch (IllegalStateException e) {
      // If it reaches this code, the move is invalid, hence failing the move.
    }

    try {
      userInput = new StringReader("");
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();

    } catch (IllegalStateException e) {
      // If it reaches this code, the move is invalid, hence failing the move.
    }

    try {
      userInput = new StringReader(" 7 8 17 0 1 69 8 2");
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();

    } catch (IllegalStateException e) {
      // If it reaches this code, the move is invalid, hence failing the move.
    }

    try {
      userInput = new StringReader(" " +
              " " +
              " " +
              "                ");
      controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
      controller1.playGame();
      fail();

    } catch (IllegalStateException e) {
      // If it reaches this code, the move is invalid, hence failing the move.
    }
  }

  @Test
  public void testStringInvalidInput() {
    userInput = new StringReader("String Bob pog not to hello q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMultipleStringInputs() {
    userInput = new StringReader("2 String Bob 4 pog not to 4 4 hello q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMultipleCharInputs() {
    userInput = new StringReader("2 4 4 s b p n t h 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testCharInvalidInput() {
    userInput = new StringReader("a q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testNegativeInputOne() {
    userInput = new StringReader("4 3 -2 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Not a valid positive input. Try again!Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testNegativeInputTwo() {
    userInput = new StringReader("4 -3 -2 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Not a valid positive input. Try again!Not a valid positive input. " +
            "Try again!Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testNegativeInputThree() {
    userInput = new StringReader("-4 -3 -2 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Not a valid positive input. Try again!Not a valid positive input. Try again!" +
            "Not a valid positive input. Try again!Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testNegativeInputAll() {
    userInput = new StringReader("-4 -3 -2 -4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Not a valid positive input. Try again!Not a valid positive input. Try again!" +
            "Not a valid positive input. Try again!Not a valid positive input. Try again!" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }


  @Test
  public void testQuitLowercaseAll() {
    userInput = new StringReader("q q q q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitLowercaseOne() {
    userInput = new StringReader("5 4 q 3");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitLowercaseTwo() {
    userInput = new StringReader("q 4 q 3");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitLowercaseThree() {
    userInput = new StringReader("q q q 3");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitUppercaseAll() {
    userInput = new StringReader("Q Q Q Q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitUppercaseOne() {
    userInput = new StringReader("5 4 Q 3");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitUppercaseTwo() {
    userInput = new StringReader("Q 4 Q 3");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testQuitUppercaseThree() {
    userInput = new StringReader("Q Q Q 3");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testGameOver() {
    userInput = new StringReader("4 2 4 4 6 3 4 3 5 5 5 3 3 4 " +
            "5 4 1 4 3 4 5 3 5 5 6 5 6 3 5 1 5 3 3 1 5 1 3 3 3 1 " +
            "1 3 3 3 3 4 3 2 3 1 3 3 4 3 2 3 6 3 4 3 3 6 3 4 4 6 " +
            "4 4 5 6 5 4 4 3 4 5 1 5 3 5 3 4 3 6 3 7 3 5 3 5 5 5 " +
            "5 4 5 6 5 7 3 7");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O O _ _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O _ O _ O O O\n" +
            "O O O O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "O O O O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "O O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "O O _ _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "_ _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "_ O O O O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "\n" +
            "    _ _ O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "\n" +
            "    _ _ O\n" +
            "    _ _ O\n" +
            "O O _ _ O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "\n" +
            "    _ _ O\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ O O O\n" +
            "_ _ _ _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ _ _ O O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O _ _ _ O O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ _ O O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ O O _ O\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 12\n" +
            "\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 11\n" +
            "\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 10\n" +
            "\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ O O _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 9\n" +
            "\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 8\n" +
            "\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "O _ _ _ _ O _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 7\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveUpDir() {
    userInput = new StringReader("6 4 4 4 Q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveDownDir() {
    userInput = new StringReader("2 4 4 4 Q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveLeftDir() {
    userInput = new StringReader("4 6 4 4 Q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveRightDir() {
    userInput = new StringReader("4 2 4 4 Q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testLargeMove() {
    userInput = new StringReader("400291 6918272 4127636 41364684 Q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testDiagonalMoveDown() {
    userInput = new StringReader("4 2 5 3 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testDiagonalMoveUp() {
    userInput = new StringReader("4 2 3 1 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveFromInvalidRow() {
    userInput = new StringReader("9 3 7 3 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());

  }

  @Test
  public void testMoveFromInvalidCol() {
    userInput = new StringReader("3 9 3 7 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveToInvalidCol() {
    userInput = new StringReader("4 6 4 8 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testMoveToInvalidRow() {
    userInput = new StringReader("6 4 8 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testInvalidMoveFromNoMarble() {
    userInput = new StringReader("4 4 2 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testInvalidMoveToNotEmpty() {
    userInput = new StringReader("3 3 5 3 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testInvalidMoveEmptySlotJump() {
    userInput = new StringReader("4 3 4 5 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testInvalidMoreThanTwo() {
    userInput = new StringReader("3 3 6 3 q");
    controller1 = new MarbleSolitaireControllerImpl(model, output, userInput);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Invalid move chump, try again!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n", apObject.toString());
  }

  @Test
  public void testValidMockInput() {
    Readable userInput1 = new StringReader(" 4 2 4 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("3 1 3 3 ", baseString.toString());
  }

  @Test
  public void testValidMockInputTwo() {
    Readable userInput1 = new StringReader("3 6 3 2 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("2 5 2 1 ", baseString.toString());
  }

  @Test
  public void testInvalidNegMockInput() {
    Readable userInput1 = new StringReader("-4 2 4 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("", baseString.toString());
  }

  @Test
  public void testInvalidNegTwoMockInput() {
    Readable userInput1 = new StringReader("-4 2 -4 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("", baseString.toString());
  }

  @Test
  public void testInvalidFromMockInput() {
    Readable userInput1 = new StringReader("9 4 7 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("8 3 6 3 ", baseString.toString());
  }

  @Test
  public void testInvalidToMockInput() {
    Readable userInput1 = new StringReader("7 4 9 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("6 3 8 3 ", baseString.toString());
  }

  @Test
  public void testEndgameMockInput() {
    Readable userInput1 = new StringReader("4 2 4 4 6 3 4 3 5 5 5 3 3 4 " +
            "5 4 1 4 3 4 5 3 5 5 6 5 6 3 5 1 5 3 3 1 5 1 3 3 3 1 " +
            "1 3 3 3 3 4 3 2 3 1 3 3 4 3 2 3 6 3 4 3 3 6 3 4 4 6 " +
            "4 4 5 6 5 4 4 3 4 5 1 5 3 5 3 4 3 6 3 7 3 5 3 5 5 5 " +
            "5 4 5 6 5 7 3 7 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("3 1 3 3 5 2 3 2 4 4 4 2 2 3 4 3 0 3 2 3 4 2 4 4 5 4 5 2 " +
            "4 0 4 2 2 0 4 0 2 2 2 0 0 2 2 2 2 3 2 1 2 0 2 2 3 2 1 2 5 2 3 2 2 5 " +
            "2 3 3 5 3 3 4 5 4 3 3 2 3 4 0 4 2 4 2 3 2 5 2 6 2 4 2 4 4 4 4 3 4 " +
            "5 4 6 2 6 ", baseString.toString());
  }

  @Test
  public void testInvalidStringMockInput() {
    Readable userInput1 = new StringReader("String box mine pog to q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("", baseString.toString());
  }

  @Test
  public void testInvalidCharMockInput() {
    Readable userInput1 = new StringReader("a b j k i q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("", baseString.toString());
  }

  @Test
  public void testLowercaseQMockInput() {
    Readable userInput1 = new StringReader("q q q q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("", baseString.toString());
  }

  @Test
  public void testUppercaseQMockInput() {
    Readable userInput1 = new StringReader("Q Q Q Q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("", baseString.toString());
  }

  @Test
  public void testLargeMockInput() {
    Readable userInput1 = new StringReader("100000 20000 210000 90000 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("99999 19999 209999 89999 ", baseString.toString());
  }

  @Test
  public void testDiagonalMockInput() {
    Readable userInput1 = new StringReader("2 3 3 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("1 2 2 3 ", baseString.toString());
  }

  @Test
  public void testValidIntAndStringMockInput() {
    Readable userInput1 = new StringReader("String 2 4 box mine 4 pog to 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("1 3 3 3 ", baseString.toString());
  }

  @Test
  public void testValidIntAndCharMockInput() {
    Readable userInput1 = new StringReader("S 2 4 b m 4 p t 4 q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("1 3 3 3 ", baseString.toString());
  }

  @Test
  public void testValidCombination() {
    Readable userInput1 = new StringReader("S 245 4 b m 4 p t 4 lots 87 6 m string hello man q");
    StringBuilder baseString = new StringBuilder();
    MarbleSolitaireModelMock mockModel = new MarbleSolitaireModelMock(baseString);
    MarbleSolitaireView output = new MarbleSolitaireTextView(mockModel, System.out);
    controller1 = new MarbleSolitaireControllerImpl(mockModel, output, userInput1);
    controller1.playGame();
    assertEquals("244 3 3 3 ", baseString.toString());
  }
}

