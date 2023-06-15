package apps;

import java.util.*;

import algorithm.backwardElimination;
import algorithm.forwardElimination;
import algorithm.multiplyMatrix;
import utility.*;

public class bicubicInterpolate {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("BICUBIC INTERPOLATION");
        menu.border();

        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();
        double result = 0;
        double x = 0;
        double y = 0;
        double[][] matrix = new double[4][4];
        double[] matrixNew = new double[16];
        double[] matrixResult = new double[16];

        if (choice == 1) {
            System.out
                    .println(
                            "Insert the elements of the matrix (use space as separator and enter to move to next row): ");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = input.nextDouble();
                }
            }
            System.out.println();

        } else if (choice == 2) {
            double[][] matrixFile = inputMatrix.readFile();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = matrixFile[i][j];
                }
            }
        }

        matrixNew = reshape(matrix, 16);
        matrixResult = interpolateMatrix(matrixNew);

        System.out.print("Insert the value of X: ");
        x = input.nextDouble();
        System.out.print("Insert the value of Y: ");
        y = input.nextDouble();

        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result = result + matrixResult[k] * Math.pow(x, i) * Math.pow(y, j);
                k++;
            }
        }
        System.out.println();
        System.out.printf("f(" + x + ", " + y + ") = %.3f\n", result);
        System.out.println();

        menu.backToMenu();
    }

    public static double[] interpolateMatrix(double[] matrix) {
        double[][] matBase = new double[16][16];
        int K = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                matBase[0][K] = Math.pow((-1), i) * Math.pow((-1), j);
                matBase[1][K] = Math.pow((0), i) * Math.pow((-1), j);
                matBase[2][K] = Math.pow((1), i) * Math.pow((-1), j);
                matBase[3][K] = Math.pow((2), i) * Math.pow((-1), j);
                matBase[4][K] = Math.pow((-1), i) * Math.pow((0), j);
                matBase[5][K] = Math.pow((0), i) * Math.pow((0), j);
                matBase[6][K] = Math.pow((1), i) * Math.pow((0), j);
                matBase[7][K] = Math.pow((2), i) * Math.pow((0), j);
                matBase[8][K] = Math.pow((-1), i) * Math.pow((1), j);
                matBase[9][K] = Math.pow((0), i) * Math.pow((1), j);
                matBase[10][K] = Math.pow((1), i) * Math.pow((1), j);
                matBase[11][K] = Math.pow((2), i) * Math.pow((1), j);
                matBase[12][K] = Math.pow((-1), i) * Math.pow((2), j);
                matBase[13][K] = Math.pow((0), i) * Math.pow((2), j);
                matBase[14][K] = Math.pow((1), i) * Math.pow((2), j);
                matBase[15][K] = Math.pow((2), i) * Math.pow((2), j);
                K++;
            }
        }
        
        double[][] matId = new double[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (i == j) {
                    matId[i][j] = 1;
                } else {
                    matId[i][j] = 0;
                }
            }
        }

        double[] matResult = new double[16];
        backwardElimination.calculateId(matBase, matId);
        forwardElimination.calculateId(matBase, matId);
        matResult = multiplyMatrix.calculate(matId, matrix);
        return matResult;
    }
    
    public static double[] reshape(double[][] matrix, int row) {
        double[] matResult = new double[row];
        int x = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matResult[x] = matrix[i][j];
                x++;
            }
        }
        return matResult;
    }
}