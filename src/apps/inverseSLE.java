package apps;

import algorithm.inverseMatrix;
import algorithm.multiplyMatrix;
import utility.*;

public class inverseSLE {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("GAUSS ELIMINATION METHOD");
        menu.border();

        matrixData matrixData = inputMatrix.inputMat();
        double[][] matrix = matrixData.getMatrix();
        double[] matrixAns = matrixData.getMatrixAns();
        int row = matrix.length;
        int col = matrix[0].length;

        if (row != col) {
            System.out.println("The matrix is not a square matrix!\n");
            menu.backToMenu();
        }
        
        double[] solution = multiplyMatrix.calculate(inverseMatrix.calculate(matrix), matrixAns);
        print.solution(solution, 3);

        // input.close();
    }
}