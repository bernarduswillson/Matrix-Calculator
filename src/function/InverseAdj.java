import java.util.Scanner;
public class InverseAdj{
    // USABLE
    static double Determinant(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        if (ROW == 1) {
            return Mat[0][0];
        }
        else {
            double Determinant = 0;
            for (int i = 0; i < ROW; i++) {
                double[][] subMatrix = new double[ROW-1][COL-1];
                for (int j = 0; j < ROW-1; j++) {
                    for (int k = 0; k < COL-1; k++) {
                        if (k < i) {
                            subMatrix[j][k] = Mat[j+1][k];
                        }
                        else {
                            subMatrix[j][k] = Mat[j+1][k+1];
                        }
                    }
                }
                Determinant += Mat[0][i]*Math.pow(-1,i)*Determinant(subMatrix);
            }
            if (Determinant == 0) {
                System.out.println("Matriks tidak memiliki invers karena determinannya 0!");
                System.exit(0);
            }
        return Determinant;
        }  
    }

    static double[][] Cofactor(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] Cofactor = new double[ROW][COL];
        if (ROW == 1) {
            Cofactor[0][0] = 1;
            return Cofactor;
        }
        else {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    double[][] subMatrix = new double[ROW-1][COL-1];
                    for (int k = 0; k < ROW-1; k++) {
                        for (int l = 0; l < COL-1; l++) {
                            if (k < i) {
                                if (l < j) {
                                    subMatrix[k][l] = Mat[k][l];
                                }
                                else {
                                    subMatrix[k][l] = Mat[k][l+1];
                                }
                            }
                            else {
                                if (l < j) {
                                    subMatrix[k][l] = Mat[k+1][l];
                                }
                                else {
                                    subMatrix[k][l] = Mat[k+1][l+1];
                                }
                            }
                        }
                    }
                    Cofactor[i][j] = (double)Math.pow(-1,i+j)*Determinant(subMatrix);
                }
            }
            return Cofactor;
        }
    }

    static double[][] Transpose(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = i; j < COL; j++) {
                double Temp = Mat[i][j];
                Mat[i][j] = Mat[j][i];
                Mat[j][i] = Temp;
            }
        }
        return Mat;
    }

    static double[][] Inverse(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] Inverse = new double[ROW][COL];
        if (ROW == 1) {
            Inverse[0][0] = 1/Mat[0][0];
            return Inverse;
        }
        else {
            double[][] Cofactor = Cofactor(Mat);
            Inverse = MultiplyByConst(Transpose(Cofactor),(1/Determinant(Mat)));
            return Inverse;
        }
    }

    static double[][] MultiplyByConst(double[][] Mat, double k) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] mOut = new double[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mOut[i][j] = Mat[i][j] * k;
            }
        }
        return mOut;
    }
    // *USABLE

    static void PrintInverse(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil invers matriks menggunakan ADJOIN: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f ", Mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM INVERS ADJOIN\n");
        System.out.println("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
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
                    Matrix[i][j] = input.nextInt();
                }
            }
        System.out.println();
        PrintInverse(Inverse(Matrix));
        }
    }
}