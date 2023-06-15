package apps;

import cek.backSubstitution;
import cek.forwardElimination;
import utility.*;

public class gaussSLE {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("GAUSS ELIMINATION METHOD");
        menu.border();

        matrixData matrixData = inputMatrix.inputMat();
        double[][] matrix = matrixData.getMatrix();
        double[] matrixAns = matrixData.getMatrixAns();

        forwardElimination.calculate(matrix, matrixAns);
        print.echelonForm(matrix, matrixAns, 1);
        double[] solution = backSubstitution.calculate(matrix, matrixAns);
        print.solution(solution, 1);
    }
}