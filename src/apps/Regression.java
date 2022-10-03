package apps;
import java.util.*;
public class Regression
{
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
        //PrintEselon(Mat, MatAns);
        System.out.println();
        double[] Solution = new double[ROW];
        for (int i = ROW - 1; i >= 0; i--) {
            double Sum = 0;
            for (int j = i + 1; j < ROW; j++) 
                Sum += Mat[i][j] * Solution[j];
            Solution[i] = (MatAns[i] - Sum) / Mat[i][i];
        }        
        //PrintSolution(Solution);
    }
    static void BackwardOBE(double[][] Mat, double[] MatAns) {
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
// USABLE

    public static double[][] seperateMatrix(double[][] matriks, int row, int col){
        double[][] m1 = new double[row][col-1];
        double[] m2 = new double[row];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col-1; j++)
            {
                m1[i][j] = matriks[i][j];
            }
            m2[i] = matriks[i][col-1];
        }
        return m1;
    }
    public static double[] seperateMatrix1(double[][] matriks, int row, int col){
        double[][] m1 = new double[row][col-1];
        double[] m2 = new double[row];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col-1; j++)
            {
                m1[i][j] = matriks[i][j];
            }
            m2[i] = matriks[i][col-1];
        }
        return m2;
    }

    public static void Regresi ()
    {  
        Scanner input = new Scanner(System.in);
        
        // set persamaan
        System.out.println("Masukkan jumlah variabel x: ");
        int col = input.nextInt();
        System.out.println("Masukkan jumlah sampel: ");
        int row = input.nextInt(); 
        System.out.println("Masukan nilai x1 sampai xn: ");
        double[] x= new double[col];
        for (int i = 0; i < col; i++)
        {
            x[i] = input.nextDouble();
        }
        double[][] matriks = new double[row][col+1];
        System.out.print("Masukan Sampel : ");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matriks[i][j] = input.nextDouble();
            }
        }
        double[][] matrikz = new double[col+2][col+3];
        // normal estimation equation 
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                double temp = 0;
                for (int k = 0; k < row; k++)
                {
                    if (i == 0)
                    {
                        if (j == 0)
                        {
                            temp += row;
                        }
                        else
                        {
                            temp += matriks[k][j];
                        }
                    }
                    else
                    {
                        if (j == 0)
                        {
                            temp += matriks[k][i];
                        }
                        else
                        {
                            temp += matriks[k][i] * matriks[k][j];
                        }
                    }
                }
                matrikz[i][j] = temp;

            }

        }
        // SPLGauss obe = new SPLGauss();
        // SPLGaussJordan obe2 = new SPLGaussJordan();
        double[][] m1;
        double[] m2;
        m1 = seperateMatrix(matrikz, col+2, col+3);
        m2 = seperateMatrix1(matrikz, col+2, col+3);
        ForwardOBE(m1, m2);
        BackwardOBE(m1, m2);
        PrintEselon(m1, m2);
        double sum = m2[0];
        for (int i=0; i<col; i++){
            sum += x[i]*m2[i+1];
        }
        System.out.println("Hasil Regresi : ");
        //System.out.println("y = "+sum);
    }

    public static void main(String[] args)
    {
        Regresi();
    }
}