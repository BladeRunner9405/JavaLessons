import java.util.Objects;

public class Point {

    private double x;
    private double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public  Point(){
        this.x = 0;
        this.y = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double[] getCoords(){
        return new double[] {x, y};
    }

    public void translate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void scale(double x){
        this.x *= x;
        this.y *= y;
    }
}
