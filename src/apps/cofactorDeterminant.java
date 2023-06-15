package apps;

import algorithm.cofactorExpansion;
import utility.*;

public class cofactorDeterminant {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("COFACTOR EXPANSION METHOD FOR DETERMINANT");
        menu.border();

        matrixData matrixData = inputMatrix.inputMatOnly();
        double[][] matrix = matrixData.getMatrix();
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }

        double determinant = cofactorExpansion.calculate(matrix);
        print.determinant(determinant, 1);
    }
}