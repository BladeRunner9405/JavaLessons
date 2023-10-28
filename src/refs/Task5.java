package refs;

public class Task5 {

  public static void main(String[] args) {
    System.out.println(authorize("Tester", "123", "123"));
    System.out.println(authorize("Tester", "123", "12"));
    System.out.println(authorize("Tester!!!", "123", "123"));
    System.out.println(authorize("Tester", "123!!!", "123!!!"));
  }

  public static boolean authorize(String login, String password, String confirmPassword) {
    try {
      validate(login, true);
      validate(password, false);
      if (password != confirmPassword) {
        System.out.println("Пароли не совпадают");
        return false;
      }
    } catch (WrongLoginException e) {
      System.out.println("Некорректный логин");
      return false;
    } catch (WrongPasswordException e) {
      System.out.println("Некорректный пароль");
      return false;
    } catch (Exception e) {
      System.out.println("Что-то пошло не так");
      return false;
    }
    return true;
  }

  public static void validate(String word, boolean isLogin) throws Exception {
    if (word.length() > 20) {
      if (isLogin) {
        throw new WrongLoginException(word);
      } else {
        throw new WrongPasswordException();
      }
    }
    char[] possibleСhars = "qwertyuiopasdfghjklzxcvbnm_1234567890".toCharArray();
    for (char wordChars : word.toLowerCase().toCharArray()) {
      boolean contains = false;
      for (char possibleChar : possibleСhars) {
        if (wordChars == possibleChar) {
          contains = true;
          break;
        }
      }
      if (!contains) {
        if (isLogin) {
          throw new WrongLoginException(word);
        } else {
          throw new WrongPasswordException();
        }
      }
    }
  }
}

class WrongLoginException extends Exception {
  public WrongLoginException(String message) {
    super(message);
  }
}

class WrongPasswordException extends Exception {}
