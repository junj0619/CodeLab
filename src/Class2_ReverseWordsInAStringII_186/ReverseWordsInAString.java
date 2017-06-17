package Class2_ReverseWordsInAStringII_186;

/**
 * Created by junjin on 6/9/17.
 */
public class ReverseWordsInAString {

    public static void main(String args[]) {

        String input = "The Sky Is Blue";
        String result = reverseWords(input);
        System.out.printf(result);

    }

    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();
        /* Reverse whole String first*/
        reverseHelper(ch, 0, ch.length - 1);

        /* Reverse each word */
        int i = 0;
        for (int j = i + 1; j < ch.length - 1; j++) {
            if (ch[j] == ' ') {
                reverseHelper(ch, i, j - 1);
                i = j + 1;
            }
        }

        /* Reverse last word */
        reverseHelper(ch, i, ch.length - 1);

        return new String(ch);
    }

    private static void reverseHelper(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = temp;
        }
    }

}
