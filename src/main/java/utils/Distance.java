package utils;

public class Distance {

    public static double getEuclidianDistance(double[] p0, double[] p1) {
        double dist = 0.000000;
        for (int i = 0; i < Math.min(p0.length, p1.length); i++) {
            dist += Math.pow((MatrixUtils.getFormat(p0[i] - p1[i])), 2);
        }
        return Math.sqrt(dist);
    }
}