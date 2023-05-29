package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;

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
  public void ScreenLockinPatternTest_1x1()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { {1} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1 };
    assertArrayEquals( result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals( result, expected);
  }
  @Test
  public void ScreenLockinPatternTest_4x4Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 ,4}, { 5, 6, 7 ,8}, { 9, 10, 11 ,12} , { 13, 14, 15, 16}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 };
    assertArrayEquals( result, expected);
  }

  @Test
  public void ScreenLockinPatternTest_2x2Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2}, { 3, 4} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 4, 3 };
    assertArrayEquals( result, expected);
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
    assertArrayEquals( result, expected);
  }

  @Test
  public void ScreenLockinPatternTest_20x20Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
            { 10, 15, 8, 2, 17, 5, 20, 13, 4, 12, 3, 9, 11, 1, 19, 16, 14, 7, 18, 6 },
            { 6, 13, 7, 1, 19, 2, 14, 12, 10, 18, 3, 15, 11, 9, 5, 4, 20, 16, 17, 8 },
            { 5, 12, 9, 19, 4, 1, 14, 13, 7, 3, 10, 20, 15, 2, 11, 6, 8, 18, 16, 17 },
            { 9, 3, 1, 15, 14, 11, 17, 12, 20, 10, 13, 2, 8, 19, 5, 7, 6, 18, 16, 4 },
            { 12, 16, 18, 2, 10, 17, 15, 11, 14, 13, 7, 9, 4, 20, 3, 19, 8, 1, 6, 5 },
            { 7, 8, 16, 5, 12, 3, 18, 11, 19, 2, 9, 4, 15, 10, 1, 14, 13, 6, 20, 17 },
            { 19, 2, 18, 14, 11, 6, 3, 5, 16, 15, 9, 8, 7, 12, 1, 4, 17, 13, 20, 10 },
            { 20, 5, 9, 18, 13, 1, 7, 8, 12, 10, 16, 4, 11, 3, 17, 14, 19, 2, 6, 15 },
            { 11, 9, 10, 20, 17, 14, 13, 2, 8, 6, 1, 5, 19, 7, 3, 18, 16, 15, 12, 4 },
            { 18, 10, 2, 3, 14, 20, 13, 9, 7, 15, 5, 17, 19, 4, 6, 1, 8, 11, 12, 16 },
            { 1, 6, 4, 11, 16, 13, 20, 14, 5, 8, 3, 10, 15, 7, 17, 12, 19, 2, 18, 9 },
            { 16, 7, 12, 14, 5, 9, 20, 18, 17, 11, 2, 4, 6, 8, 13, 3, 1, 15, 10, 19 },
            { 4, 14, 15, 8, 6, 2, 11, 20, 18, 12, 9, 3, 10, 19, 7, 16, 13, 17, 1, 5 },
            { 8, 19, 13, 12, 20, 17, 1, 9, 3, 4, 6, 15, 2, 16, 18, 11, 14, 5, 7, 10 },
            { 13, 18, 14, 6, 1, 10, 12, 20, 2, 16, 17, 5, 3, 15, 8, 4, 9, 7, 11, 19 },
            { 3, 17, 6, 10, 9, 12, 8, 14, 1, 13, 4, 7, 16, 5, 19, 20, 11, 15, 18, 2 },
            { 15, 4, 11, 7, 18, 16, 10, 17, 9, 19, 14, 1, 5, 6, 2, 12, 3, 20, 13, 8 },
            { 17, 1, 3, 13, 15, 19, 5, 6, 11, 8, 12, 7, 20, 14, 10, 2, 4, 9, 16, 18 },
            { 2, 11, 17, 16, 7, 8, 6, 15, 19, 14, 20, 18, 13, 9, 4, 10, 5, 3, 1, 12 },
            { 14, 20, 5, 9, 8, 4, 16, 7, 15, 1, 19, 6, 17, 18, 12, 13, 2, 10, 11, 3 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {10, 15, 8, 2, 17, 5, 20, 13, 4, 12, 3, 9, 11, 1, 19, 16, 14, 7, 18, 6, 8, 17, 4, 5, 17, 10, 15, 4,
            16, 9, 19, 5, 10, 19, 2, 8, 18, 12, 3, 11, 10, 2, 13, 12, 18, 17, 6, 19, 1, 15, 7, 16, 4, 8, 9, 5, 20, 14,
            2, 17, 15, 3, 13, 8, 4, 16, 1, 18, 11, 20, 19, 7, 12, 9, 5, 6, 13, 7, 1, 19, 2, 14, 12, 10, 18, 3, 15, 11,
            9, 5, 4, 20, 16, 17, 16, 16, 6, 20, 20, 6, 12, 12, 18, 10, 1, 7, 11, 18, 13, 16, 1, 3, 5, 10, 4, 9, 13, 18,
            20, 14, 19, 15, 6, 8, 7, 16, 17, 11, 1, 4, 17, 18, 19, 14, 7, 6, 10, 9, 5, 2, 8, 16, 3, 12, 9, 19, 4, 1, 14,
            13, 7, 3, 10, 20, 15, 2, 11, 6, 8, 18, 18, 1, 6, 13, 2, 15, 11, 2, 15, 17, 5, 7, 15, 20, 9, 4, 2, 10, 14,
            20, 7, 12, 8, 11, 6, 5, 19, 15, 13, 3, 11, 6, 14, 13, 15, 12, 4, 2, 10, 9, 18, 16, 18, 1, 15, 14, 11, 17,
            12, 20, 10, 13, 2, 8, 19, 5, 7, 6, 8, 13, 17, 19, 16, 8, 19, 1, 13, 14, 9, 11, 3, 12, 2, 6, 5, 1, 14, 19, 9,
            17, 10, 16, 18, 7, 10, 6, 12, 8, 14, 11, 3, 20, 18, 14, 5, 2, 10, 17, 15, 11, 14, 13, 7, 9, 4, 20, 3, 19, 14,
            4, 14, 18, 1, 12, 3, 16, 11, 4, 20, 19, 5, 16, 7, 4, 13, 1, 14, 8, 12, 9, 1, 20, 6, 5, 16, 14, 17, 13, 11,
            12, 3, 18, 11, 19, 2, 9, 4, 15, 10, 1, 1, 17, 3, 6, 17, 13, 7, 18, 8, 15, 3, 5, 17, 16, 2, 20, 12, 10, 17, 2,
            9, 13, 20, 14, 1, 6, 3, 5, 16, 15, 9, 8, 7, 12, 3, 7, 4, 7, 8, 19, 16, 2, 15, 6, 4, 3, 9, 1, 11, 20, 20, 13,
            13, 7, 8, 12, 10, 16, 4, 11, 19, 19, 15, 6, 10, 3, 9, 12, 18, 20, 18, 14, 9, 2, 8, 6, 1, 5, 17, 10, 4, 2, 11,
            17, 5, 7, 15, 5, 3, 8}
    ;
    assertArrayEquals( result, expected);
  }

  @Test
  public void ScreenLockinPatternTest_30x30Matrix()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
            { 89, 72, 54, 42, 65, 78, 13, 97, 30, 10, 48, 16, 50, 20, 35, 28, 8, 59, 23, 5, 92, 96, 25, 71, 46, 81, 63, 19, 33, 57 },
            { 79, 66, 12, 51, 60, 7, 95, 76, 38, 69, 91, 74, 3, 43, 21, 17, 27, 6, 88, 9, 41, 64, 15, 24, 58, 85, 98, 84, 31, 36 },
            { 82, 93, 40, 55, 32, 68, 34, 87, 75, 49, 18, 83, 2, 14, 99, 37, 70, 61, 11, 44, 86, 4, 26, 94, 22, 47, 67, 56, 73, 29 },
            { 80, 45, 77, 39, 62, 53, 90, 1, 52, 94, 76, 84, 31, 19, 10, 23, 64, 26, 67, 41, 96, 88, 6, 29, 37, 28, 46, 69, 18, 58 },
            { 16, 92, 56, 13, 25, 48, 22, 50, 97, 59, 9, 36, 78, 70, 5, 32, 15, 81, 55, 7, 86, 30, 42, 61, 38, 3, 89, 79, 17, 66 },
            { 74, 98, 43, 85, 71, 31, 77, 20, 51, 67, 29, 35, 2, 14, 96, 58, 10, 62, 11, 19, 42, 78, 91, 93, 87, 68, 52, 44, 39, 55 },
            { 82, 29, 71, 40, 53, 83, 47, 38, 88, 18, 99, 13, 28, 65, 79, 42, 66, 51, 58, 7, 10, 72, 94, 12, 96, 32, 21, 64, 54, 39 },
            { 91, 43, 17, 50, 73, 33, 81, 23, 49, 59, 87, 15, 4, 92, 11, 67, 30, 48, 25, 19, 36, 39, 56, 60, 20, 77, 62, 86, 24, 68 },
            { 75, 28, 34, 97, 31, 65, 54, 10, 13, 86, 1, 18, 43, 77, 69, 49, 57, 83, 94, 50, 63, 11, 29, 46, 60, 81, 40, 72, 98, 22 },
            { 24, 95, 12, 56, 71, 36, 58, 76, 65, 50, 42, 81, 19, 27, 39, 30, 47, 84, 99, 66, 90, 18, 83, 37, 73, 62, 21, 44, 8, 13 },
            { 60, 46, 82, 71, 38, 88, 22, 74, 63, 16, 92, 58, 44, 53, 6, 40, 81, 12, 33, 37, 91, 67, 99, 10, 14, 39, 57, 48, 27, 95 },
            { 51, 35, 89, 72, 3, 66, 30, 69, 96, 57, 19, 2, 27, 8, 60, 47, 41, 83, 31, 56, 61, 73, 23, 10, 79, 87, 54, 22, 78, 45 },
            { 32, 76, 9, 55, 42, 58, 21, 68, 47, 88, 16, 71, 84, 62, 15, 98, 80, 24, 26, 37, 45, 11, 49, 31, 67, 81, 90, 40, 3, 17 },
            { 67, 48, 28, 83, 55, 40, 10, 73, 61, 32, 75, 47, 6, 56, 88, 35, 16, 23, 92, 81, 41, 25, 57, 62, 95, 37, 27, 76, 49, 80 },
            { 2, 77, 64, 93, 43, 13, 55, 35, 28, 83, 42, 71, 52, 23, 41, 87, 75, 89, 68, 17, 33, 49, 31, 59, 96, 16, 44, 72, 38, 21 },
            { 69, 20, 14, 34, 66, 47, 39, 76, 25, 5, 29, 86, 61, 43, 8, 56, 51, 90, 78, 33, 68, 93, 48, 26, 96, 12, 10, 22, 60, 84 },
            { 46, 70, 28, 36, 63, 13, 7, 82, 30, 95, 48, 88, 55, 71, 41, 85, 77, 19, 44, 12, 59, 99, 23, 32, 67, 4, 21, 57, 80, 64 },
            { 18, 58, 90, 83, 31, 22, 74, 42, 51, 68, 40, 17, 73, 63, 84, 30, 97, 19, 20, 45, 76, 87, 4, 61, 6, 39, 52, 16, 35, 99 },
            { 25, 89, 72, 53, 43, 3, 76, 60, 13, 28, 94, 82, 36, 17, 41, 91, 32, 70, 21, 66, 97, 75, 49, 5, 63, 14, 18, 48, 54, 38 },
            { 7, 80, 33, 42, 64, 15, 78, 92, 58, 29, 44, 98, 88, 35, 24, 71, 85, 68, 96, 27, 56, 91, 67, 81, 45, 53, 69, 46, 19, 39 },
            { 74, 9, 36, 51, 19, 27, 61, 48, 22, 68, 92, 77, 56, 45, 73, 30, 95, 23, 10, 86, 63, 31, 60, 7, 54, 42, 89, 80, 57, 18 },
            { 38, 64, 34, 83, 47, 76, 90, 29, 67, 50, 55, 40, 10, 21, 9, 13, 48, 25, 88, 71, 19, 36, 58, 84, 4, 15, 81, 43, 87, 66 },
            { 1, 26, 72, 77, 6, 43, 98, 84, 11, 52, 17, 46, 32, 91, 56, 74, 65, 79, 37, 61, 87, 20, 30, 53, 49, 66, 28, 76, 45, 93 },
            { 31, 5, 19, 22, 83, 51, 78, 67, 63, 88, 11, 60, 74, 49, 36, 40, 57, 98, 3, 80, 70, 86, 33, 55, 81, 29, 24, 76, 15, 94 },
            { 69, 26, 15, 30, 53, 59, 66, 95, 35, 92, 43, 47, 1, 51, 72, 87, 84, 49, 80, 3, 19, 70, 8, 39, 63, 88, 57, 36, 61, 96 },
            { 50, 12, 68, 88, 81, 46, 53, 9, 30, 6, 92, 19, 22, 44, 40, 35, 71, 14, 65, 55, 63, 75, 41, 96, 27, 76, 90, 57, 1, 38 },
            { 56, 78, 21, 45, 36, 64, 82, 5, 42, 75, 89, 8, 66, 32, 29, 93, 39, 13, 70, 16, 97, 60, 48, 55, 84, 23, 86, 19, 52, 87 },
            { 14, 93, 67, 51, 71, 48, 22, 81, 40, 76, 36, 19, 7, 89, 59, 13, 35, 42, 55, 68, 32, 50, 3, 87, 65, 9, 28, 90, 94, 61 },
            { 62, 24, 88, 70, 30, 19, 59, 42, 10, 71, 90, 77, 44, 6, 48, 81, 55, 93, 67, 53, 28, 13, 36, 84, 50, 66, 35, 17, 95, 74 },
            { 79, 46, 16, 68, 9, 33, 82, 1, 55, 40, 88, 78, 22, 59, 14, 71, 93, 63, 36, 19, 65, 48, 30, 87, 90, 42, 28, 67, 7, 50 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {89, 72, 54, 42, 65, 78, 13, 97, 30, 10, 48, 16, 50, 20, 35, 28, 8, 59, 23, 5, 92, 96, 25, 71, 46, 81, 63, 19, 33, 57, 36, 29, 58, 66, 55, 39, 68, 22, 13, 95, 45, 17, 80, 21, 84, 64, 99, 38, 39, 18, 66, 93, 94, 96, 38, 87, 61, 74, 50, 7, 67, 28, 42, 90, 87, 30, 48, 65, 19, 36, 63, 93, 71, 14, 59, 22, 78, 88, 40, 55, 1, 82, 33, 9, 68, 16, 46, 79, 62, 14, 56, 50, 69, 31, 1, 38, 74, 7, 25, 18, 46, 69, 2, 67, 32, 51, 60, 24, 75, 91, 82, 74, 16, 80, 82, 79, 66, 12, 51, 60, 7, 95, 76, 38, 69, 91, 74, 3, 43, 21, 17, 27, 6, 88, 9, 41, 64, 15, 24, 58, 85, 98, 84, 31, 73, 18, 17, 39, 54, 24, 98, 8, 27, 78, 3, 49, 38, 60, 80, 35, 54, 19, 57, 87, 45, 15, 61, 1, 52, 94, 95, 17, 35, 66, 50, 84, 36, 13, 28, 53, 67, 93, 55, 81, 48, 6, 44, 77, 90, 71, 10, 42, 59, 19, 30, 70, 88, 24, 93, 78, 12, 26, 5, 26, 64, 9, 80, 89, 58, 70, 20, 77, 48, 76, 35, 46, 95, 28, 43, 29, 98, 92, 45, 93, 40, 55, 32, 68, 34, 87, 75, 49, 18, 83, 2, 14, 99, 37, 70, 61, 11, 44, 86, 4, 26, 94, 22, 47, 67, 56, 69, 79, 44, 64, 86, 72, 44, 48, 22, 40, 76, 72, 22, 57, 16, 48, 46, 80, 43, 76, 76, 36, 57, 19, 90, 28, 9, 65, 87, 3, 50, 32, 68, 55, 42, 35, 13, 59, 89, 7, 19, 36, 76, 40, 81, 22, 48, 71, 51, 67, 21, 68, 15, 19, 72, 34, 36, 33, 72, 90, 28, 14, 64, 28, 9, 89, 82, 12, 34, 17, 71, 43, 56, 77, 39, 62, 53, 90, 1, 52, 94, 76, 84, 31, 19, 10, 23, 64, 26, 67, 41, 96, 88, 6, 29, 37, 28, 46, 89, 52, 21, 62, 40, 21, 57, 54, 90, 27, 44, 10, 21, 52, 18, 69, 89, 81, 28, 24, 57, 90, 86, 23, 84, 55, 48, 60, 97, 16, 70, 13, 39, 93, 29, 32, 66, 8, 89, 75, 42, 5, 82, 64, 36, 45, 88, 30, 22, 77, 83, 51, 42, 53, 83, 36, 34, 93, 83, 55, 72, 71, 56, 97, 50, 40, 85, 13, 25, 48, 22, 50, 97, 59, 9, 36, 78, 70, 5, 32, 15, 81, 55, 7, 86, 30, 42, 61, 38, 3, 68, 32, 77, 81, 62, 39, 87, 81, 37, 16, 12, 4, 39, 14, 53, 42, 15, 66, 29, 88, 76, 27, 96, 41, 75, 63, 55, 65, 14, 71, 35, 40, 44, 22, 19, 92, 6, 30, 9, 53, 46, 81, 53, 83, 6, 47, 19, 64, 43, 31, 63, 66, 43, 55, 42, 3, 38, 71, 31, 73, 53, 71, 31, 77, 20, 51, 67, 29, 35, 2, 14, 96, 58, 10, 62, 11, 19, 42, 78, 91, 93, 87, 96, 20, 60, 73, 14, 79, 67, 95, 96, 96, 67, 6, 63, 45, 54, 4, 49, 81, 63, 39, 8, 70, 19, 3, 80, 49, 84, 87, 72, 51, 1, 47, 43, 92, 35, 95, 66, 59, 51, 43, 76, 27, 15, 3, 22, 13, 47, 13, 40, 58, 66, 88, 36, 65, 33, 83, 47, 38, 88, 18, 99, 13, 28, 65, 79, 42, 66, 51, 58, 7, 10, 72, 94, 12, 60, 46, 37, 10, 10, 31, 62, 59, 26, 32, 61, 5, 81, 7, 84, 53, 55, 33, 86, 70, 80, 3, 98, 57, 40, 36, 49, 74, 60, 11, 88, 63, 67, 78, 98, 90, 61, 78, 76, 74, 7, 39, 55, 10, 21, 30, 22, 58, 54, 81, 23, 49, 59, 87, 15, 4, 92, 11, 67, 30, 48, 25, 19, 36, 39, 56, 29, 83, 99, 23, 49, 57, 31, 48, 23, 4, 49, 67, 60, 58, 30, 20, 87, 61, 37, 79, 65, 74, 56, 91, 32, 46, 17, 52, 11, 84, 29, 48, 92, 60, 42, 82, 76, 35, 73, 68, 69, 74, 76, 10, 13, 86, 1, 18, 43, 77, 69, 49, 57, 83, 94, 50, 63, 11, 18, 67, 73, 11, 25, 49, 93, 99, 87, 75, 91, 31, 36, 19, 71, 88, 25, 48, 13, 9, 21, 10, 40, 55, 50, 67, 22, 58, 13, 51, 30, 25, 28, 61, 47, 96, 63, 65, 50, 42, 81, 19, 27, 39, 30, 47, 84, 99, 66, 90, 91, 61, 45, 41, 33, 68, 59, 76, 97, 56, 63, 86, 10, 23, 95, 30, 73, 45, 56, 77, 92, 68, 29, 28, 68, 95, 5, 83, 32, 88, 57, 16, 92, 58, 44, 53, 6, 40, 81, 12, 33, 37, 56, 37, 81, 17, 33, 12, 45, 66, 27, 96, 68, 85, 71, 24, 35, 88, 98, 44, 94, 40, 48, 29, 42, 75, 16, 19, 2, 27, 8, 60, 47, 41, 83, 31, 26, 92, 68, 78, 44, 20, 21, 70, 32, 91, 41, 17, 36, 82, 17, 88, 86, 71, 47, 71, 84, 62, 15, 98, 80, 24, 23, 89, 90, 19, 19, 97, 30, 84, 63, 73, 55, 61, 52, 6, 56, 88, 35, 16, 75, 51, 77, 85, 41, 71, 43, 23, 41, 87, 56, 8}

    ;
    assertArrayEquals( result, expected);
  }



}