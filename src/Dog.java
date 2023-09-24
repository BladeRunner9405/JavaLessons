public class Dog extends Pet{
    private String breed;
    private enum feedType{};

    public void walk(){
        System.out.println("Прогуливаюсь");
    }
    public void walk(String name){
        System.out.println("Со мной гуляет " + name);
    }
}
