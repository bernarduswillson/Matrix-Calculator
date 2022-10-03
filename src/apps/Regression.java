import java.util.*;
public class Regression
{
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
        double[][] matriks = new double[row][col+1];
        System.out.print("Masukan Sampel : ");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matriks[i][j] = input.nextDouble();
            }
        }
        double[][] matrikz = new double[col+1][col+2];
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
        SPLGauss obe = new SPLGauss();
        SPLGaussJordan obe2 = new SPLGaussJordan();
        double[][] m1;
        double[] m2;
        m1 = seperateMatrix(matrikz, col+1, col+2);
        m2 = seperateMatrix1(matrikz, col+1, col+2);
        obe.ForwardOBE(m1, m2);
        obe2.BackwardOBE(m1, m2);
        double sum = row;
        for (int i=0; i<row; i++){
            sum += x[i]*m2[i];
        }
        System.out.println("Hasil Regresi : ");
        System.out.println("y = "+sum);
    }
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
    public static void main(String[] args)
    {

        Regresi();
    }
}