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
        SPLGaussJordan obe2 = new SPLGaussJordan();
        obe2.ForwardOBE(seperateMatrix(matrikz, row, col));
        
    }
    public static void seperateMatrix(double[][] matriks, int row, int col){
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
    }
}