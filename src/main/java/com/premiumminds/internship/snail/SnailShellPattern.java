package com.premiumminds.internship.snail;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {
  ExecutorService executor;

  public SnailShellPattern(){
    this.executor = Executors.newSingleThreadExecutor();
  }
  /**
   * Method to determine if the iteration is still in matrix bounds
   *
   * @param x current row
   * @param y current column
   * @param n matrix num. of rows or columns ( N*N matrix)
   * @return True if within bound otherwise False
   */

  private boolean withinBounds( int x, int y, int n){
    return x >= 0 && x < n && y >= 0 && y < n;
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
   * Method to determine the snail path for a given N*N matrix*
   *
   * @param matrix N*N matrix
   * @return representation of the snailshell pattern with its path
   */

  private int[] snailShellPath (int[][] matrix){
    // Given a N*N matrix, the max amount of steps in the path equals to
    // the amount of cells of the given matrix
    int max_steps = matrix.length * matrix.length;


    // Create visited matrix with same size as given matrix to know when to not visit a cell
    int[][] visited = new int[matrix.length][matrix.length];
    for (int[] visited_row : visited) {
      Arrays.fill(visited_row, 0); // Fills the visited array with zeroes
    }


    // Initialize a int[N] for the path itself and a Queue for the directions order
    Queue<String> directions = new LinkedList<>();
    int[] path = new int[max_steps];
    String current_direction;


    // Starting position of the path
    int row = 0;
    int col = 0;
    int step = 0;


    // In a clockwise snailshell pattern the path follows
    // the directions in this form: Right -> Down -> Left -> Up (repeat)
    directions.add("Right");
    directions.add("Down");
    directions.add("Left");
    directions.add("Up");


    // Get the next direction (Right) and put it at the end of the queue
    current_direction = directions.remove();
    directions.add( current_direction );

    // Iterate over the cells of the matrix in a snailshell pattern
    while ( step < max_steps ){
      if( withinBounds(row, col, matrix.length) && visited[row][col] == 0 ) {
        path[step] = matrix[row][col];
        visited[row][col] = 1;
        step++;
      }
      else {
        row -= incrementNextRow(current_direction);
        col -= incrementNextColumn(current_direction);
        current_direction = directions.remove();
        directions.add( current_direction );
      }
      row += incrementNextRow(current_direction);
      col += incrementNextColumn(current_direction);
    }

    return path;
  }


  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(final int[][] matrix) {

    if( matrix.length == 0) throw new RuntimeException("Matrix has size 0");

    Future<int[]> result;
    result = executor.submit(new Callable<int[]>() {
                               @Override
                               public int[] call() throws Exception {
                                 try {
                                   return snailShellPath(matrix);
                                 }catch (Exception e){
                                   throw new Exception("error: " + e.getMessage());
                                 }
                               }
                             });
    return result;
  }


}
