public static class Pet {
    protected String name;
    protected float weight;
    protected int age;
    protected String owner;

    public Pet(String name, float weight, int age, String owner){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }

    public void say(){
        System.out.println("Helo, world!");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}

public static class Cat extends Pet {
    @Override
    public void doSound() {
        System.out.println("I'm a cat! Meow! Meow!");
    }
}

