README

# Matrix-Calculator
- --
## General Information 
This repository contains a library linear algebra using Java needed as a fullfilment for our 1st Big Project of IF2123 Linear and Geometric Algebra. This library contains source files to solve determinant, inverse, linear system equation such as interpolation and linear regression using various methods (Gauss, Gauss-Jordan, Inverse, and Cramer). 
## Technology Used
- Java Language
## Contributors (Jamet Nangor Ganteng)
- 13521005 Kelvin Rayhan Alkarim <br/>
- 13521021 Bernardus Willson <br/>
- 13521023 Kenny Benaya Nathan <br/>
## Program Features
- Linear system equation calculator using:
  - Gauss Elimination
  - Gauss-Jordan Elimination
  - Inverse Method
  - Cramer's Rule
- Matrix determinant calculator using:
  - Cofactor Expansion
  - Row Reduction
- Matrix inverse calculator using:
  - Adjoin
  - Row Reduction
- Polynomial Interpolation
- Bicubic Interpolation
- Multiple Linear Regression
## Project Structure
```bash
.
├── bin ------------------------------------------ Folder containing binary files (*.class)
├── doc ------------------------------------------ Folder containing project report
│   └── Algeo01-21005.pdf
├── src ------------------------------------------ Folder containing source files (*.java)
│   └––─–─– apps -------------------------- Application package
│       │   ├── BicubicInterpolate.java
│       │   ├── DeterminantCofact.java
│       │   ├── DeterminantReduct.java
│       │   ├── InverseReduct.java   
│       │   ├── PolinomInterpolate.java   
│       │   ├── Regression.java   
│       │   ├── SPLCrammer.java   
│       │   ├── SPLGauss.java   
│       │   ├── SPLGaussJordan.java
│       │   └── SPLInverse.java   
│       │
│       ├── function --------------------------------- Input Matrix package
│       │   └── inputMatrix.java
│       │
│       └── utility ----------------------------- Main package
│           └── menu.java
│
├── test ------------------------------------------ Folder containing testing case files
│   
└── README.md
```
## Local Setup
1. Clone this repository
2. Go to src folder:<br>
<code>/src/</code>

3. Compile by running: <br>
<code>javac -d ../bin function/*.java utility/*.java apps/*.java</code>

4. Go to bin folder: <br>
<code>/bin/</code>

5. Run menu program by using command: <br>
<code>java utility.menu</code>
