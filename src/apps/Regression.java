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
        double[][] matriks = new double[row][col];
        double[] matriksans = new double[row];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.print("Masukkan nilai x" + (j+1) + " pada sampel ke-" + (i+1) + ": ");
                matriks[i][j] = input.nextDouble();
                System.out.println();
            }
            System.out.println("Masukkan nilai y" + (i+1) + ": ");
            matriksans[i] = input.nextDouble();
        }

        // normal estimation equation 
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                for (int k = 0; k < row; k++)
                {
                    if (i == 0)
                    {
                        if (j == 0)
                        {
                            matriks[i][j] = row;
                        }
                        else
                        {
                            matriks[i][j] = rowcol;
                        }
                    }
                    else
                    {
                        if (j == 0)
                        {
                            matriks[i][j] = colsum(matriks, (i-1));
                        }
                        else
                        {
                            matriks[i][j] = twocolsum(matriks, (i-1), (j-1));
                        }
                    }
                }
            }

        }
    }
}