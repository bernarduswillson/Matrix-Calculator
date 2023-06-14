package apps;
import java.util.Scanner;

import algorithm.determinantCofactor;
import utility.*;

public class crammerSLE{
    public static void functionSPLCrammer() throws Exception {
        double matrix[][] = new double[0][0];
        double matrixAns[] = new double[0];
        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();
        int ROW = 0;
        int COL = 0;

        menu.border();
        System.out.println("CRAMMER'S RULE METHOD");
        menu.border();

        if (choice == 1) {
            System.out.print("Insert the size of the matrix (ROW COL): ");
            ROW = input.nextInt();
            COL = input.nextInt();
            matrix = new double[ROW][COL];
            matrixAns = new double[ROW];
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
            COL--;
        }
        
        if (ROW != COL) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }
        else if (determinantCofactor.calculate(matrix) == 0) {
            System.out.println("Cannot be solved because the determinant is 0!\n");
            menu.backToMenu();
        }

        double[][] subMatrix = new double[ROW][COL];
        double determinant = determinantCofactor.calculate(matrix);
        double[] solution = new double[ROW];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < ROW; j++) {
                for (int k = 0; k < COL; k++) {
                    if (k == i) {
                        subMatrix[j][k] = matrixAns[j];
                    } else {
                        subMatrix[j][k] = matrix[j][k];
                    }
                }
            }
            solution[i] = determinantCofactor.calculate(subMatrix) / determinant;
        }
        
        print.solution(solution, 4);
        // input.close();
    }
}