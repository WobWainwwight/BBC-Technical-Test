// Problem 1081 Game of Life
// Author: Robert Wainwright
 
#include <stdio.h>
#include <string.h>
 
char flip(char c);
 
int main(void){
  int rows;
  int cols;
  int steps;
 
 
  /*First, values for rows, columns and steps are inputted
  then values for the cells are inputted and saved onto the 2d
  array using a nested for loop*/
  scanf("%d %d %d", &rows, &cols, &steps);

  //create a board with the size given in rows and columns
  char board [cols][rows];
  for(int i = 0; i<rows; i++){
    for(int j = 0; j<cols; j++){
      scanf(" %c", &board[j][i]);
    }
  }
  printf("R:%d C:%d S:%d\n", rows, cols, steps);
 
  //printing the board in the right format
  for(int i = 0; i<rows; i++){
    for(int j = 0; j<cols; j++){
      printf("%c", board[j][i]);
    }
    printf("\n");
  }
  
  printf("\n\n");

  for(int i = 0; i<rows; i++){
    for(int j = 0; j<cols; j++){
      int liveNeighbsCount = 0;
      //The following checks that there exists a row above the current board position
      if(i-1 >= 0){
        //checks for a cell existing in the upper left neighbour
        if(j-1 >= 0){
          //if the upper left neighbour is alive it's the counter is incremented
          if(board[j-1][i-1] == 'X'){liveNeighbsCount++;}
          printf("UL EXISTS\n");
        }
        //checks for cell existing in the upper right neighbour
        if(j+1 < cols){
          // incremented count if UR alive
          if(board[j+1][i-1] == 'X'){liveNeighbsCount++;}
          printf("UR Exists\n");
        }
        //count incremented if the up neighbour is live
        if(board[j][i+1] == 'X'){liveNeighbsCount++;}
        printf("UP EXISTS\n" );
      }
      //checks that there is a cell to the left of the current position
      if(j-1 >= 0){
        if(board[j-1][i] == 'X'){liveNeighbsCount++;}
        printf("L Exists\n");
      }
      if(j+1 < cols){
        if(board[j+1][i] == 'X'){liveNeighbsCount++;}
        printf("R Exists\n");
      }
      if(i+1 < rows){
        if(j-1 >= 0){
          if(board[j-1][i+1] == 'X'){liveNeighbsCount++;}
          printf("BL Exists\n");
        }
        if(j+1 < cols){
          if(board[j+1][i+1] == 'X'){liveNeighbsCount++;}
          printf("BR Exists\n" );
        }
        if(board[j][i+1] == 'X'){liveNeighbsCount++;}
        printf("B EXISTS\n");
      }
      printf("Current VALUE = %c Live Neighbours of %d,%d are: %d\n",board[j][i], j, i, liveNeighbsCount );
      if(board[j][i] == '.'){
        if(liveNeighbsCount == 3){
          board[j][i] = 'X';
        }
      }
      else if(board[j][i] == 'X'){
        if(liveNeighbsCount < 2 || liveNeighbsCount >= 4){
          board[j][i] = '.';
        }
      }

    }
    printf("\n");
  }
  for(int i = 0; i<rows; i++){
    for(int j = 0; j<cols; j++){
      printf("%c", board[j][i]);
    }
  printf("\n");
  }
return 0;
}




