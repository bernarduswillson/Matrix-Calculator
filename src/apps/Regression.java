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
<<<<<<< HEAD:src/function/Regression.java
                            temp += matriks[k][j];
=======
                            matriks[i][j] = rowcol;
>>>>>>> 30ab9b76f4b402f3992218ea134666c4044915c6:src/apps/Regression.java
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
        for (int i=0; i<row; i++){
            double temp1 = 0;
            for (int j=0; j<row; j++){
                if (i==0){
                    temp1 += matriksans[j];
                }
                else{
                    temp1 += matriksans[j] * matriks[j][col];
                }
            }
            matrikz[i][col+1] = temp1;
        }
         SPLGaussJordan obe2 = new SPLGaussJordan();
    }
}