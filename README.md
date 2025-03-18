# KnightOnChess
Prints the knight's position on a board and suggests next moves.

### Classes:
- Main - Root of Application
- Position - represents coordinates on the board

### Functions:
- getYesOrNo() - Prompter to ask a user to continue or exit
- showKnightMoves() - Shows the exact position of a knight and suggests the next move
- printBoard() - Prints the chessboard with the knight's exact position and next moves
- calculateNewPosition() - Calculates new move, sends null if off board
- convertPositiontoSquare() - Converts 2D array into String ([][] to position)
- convertSquaretoPosition() - Converts String into 2D array (position to [][])

#### 2D array
- there are 8 possible moves a knight can make 
- 1st dimension is file - [a, b, c, d, e, f, g, h]
- 2nd dimension is rank - [1, 2, 3, 4, 5, 6, 7, 8]
- 2D array to String - board[4][5] = e6
- Holds 3 values:
    * 0 - knight not present
    * 1 - knight present
    * 2 - knight might move
 
### Built With(Technology):

  - Maven - Dependency Management
  - JDK - Java™ Platform, Standard Edition Development Kit
