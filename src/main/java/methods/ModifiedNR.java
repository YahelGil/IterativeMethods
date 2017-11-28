package methods;

import java.util.ArrayList;
import static java.lang.Math.pow;

public class ModifiedNR {
    private double[][] inverseJacobian;
    private double p0x;
    private double p0y;
    private int iterations;

    public ModifiedNR(double[][] inverseJacobian, double p0x, double p0y, int iterations) {
        this.inverseJacobian = inverseJacobian;
        this.p0x = p0x;
        this.p0y = p0y;
        this.iterations = iterations;
    }

    public void calculate() {
        ArrayList<Double> xyArray = getNextPointNRM(p0x, p0y);
        System.out.println("point is " + xyArray);
    }

    private ArrayList<Double> getNextPointNRM(double p0x, double p0y) {
        ArrayList<Double> xyArray = new ArrayList<Double>();
        for (int i = 0; i < iterations; i++) {
            long startTime = System.currentTimeMillis();
            System.out.println("Got request to do NR algorithm for point x:" + p0x + "" +
                    "            y:" + p0y + " iteration number: " + i);
            double fpx = getFirstFunctionValue(p0x, p0y);
            double fpy = getSecondFunctionValue(p0x, p0y);
            p0x = p0x - getPx(fpx, fpy);
            p0y = p0y - getPy(fpx, fpy);
            long endTime = System.currentTimeMillis();
            System.out.println("Iteration: " + i + " took " + (endTime - startTime) + " millis");
        }
        xyArray.add(p0x);
        xyArray.add(p0y);
        return xyArray;
    }

    private double getPx(double x, double y) {
        double a = inverseJacobian[0][0];
        double b = inverseJacobian[0][1];
        return (a * x + b * y);
    }

    private double getPy(double x, double y) {
        double c = inverseJacobian[1][0];
        double d = inverseJacobian[1][1];
        return (c * x + d * y);
    }

    private double getFirstFunctionValue(double x, double y) {
        System.out.println("Got request to calculate f1 value");
        double f1 = (4.0 * pow(x, 2.0E00)) + (2.0 * x * y);
        System.out.println("function f1 value is " + f1);
        return f1;
    }

    private double getSecondFunctionValue(double x, double y) {
        System.out.println("Got request to calculate f2 value");
        double f2 = 2.0 * pow(x, 2.0) + 3.0 * x * y + pow(y, 2.0) - 3.0;
        System.out.println("function f2 value is " + f2);
        return f2;
    }
}
