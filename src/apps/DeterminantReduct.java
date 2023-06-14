package Apps;
import java.util.Scanner;

import Utility.inputMatrix;
import Utility.menu;

public class DeterminantReduct {
    static void DeterminantR(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        int P = 0;
        for (int i = 0; i < ROW; i++) {
            int Max = i;
            for (int j = i + 1; j < ROW; j++) { 
                if (Math.abs(Mat[j][i]) > Math.abs(Mat[Max][i])) {
                    Max = j;
                    double[] Temp = Mat[i]; 
                    Mat[i] = Mat[Max];
                    Mat[Max] = Temp;
                    for (int k = i + 1; k < ROW; k++) {
                        double Const = Mat[k][i] / Mat[i][i];
                        for (int l = i; l < COL; l++) {
                            Mat[k][l] -= Const * Mat[i][l];
                        }
                    }
                    P++;
                }
                else {
                    for (int k = i + 1; k < ROW; k++) {
                        double Const = Mat[k][i] / Mat[i][i];
                        for (int l = i; l < COL; l++) {
                            Mat[k][l] -= Const * Mat[i][l];
                        }
                    }
                }
            }
        }
        PrintEselon(Mat);
        double Determinant = 1;
        for (int i = 0; i < ROW; i++) {
            Determinant *= Mat[i][i];
        }
        System.out.printf("Hasil determinan menggunakan REDUKSI: %.3f\n", Determinant*Math.pow(-1,P));
    }

    static void PrintEselon(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil matriks setelah direduksi: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f ", Mat[i][j]);
            }  
            System.out.println();
        }
        System.out.println();
    }

    public static void functionDetReduct() throws Exception {
        Scanner input = new Scanner(System.in);
        menu.border();
        System.out.println("PROGRAM DETERMINAN REDUKSI\n");
        menu.border();
        int choice = inputMatrix.inputMenu();
        if (choice == 1)
        {
            System.out.print("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
            int ROW = input.nextInt();
            int COL = input.nextInt();
            System.out.println();
            double[][] Matrix = new double[ROW][COL];
            if (ROW != COL) {
                System.out.println("Matriks tidak mempunyai determinan karena bukan matriks persegi!\n");
            }
            else {
                System.out.println("Masukkan elemen matriks (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
                for (int i = 0; i < ROW; i++) {
                    for (int j = 0; j < COL; j++) {
                        Matrix[i][j] = input.nextDouble();
                    }
                }
            }
            System.out.println();
            DeterminantR(Matrix);
        }
        else if (choice == 2)
        {
            double[][] Matrix = inputMatrix.readFile();
            int ROW = Matrix.length;
            int COL = Matrix[0].length;
            if (ROW != COL) 
            {
                System.out.println("Matriks tidak mempunyai determinan karena bukan matriks persegi!\n");
            }
            else
            {
                System.out.println();
                DeterminantR(Matrix);
            }
        }
        else
        {
            System.out.println("Input tidak valid!");
        }
        menu.backToMenu();
    }
}