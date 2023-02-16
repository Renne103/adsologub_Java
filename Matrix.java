import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
    private int row = 0, col = 0;
    public ComplexNum[][] data = null;
    final ComplexNum complexNum = new ComplexNum();

    // Default Constructor
    public Matrix() {

    }

    public Matrix(int row, int col) {
        data = new ComplexNum[row][col];
        this.row = row;
        this.col = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.data[i][j] = new ComplexNum();
            }
        }
    }

    public boolean isSquare() {
        return row == col;
    }

    /**
     * Заполнение матрицы значениями из ввода
     * @param row
     * @param col
     */
    public void fillMatrix(int row, int col) {
        PrintWriter pw = new PrintWriter(System.out, true);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ComplexNum complexNum = new ComplexNum();
                while (true){
                    Scanner in3 = new Scanner(System.in);
                    try{
                        complexNum.re = in3.nextDouble();
                    }
                    catch (InputMismatchException e){
                        pw.println("You enter another symbol. Please, try again");
                        continue;
                    }
                    try{
                        complexNum.im = in3.nextDouble();
                    }
                    catch (InputMismatchException e){
                        pw.println("You enter another symbol. Please, try again");
                        continue;
                    }
                    break;
                }
                this.data[i][j] = complexNum;
            }
        }
    }

    /**
     * Производит сложение двух матриц
     * @param matrix1
     * @param matrix2
     * @param matrix3
     * @return матрица сложения
     * @throws ArrayIndexOutOfBoundsException
     */
    public Matrix sum(Matrix matrix1, Matrix matrix2, Matrix matrix3) throws ArrayIndexOutOfBoundsException {
        if (matrix1.row != matrix2.row && matrix1.col != matrix2.col) {
            throw new ArithmeticException("Невозможно выполнить сложение матриц данных размеров");
        }
        for (int i = 0; i < matrix1.row; i++) {
            for (int j = 0; j < matrix1.col; j++) {
                ComplexNum complexNum1 = new ComplexNum();
                matrix3.data[i][j] = complexNum1;
                matrix3.data[i][j] = complexNum.plus(matrix1.data[i][j], matrix2.data[i][j]);
            }
        }
        return matrix3;
    }

    /**
     *
     * @param matrix1
     * @param matrix2
     * @return матрица умножения
     * @throws ArrayIndexOutOfBoundsException
     */
    public Matrix mult(Matrix matrix1, Matrix matrix2) throws ArrayIndexOutOfBoundsException {
        if (matrix1.row != matrix2.col) {
            throw new ArithmeticException("Невозможно выполнить умножение матриц данных размеров");
        }
        Matrix matrix_multy = new Matrix(matrix1.row, matrix1.col);
        for (int i = 0; i < matrix1.row; i++) {
            for (int j = 0; j < matrix2.col; j++) {
                ComplexNum complexNum2 = new ComplexNum();
                matrix_multy.data[i][j] = complexNum2;
                matrix_multy.data[i][j] = complexNum.asterisk(matrix1.data[i][j], matrix2.data[i][j]);
            }
        }
        return matrix_multy;
    }

    /**
     *
     * @param matrix
     * @return транспонированная матрица
     */
    public Matrix transpose(Matrix matrix) {
        Matrix result = new Matrix(matrix.col, matrix.row);
        for (int i = 0; i < matrix.row; ++i) {
            for (int j = 0; j < matrix.col; ++j) {
                ComplexNum complexNum3 = new ComplexNum();
                result.data[j][i] = complexNum3;
                result.data[j][i] = matrix.data[i][j];
            }
        }
        return result;
    }

    public void writeMatrix(int row, int col) {
        System.out.print("[");
        for (int r = 0; r < row; ++r) {
            if (r != 0) {
                System.out.print(" ");
            }
            for (int c = 0; c < col; ++c) {
                System.out.printf("%.3f + %.3fi", data[r][c].re, data[r][c].im);
                System.out.print(" ");
                if (c != col - 1) {
                    System.out.print(" ");
                }
            }
            if (r == row - 1) {
                System.out.print("]");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void startMatrix() {
        PrintWriter pw = new PrintWriter(System.out, true);
        Scanner in = new Scanner(System.in);
        int count1 = 0;
        int count2 = 0;
        int row1;
        int row2;
        int col1;
        int col2;
        while (true){
            Scanner in3 = new Scanner(System.in);
            pw.println("Enter the count of rows for the 1 matrix");
            try{
                row1 = in3.nextInt();
            }
            catch (InputMismatchException e){
                pw.println("You enter another symbol. Please, try again");
                continue;
            }
            break;
        }
        while (true){
            Scanner in3 = new Scanner(System.in);
            pw.println("Enter the count of columns for the 1 matrix");
            try{
                col1 = in3.nextInt();
            }
            catch (InputMismatchException e){
                pw.println("You enter another symbol. Please, try again");
                continue;
            }
            break;
        }
        while (true){
            Scanner in3 = new Scanner(System.in);
            pw.println("Enter the count of rows for the 2 matrix");
            try{
                row2 = in3.nextInt();
            }
            catch (InputMismatchException e){
                pw.println("You enter another symbol. Please, try again");
                continue;
            }
            break;
        }
        while (true){
            Scanner in3 = new Scanner(System.in);
            pw.println("Enter the count of columns for the 2 matrix");
            try{
                col2 = in3.nextInt();
            }
            catch (InputMismatchException e){
                pw.println("You enter another symbol. Please, try again");
                continue;
            }
            break;
        }
        int count_num1 = row1 * col1 * 2;
        int count_num2 = row2 * col2 * 2;
        pw.println("Size of the first matrix " + row1 + " " + col1);
        pw.println("Size of the second matrix " + row2 + " " + col2);
        pw.println();
        pw.println("Now you need to fill the first matrix. Write 2 numbers for the real and" +
                " imaginary parts, respectively. Write a number and a zero,\n" +
                " if you want to work with real number (Example:2 0)");
        pw.printf("You need to enter %d numbers for the first matrix", count_num1);
        Matrix matrix1 = new Matrix(row1, col1);
        matrix1.fillMatrix(row1, col1);
        matrix1.writeMatrix(row1, col1);
        pw.println("Now you need to fill the second matrix. Write 2 numbers for the real and" +
                " imaginary parts, respectively. Write a number and a zero,\n" +
                " if you want to work with real number (Example:2 0)");
        pw.printf("You need to enter %d numbers for the second matrix", count_num2);
        Matrix matrix2 = new Matrix(row2, col2);
        matrix2.fillMatrix(row2, col2);
        matrix2.writeMatrix(row2, col2);
        pw.println("Enter what do you want to do with matrixes");
        pw.println("1 - summary");
        pw.println("2 - multiply");
        pw.println("3 - matrix transposition");
        pw.println("4 - matrix determinant");
        int num;
        while (((num = in.nextInt()) != 1) && (num != 2) && (num != 3) && (num != 4)) {
            pw.println("You write another number, please, try again");
        }
        if (num == 1) {
            Matrix matrix3 = new Matrix(row1, col1);
            pw.println("Sum of two matrix");
            sum(matrix1, matrix2, matrix3).writeMatrix(matrix3.row,matrix3.col);
            }
        if (num == 2) {
            pw.println("Multiply of two matrix");
            mult(matrix1, matrix2).writeMatrix(row1, col2);
        }
        if (num == 3) {
            pw.println("Transpose of two matrix");
            transpose(matrix1).writeMatrix(transpose(matrix1).row, transpose(matrix1).col);
            transpose(matrix2).writeMatrix(transpose(matrix2).row, transpose(matrix2).col);
        }
        if (num == 4) {
            pw.println("Determinant");
          
        }
    }
}
