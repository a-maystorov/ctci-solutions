/* 
 * Question: 1.3
 * Page: 90
 */

public class URLify {
    public static void solution(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        /*
         * If there are excess spaces, add a null character. This indicates that the
         * spaces after that point have not been replaced with %20.
         */
        if (newIndex + 1 < str.length)
            str[newIndex + 1] = '\0';

        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') {
                // Insert %20
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex--;
            }
        }
    }

    // Count occurrences of target between start (inclusive) and end (exclusive)
    private static int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;
            }
        }
        return count;
    }

    // Test helper method
    private static void runTest(String input, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (input.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int finalLength = trueLength + spaceCount * 2;
        char[] chars = new char[finalLength];

        for (int i = 0; i < trueLength; i++) {
            chars[i] = input.charAt(i);
        }

        solution(chars, trueLength);
        System.out.println(new String(chars));
    }

    public static void main(String[] args) {
        runTest("Mr John Smith", 13); // ➜ Mr%20John%20Smith
        runTest("Hello World", 11); // ➜ Hello%20World
        runTest("NoSpace", 7); // ➜ NoSpace
        runTest(" A B ", 5); // ➜ %20A%20B%20
        runTest("EndsWithSpace ", 14); // ➜ EndsWithSpace%20
        runTest("  Leading", 9); // ➜ %20%20Leading
    }
}
