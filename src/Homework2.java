public class Homework2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("asdffda"));

    }

    static boolean equals(String s, String t) {
        return s.equalsIgnoreCase(t); // проверить, что строки совпадают без учета регистра
    }

    static String replace(String str, String oldStr, String newStr) {
        return str.replace(oldStr, newStr); // в строке str все вхождения oldStr заменить на newStr
    }

    static String format(String surname, int mark, String subject) {
        Object[] args = {surname, mark, subject};
        return String.format("Студент %s получил %s по %s", args); // вернуть строку, используя форматирование: Студент [Фамилия] получил [оценка] по [предмету]
    }

    static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true; // проверить, является ли строка палиндромом
    }
}
