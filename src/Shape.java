class Shape {
    private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public static void main(String[] args) {
        Shape shape = new Shape(13);
        Ball ball = new Ball(13);
        Cylinder cylinder = new Cylinder(13, 4);
        Pyramid pyramid = new Pyramid(13, 213);
        ColourPyramid colourPyramid = new ColourPyramid(13, 213, "white");
        Shape[] shapes = new Shape[]{shape, ball, cylinder, pyramid, colourPyramid};
        for (Shape elem :
                shapes) {
            elem.print();
            System.out.println();
        }
    }

    public void print() {
        System.out.println("Объём фигуры: " + volume);
    }
}

final class Ball extends Shape {

    private double radius;

    public Ball(double radius) {
        super((4 * 3.14 * radius * radius * radius) / 3);
        this.radius = radius;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Тип фигуры: шар с радиусом " + radius);
    }
}

final class Cylinder extends Shape {
    private double height;

    public Cylinder(double volume, double height) {
        super(volume);
        this.height = height;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Тип фигуры: цилиндр с выстой " + height);
    }
}

sealed class Pyramid extends Shape permits ColourPyramid {
    private double height;
    private double area; // площадь основания

    public Pyramid(double height, double area) {
        super(height * area);
        this.height = height;
        this.area = area;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Тип фигуры: Пирамида с площадью основания " + area + " и высотой " + height);
    }
}

non-sealed class ColourPyramid extends Pyramid {
    private String colour;
    // your code


    public ColourPyramid(double height, double area, String colour) {
        super(height, area);
        this.colour = colour;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Цвет фигуры: " + colour);
    }
}