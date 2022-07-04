import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the MarbleSolitairetextView class.
 */
public class MarbleSolitaireTextViewTest {

  private MarbleSolitaireModel test1;
  private MarbleSolitaireModel test2;
  private MarbleSolitaireModel test3;
  private MarbleSolitaireModel test4;

  private MarbleSolitaireModel test5;

  private MarbleSolitaireModel model;
  private MarbleSolitaireTextView view;
  private MarbleSolitaireTextView view1;
  private MarbleSolitaireTextView view2;
  private MarbleSolitaireTextView view3;
  private MarbleSolitaireTextView view4;

  private MarbleSolitaireTextView view5;
  private Appendable apObjectNull;
  private MarbleSolitaireModelState nullModel;

  /**
   * Initial conditions of the board before running textview void methods.
   */
  @Before
  public void init() {
    test1 = new EnglishSolitaireModel();
    test2 = new EnglishSolitaireModel(4, 4);
    test3 = new EnglishSolitaireModel(11);
    test4 = new EnglishSolitaireModel(13, 6, 12);
    model = new EnglishSolitaireModel(7, 7, 7);
    test5 =  new EuropeanSolitaireModel();
    Appendable apObjectModel = new StringBuilder();
    apObjectNull = null;
    view = new MarbleSolitaireTextView(model, apObjectModel);
    view1 = new MarbleSolitaireTextView(test1, apObjectModel);
    view2 = new MarbleSolitaireTextView(test2, apObjectModel);
    view3 = new MarbleSolitaireTextView(test3, apObjectModel);
    view4 = new MarbleSolitaireTextView(test4, apObjectModel);
    view5 = new MarbleSolitaireTextView(test5, apObjectModel);
    nullModel = null;
  }

  /**
   * Testing if the view is invalid.
   */
  @Test
  public void invalidView() {
    try {
      MarbleSolitaireTextView nullModelObject = new MarbleSolitaireTextView(nullModel);
      fail();

    } catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      MarbleSolitaireTextView nullApObject = new MarbleSolitaireTextView(test2, apObjectNull);
      fail();

    } catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      MarbleSolitaireTextView nullApObject = new MarbleSolitaireTextView(test3, apObjectNull);
      fail();

    } catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      MarbleSolitaireTextView nullApObject = new MarbleSolitaireTextView(test4, apObjectNull);
      fail();

    } catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      MarbleSolitaireTextView nullBoth = new MarbleSolitaireTextView(nullModel, apObjectNull);
      fail();

    } catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }
  }

  /**
   * Testing the toString() method to view the game board.
   */
  @Test
  public void view() {
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O _ O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", view.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "    O O O\n" +
            "    O O O", view2.toString());
    assertEquals("                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O _ O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O", view3.toString());
    assertEquals("                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        _ O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O", view4.toString());
    assertEquals("", view5.toString());
  }

  /**
   * Tests the view method after making moves.
   */
  @Test
  public void viewAfterMove() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());
    test1.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());
    test1.move(5, 2, 3, 2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O", view1.toString());
    test1.move(4, 4, 4, 2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O O _ _ O O\n" +
            "    _ O O\n" +
            "    O O O", view1.toString());
    test1.move(2, 3, 4, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O _ O _ O O O\n" +
            "O O O O _ O O\n" +
            "    _ O O\n" +
            "    O O O", view1.toString());
    test1.move(0, 3, 2, 3);
    assertEquals("    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "O O O O _ O O\n" +
            "    _ O O\n" +
            "    O O O", view1.toString());
    test1.move(4, 2, 4, 4);
    assertEquals("    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "O O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O", view1.toString());
    test1.move(5, 4, 5, 2);
    assertEquals("    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "O O _ _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(4, 0, 4, 2);
    assertEquals("    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O O O\n" +
            "_ _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 0, 4, 0);
    assertEquals("    O _ O\n" +
            "    O _ O\n" +
            "_ O O O O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 2, 2, 0);
    assertEquals("    O _ O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(0, 2, 2, 2);
    assertEquals("    _ _ O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 3, 2, 1);
    assertEquals("    _ _ O\n" +
            "    _ _ O\n" +
            "O O _ _ O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 0, 2, 2);
    assertEquals("    _ _ O\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(3, 2, 1, 2);
    assertEquals("    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ O O O\n" +
            "_ _ _ _ O O O\n" +
            "O _ O _ O O O\n" +
            "    O _ _\n" +
            "    O O O", view1.toString());
    test1.move(5, 2, 3, 2);
    assertEquals("    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ O O O\n" +
            "_ _ O _ O O O\n" +
            "O _ _ _ O O O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 5, 2, 3);
    assertEquals("    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O _ _ _ O O O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(3, 5, 3, 3);
    assertEquals("    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ _ O O O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(4, 5, 4, 3);
    assertEquals("    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(3, 2, 3, 4);
    assertEquals("    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(0, 4, 2, 4);
    assertEquals("    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ O O _ O\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 3, 2, 5);
    assertEquals("    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 6, 2, 4);
    assertEquals("    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ O _ _ O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(2, 4, 4, 4);
    assertEquals("    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ O O _ O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(4, 3, 4, 5);
    assertEquals("    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ O O\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
    test1.move(4, 6, 2, 6);
    assertEquals("    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "O _ _ _ _ O _\n" +
            "    _ _ _\n" +
            "    O O O", view1.toString());
  }

  @Test
  public void testRenderBoard() {
    try {
      MarbleSolitaireView boardTest = new MarbleSolitaireTextView(model, new IOExceptionTest());
      boardTest.renderBoard();
      fail();
    } catch (IOException e) {
      //If it hits here then the fail is passed over, and it is not working.
    }
  }

  @Test
  public void renderMessage() {
    try {
      MarbleSolitaireView messageTest = new MarbleSolitaireTextView(model, new IOExceptionTest());
      messageTest.renderMessage("Pog");
      fail();
    } catch (IOException e) {
      //If it hits here then the fail is passed over, and it is not working.
    }
  }
}


