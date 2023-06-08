package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Matteo Passalent
 * @version 2023-05-18
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

        if (sn.charAt(0) != 'S' || sn.charAt(1) != 'N' || sn.charAt(2) != '/' || sn.charAt(7) != '-'
                || sn.length() != 11) {
            return false;
        }
        for (int i = 3; i <= 6; i++) {
            if (!Character.isDigit(sn.charAt(i))) {
                return false;
            }
        }
        for (int i = 8; i <= 10; i++) {
            if (!Character.isDigit(sn.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

        while (fileIn.hasNextLine()) {
            String sn = fileIn.nextLine();
            if (validSn(sn)) {
                goodSns.println(sn);
            } else {
                badSns.println(sn);
            }
        }

        return;
    }

}
