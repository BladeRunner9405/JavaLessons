import java.util.Random;

public class Parrot extends Pet{
    public String country;
    public boolean isLegal;

    public void fly(){
        Random random = new Random();
        int time = random.nextInt(60 + 1);
        System.out.println("Попугай по имени " + name + " улетел, но обещал вернуться через " + time + " минут.");
    }
}
