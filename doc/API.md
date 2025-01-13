# Personal Web API

## Minesweeper

### Create the Minesweeper Game

- URL: /minesweeper/create
- Description: Create a new minesweeper game, return the game id. Must be called before any other API.
- Method: POST
- Request Body: 
  ```json
  {
    "boardSize": 3,
    "numOfMines": 3
  }
  ```

- Response Body:
  ```json
  {
    "code": "ERROR",
    "message": "Error message",
    "gameToken": "gameId"
  }
  ```
    - If the code is "ERROR", the message field will contain an error message.
    - If the code is "OK", the gameId field will contain the game id.


### Reset the Minesweeper Game

- URL: /minesweeper/reset
- Description: Reset a new minesweeper game board with the given number of rows, columns, and mines.
    The board is a 2D array of integers. Each cell is either a mine (9) or a number indicating the number of mines in the adjacent cells.
- Method: POST
- Request Body: 
  ```json
  {
    "rows": 3,
    "cols": 3,
    "mines": 3,
    "gameToken": "123"

  }
  ```
    The row and col fields are the number of rows and columns of the board, respectively.
    The mines field is the number of mines in the board.

- Response Body:
  ```json
  {
    "code": "ERROR",
    "message": "Error message",
    "board": [[9, 9, 9], [9, 9, 9], [9, 9, 9]],
    "gameState": "inProgress"
  }
  ```
    - If the code is "ERROR", the message field will contain an error message.
    - If the code is "OK", the board field will contain the initial board.

### Reveal a Cell

- URL: /minesweeper/reveal
- Method: POST
- Request Body: 
  ```json
  {
    "row": 0,
    "col": 0,
    "gameToken": "123"
  }
  ```
    The row and col fields are the row and column of the cell to reveal.
- Response Body:
  ```json
  {
    "code": "ERROR",
    "message": "Error message",
    "board": [[9, 9, 9], [9, 9, 9], [9, 9, 9]],
    "gameState": "inProgress"
  }
  ```
    - If game is lose, the board field will contain the final board, with all mines revealed.
    - If game is win, the board field will contain the final board, with all mines.
    - If game is inProgress, the board field will contain the updated board.


### Call AI to Reveal a Cell

- URL: /minesweeper/agent
- Method: POST
- Request Body: 
  ```json
  {
    "gameToken": "123"
  }
  ```
- Response Body:
  ```json
  {
    "code": "ERROR",
    "message": "Error message",
    "board": [[9, 9, 9], [9, 9, 9], [9, 9, 9]],
    "gameState": "inProgress"
  }
  ```
  
