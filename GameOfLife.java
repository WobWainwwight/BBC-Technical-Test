public class GameOfLife{
  private int rows = 0;
  private int columns = 0;
  private boolean[][] board = new boolean[rows][columns];
  private boolean alive = true;

  public GameOfLife(int r, int c){
    rows = r;
    columns = c;
    board = new boolean[rows][columns];
  }
  public void randomiseBoard(){
    //Goes through each cell and randomly assigns whether they are dead or alive
    // true means alive, false means dead 
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        double rand = Math.random();
        if(rand < 0.5){
          board[i][j] = false;
        }
        else{
          board[i][j] = true;
        }
      }
    }
  }
  
  // Method prints the board, 1 denotes an alive cell while 0 denotes a dead cell
  public void printBoard(){
    for(int i =0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        if(board[i][j] == true){
          System.out.print("1 ");
        }
        else{
          System.out.print("0 ");
        }
      }
      System.out.print("\n");
    }
  }

  public void evolve(){
    boolean[][] newBoard = new boolean[rows][columns];
    int deadCells = 0;
    for(int i =0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        byte liveNeighbCount = 0;
        // check row above exists
        if(i - 1 >= 0){
          if(board[i-1][j] == true){
            liveNeighbCount++;
          }
          //check if right col exists
          if(j + 1 < columns){
            // check upper right
            if(board[i-1][j+1] == true){
              liveNeighbCount++;
            }
          }
          //check if left col exists
          if(j - 1 >= 0){
            //check upper left
            if(board[i-1][j-1] == true){
              liveNeighbCount++;
            }
          }
        }
        //check below exists
        if(i + 1 < rows){
          // check cell below is alive
          if(board[i+1][j] == true){
            liveNeighbCount++;
          }
          //check bottom left
          if(j - 1 >= 0){
            if(board[i+1][j-1] == true){
              liveNeighbCount++;
            }
          }
          //check bottom right
          if(j + 1 < columns){
            if(board[i+1][j+1] == true){
              liveNeighbCount++;
            }
          }
        }
        //check left
        if(j -1 >= 0){
          if(board[i][j-1] == true){
            liveNeighbCount++;
          }
        }  
        // check right
        if(j + 1 < columns){
          if(board[i][j+1] == true){
            liveNeighbCount++;
          }
        }
        if(board[i][j] == false){
          deadCells++;
          if(liveNeighbCount == 3){
            newBoard[i][j] = true;
          }
          else{
            newBoard[i][j] = false;
          }
        }
        else{
          if(liveNeighbCount == 2 || liveNeighbCount == 3){
            newBoard[i][j] = true;
          }
          else{
            newBoard[i][j] = false;
          }
        }
      }
    }
    if(deadCells == rows*columns){
      // if the whole grid is dead then it will never have life again
      alive = false;
    }
    board = newBoard;
  }
  public boolean getStatus(){
    return alive;
  }
}