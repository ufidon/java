import java.util.*;

public class TestArrayListNew {
  public static void main(String[] args) {
    ArrayList<String> cityList = new ArrayList<String>();

    cityList.add("London");
    cityList.add("New York");
    cityList.add("Paris");
    cityList.add("Toronto");
    cityList.add("Hong Kong");
    cityList.add("Singapore");

    System.out.println("List size? " + cityList.size());
    System.out.println("Is Toronto in the list? " + cityList.contains("Toronto"));
    System.out.println("The location/index of New York in the list? " + cityList.indexOf("New York"));
    System.out.println("Is the list empty? " + cityList.isEmpty());

    cityList.add(2, "Beijing");

    cityList.remove("Toronto");

    cityList.remove(1);

    for (int i = 0; i < cityList.size(); i++)
      System.out.print(cityList.get(i) + " ");
    System.out.println();

    ArrayList<Circle> list = new ArrayList<Circle>();

    list.add(new Circle(2));
    list.add(new Circle(3));

    System.out.println("The area of the circle? " + ((Circle) list.get(0)).getArea());
  }
}

class Circle {
  double radius = 1;

  Circle(double r) {
    radius = r;
  }

  double getArea() {
    return Math.PI * radius * radius;
  }
}
