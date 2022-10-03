package apps;
import java.util.Scanner;

import function.inputMatrix;
import function.*;
import utility.*;
public class SPLGauss {
    static void ForwardOBE(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        for (int i = 0; i < ROW; i++) {
            int Max = i;
            for (int j = i + 1; j < ROW; j++) {
                if (Math.abs(Mat[j][i]) > Math.abs(Mat[Max][i])) {
                    Max = j;
                    double[] Temp = Mat[i]; 
                    Mat[i] = Mat[Max]; 
                    Mat[Max] = Temp;
                    double temp = MatAns[i]; 
                    MatAns[i] = MatAns[Max]; 
                    MatAns[Max] = temp;
                    for (int k = i + 1; k < ROW; k++) {
                        double Const = Mat[k][i] / Mat[i][i];
                        MatAns[k] -= Const * MatAns[i];
                        for (int l = i; l < COL; l++){
                            Mat[k][l] -= Const * Mat[i][l];
                        }       
                    }
                }
                else {
                    for (int k = i + 1; k < ROW; k++) {
                        double Const = Mat[k][i] / Mat[i][i];
                        MatAns[k] -= Const * MatAns[i];
                        for (int l = i; l < COL; l++){
                            Mat[k][l] -= Const * Mat[i][l];
                        }       
                    }
                }
            }
        }
        for (int i = 0; i < ROW; i++) {
            double Const1 = Mat[i][i];
            for (int j = 0; j < COL; j++) {
                Mat[i][j] = (Mat[i][j])/(Const1);
            }
            MatAns[i] = (MatAns[i])/(Const1);
        }
        
        System.out.println();
        // double[] Solution = new double[ROW];
        // for (int i = ROW - 1; i >= 0; i--) {
        //     double Sum = 0;
        //     for (int j = i + 1; j < ROW; j++) 
        //         Sum += Mat[i][j] * Solution[j];
        //     Solution[i] = (MatAns[i] - Sum) / Mat[i][i];
        // }
        // PrintSolution(Solution);
    }

    static void PrintEselon(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil matriks setelah menggunakan GAUSS: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", Mat[i][j]);
            }
            System.out.printf("  |\t%.3f\n", MatAns[i]);
        }
    }

    static void PrintSolution(double[] Sol) {
        int ROW = Sol.length;
        System.out.println("Solusi SPL dengan metode GAUSS: ");
        for (int i = 0; i < ROW; i++) {
            System.out.print("X"+(i+1)+" = ");
            System.out.printf("%.4f\n", Sol[i]);
        }
        System.out.println();     
    }

    public static void functionSPLGauss() throws Exception {
        Scanner input = new Scanner(System.in);
        menu.batas();
        System.out.println("PROGRAM ELIMINASI GAUSS\n");
        menu.batas();
        int choice = inputMatrix.inputMenu();
        if (choice == 1)
        {
            System.out.print("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
            int ROW = input.nextInt();
            int COL = input.nextInt();
            System.out.println();
            double[][] Matrix = new double[ROW][COL];
            double[] MatrixAns = new double[ROW];
            System.out.println("Masukkan elemen matriks (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
            for (int i = 0; i < ROW; i++)
                for (int j = 0; j < COL; j++)
                    Matrix[i][j] = input.nextDouble();
            System.out.println();
            System.out.println("Masukkan elemen matriks jawaban (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
            for (int i = 0; i < ROW; i++)
                MatrixAns[i] = input.nextDouble();
            System.out.println();
            ForwardOBE(Matrix, MatrixAns);
            PrintEselon(Matrix, MatrixAns);
            double[] Solution = new double[ROW];
            for (int i = ROW - 1; i >= 0; i--) {
                double Sum = 0;
                for (int j = i + 1; j < ROW; j++) 
                    Sum += Matrix[i][j] * Solution[j];
                Solution[i] = (MatrixAns[i] - Sum) / Matrix[i][i];
            }
            PrintSolution(Solution);
        }
        else if (choice == 2)
        {
            double[][] Matrix = inputMatrix.readFile();
            int ROW = Matrix.length;
            int COL = Matrix[0].length;
            if (ROW != (COL - 1)) 
            {
                System.out.println("Tidak dapat diperoleh penyelesaian karena bukan matriks persegi!\n");
            }
            else
            {
                double[][] MatrixEq = Regression.seperateMatrix(Matrix, ROW, COL);
                double[] MatrixAns = Regression.seperateMatrix1(Matrix, ROW, COL);
                ForwardOBE(MatrixEq, MatrixAns);
                PrintEselon(MatrixEq, MatrixAns);
                double[] Solution = new double[ROW];
                for (int i = ROW - 1; i >= 0; i--) {
                    double Sum = 0;
                    for (int j = i + 1; j < ROW; j++) 
                        Sum += MatrixEq[i][j] * Solution[j];
                    Solution[i] = (MatrixAns[i] - Sum) / MatrixEq[i][i];
                }
                PrintSolution(Solution);
            }
            
        }
        menu.backToMenu();
    }
}