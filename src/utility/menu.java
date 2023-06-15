package utility;

import java.util.*;

import apps.*;

public class menu {
    public static void main(String[] args) throws Exception {
        mainMenu();
    }

    public static void mainMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        border();
        System.out.println("MATRIX CALCULATOR");
        Boolean status = true;
        int choice = 0;
        while (status) {
            border();
            System.out.println("MENU");
            System.out.println("1. Linear Equation System");
            System.out.println("2. Determinant");
            System.out.println("3. Inverse Matrix");
            System.out.println("4. Polinom Interpolation");
            System.out.println("5. Bicubic Interpolation");
            System.out.println("6. Multiple Linear Regression");
            System.out.println("7. Exit");
            border();
            System.out.println("Choose Menu (1-7) :");
            try {
                choice = input.nextInt();
                System.out.println(' ');
                if (choice <= 7 && choice >= 1) {
                    status = false;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not valid");
                mainMenu();
                continue;
            } catch (Exception e) {
                System.exit(0);
                ;
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
            case 4:
                PolinomInterpolate.functionPolinomInterpolate();
                break;
            case 5:
                BicubicInterpolate.functionBicubicInterpolate();
                break;
            case 6:
                // regMenu();
                break;
            case 7:
                System.exit(0);
                ;
                break;
            default:
                break;
        }
        // input.close();
    }

    public static void splMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("LINEAR EQUATION SYSTEM");
        Boolean status = true;
        int choice = 0;
        while (status) {
            border();
            System.out.println("METHOD");
            System.out.println("1. Gauss Elimination Method");
            System.out.println("2. Gauss-Jordan Elimination Method");
            System.out.println("3. Inverse Matrix Method");
            System.out.println("4. Cramer's Rule Method");
            System.out.println("5. Back to main menu");
            border();
            System.out.println("Choose Method (1-5) : ");
            try {
                choice = input.nextInt();
                System.out.println(' ');
                if (choice <= 5 && choice >= 1) {
                    status = false;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not valid");
                continue;
            } catch (Exception e) {
                System.exit(0);
                ;
            }
        }
        switch (choice) {
            case 1:
                gaussSLE.calculate();
                break;
            case 2:
                gaussJordanSLE.calculate();
                break;
            case 3:
                inverseSLE.calculate();
                break;
            case 4:
                crammerSLE.calculate();
                break;
            case 5:
                mainMenu();
                break;
            default:
                break;
        }
        // input.close();
    }

    public static void detMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("DETERMINANT");
        Boolean status = true;
        int choice = 0;
        while (status) {
            border();
            System.out.println("METHOD");
            System.out.println("1. Cofactor Expansion Method");
            System.out.println("2. Reduction Method");
            System.out.println("3. Back to main menu");
            border();
            System.out.println("Choose Method (1-3) : ");
            try {
                choice = input.nextInt();
                System.out.println(' ');
                if (choice <= 3 && choice >= 1) {
                    status = false;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not valid");
                continue;
            } catch (Exception e) {
                System.exit(0);
                ;
            }
        }
        switch (choice) {
            case 1:
                cofactorDeterminant.calculate();
                break;
            case 2:
                reductionDeterminant.functionDetReduct();
                break;
            case 3:
                mainMenu();
                break;
            default:
                break;
        }
        // input.close();
    }

    public static void invMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("INVERSE MATRIX");
        Boolean status = true;
        int choice = 0;
        while (status) {
            border();
            System.out.println("METHOD");
            System.out.println("1. Adjoint Method");
            System.out.println("2. Reduction Method");
            System.out.println("3. Back to main menu");
            border();
            System.out.println("Choose Method (1-3) : ");
            try {
                choice = input.nextInt();
                System.out.println(' ');
                if (choice <= 3 && choice >= 1) {
                    status = false;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not valid");
                continue;
            } catch (Exception e) {
                System.exit(0);
                ;
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
        // input.close();
    }

    public static void backToMenu() throws Exception {
        System.out.println("Do you want to use another method? (y/n)");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        System.out.println(' ');
        if (choice.equals("y")) {
            mainMenu();
        } else if (choice.equals("n")) {
            System.exit(0);
        } else {
            System.out.println("Wrong input");
            backToMenu();
        }
        // input.close();
    }

    public static void border() {
        String border = "=======================================";
        System.out.println(border);
    }

}