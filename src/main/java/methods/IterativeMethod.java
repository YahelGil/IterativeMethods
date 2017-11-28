package methods;
import utils.Distance;
import java.util.Arrays;
import static utils.MatrixUtils.*;

public class IterativeMethod {
    private double[][] matrixR;
    private double[][] matrixb;
    private double[][] matrixB0;
    private double[][] x0;
    private int iterationNumber;
    final double[][] iterativeAnswer = new double[][]{
            {-2.000000},
            {2.00000 / 3.00000},
            {5.00000 / 3.00000}
    };

    public IterativeMethod(double[][] matrixR, double[][] matrixb, double[][] matrixB0, double[][] x0, int iterationNumber) {
        this.matrixB0 = matrixB0;
        this.matrixb = matrixb;
        this.matrixR = matrixR;
        this.x0 = x0;
        this.iterationNumber = iterationNumber;
    }

    public void calculate() {
        double[][] lastIteration = (getNextPointIterative(x0, iterationNumber));
        System.out.println("point is ");
        printMatrix(lastIteration);
    }

    public void showErr() {
        double[] iterationErr = getNextPointErr(x0, iterationNumber);
        System.out.println(Arrays.toString(iterationErr));
    }

    private double[][] getNextPointIterative(double[][] xn, int iterations) {
        for (int i = 0; i < iterations; i++) {
            long startTime = System.currentTimeMillis();
            System.out.println("Got request to do iterative algorithm iteration number: " + i + " for matrix: ");
            printMatrix(xn);
            xn = add(multiplyByMatrix(matrixR, calculateXn(i)), calculateMatrixB0b());
            long endTime = System.currentTimeMillis();
            System.out.println("Iteration: " + i + " took " + (endTime - startTime) + " millis");
        }
        return xn;
    }

    private double[] getNextPointErr(double[][] xn, int iterations) {
        double[] iterationErr = new double[iterations];
        for (int i = 0; i < iterations; i++) {
            xn = add(multiplyByMatrix(matrixR, calculateXn(i)), calculateMatrixB0b());
            double err = Distance.getEuclidianDistance(getFirstCol(xn), getFirstCol(iterativeAnswer));
            iterationErr[i] = err;
            System.out.println("Distance between result and current iteration: " + i + " is: " + err);
            System.out.println(Math.log10(err));
        }
        return iterationErr;
    }

    private double[][] calculateXn(int n) {
        return multiplyByMatrix(calculateBn(n), matrixb);
    }

    private double[][] calculateMatrixB0b() {
        return multiplyByMatrix(matrixB0, matrixb);
    }

    private double[][] calculateBn(int n) {
        double[][] matrixSum = new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        double[][] multi = matrixSum;
        for (int i = 1; i <= n; i++) {
            multi = multiplyByMatrix(multi, matrixR);
            matrixSum = add(matrixSum, multi);
        }
        return multiplyByMatrix(matrixSum, matrixB0);
    }
}
