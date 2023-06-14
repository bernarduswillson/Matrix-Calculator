package Apps;

import java.util.Scanner;

import Algorithm.multiplyMatrix;
import Algorithm.inverseMatrix;
import Utility.*;

public class inverseSLE {
    public static void functionSPLInverse() throws Exception {
        double matrix[][] = new double[0][0];
        double matrixAns[] = new double[0];
        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();
        int ROW = 0;
        int COL = 0;

        menu.border();
        System.out.println("INVERSE MATRIX METHOD");
        menu.border();

        if (choice == 1) {
            System.out.print("Insert the size of the matrix (ROW COL): ");
            ROW = input.nextInt();
            COL = input.nextInt();
            System.out.println();

            System.out
                    .println(
                            "Insert the elements of the matrix (use space as separator and enter to move to next row): ");
            for (int i = 0; i < ROW; i++)
                for (int j = 0; j < COL; j++)
                    matrix[i][j] = input.nextDouble();
            System.out.println();

            System.out.println(
                    "Insert the elements of the matrix answer (use space as separator and enter to move to next row): ");
            for (int i = 0; i < ROW; i++)
                matrixAns[i] = input.nextDouble();
            System.out.println();

        } else if (choice == 2) {
            double[][] matrixFile = inputMatrix.readFile();
            ROW = matrixFile.length;
            COL = matrixFile[0].length;
            matrix = inputMatrix.convertMatrix(matrixFile, ROW, COL);
            matrixAns = inputMatrix.convertMatrixAns(matrixFile, ROW, COL);
        }
        
        double[] matrixOut = multiplyMatrix.calculate(inverseMatrix.calculate(matrix), matrixAns);
        print.solution(matrixOut, 3);
    }
}