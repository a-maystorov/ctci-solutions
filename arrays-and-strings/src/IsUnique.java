import java.util.HashSet;
import java.util.Set;

/* Question: 1.1
 * Page: 90
 */

public class IsUnique {
    public static boolean solution(String a) {
        int len = a.length();

        if (a.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }

        if (len > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];

        for (int i = 0; i < a.length(); i++) {
            int val = a.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }

        return true;
    }

    public static boolean solutionWithSet(String a) {
        int len = a.length();

        if (a.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }

        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < len; i++) {
            char val = a.charAt(i);
            if (charSet.contains(val)) {
                return false;
            }
            charSet.add(val);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Using boolean array method:");
        System.out.println(solution("aaaa")); // false (characters are repeated)
        System.out.println(solution("aabb")); // false (characters are repeated)
        System.out.println(solution("a")); // true (only one character, unique)
        System.out.println(solution("ab")); // true (no repeated characters)
        System.out.println(solution("abc")); // true (no repeated characters)
        System.out.println(solution("aabc")); // false (character 'a' is repeated)

        System.out.println("\nUsing Set method:");
        System.out.println(solutionWithSet("aaaa")); // false (characters are repeated)
        System.out.println(solutionWithSet("aabb")); // false (characters are repeated)
        System.out.println(solutionWithSet("a")); // true (only one character, unique)
        System.out.println(solutionWithSet("ab")); // true (no repeated characters)
        System.out.println(solutionWithSet("abc")); // true (no repeated characters)
        System.out.println(solutionWithSet("aabc")); // false (character 'a' is repeated)
    }
}
