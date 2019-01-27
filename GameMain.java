import java.util.*;
public class GameMain {  
  public static void main(String[] args){
    int rows;
    int columns;
    int iterations;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter number of rows:");
    rows = scanner.nextInt();

    System.out.println("Enter number of columns:");
    columns = scanner.nextInt();

    System.out.println("Enter number of evolutions:");
    iterations = scanner.nextInt();

    GameOfLife game = new GameOfLife(rows,columns);
    
    game.randomiseBoard();
    System.out.println("The initial, randomised board:");
    game.printBoard();

    for(int i = 0; i<iterations; i++){
      if(game.getStatus() == false){
        System.out.println("All cells are dead after "+i+" cycles:");
        game.printBoard();
        break;
      }
      game.evolve();
    }
    if(game.getStatus() == true){
      System.out.println("Cells survived after "+iterations+" cycles:");
      game.printBoard();
    }

  }
}