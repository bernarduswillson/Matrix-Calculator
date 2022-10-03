package function;
import java.io.*;
import java.util.*;
import utility.*;


public class inputMatrix 
{
    // public static void main(String[] args) throws Exception 
    // {
    //     readFile();
    // }

    public static int inputMenu() 
    {
        String batas = "=======================================";
        Scanner input = new Scanner(System.in);
        boolean status = true;
        int choice = 0;

        while(status)
        {
            System.out.println("1. Input dari console");
            System.out.println("2. Input dari file");
            System.out.println(batas);
            System.out.println("Pilihan: ");
            try 
            {
                choice = input.nextInt();
                if (choice <= 2 && choice >= 1)
                {
                    status = false;
                }

                else
                {
                    System.out.println("Inputan salah");
                }
            } 

            catch (NumberFormatException e) 
            {
                System.out.println("Inputan tidak valid");
                continue;
            }

            catch (Exception e) 
            {
                System.exit(0);;
            }
        }
        return choice;
    }

    public static double[][] readFile() throws Exception
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
            return Matrix;

            // test matrix
            // for (int i = 0; i < row; i++) 
            // {
            //     for (int j = 0; j < col; j++) 
            //     {
            //         System.out.printf("%.3f\t", Matrix[i][j]);
            //     }
            //     System.out.println();
            // }
        }

        catch (FileNotFoundException e) 
        {
            System.out.println("File tidak ditemukan!");
            return new double[0][0];
        }
    } 
}

