import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class ComplexNum {

    public static final double EPs = 1e-12; // Точность вычислений.
    // Действительная и мнимая части.
    double re;
    double im;


    // 4 Constructors
    ComplexNum(double re, double im) {
        this.re = re;
        this.im = im;
    }

    ComplexNum(double re) {
        this(re, 0.0);
    }

    ComplexNum() {
        this(0.0, 0.0);
    }

    ComplexNum(ComplexNum z) {
        this(z.re, z.im);
    }

    // Getters and Setters
    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public ComplexNum getZ() {
        return new ComplexNum(re, im);
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }


    public void setZ(ComplexNum z) {
        re = z.re;
        im = z.im;
    }

    // Modulo and argument
    public double mod() {
        return Math.sqrt(re * re + im * im);
    }

    public double arg() {
        return Math.atan2(re, im);
    }

    public boolean isReal() {  // Check: real numbers?
        return Math.abs(im) < EPs;
    }

    public void pr(ComplexNum z) {  // Print
        System.out.println(z.re + (z.im < 0.0 ? "" : "+") + z.im + "i");
    }

    // Redefining class methods Object:
    public boolean equals(ComplexNum z) {
        return Math.abs(re - z.re) < EPs &&

                Math.abs(im - z.im) < EPs;

    }
    public String tostring() {

        return re + " " + im;

    }


    // Methods implementing operations +=, *=
//    public void add(ComplexNum z) {
//        re += z.re;
//        im += z.im;
//    }
//
//    public void mul(ComplexNum z) {
//
//        double t = re * z.re - im * z.im;
//        im = re * z.im + im * z.re;
//        re = t;
//    }

    // Methods implementing operations +, *
    /**
     * Складывает 2 переданных параматера в видe комплексных чисел
     *
     * @return комплексное число
     */
    public ComplexNum plus(ComplexNum z1, ComplexNum z2) {

        return new ComplexNum(z1.re + z2.re, z1.im + z2.im);

    }

    /**
     * Умножает 2 переданных параматера в видe комплексных чисел
     *
     * @return комплексное число
     */
    public ComplexNum asterisk(ComplexNum z1, ComplexNum z2) {
        return new ComplexNum(

                z1.re * z2.re - z1.im * z2.im, z1.re * z2.im + z1.im * z2.re);

    }
    /**
     * Возвращает строковое представление в тригонометрической форме
     *
     * @return строковое представление в тригонометрической форме
     */
    public void getTrigonometricView(ComplexNum complexNum1) {
        double x = complexNum1.re;
        double y = complexNum1.im;

        double r = Math.sqrt(x * x + y * y);
        double f = Math.atan(y / x);

        System.out.printf("z = %.2f * (cos%.2f + i * sin%.2f)", r, f, f);
    }
    public void startComplex() {
        PrintWriter pw = new PrintWriter(System.out, true);
        Scanner in = new Scanner(System.in);
        ComplexNum complexNum1 = new ComplexNum();
        ComplexNum complexNum2 = new ComplexNum();
        pw.println("Enter what you want to do");
        pw.println("1 - summary");
        pw.println("2 - multiply");
        pw.println("3 - trigonometric form of number");
        int num = 0;
        while (((num = in.nextInt()) != 1) && (num != 2) && (num != 3)) {
            pw.println("You write another number, please, try again");
        }
        if (num == 1) {
            pw.println("Now you need to enter 2 numbers. Write 2 numbers for the real and " +
                    "imaginary parts, respectively");
            while (true){
                Scanner in1 = new Scanner(System.in);
                try{
                    complexNum1.re = in1.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum1.im = in1.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum2.re = in1.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum2.im = in1.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                break;
            }
            pw.printf("%.3f + %.3f*i", plus(complexNum1, complexNum2).re, plus(complexNum1, complexNum2).im);
        }
        if (num == 2) {
            pw.println("Now you need to enter 2 numbers. Write 2 numbers for the real and" +
                    "imaginary parts, respectively");
            while (true){
                Scanner in2 = new Scanner(System.in);
                try{
                    complexNum1.re = in2.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum1.im = in2.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum2.re = in2.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum2.im = in2.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                break;
            }
            pw.printf("%.3f + %.3f*i", asterisk(complexNum1, complexNum2).re, asterisk(complexNum1, complexNum2).im);
        }
        if (num == 3) {
            pw.println("Now you need to enter a number. Write 2 numbers for the real and" +
                    " imaginary parts, respectively");
            while (true){
                Scanner in3 = new Scanner(System.in);
                try{
                    complexNum1.re = in3.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                try{
                    complexNum1.im = in3.nextDouble();
                }
                catch (InputMismatchException e){
                    pw.println("You enter another symbol. Please, try again");
                    continue;
                }
                break;
            }
            getTrigonometricView(complexNum1);
        }
    }
}

