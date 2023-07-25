package cp213;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-07-05
 */
public class Cashier {

    // Attributes
    private Menu menu = null;

    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
        this.menu = menu;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
        System.out.println("\nMenu:");
        System.out.println(menu.toString());
        System.out.println("Press 0 when done.");
        System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
    public Order takeOrder() {
        System.out.println("Welcome to WLU Foodorama!");
        // your code here
        int command = -1;
        Order order = new Order();
        printCommands();

        while (command != 0) {
            // should do try block
            int q = 0;
            Scanner input = new Scanner(System.in);
            System.out.print("Command: ");
            try {
                command = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number");
                continue;
            } catch (NoSuchElementException f) {
                System.out.println("Not a valid number");
                continue;
            }

            if (command == 0) {
                input.close();
            } else if (command < 0 || command > menu.size()) {
                printCommands();
            } else {
                while (q == 0) {
                    input = new Scanner(System.in);
                    try {
                        System.out.print("How many do you want? ");
                        q = input.nextInt();
                        if (q <= 0) {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Not a valid number");
                    } catch (NoSuchElementException f) {
                        System.out.println("Not a valid number");
                    }
                }
                if (q > 0) {
                    order.add(menu.getItem(command - 1), q);
                }
            }
        }
        // prob shouldnt be in here maybe?
        String str = order.toString();
        System.out.println(str);

        return order;
    }
}