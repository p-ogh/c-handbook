package testdome.java;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double a1 = (b * b) - (4 * a * c);
        double x1 =  (-b + Math.sqrt(a1))/(2*a);
        double x2 =  (-b - Math.sqrt(a1))/(2*a);

        return new Roots(x1, x2);
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
