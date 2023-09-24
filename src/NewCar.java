public class NewCar {
    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private NewCar.Engine engine;
    private int mileage;

    public NewCar(Builder builder) {
        this.colour = builder.colour;
        this.fuel = builder.fuel;
        this.maxFuel = builder.maxFuel;
        this.model = builder.model;
        this.engine = builder.engine;
        this.mileage = builder.mileage;
    }

    public static class Builder {

        private final String colour; // необходимо
        private final int fuel; // необходимо
        private final int maxFuel; // необходимо
        private final String model; // необходимо
        private NewCar.Engine engine; // опционально
        private int mileage; // опционально

        public Builder(String colour, int fuel, int maxFuel, String model) {
            this.colour = colour;
            this.fuel = fuel;
            this.maxFuel = maxFuel;
            this.model = model;
        }

        public Builder calories(NewCar.Engine val) {
            engine = val;
            return this;
        }

        public Builder mileage(int val) {
            mileage = val;
            return this;
        }

        public NewCar build() {
            return new NewCar(this);
        }
    }


    public static void main(String[] args) {
        NewCar car = new NewCar("синий", 1500, 5000, "тест");
        car.TurnEngineOn();
        while (car.fuel > 0) {
            car.driveKilometers(1000);
        }
        car.info();
        car.fillFuel();
    }

    public class Engine {

        private Boolean isEnabled = false;
        private int consumption;   // расход на 100 км

        public Engine(int consumption) {
            this.consumption = consumption;
        }

        public Boolean isEnabled() {
            return isEnabled;
        }

        public void SwitchEnable() {
            isEnabled = !isEnabled;
        }
    }

    public NewCar(String colour, int fuel, int maxFuel, String model, NewCar.Engine engine, int mileage) {
        this.colour = colour;
        this.fuel = fuel;
        this.maxFuel = maxFuel;
        this.model = model;
        this.engine = engine;
        this.mileage = mileage;
    }

    public NewCar(String colour, int fuel, int maxFuel, String model) {
        this.colour = colour;
        this.fuel = fuel;
        this.maxFuel = maxFuel;
        this.model = model;
        this.engine = new NewCar.Engine(10);
        this.mileage = 0;
    }


    public void driveKilometers(int kilometers) {
        if (engine.isEnabled() && fuel > 0) {
            int consumption = engine.consumption * kilometers / 100;
            if (consumption > fuel) {
                kilometers = (kilometers / consumption) * fuel;
            }
            mileage += kilometers;
            fuel -= consumption;
            if (fuel <= 0) {
                fuel = 0;
                engine.SwitchEnable();
                System.out.println("Нужна дозаправка!");
            }
        }
    }

    public void fillFuel() {
        fuel = maxFuel;
    }

    public void fillFuel(int fuel) {
        this.fuel += fuel;
        if (this.fuel > maxFuel) {
            this.fuel = maxFuel;
        }
    }

    public void TurnEngineOn() {
        if (!engine.isEnabled()) {
            engine.SwitchEnable();
        }
    }

    public void TurnEngineOff() {
        if (engine.isEnabled()) {
            engine.SwitchEnable();
        }
    }

    public void info() {
        System.out.println("Цвет: " + colour);
        System.out.println("Модель: " + model);
        System.out.println("Бак: " + fuel + "/" + maxFuel);
        System.out.println("Расход топлива: " + engine.consumption + "л/100 км");
        System.out.print("Состояние двигателя: ");
        if (engine.isEnabled()) {
            System.out.print("включён");
        } else {
            System.out.print("выключен");
        }
        System.out.println();
        System.out.println("Пробег: " + mileage + " км");
    }

    public void printMileage() {
        System.out.println(mileage);
    }
}
