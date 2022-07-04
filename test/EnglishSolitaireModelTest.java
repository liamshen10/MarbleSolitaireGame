import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Represents initializations of English Marble Solitaire games, to be tested.
 */
public class EnglishSolitaireModelTest {
  private MarbleSolitaireModel test1;
  private MarbleSolitaireModel test2;
  private MarbleSolitaireModel test3;
  private MarbleSolitaireModel test4;
  private MarbleSolitaireModel model;

  @Before
  public void init() {
    test1 = new EnglishSolitaireModel();
    test2 = new EnglishSolitaireModel(4, 4);
    test3 = new EnglishSolitaireModel(11);
    test4 = new EnglishSolitaireModel(13 ,6,  12);
    model = new EnglishSolitaireModel(7, 7, 7);
  }

  /**
   * Testing to see if the second constructor is valid.
   */
  @Test
  public void InvalidConstructorTwoTest() {
    try {
      EnglishSolitaireModel at3c2invalid2test1 = new EnglishSolitaireModel(-1, 6);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c2invalid2test2 = new EnglishSolitaireModel(-5, -8);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c2invalid2test3 = new EnglishSolitaireModel(7, -5);
      fail();
    }
    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c2invalid2test4 = new EnglishSolitaireModel(8, 9);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c2invalid2test5 = new EnglishSolitaireModel(-1, -1);
      fail();
    }
    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c2invalid2test6 = new EnglishSolitaireModel(7, 7);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }
  }

  /**
   * Testing if the third constructor is valid.
   */
  @Test
  public void InvalidConstructorThreeTest() {
    try {
      EnglishSolitaireModel at0c3 = new EnglishSolitaireModel(0);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at2c3 = new EnglishSolitaireModel(2);
      fail();
    }
    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at10c3 = new EnglishSolitaireModel(10);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at36c3 = new EnglishSolitaireModel(36);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at98c3 = new EnglishSolitaireModel(98);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }
  }

  /**
   * Testing if fourth constructor is valid.
   */
  @Test
  public void InvalidConstructorFourTest() {
    try {
      EnglishSolitaireModel at3c4test1 = new EnglishSolitaireModel(3, 0, 1);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c4test2 = new EnglishSolitaireModel(3, 0, 5);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c4test3 = new EnglishSolitaireModel(3, 6, 0);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at3c4test4 = new EnglishSolitaireModel(3, 5, 6);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at4c4test5 = new EnglishSolitaireModel(4, 3, 3);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at4c4test6 = new EnglishSolitaireModel(3, -1, 7);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at4c4test7 = new EnglishSolitaireModel(3, -1, 6);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at4c4test8 = new EnglishSolitaireModel(3, 4, 8);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }

    try {
      EnglishSolitaireModel at4c4test9 = new EnglishSolitaireModel(3, 7, 8);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the constructor is valid, hence failing the invalid test
    }
  }

  /**
   * Testing if the move is invalid.
   */
  @Test
  public void invalidMove() {
    try {
      test1.move(8, 2, 6, 2);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }
    try {
      test1.move(3, 5, 3, 7);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }

    try {
      test2.move(4, 4, 6, 4);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }

    try {
      test1.move(2, 2, 4, 2);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }

    try {
      test1.move(2, 3, 4, 3);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }

    try {
      test3.move(11, 11, 14, 11);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }

    try {
      test1.move(2, 2, 3, 3);
      fail();
    }

    catch (IllegalArgumentException x) {
      // If it reaches this code, the move is valid, hence failing the invalid test
    }
  }

  /**
   * Testing the game play, testing methods move(),
   * isGameOver(), and getScore().
   */
  @Test
  public void currentGameMoveScoreAndGameOver() {
    assertEquals(false, test1.isGameOver());
    assertEquals(32, test1.getScore());
    test1.move(3, 1 ,3,3);

    assertEquals(false, test1.isGameOver());
    assertEquals(31, test1.getScore());
    test1.move(5,2,3,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(30, test1.getScore());
    test1.move(4,4,4,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(29, test1.getScore());
    test1.move(2,3,4,3);

    assertEquals(false, test1.isGameOver());
    assertEquals(28, test1.getScore());
    test1.move(0,3,2,3);

    assertEquals(false, test1.isGameOver());
    assertEquals(27, test1.getScore());
    test1.move(4,2,4,4);

    assertEquals(false, test1.isGameOver());
    assertEquals(26, test1.getScore());
    test1.move(5,4,5,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(25, test1.getScore());
    test1.move(4,0,4,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(24, test1.getScore());
    test1.move(2,0,4,0);

    assertEquals(false, test1.isGameOver());
    assertEquals(23, test1.getScore());
    test1.move(2,2,2,0);

    assertEquals(false, test1.isGameOver());
    assertEquals(22, test1.getScore());
    test1.move(0,2,2,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(21, test1.getScore());
    test1.move(2,3,2,1);

    assertEquals(false, test1.isGameOver());
    assertEquals(20, test1.getScore());
    test1.move(2,0,2,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(19, test1.getScore());
    test1.move(3,2,1,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(18, test1.getScore());
    test1.move(5,2,3,2);

    assertEquals(false, test1.isGameOver());
    assertEquals(17, test1.getScore());
    test1.move(2,5,2,3);

    assertEquals(false, test1.isGameOver());
    assertEquals(16, test1.getScore());
    test1.move(3,5,3,3);

    assertEquals(false, test1.isGameOver());
    assertEquals(15, test1.getScore());
    test1.move(4,5,4,3);

    assertEquals(false, test1.isGameOver());
    assertEquals(14, test1.getScore());
    test1.move(3,2,3,4);

    assertEquals(false, test1.isGameOver());
    assertEquals(13, test1.getScore());
    test1.move(0,4,2,4);

    assertEquals(false, test1.isGameOver());
    assertEquals(12, test1.getScore());
    test1.move(2,3,2,5);

    assertEquals(false, test1.isGameOver());
    assertEquals(11, test1.getScore());
    test1.move(2,6,2,4);

    assertEquals(false, test1.isGameOver());
    assertEquals(10, test1.getScore());
    test1.move(2,4,4,4);

    assertEquals(false, test1.isGameOver());
    assertEquals(9, test1.getScore());
    test1.move(4,3,4,5);

    assertEquals(false, test1.isGameOver());
    assertEquals(8, test1.getScore());
    test1.move(4,6,2,6);

    assertEquals(true, test1.isGameOver());
    assertEquals(7, test1.getScore());
  }

  /**
   * Testing method getBoardSize() to
   * return the size of the game board.
   */
  @Test
  public void getBoardSize() {
    assertEquals(7, test1.getBoardSize());
    assertEquals(7, test2.getBoardSize());
    assertEquals(31, test3.getBoardSize());
    assertEquals(37, test4.getBoardSize());
    assertEquals(19, model.getBoardSize());
  }

  /**
   * Tests getSlotAt() to determine whether
   * it is Empty, Marble, or Invalid at a given slot.
   */
  @Test
  public void getSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, test1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, test2.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, test3.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, test4.getSlotAt(6, 12));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, test4.getSlotAt(13, 13));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(18, 18));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(17, 0));
  }
}

