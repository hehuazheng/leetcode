import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        final int IMPOSSIBLE = Integer.MIN_VALUE;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        matrix[0][0] = IMPOSSIBLE;
        int orientation = 0;
        int cnt = 1;
        while (cnt < rows * cols) {
            switch (orientation) {
                case 0://右
                    if (j + 1 < cols && matrix[i][j + 1] != IMPOSSIBLE) {
                        list.add(matrix[i][j + 1]);
                        matrix[i][j + 1] = IMPOSSIBLE;
                        j++;
                        cnt++;
                    } else {
                        orientation = 1;
                    }
                    break;
                case 1://下
                    if (i + 1 < rows && matrix[i + 1][j] != IMPOSSIBLE) {
                        list.add(matrix[i + 1][j]);
                        matrix[i + 1][j] = IMPOSSIBLE;
                        i++;
                        cnt++;
                    } else {
                        orientation = 2;
                    }
                    break;
                case 2://左
                    if (j - 1 >= 0 && matrix[i][j - 1] != IMPOSSIBLE) {
                        list.add(matrix[i][j - 1]);
                        matrix[i][j - 1] = IMPOSSIBLE;
                        j--;
                        cnt++;
                    } else {
                        orientation = 3;
                    }
                    break;
                case 3://上
                    if (i - 1 >= 0 && matrix[i - 1][j] != IMPOSSIBLE) {
                        list.add(matrix[i - 1][j]);
                        matrix[i - 1][j] = IMPOSSIBLE;
                        i--;
                        cnt++;
                    } else {
                        orientation = 0;
                    }
                    break;
                default:
                    break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new P54().spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new P54().spiralOrder(matrix));

        matrix = new int[][]{};
        System.out.println(new P54().spiralOrder(matrix));
    }
}
