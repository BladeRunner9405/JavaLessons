public class Cat extends Pet{
    private String breed;
    private enum feedType{};
    public Cat(String name, float weight, int age, String owner){
        super(name, weight, age, owner);
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }
    public void walk(){
        System.out.println("Прогуливаюсь");
    }
    public void walk(String name){
        System.out.println("Со мной гуляет " + name);
    }
}
