import java.util.Arrays;

/**
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 * <p>
 * For example:
 * persistence(39) === 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
 * // and 4 has only one digit
 * <p>
 * persistence(999) === 4 // because 9*9*9 = 729, 7*2*9 = 126,
 * // 1*2*6 = 12, and finally 1*2 = 2
 * <p>
 * persistence(4) === 0 // because 4 is already a one-digit number
 */
class Persist {
    public static int persistence(long n) {
        return persistenceRecursive(n, 0);
    }

    private static int persistenceRecursive(long n, long acc) {
        String[] number = Long.toString(n).split("");
        if (number.length == 1) {
            return (int) acc;
        } else {
            return persistenceRecursive(Arrays
                    .stream(number)
                    .map(Long::parseLong)
                    .reduce(1L, (state, next) -> state *= next), ++acc);
        }
    }
}

/**
 * In this kata, you must create a digital root function.
 * <p>
 * A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n.
 * If that value has two digits, continue reducing in this way until a single-digit number is produced. This is only
 * applicable to the natural numbers.
 * <p>
 * Examples:
 * digital_root(16)
 * => 1 + 6
 * => 7
 * <p>
 * digital_root(942)
 * => 9 + 4 + 2
 * => 15 ...
 * => 1 + 5
 * => 6
 */
class DRoot {
    public static int digital_root(int n) {
        String[] number = Integer.toString(n).split("");
        if (number.length == 1) {
            return n;
        } else {
            return digital_root(Arrays
                    .stream(number)
                    .map(Integer::parseInt)
                    .reduce(0, (state, next) -> state += next));
        }
    }
}


/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is '(' if
 * that character appears only once in the original string, or ')' if that character appears more than once in the
 * original string. Ignore capitalization when determining if a character is a duplicate.
 * <p>
 * Examples:
 * <p>
 * "din" => "((("
 * <p>
 * "recede" => "()()()"
 * <p>
 * "Success" => ")())())"
 * <p>
 * "(( @" => "))(("
 */
public class DuplicateEncoder {
    static String encode(String word) {
        Map<String, Integer> map = new HashMap<>();
        String[] stringList = word.toLowerCase().split("");
        StringBuffer res = new StringBuffer();
        for (String c : stringList) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (String c : stringList) {
            if (map.get(c) == 1) res.append("(");
            if (map.get(c) > 1) res.append(")");
        }

        return res.toString();
    }
}

/**
 * Welcome. In this kata, you are asked to square every digit of a number.
 * <p>
 * For example, if we run 9119 through the function, 811181 will come out, because 9^2 is 81 and 12 is 1.
 * <p>
 * Note: The function accepts an integer and returns an integer
 */
public class SquareDigit {

    public int squareDigits(int n) {
        return Integer.valueOf(Arrays.stream(new Integer(n).toString().split(""))
                .map(i -> String.valueOf((int) Math.pow(Integer.valueOf(i), 2)))
                .reduce("", String::concat));
    }

}

/**
 * Write a function called repeatStr which repeats the given string string exactly n times.
 * repeatStr(6, "I") // "IIIIII"
 * repeatStr(5, "Hello") // "HelloHelloHelloHelloHello"
 */
public class Solution {
    public static String repeatStr(final int repeat, final String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            builder.append(string);
        }
        return builder.toString();
    }
}

/**
 * You are going to be given a word. Your job is to return the middle character of the word. If the word's length is
 * odd, return the middle character. If the word's length is even, return the middle 2 characters.
 * <p>
 * #Examples:
 * <p>
 * Kata.getMiddle("test") should return "es"
 * <p>
 * Kata.getMiddle("testing") should return "t"
 * <p>
 * Kata.getMiddle("middle") should return "dd"
 * <p>
 * Kata.getMiddle("A") should return "A"
 * <p>
 * <p>
 * #Input
 * <p>
 * A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000 in some test cases due
 * to an error in the test cases). You do not need to test for this. This is only here to tell you that you do not need
 * to worry about your solution timing out.
 * <p>
 * #Output
 * <p>
 * The middle character(s) of the word represented as a string.
 */
class Kata {
    public static String getMiddle(String word) {
        int length = word.length();
        int mid = length / 2;
        if (length % 2 == 0) {
            return word.substring(mid - 1, mid + 1);
        } else {
            return Character.toString(word.charAt(mid));
        }
    }
}