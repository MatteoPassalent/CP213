package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        try {
            // Step 1: Prepare input files
            File inputFile = new File("C:/cp213 main folder/pass7410_a01/src/cp213/input.txt");

            // Step 2: Create output files
            File goodSnFile = new File("C:/cp213 main folder/pass7410_a01/src/cp213/good_sns.txt");
            File badSnFile = new File("C:/cp213 main folder/pass7410_a01/src/cp213/bad_sns.txt");

            // Step 3: Set up the test environment
            Scanner fileIn = new Scanner(inputFile);
            PrintStream goodSns = new PrintStream(goodSnFile);
            PrintStream badSns = new PrintStream(badSnFile);

            // Step 4: Call the validSnFile method
            SerialNumber.validSnFile(fileIn, goodSns, badSns);

            // Step 5: Verify the results
            fileIn.close();
            goodSns.close();
            badSns.close();

            System.out.println("Testing complete. Check the output files for results.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}