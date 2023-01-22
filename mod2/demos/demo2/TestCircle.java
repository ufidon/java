public class TestCircle {
    public static void main(String[] args) {
      Circle c1 = null, c2 = null, c3 = null;
      try {
        c1 = new Circle(5);
        c2 = new Circle(-5);
        c3 = new Circle(0);
      }
      catch (IllegalArgumentException ex) {
        System.out.println(ex);
      }
  
      System.out.println("Number of objects created: " + Circle.getNumberOfObjects());

      if (c1 != null) {
        System.out.println("Created circle with radius " + c1.getRadius());
      }
      if (c2 != null) {
        System.out.println("Created circle with radius " + c2.getRadius());
      }
      if (c3 != null) {
        System.out.println("Created circle with radius " + c3.getRadius());
      }
    }
  }