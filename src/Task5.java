public class Task5 {
    public void authorize(String login, String password, String confirmPassword){

    }

    public void validate(String word, Exception exception) throws Exception {
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
