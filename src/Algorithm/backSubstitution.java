package Algorithm;

import Utility.menu;

public class backSubstitution {
    public static double[] calculate(double[][] Mat, double[] MatAns) throws Exception {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[] solution = new double[ROW];
        double tolerance = 1e-8;
        if (Math.abs(Mat[ROW - 1][COL - 1]) < tolerance || Math.abs(Mat[ROW - 1][COL - 2]) >= tolerance) {
            System.out.println("No Solution!");
            System.out.println();
            menu.backToMenu();
        }
        for (int i = ROW - 1; i >= 0; i--) {
            solution[i] = MatAns[i];
            for (int j = i + 1; j < COL; j++) {
                solution[i] -= Mat[i][j] * solution[j];
            }
            solution[i] /= Mat[i][i];
        }
        return solution;
    }
}
