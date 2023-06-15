package apps;

import algorithm.forwardElimination;
import utility.*;

public class reductionDeterminant {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("REDUCTION METHOD FOR DETERMINANT");
        menu.border();

        matrixData matrixData = inputMatrix.inputMatOnly();
        double[][] matrix = matrixData.getMatrix();
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }

        int[] p = { 0 };
        forwardElimination.calculate(matrix, p);

        double determinant = 1;
        for (int i = 0; i < row; i++) {
            determinant *= matrix[i][i];
        }
        
        if (p[0] % 2 == 1) {
            determinant *= -1;
        }

        print.matrixForm(matrix, 1);
        print.determinant(determinant, 2);
    }
}