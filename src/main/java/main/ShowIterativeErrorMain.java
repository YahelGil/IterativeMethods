package main;

import methods.IterativeMethod;

public class ShowIterativeErrorMain {
    //showErr
    public static void main(String args[]) {
        final double[][] r = new double[][]{
                {5.00000 / 6.00000, -1.00000 / 30.00000, -4.00000 / 15.00000},
                {-1.00000 / 30.00000, 14.00000 / 15.00000, -1.00000 / 30.00000},
                {-4.00000 / 15.00000, -1.00000 / 30.00000, 8.00000 / 15.00000},
        };
        final double[][] b0 = new double[][]{
                {1.00000 / 30.00000, 1.00000 / 15.00000, 0.00000},
                {1.00000 / 30.00000, 0.00000, -1.00000 / 30.00000},
                {1.00000 / 15.00000, 1.00000 / 10.00000, 1.00000 / 30.00000},
        };

        final double[][] b = new double[][]{
                {2.00000}, {1.00000}, {1.00000}
        };
        final double[][] x0 = new double[][]{
                {0.00000}, {0.00000}, {0.00000}
        };
        IterativeMethod iterativeMethod = new IterativeMethod(r, b, b0, x0, 4100);
        iterativeMethod.showErr();
    }
}
