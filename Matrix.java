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

    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
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

    /**
     * Заполнение матрицы значениями из ввода
     *
     * @param row
     * @param col
     */
    public void fillMatrix(int row, int col) {
        PrintWriter pw = new PrintWriter(System.out, true);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ComplexNum complexNum = new ComplexNum();
                while (true) {
                    Scanner in3 = new Scanner(System.in);
                    try {
                        complexNum.re = in3.nextDouble();
                    } catch (InputMismatchException e) {
                        pw.println("You enter another symbol. Please, try again");
                        continue;
                    }
                    try {
                        complexNum.im = in3.nextDouble();
                    } catch (InputMismatchException e) {
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
     *
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

    // exclude_row and exclude_col starts from 1
    public static Matrix subMatrix(Matrix matrix, int exclude_row, int exclude_col) {
        Matrix result = new Matrix(matrix.row - 1, matrix.col - 1);

        for (int r = 0, p = 0; r < matrix.row; ++r) {
            if (r != exclude_row - 1) {
                for (int c = 0, q = 0; c < matrix.col; ++c) {
                    if (c != exclude_col - 1) {
                        result.data[p][q] = matrix.data[r][c];

                        ++q;
                    }
                }

                ++p;
            }
        }

        return result;
    }

    public ComplexNum determinant() throws ArrayIndexOutOfBoundsException {
        if (row != col) {
            throw new ArithmeticException("Невозможно найти детерминант");
        } else {
            return _determinant(this);
        }
    }

    private ComplexNum _determinant(Matrix matrix) {
        if (matrix.col == 1) {
            return matrix.data[0][0];
        } else if (matrix.col == 2) {
            return complexNum.minus(complexNum.asterisk(data[0][0], data[1][1]),
                    complexNum.asterisk(data[0][1], data[1][0]));
        } else {
            double res = 0.0;
            for (int col = 0; col < matrix.col; ++col) {
                Matrix sub = subMatrix(matrix, 1, col + 1);
                res += (Math.pow(-1, 1 + col + 1) *
                        matrix.data[0][col].re * _determinant(sub));
            }

            return res;
        }
    }

    public Matrix inverse() {
        ComplexNum det = determinant();

        if (row != col || det == null) {
            return null;
        } else {
            Matrix result = new Matrix(row, col);

            for (int r = 0; r < row; ++r) {
                for (int c = 0; c < col; ++c) {
                    Matrix sub = subMatrix(this, r + 1, c + 1);
                    complexNum.re = 1;
                    complexNum.im = 0;

                    result.data[c][r] = (det / det *
                            Math.pow(-1, r + c) *
                            _determinant(sub));
                }
            }

            return result;
        }
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
}
