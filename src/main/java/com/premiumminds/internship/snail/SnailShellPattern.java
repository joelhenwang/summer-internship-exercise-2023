package com.premiumminds.internship.snail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Class to determine the path of a given N*N matrix where the path follows a
 * snail shell like pattern.
 * Said path is determined by invoking the snailShellPath method with the given matrix.
 * It is determined by implementing a DFS algorithm. Knowing that the path follows in a loop 4 directions
 * ( Right -> Down -> Left -> Up) we can determine the path by iterating the matrix with a queue of directions
 * where every time the iteration reaches a boundary it updates its boundaries and resumes the iteration with the next
 * direction.
 */
class SnailShellPattern implements ISnailShellPattern {
  private final ExecutorService executor;

  // Boundaries of the transversal
  private int right_bound, left_bound, upper_bound, lower_bound;

  /**
   * Constructor for class SnailShellPattern
   */
  public SnailShellPattern(){
    this.executor = Executors.newSingleThreadExecutor();
  }

  /**
   * Method to determine if the iteration is still in transversal bounds
   *
   * @param x current row
   * @param y current column
   * @param upper_bound Upper bound of the transversal
   * @param lower_bound Lower bound of the transversal
   * @param left_bound Left bound of the transversal
   * @param right_bound Right bound of the transversal
   * @return True if within boundaries otherwise False
   */

  private boolean withinBounds( int x, int y, int upper_bound, int lower_bound, int right_bound, int left_bound){
    return y >= left_bound && y <= right_bound && x >= upper_bound && x <= lower_bound;
  }

  /**
   * Method to update the bounds of the transversal depending of its direction
   *
   * @param current_direction Current direction of the transversal
   *
   */

  private void updateBounds(String current_direction){
    if(current_direction.equals("Right")) upper_bound++;
    if(current_direction.equals("Left")) lower_bound--;
    if(current_direction.equals("Up") ) left_bound++;
    if(current_direction.equals("Down")) right_bound--;
  }


  /**
   * Method to determine the next increment for the next row
   *
   * @param direction current direction
   * @return 1 if going Down or -1 if going Up
   */

  private int incrementNextRow( String direction ){
    if( direction.equals("Down")) return 1; // Next row is row+1
    else if (direction.equals("Up")) return -1; // Next row is row-1
    else return 0; // Wrong direction
  }

  /**
   * Method to determine the next increment for the next column
   *
   * @param direction current direction
   * @return 1 if going Right or -1 if going Left
   */

  private int incrementNextColumn( String direction ){
    if( direction.equals("Right")) return 1; // Next column is column+1
    else if (direction.equals("Left")) return -1; // Next column is column-1
    else return 0; // Wrong direction
  }


  /**
   * Method to determine the snail path for a given N*N matrix
   *
   * @param matrix N*N matrix
   * @return representation of the snailshell pattern with its path
   */

  private int[] snailShellPath (int[][] matrix){
    /// row and col are the coordinates of the cell that is being transversed
    // step is the number of cells that have been transversed
    int row = 0;
    int col = 0;
    int step = 0;


    // Initiate boundaries of the transversal
    // Initial boundaries correspond to the first cell (0,0) and last cell of the matrix (N-1,N-1)
    left_bound = 0;
    upper_bound = 0;
    right_bound = matrix.length - 1;
    lower_bound = matrix.length - 1;


    // Given a N*N matrix, the max amount of steps in the path equals to
    // the amount of cells of the given matrix
    int max_steps = (matrix.length * matrix.length);


    // Initialize an array of integers, where the size is the amount of cells in the matrix,
    // for the path itself and a Queue for the order of directions
    Queue<String> directions = new LinkedList<>();
    int[] path = new int[max_steps];
    String current_direction;

    directions.add("Right");
    directions.add("Down");
    directions.add("Left");
    directions.add("Up");


    // Get the next direction (Right) and put it at the end of the queue
    current_direction = directions.remove();
    directions.add( current_direction );

    // Iterate over the cells of the matrix in a snailshell pattern
    while ( step < max_steps ){
      // If the cell of current row and column is within bounds
      // Add to path the value of the cell
      if( withinBounds(row, col, upper_bound, lower_bound, right_bound, left_bound) ) {
        path[step] = matrix[row][col];
        step++;
      }else if(upper_bound == lower_bound && left_bound == right_bound) break; // If last cell has been reached end iteration
      else {

        // If the cell of current row and column is out of bounds
        // Update the boundaries according to the direction
        // Go back to the previous cell and change to the next direction in the queue
        updateBounds(current_direction);
        row -= incrementNextRow(current_direction);
        col -= incrementNextColumn(current_direction);

        current_direction = directions.remove();
        directions.add( current_direction );

      }
      // Set next current row and column (next cell = matrix[row][col])
      row += incrementNextRow(current_direction);
      col += incrementNextColumn(current_direction);

    }

    return path;
  }





  /**
   * Method to get snailshell pattern
   * 
   * @param matrix N*N matrix
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(final int[][] matrix) {

    if(matrix.length == 0) return CompletableFuture.completedFuture(new int[0]);
    Future<int[]> result;

    result = executor.submit(() -> {
      try {
        return snailShellPath(matrix);
      }catch (Exception e){
        throw new Exception("error: " + e.getMessage());
      }
    });

    return result;
  }

}
