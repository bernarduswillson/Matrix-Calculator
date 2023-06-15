package apps;

import algorithm.forwardElimination;
import algorithm.backwardElimination;
import utility.*;

public class reductionInverse {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("REDUCTION INVERSE METHOD");
        menu.border();

        matrixData matrixData = inputMatrix.inputMatOnly();
        double[][] matrix = matrixData.getMatrix();
        int row = matrix.length;
        int col = matrix[0].length;

        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }

        double[][] matrixId = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    matrixId[i][j] = 1;
                } else {
                    matrixId[i][j] = 0;
                }
            }
        }

        forwardElimination.calculateId(matrix, matrixId);
        backwardElimination.calculateId(matrix, matrixId);
        print.echelonForm(matrix, matrixId, 1);
        System.out.println();
        print.matrixForm(matrixId, 3);
    }
}