package cp213;

/**
 * @author Your name and id here
 * @version 2022-09-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

        String newstr = "";
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                newstr += string.charAt(i);
            }
        }

        String reversed = "";
        for (int i = newstr.length() - 1; i >= 0; i--) {
            reversed += newstr.charAt(i);
        }

        System.out.println(reversed);
        if (newstr.equalsIgnoreCase(reversed)) {
            return true;
        }
        return false;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

        if (!Character.isLetter(name.charAt(0)) && name.charAt(0) != '_') {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c) && c != '_') {
                return false;
            }
        }

        if (name.charAt(0) == '_' && name.length() == 1) {
            return false;
        }

        return true;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

        boolean up = false;
        if (Character.isUpperCase(word.charAt(0))) {
            up = true;
        }

        if (VOWELS.contains((Character.toString(word.charAt(0))))) {
            word += "way";

        } else {
            char first = word.charAt(0);
            if (up) {
                first = Character.toLowerCase(first);
            }
            word += first;
            word = word.substring(1);

            String firstconsts = "";
            while (!(VOWELS + 'Y' + 'y').contains((Character.toString(word.charAt(0))))) {
                char nfirst = word.charAt(0);
                if (up) {
                    nfirst = Character.toLowerCase(nfirst);
                }
                firstconsts += nfirst;
                word = word.substring(1);
            }
            word += firstconsts + "ay";
        }

        if (up)

        {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
        }

        return word;
    }

}
