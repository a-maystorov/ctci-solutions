import java.util.Arrays;

/* 
 * Question: 1.2
 * Page: 90
 */

public class IsPermutation {
    public static boolean solution(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA != lenB)
            return false;

        return sort(a).equals(sort(b));
    }

    private static String sort(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean solution2(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA != lenB)
            return false;

        int[] letters = new int[128]; // Assumes ASCII characters only

        for (int i = 0; i < lenA; i++) {
            letters[a.charAt(i)]++;
        }

        for (int i = 0; i < lenB; i++) {
            letters[b.charAt(i)]--;
            if (letters[b.charAt(i)] < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases for solution (sorting approach)
        System.out.println("Testing solution (sorting approach):");
        System.out.println(solution("abc", "bca")); // true
        System.out.println(solution("hello", "oellh")); // true
        System.out.println(solution("apple", "pale")); // false
        System.out.println(solution("abc", "abcd")); // false
        System.out.println(solution("aabbcc", "abcabc")); // true
        System.out.println(solution("listen", "silent")); // true
        System.out.println(solution("race", "care")); // true
        System.out.println(solution("a", "a")); // true
        System.out.println(solution("a", "b")); // false
        System.out.println(solution("test", "sets")); // true
        System.out.println(solution("abcd", "dcba")); // true

        // Test cases for solution2 (character counting approach)
        System.out.println("\nTesting solution2 (character counting approach):");
        System.out.println(solution2("abc", "bca")); // true
        System.out.println(solution2("hello", "oellh")); // true
        System.out.println(solution2("apple", "pale")); // false
        System.out.println(solution2("abc", "abcd")); // false
        System.out.println(solution2("aabbcc", "abcabc")); // true
        System.out.println(solution2("listen", "silent")); // true
        System.out.println(solution2("race", "care")); // true
        System.out.println(solution2("a", "a")); // true
        System.out.println(solution2("a", "b")); // false
        System.out.println(solution2("test", "sets")); // true
        System.out.println(solution2("abcd", "dcba")); // true
    }
}
