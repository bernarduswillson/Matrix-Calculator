import java.util.Scanner;
public class InverseReduct {
    static void ForwardOBE(double[][] Mat, double[][] MatAns) {
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
                    double[] temp = MatAns[i]; 
                    MatAns[i] = MatAns[Max]; 
                    MatAns[Max] = temp;
                    for (int k = i + 1; k < ROW; k++) {
                        double Const = Mat[k][i] / Mat[i][i];
                        for (int l = 0; l < COL; l++){
                            Mat[k][l] -= Const * Mat[i][l];
                            MatAns[k][l] -= Const * MatAns[i][l];
                        }       
                    }
                }
                else {
                    for (int k = i + 1; k < ROW; k++) {
                        double Const = Mat[k][i] / Mat[i][i];
                        for (int l = 0; l < COL; l++){
                            Mat[k][l] -= Const * Mat[i][l];
                            MatAns[k][l] -= Const * MatAns[i][l];
                        }       
                    }
                }
            }
        }
        for (int i = 0; i < ROW; i++) {
            double Const1 = Mat[i][i];
            for (int j = 0; j < COL; j++) {
                Mat[i][j] = (Mat[i][j])/(Const1);
                MatAns[i][j] = (MatAns[i][j])/(Const1);
            }
        }
    }

    static void BackwardOBE(double[][] Mat, double[][] MatAns) {
        int ROW = Mat.length;
        for (int i = ROW - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double Const = Mat[j][i] / Mat[i][i];
                for (int k = ROW-1; k >= 0; k--) {
                    Mat[j][k] -= Const * Mat[i][k];
                    MatAns[j][k] -= Const * MatAns[i][k];
                } 
            }
        }
        PrintEselon(Mat, MatAns);
    }
    
    static void PrintEselon(double[][] Mat, double[][] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil matriks setelah di-REDUKSI: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", Mat[i][j]);
            }
            System.out.print("  |\t");
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", MatAns[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM INVERS REDUKSI\n");
        System.out.print("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
        int ROW = input.nextInt();
        int COL = input.nextInt();
        System.out.println();
        double[][] Matrix = new double[ROW][COL];
        double[][] IdentityMat = new double[ROW][COL];
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
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (i == j) {
                        IdentityMat[i][j] = 1;
                    }
                    else {
                        IdentityMat[i][j] = 0;
                    }
                }
            }
        }
        System.out.println();
        ForwardOBE(Matrix, IdentityMat);
        BackwardOBE(Matrix, IdentityMat);
        System.out.println();
        System.out.println("Hasil invers matriks menggunakan REDUKSI: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", IdentityMat[i][j]);
            }
            System.out.println();
        }
    }
}