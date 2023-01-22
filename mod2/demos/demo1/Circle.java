public class Circle {
    /** The radius of the circle */
    public double radius;

    /** The number of the objects created */
    public static int numberOfObjects = 0;

    public final static double PI = 3.1415926;

    /** Construct a circle with radius 1 */
    public Circle() {
        radius = 1.0;
        numberOfObjects++;
    }

    /** Construct a circle with a specified radius */
    public Circle(double newRadius) {
        radius = newRadius;
        numberOfObjects++;
    }

    /** Return numberOfObjects */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /** Return the area of this circle */
    public double getArea() {
        return radius * radius * PI;
    }
}