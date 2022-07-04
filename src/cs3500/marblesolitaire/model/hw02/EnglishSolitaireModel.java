package cs3500.marblesolitaire.model.hw02;

/**
 * Represents an English Marble Solitaire game that implements fields armThickness,
 * sCol, and sRow.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {
  private final int armThickness;
  private final int sCol;
  private final int sRow;
  private SlotState[][] gameBoard;

  /**
   * Represents an English Solitaire Game with arm thickness at 3, and empty center.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Represents an English Marble Solitaire game
   * with armThickness 3, and empty starting point at sRow, sCol.
   *
   * @param sRow represents row of starting point
   * @param sCol represents column of starting point
   * @throws IllegalArgumentException if the starting point is out of bounds
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Represents an English Marble Solitaire game with armThickness 3.
   *
   * @param armThickness represents the thickness of the arm
   * @throws IllegalArgumentException if the arm thickness is not positive and odd
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, ((3 * armThickness) - 2) / 2, ((3 * armThickness) - 2) / 2);
  }

  /**
   * Represents an English Marble Solitaire game with armThickness,
   * and empty starting point at sRow, sCol.
   *
   * @param armThickness represents thickness of the arm
   * @param sRow         represents starting point of the row
   * @param sCol         represents the starting point of the column
   * @throws IllegalArgumentException if armThickness is not a positive and odd integer,
   *                                  if starting point is off the board,
   *                                  or starting point is in one of the corners
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    int lengthOfBoard = (3 * armThickness) - 2;
    if (armThickness <= 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness must be a positive odd integer");
    }
    if ((sRow < 0 || sRow > lengthOfBoard - 1) || (sCol < 0 || sCol > lengthOfBoard - 1)) {
      throw new IllegalArgumentException("It is off the board");
    }
    if (checkCorner(armThickness, sRow, sCol)) {
      throw new IllegalArgumentException("It is in one of the corners");
    }
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    makeBoard();
  }

  private void makeBoard() {
    int lengthOfBoard = (3 * this.armThickness) - 2;
    this.gameBoard = new SlotState[lengthOfBoard][lengthOfBoard];
    for (int rowNumb = 0; rowNumb < lengthOfBoard; rowNumb++) {
      for (int colNumb = 0; colNumb < lengthOfBoard; colNumb++) {
        if (this.checkCorner(this.armThickness, rowNumb, colNumb)) {
          this.gameBoard[rowNumb][colNumb] = SlotState.Invalid;
        }
        if (!this.checkCorner(this.armThickness, rowNumb, colNumb)) {
          this.gameBoard[rowNumb][colNumb] = SlotState.Marble;
        }
        this.gameBoard[this.sRow][this.sCol] = SlotState.Empty;
      }
    }
  }

  /**
   * Tests if a marble is able to be moved in the gameBoard.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if checkValid move fails, hence going out of bounds,
   *                                  if jumped slot is empty, or if move is horizontal.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!checkValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("This is not a valid move");
    }
    this.gameBoard[toRow][toCol] = SlotState.Marble;
    this.gameBoard[fromRow][fromCol] = SlotState.Empty;
    this.gameBoard[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
  }

  @Override
  public boolean isGameOver() {
    int lengthOfBoard = this.gameBoard.length;
    for (int rowNumb = 0; rowNumb < lengthOfBoard; rowNumb++) {
      for (int colNumb = 0; colNumb < lengthOfBoard; colNumb++) {
        if ((this.getSlotAt(rowNumb, colNumb) == SlotState.Marble)
                && this.containsValidMove(rowNumb, colNumb)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return this.gameBoard.length;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < this.gameBoard.length || col < this.gameBoard.length
            || row >= 0 || col >= 0) {
      return this.gameBoard[row][col];
    }
    throw new IllegalArgumentException("This is off the board");
  }

  @Override
  public int getScore() {
    int lengthOfBoard = this.gameBoard.length;
    int score = 0;
    for (int rowNumb = 0; rowNumb < lengthOfBoard; rowNumb++) {
      for (int colNumb = 0; colNumb < lengthOfBoard; colNumb++) {
        if (getSlotAt(rowNumb, colNumb) == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }

  private boolean checkCorner(int armThickness, int rowNumb, int colNumb) {
    int lengthOfBoard = (3 * armThickness) - 2;
    double armGap = (lengthOfBoard - armThickness) / 2;
    return ((rowNumb < armGap && colNumb < armGap)
            || ((rowNumb >= lengthOfBoard - armGap)
            && colNumb >= lengthOfBoard - armGap)
            || (rowNumb < armGap && colNumb >= lengthOfBoard - armGap)
            || (colNumb < armGap && rowNumb >= lengthOfBoard - armGap));
  }

  private boolean addRep(int fromRow, int fromCol, int toRow, int toCol) {
    return ((this.gameBoard[fromRow][fromCol] == SlotState.Marble)
            && (this.gameBoard[toRow][toCol] == SlotState.Empty)
            && (this.gameBoard[((fromRow + toRow) / 2)][((fromCol + toCol) / 2)]
            == SlotState.Marble));
  }

  private boolean checkLowerBound(int fromRow, int fromCol, int toRow, int toCol) {
    return ((fromCol >= 0 && fromRow >= 0) && (toCol >= 0 && toRow >= 0));
  }

  private boolean checkUpperBound(int fromRow, int fromCol, int toRow, int toCol) {
    int lengthOfBoard = this.gameBoard.length;
    return ((fromRow < lengthOfBoard && fromCol < lengthOfBoard)
            && (toRow < lengthOfBoard && toCol < lengthOfBoard));
  }

  private boolean checkVertOrHorizontalMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (((Math.abs(toRow - fromRow) == 2) && (toCol - fromCol == 0))
            || ((Math.abs(toCol - fromCol) == 2) && (toRow - fromRow == 0)));
  }

  private boolean checkValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return ((checkVertOrHorizontalMove(fromRow, fromCol, toRow, toCol))
            && (checkLowerBound(fromRow, fromCol, toRow, toCol))
            && (checkUpperBound(fromRow, fromCol, toRow, toCol))
            && (addRep(fromRow, fromCol, toRow, toCol)));
  }

  private boolean containsValidMove(int rowNumb, int colNumb) {
    int boardSize = this.gameBoard.length;
    return (rowNumb >= 2 && this.checkValidMove(rowNumb, colNumb, rowNumb - 2, colNumb)
            || rowNumb <= boardSize - 3
            && this.checkValidMove(rowNumb, colNumb, rowNumb + 2, colNumb)
            || colNumb >= 2
            && this.checkValidMove(rowNumb, colNumb, rowNumb, colNumb - 2)
            || colNumb <= boardSize - 3
            && this.checkValidMove(rowNumb, colNumb, rowNumb, colNumb + 2));
  }
}