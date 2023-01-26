public class Circle extends GeometricObject {
  private double radius;

  private static int numberOfObjects = 0;

  public Circle() {
    this(1.0);
  }

  public Circle(double newRadius) {
    setRadius(newRadius);
    numberOfObjects++;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double newRadius)
      throws IllegalArgumentException {
    if (newRadius >= 0)
      radius = newRadius;
    else
      throw new IllegalArgumentException(
          "Radius cannot be negative");
  }

  public static int getNumberOfObjects() {
    return numberOfObjects;
  }

  public double findArea() {
    return radius * radius * 3.14159;
  }
}

class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  public GeometricObject() {
    dateCreated = new java.util.Date();
  }

  public GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
  }
}