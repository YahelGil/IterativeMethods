package main;

/**
 * Created by shavi on 28/11/2017.
 */
public class ModifiedNRMain {
    public static void main(String args[]) {
        final double[][] inverseJacobians = new double[][]{
                {0.25951557093425603, -0.06920415224913494},
                {-0.37197231833910027, 0.4325259515570934},
        };
        final double p0x = 0.4;
        final double p0y = 0.9;
        methods.ModifiedNR modifiedNR = new methods.ModifiedNR(inverseJacobians, p0x, p0y, 400000);
        modifiedNR.calculate();
    }
}
