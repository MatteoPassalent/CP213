package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A05GUITEST {

    public static void main(String[] args) {
        System.out.println("GUITEST");
        GUITEST();

    }

    public static void GUITEST() {
        Menu menu = null;
        String filename = "pass7410_a05\\src\\cp213\\menu.txt";

        try {

            Scanner fileScanner = new Scanner(new File(filename));
            menu = new Menu(fileScanner);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open menu file");
        }
        OrderPanel panel = new OrderPanel(menu);
    }
}
