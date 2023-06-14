package utility;

import java.io.*;
import java.util.*;

public class inputMatrix {
    public static int inputMenu() {
        Scanner input = new Scanner(System.in);
        boolean status = true;
        int choice = 0;
        while (status) {
            System.out.println("1. Keyboard input");
            System.out.println("2. File input");
            menu.border();
            System.out.println("Choose Input (1-2): ");
            try {
                choice = input.nextInt();
                System.out.println();
                if (choice <= 2 && choice >= 1) {
                    status = false;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not valid");
                continue;
            } catch (Exception e) {
                System.exit(0);
                ;
            }
        }
        // input.close();
        return choice;
    }

    public static double[][] readFileBicubic() throws Exception {
        try {
            // input file
            System.out.println("Insert file name (example: bernard.txt): ");
            Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();
            System.out.println(' ');
            // if file is empty
            if (Objects.isNull(fileName)) {
                // input.close();
                throw new Exception();
            }

            // update path
            String currentDirectory = System.getProperty("user.dir");
            String parentDirectory = new File(currentDirectory).getParent();
            String path = parentDirectory + '\\' + "test" + '\\' + fileName;
            File file = new File(path);

            double[][] Matrix = new double[5][4];
            Scanner fileMatrix = new Scanner(file);

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Matrix[i][j] = fileMatrix.nextDouble();
                }
            }
            Matrix[4][0] = fileMatrix.nextDouble();
            Matrix[4][1] = fileMatrix.nextDouble();
            Matrix[4][2] = 0;
            Matrix[4][3] = 0;

            fileMatrix.close();
            // input.close();
            return Matrix;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.out.println();
            menu.backToMenu();
            return new double[0][0];
        }
    }

    public static double[][] readFile() throws Exception {
        try {
            // input file
            System.out.println("Insert file name (example: bernard.txt): ");
            Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();
            System.out.println();

            // if file is empty
            if (Objects.isNull(fileName)) {
                throw new Exception();
            }

            // update path
            String currentDirectory = System.getProperty("user.dir");
            String parentDirectory = new File(currentDirectory).getParent();
            String path = parentDirectory + '\\' + "test" + '\\' + fileName;
            File file = new File(path);
            Scanner fileContent = new Scanner(file);

            // hitung row, col
            int col = 0;
            int row = 0;
            while (fileContent.hasNextLine()) {
                String lineKotor = fileContent.nextLine();
                String[] lineBersih = lineKotor.trim().split(" ");
                col = lineBersih.length;
                row++;
            }
            // fileContent.close();

            // input matrix
            double[][] Matrix = new double[row][col];
            Scanner fileMatrix = new Scanner(file);
            while (fileMatrix.hasNextLine()) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        Matrix[i][j] = fileMatrix.nextDouble();
                    }
                }
            }
            // fileMatrix.close();
            // input.close();
            return Matrix;
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.out.println();
            menu.backToMenu();
            return new double[0][0];
        }
    }

    public static double[][] convertMatrix(double[][] matriks, int row, int col) {
        double[][] m1 = new double[row][col - 1];
        double[] m2 = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - 1; j++) {
                m1[i][j] = matriks[i][j];
            }
            m2[i] = matriks[i][col - 1];
        }
        return m1;
    }

    public static double[] convertMatrixAns(double[][] matriks, int row, int col) {
        double[][] m1 = new double[row][col - 1];
        double[] m2 = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - 1; j++) {
                m1[i][j] = matriks[i][j];
            }
            m2[i] = matriks[i][col - 1];
        }
        return m2;
    }
    
    public static matrixData inputMat() throws Exception {
        int row = 0;
        int col = 0;
        double[][] mat = null;
        double[] matAns = null;
        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();

        if (choice == 1) {
            System.out.print("Insert the size of the matrix (ROW COL): ");
            row = input.nextInt();
            col = input.nextInt();
            mat = new double[row][col];
            matAns = new double[row];
            System.out.println();

            System.out.println(
                    "Insert the elements of the matrix (use space as separator and enter to move to next row): ");
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    mat[i][j] = input.nextDouble();
            System.out.println();

            System.out.println(
                    "Insert the elements of the matrix answer (use space as separator and enter to move to next row): ");
            for (int i = 0; i < row; i++)
                matAns[i] = input.nextDouble();
            System.out.println();

        } else if (choice == 2) {
            double[][] matrixFile = inputMatrix.readFile();
            row = matrixFile.length;
            col = matrixFile[0].length;
            mat = inputMatrix.convertMatrix(matrixFile, row, col);
            matAns = inputMatrix.convertMatrixAns(matrixFile, row, col);
        }

        return new matrixData(mat, matAns);
    }
    
    public static matrixData inputMatOnly() throws Exception {
        int row = 0;
        int col = 0;
        double[][] mat = null;
        double[] matAns = null;
        double[][] appendedMatrix = null;
        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();

        if (choice == 1) {
            System.out.print("Insert the size of the matrix (ROW COL): ");
            row = input.nextInt();
            col = input.nextInt();
            mat = new double[row][col];
            System.out.println();

            System.out.println("Insert the elements of the matrix (use space as separator and enter to move to next row): ");
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    mat[i][j] = input.nextDouble();
            System.out.println();

        } else if (choice == 2) {
            double[][] matrixFile = inputMatrix.readFile();
            row = matrixFile.length;
            col = matrixFile[0].length;
            mat = inputMatrix.convertMatrix(matrixFile, row, col);
            matAns = inputMatrix.convertMatrixAns(matrixFile, row, col);

            appendedMatrix = new double[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col - 1; j++) {
                    appendedMatrix[i][j] = mat[i][j];
                }
                appendedMatrix[i][col - 1] = matAns[i];
            }
        }

        return new matrixData(appendedMatrix, matAns);
    }
}