import java.util.Scanner;
public class SPLGaussJordan {
    public void Gauss(double[][] Mat, double[] MatAns) {
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
    }

    public void GaussJordan(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        for (int i = ROW - 1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                double Const = Mat[j][i] / Mat[i][i];
                MatAns[j] -= Const * MatAns[i];
                for (int k = i; k >= 0; k--) {
                    Mat[j][k] -= Const * Mat[i][k];
                } 
            }
        }
        PrintEselon(Mat, MatAns);
        System.out.println();
        System.out.println("Solusi SPL dengan metode GAUSS-JORDAN: ");
        for (int i = 0; i < MatAns.length; i++) {
            System.out.printf("X"+(i+1)+" = %.3f\n", MatAns[i]);
        }
    }
    
    public void PrintEselon(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil matriks setelah menggunakan GAUSS-JORDAN: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t ", Mat[i][j]);
            }
            System.out.printf("  |\t%.3f\n", MatAns[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM ELIMINASI GAUSS\n");
        SPLGaussJordan ge = new SPLGaussJordan();
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
        ge.Gauss(Matrix, MatrixAns);
        ge.GaussJordan(Matrix, MatrixAns);
    }
}