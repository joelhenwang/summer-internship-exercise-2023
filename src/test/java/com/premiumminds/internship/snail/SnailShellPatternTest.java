package com.premiumminds.internship.snail;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   */
  public SnailShellPatternTest() {
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }
  @Test
  public void ScreenLockinPatternTest_4x4Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 ,4}, { 5, 6, 7 ,8}, { 9, 10, 11 ,12} , { 13, 14, 15, 16}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 };
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }

  @Test
  public void ScreenLockinPatternTest_2x2Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2}, { 3, 4} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 4, 3 };
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }

  @Test
  public void ScreenLockinPatternTest_7x7Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
            { 1, 2, 3, 4, 5, 6, 7},
            { 8, 9, 10, 11, 12, 13, 14},
            { 15, 16, 17, 18, 19, 20, 21},
            { 22, 23, 24, 25, 26, 27, 28},
            { 29, 30, 31, 32, 33, 34, 35},
            { 36, 37, 38, 39, 40, 41, 42},
            { 43, 44, 45, 46, 47, 48, 49}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 14, 21, 28, 35, 42, 49, 48,
            47, 46, 45, 44, 43, 36, 29, 22, 15, 8, 9 ,10 ,11, 12, 13, 20,
            27, 34, 41, 40, 39, 38, 37, 30, 23, 16, 17, 18, 19, 26, 33, 32, 31, 24, 25};
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }



}