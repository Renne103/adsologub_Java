import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class ComplexNum {

    private static final double EPs = 1e-12; // Точность вычислений.
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
    private double getRe() {
        return re;
    }

    private double getIm() {
        return im;
    }

    private ComplexNum getZ() {
        return new ComplexNum(re, im);
    }

    private void setRe(double re) {
        this.re = re;
    }

    private void setIm(double im) {
        this.im = im;
    }


    private void setZ(ComplexNum z) {
        re = z.re;
        im = z.im;
    }

    // Modulo and argument
    private double mod() {
        return Math.sqrt(re * re + im * im);
    }

    private double arg() {
        return Math.atan2(re, im);
    }

    private boolean isReal() {  // Check: real numbers?
        return Math.abs(im) < EPs;
    }

    private void pr(ComplexNum z) {  // Print
        System.out.println(z.re + (z.im < 0.0 ? "" : "+") + z.im + "i");
    }

    // Redefining class methods Object:
    private boolean equals(ComplexNum z) {
        return Math.abs(re - z.re) < EPs &&

                Math.abs(im - z.im) < EPs;

    }
    private String tostring() {

        return re + " " + im;

    }
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
     * Вычитает 2 переданных параматера в видe комплексных чисел
     * @param z1
     * @param z2
     * @return комплексное число
     */
    public ComplexNum minus(ComplexNum z1, ComplexNum z2) {
        return new ComplexNum(

                z1.re - z2.re, z1.im - z2.im);
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
}

