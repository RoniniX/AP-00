/**
 * The type Triangle.
 */
public class Triangle extends Polygon {
    /**
     * Instantiates a new Triangle.
     *
     * @param sides the sides
     */
    public Triangle(double... sides) {
        super(sides);
    }

    /**
     * Is equilateral boolean.
     *
     * @return the boolean
     */
    public boolean isEquilateral() {
        Double temp = getSides().get(0);

        for (Double side : getSides()) {
            if (!side.equals(temp)) {
                return false;
            }
            temp = side;
        }

        return true;
    }

    @Override
    public double calculatePerimeter() {
        double sum = 0;

        for (Double side : getSides())
            sum += side;

        return sum;
    }

    @Override
    public double calculateArea() {
        double sum = 0;

        for (Double side : getSides())
            sum += side;

        sum /= 2;
        return java.lang.Math.sqrt(sum * (sum - getSides().get(0)) * (sum - getSides().get(2)) * (sum - getSides().get(1)));
    }

    @Override
    public String draw() {
        return "Type: Triangle\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides: side1: " + getSides().get(0) + " side2: " + getSides().get(1) + " side3: " + getSides().get(2) +
                ", Equilateral=" + isEquilateral() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return getSides().equals(triangle.getSides());
    }
}
