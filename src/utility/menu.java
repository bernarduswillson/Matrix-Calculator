package utility;
import java.util.*;

import apps.*;
import function.*;
public class menu
{
    public static void main(String[] args) throws Exception 
    {
        backToMenu();
        // mainMenu();
    }
    
    public static void mainMenu () throws Exception
    {
        Scanner input = new Scanner(System.in);
        batas();
        System.out.println("KALKULATOR MATRIKS");
        Boolean status = true;
        int choice = 0;
        while (status)
        {
            batas();
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic");
            System.out.println("6. Regresi linier berganda");
            System.out.println("7. Keluar");
            batas();
            System.out.println("Pilih kalkulator yang akan digunakan (1-7) : ");
            try {
                choice = input.nextInt();
                if (choice <= 7 && choice >= 1)
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
                mainMenu();
                continue;
            }
            catch (Exception e) 
            {
                System.exit(0);;
            }   
            
        }
        switch (choice) {
            case 1:
                splMenu();
                break;
            case 2:
                detMenu();
                break;
            case 3:
                invMenu();
                break;

            // case 4-6 gaada menu kan ya? lgsg fungsinya?
            case 4:
                PolinomInterpolate.functionPolinomInterpolate();
                break;
            case 5:
                BicubicInterpolate.functionBicubicInterpolate();
                break;
            case 6:
                //regMenu();
                break;
            case 7:
                System.exit(0);;
                break;
            default:
                break;
        }
    }

    public static void splMenu () throws Exception
    {
        String batas = "=======================================";
        Scanner input = new Scanner(System.in);

        System.out.println("SISTEM PERSAMAAN LINIER");
        Boolean status = true;
        int choice = 0;
        while (status)
        {
            batas();
            System.out.println("METODE");
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode matriks balikan");
            System.out.println("4. Kaidah Cramer");
            System.out.println("5. Kembali ke menu utama");
            batas();
            System.out.println("Pilih metode yang akan digunakan (1-7) : ");
            try {
                choice = input.nextInt();
                if (choice <= 5 && choice >= 1)
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
        switch (choice) {
            case 1:
                SPLGauss.functionSPLGauss();
                break;
            case 2:
                SPLGaussJordan.functionSPLGaussJordan();
                break;
            case 3:
                SPLInverse.functionSPLInverse();
                break;
            case 4:
                SPLCrammer.functionSPLCrammer();
                break;
            case 5:
                mainMenu();
                break;
            default:
                break;
        }
    }

    
    public static void detMenu () throws Exception
    {
        String batas = "=======================================";
        Scanner input = new Scanner(System.in);

        System.out.println("DETERMINAN");
        Boolean status = true;
        int choice = 0;
        while (status)
        {
            batas();
            System.out.println("METODE");
            System.out.println("1. Metode ekspansi kofaktor");
            System.out.println("2. Metode matriks reduksi");
            System.out.println("3. Kembali ke menu utama");
            batas();
            System.out.println("Pilih metode yang akan digunakan (1-3) : ");
            try {
                choice = input.nextInt();
                if (choice <= 3 && choice >= 1)
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

        switch (choice) {
            case 1:
                DeterminantCofact.functionDetCofact();
                break;
            case 2:
                DeterminantReduct.functionDetReduct();
                break;
            case 3:
                mainMenu();
                break;
            default:
                break;
        }
    }
    public static void invMenu () throws Exception
    {
        String batas = "=======================================";
        Scanner input = new Scanner(System.in);

        System.out.println("MATRIKS BALIKAN");
        Boolean status = true;
        int choice = 0;
        while (status)
        {
            batas();
            System.out.println("METODE");
            System.out.println("1. Metode adjoin");
            System.out.println("2. Metode matriks reduksi");
            System.out.println("3. Kembali ke menu utama");
            batas();
            System.out.println("Pilih metode yang akan digunakan (1-3) : ");
            try {
                choice = input.nextInt();
                if (choice <= 3 && choice >= 1)
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

        switch (choice) {
            case 1:
                InverseAdj.functionInverseAdj();
                break;
            case 2:
                InverseReduct.functionInverseReduct();
                break;
            case 3:
                mainMenu();
                break;
            default:
                break;
        }
    }

    public static void backToMenu () throws Exception
    {
        System.out.println("Apakah anda ingin menggunakan kalkulator lagi? (y/n)");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("y"))
        {
            mainMenu();
        }
        else if (choice.equals("n"))
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Inputan salah");
            backToMenu();
        }
    }

    public static void batas()   
    {
        String batas = "=======================================";
        System.out.println(batas);
    }
    
}