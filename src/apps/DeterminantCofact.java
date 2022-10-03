package apps;
import java.util.Scanner;

public class DeterminantCofact {
    static double DeterminantC(double[][] Mat) {
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
                Determinant += Mat[0][i]*Math.pow(-1,i)*DeterminantC(subMatrix);
            }
            return Determinant;
        }
    }

    public static void functionDetCofact() {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM DETERMINAN KOFAKTOR\n");
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
            System.out.println();
            System.out.printf("Hasil determinan menggunakan KOFAKTOR: %.3f\n", DeterminantC(Matrix));
        }
    }
}