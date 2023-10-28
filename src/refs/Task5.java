package refs;

public class Task5 {
    public void authorize(String login, String password, String confirmPassword) throws Exception {
        validate(login, new WrongLoginException());
        validate(login, new WrongPasswordException());
    }

    public static void validate(String word, Exception exception) throws Exception {
        if (word.length() > 20){
            throw exception;
        }
        char[] possibleСhars = "qwertyuiopasdfghjklzxcvbnm_1234567890".toCharArray();
        for (char wordChars: word.toCharArray()) {
            boolean contains = false;
            for (char possibleChar: possibleСhars) {
                if (wordChars == possibleChar){
                    contains = true;
                    break;
                }
            }
            if (!contains){
                throw exception;
            }
        }

    }
}

class WrongLoginException  extends Exception{ }
class WrongPasswordException   extends Exception{ }