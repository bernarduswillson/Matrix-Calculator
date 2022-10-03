package function
import java.io.*;
import java.util.*;

public class inputMatrix 
{
    public static void main(String[] args) throws Exception 
    {
        readFile();
    }

    public static void inputMenu() 
    {
        System.out.println("1. Input manual");
        System.out.println("2. Input dari file");
        System.out.println("3. Kembali ke menu utama");
        System.out.print("Pilihan: ");
    }

    public static void readFile() throws Exception
    {
        try 
        {
            // input file
            System.out.println("Masukkan nama file (contoh: bernard.txt): ");
            Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();

            // kalau file kosong
            if (Objects.isNull(fileName))
            {
                throw new Exception();
            }
            
            // update path
            String path = System.getProperty("user.dir") + "/" + fileName;
            System.out.println(path);
            File file = new File(path);
            Scanner fileContent = new Scanner(file);

            // hitung row, col
            int col = 0;
            int row = 0;
            while (fileContent.hasNextLine()) 
            {
                String lineKotor = fileContent.nextLine();
                String[] lineBersih = lineKotor.trim().split(" ");
                col = lineBersih.length;
                row++;
            }
            fileContent.close();
            
            System.out.println("row: " + row);
            System.out.println("col: " + col);

            // input matrix
            double[][] Matrix = new double[row][col];
            Scanner fileMatrix = new Scanner(file);
            while (fileMatrix.hasNextLine()) 
            {
                for (int i = 0; i < row; i++) 
                {
                    for (int j = 0; j < col; j++) 
                    {
                        Matrix[i][j] = fileMatrix.nextDouble();
                    }
                }
            }
            fileMatrix.close();
            //return Matrix;
            for (int i = 0; i < row; i++) 
            {
                for (int j = 0; j < col; j++) 
                {
                    System.out.printf("%.3f\t", Matrix[i][j]);
                }
                System.out.println();
            }
        }

        catch (FileNotFoundException e) 
        {
            System.out.println("File tidak ditemukan!");
            //return new double[0][0];
        }
    } 
}

