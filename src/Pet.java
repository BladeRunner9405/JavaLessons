import java.util.Random;

public class Pet {
    protected String name;
    protected float weight;
    protected int age;
    protected String owner;

    public static void main(String[] args) {
        Cat cat = new Cat("1", 5, 3, "Tester", "4232", FeedType.Expensive);
        Dog dog = new Dog("2", 5, 3, "Tester", "4232", FeedType.Expensive);
        Parrot parrot = new Parrot("3", 5, 3, "Tester");
        cat.say();
        dog.walk();
        dog.walk("Test");
        parrot.fly();
        Pet[] pets = new Pet[] {cat, dog, parrot};
        for (Pet pet:
             pets) {
            pet.say();
            System.out.println(pet instanceof Cat);
            System.out.println(pet instanceof Dog);
            System.out.println(pet instanceof Parrot);
        }
    }

    public Pet(String name, float weight, int age, String owner){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }

    public void say(){
        System.out.println("Привет! Я - " + name);
    }
}

enum FeedType{

    Expensive,
    Cheap
}
class Cat extends Pet{
    private String breed;
    private FeedType feedType;

    public Cat(String name, float weight, int age, String owner, String breed, FeedType feedType) {
        super(name, weight, age, owner);
        this.breed = breed;
        this.feedType = feedType;
    }

    public void walk(){
        System.out.println("Прогуливаюсь");
    }
    public void walk(String name){
        System.out.println("Со мной гуляет " + name);
    }
}

class Dog extends Pet{
    private String breed;
    private FeedType feedType;

    public Dog(String name, float weight, int age, String owner, String breed, FeedType feedType) {
        super(name, weight, age, owner);
        this.breed = breed;
        this.feedType = feedType;
    }

    public void walk(){
        System.out.println("Прогуливаюсь");
    }
    public void walk(String name){
        System.out.println("Со мной гуляет " + name);
    }

}



class Parrot extends Pet{
    public String country;
    public boolean isLegal;

    public Parrot(String name, float weight, int age, String owner) {
        super(name, weight, age, owner);
    }

    public void fly(){
        Random random = new Random();
        int time = random.nextInt(60 + 1);
        System.out.println("Попугай по имени " + name + " улетел, но обещал вернуться через " + time + " минут.");
    }
}

