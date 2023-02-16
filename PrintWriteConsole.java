import java.io.*;
import java.util.Scanner;

public class PrintWriteConsole {

    public static void start() {
        ComplexNum cn = new ComplexNum();
        Matrix matr = new Matrix();
        PrintWriter pw = new PrintWriter(System.out, true);
        Scanner in = new Scanner(System.in);
        pw.println("Enter one of the letters");
        pw.println("1 - actions with complex numbers");
        pw.println("2 - actions with matrix");
        int num;
        while (((num = in.nextInt()) != 1) && (num != 2)) {
            pw.println("You write another number, please, try again");
        }
        if (num == 1) {
            cn.startComplex();
        }
        if (num == 2) {
            matr.startMatrix();
        }
        // Создание объекта типа PrintWriter, связанного
        // с потоком стандартного вывода System.out.

    }

}
