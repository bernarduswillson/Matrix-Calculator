package cek;

import utility.menu;

public class backSubstitution {
    public static double[] calculate(double[][] mat, double[] matAns) throws Exception {
        int row = mat.length;
        int col = mat[0].length;
        double[] solution = new double[row];
        double tolerance = 1e-8;
        if (Math.abs(mat[row - 1][col - 1]) < tolerance || Math.abs(mat[row - 1][col - 2]) >= tolerance) {
            System.out.println("No Solution!");
            System.out.println();
            menu.backToMenu();
        }
        for (int i = row - 1; i >= 0; i--) {
            solution[i] = matAns[i];
            for (int j = i + 1; j < col; j++) {
                solution[i] -= mat[i][j] * solution[j];
            }
            solution[i] /= mat[i][i];
        }
        return solution;
    }
}
