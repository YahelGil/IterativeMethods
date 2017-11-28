package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MatrixUtils {
    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    public static double[][] multiplyByScalar(double[][] m1, double scalar) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m1RowLength = m1.length;    // m result rows length
        for (int i = 0; i < m1ColLength; i++) {         // rows from m1
            for (int j = 0; j < m1RowLength; j++) {     // columns from m2
                m1[i][j] = scalar * m1[i][j];
            }
        }
        return m1;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(MatrixUtils.getFormat(matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static double[][] add(double[][] a, double[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static double[] getFirstCol(double[][] matrix) {
        double[] vector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            vector[i] = matrix[i][0];
        }
        return vector;
    }

    public static double getFormat(double num) {
        NumberFormat df = new DecimalFormat("#.############");
        return Double.parseDouble(df.format(num));
    }
}