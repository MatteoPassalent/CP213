package cp213;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Stores a List of MenuItems and provides a method return these items in a
 * formatted String. May be constructed from an existing List or from a file
 * with lines in the format:
 *
 * <pre>
1.25 hot dog
10.00 pizza
...
 * </pre>
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-07-05
 */
public class Menu {

    // Attributes.
    // define a List of MenuItem objects

    // your code here
    private ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();

    /**
     * Creates a new Menu from an existing Collection of MenuItems. MenuItems are
     * copied into the Menu List.
     *
     * @param items an existing Collection of MenuItems.
     */
    public Menu(Collection<MenuItem> items) {

        // your code here
        menuList = new ArrayList<MenuItem>(items);

    }

    /**
     * Constructor from a Scanner of MenuItem strings. Each line in the Scanner
     * corresponds to a MenuItem. You have to read the Scanner line by line and add
     * each MenuItem to the List of items.
     *
     * @param fileScanner A Scanner accessing MenuItem String data.
     */
    public Menu(Scanner fileScanner) {

        // your code here
        // must be a better way
        MenuItem item;
        String num;
        double price;
        String name = "";
        String line;
        String[] words;
        while (fileScanner.hasNext()) {
            line = fileScanner.nextLine();
            words = line.split(" ");
            num = words[0];
            price = Double.parseDouble(num);
            for (int i = 1; i < words.length; i++) {
                name += words[i];
                name += " ";
            }
            name = name.strip();
            item = new MenuItem(name, price);
            menuList.add(item);
            name = "";
        }

    }

    /**
     * Returns the List's i-th MenuItem.
     *
     * @param i Index of a MenuItem.
     * @return the MenuItem at index i
     */
    public MenuItem getItem(int i) {

        // your code here
        // privacy leak?
        return new MenuItem(menuList.get(i).getName(), menuList.get(i).getPrice());
    }

    /**
     * Returns the number of MenuItems in the items List.
     *
     * @return Size of the items List.
     */
    public int size() {

        // your code here
        return menuList.size();
    }

    /**
     * Returns the Menu items as a String in the format:
     *
     * <pre>
    5) poutine      $ 3.75
    6) pizza        $10.00
     * </pre>
     *
     * where n) is the index + 1 of the MenuItems in the List.
     */
    @Override
    public String toString() {

        // your code here
        String r = "";
        for (int i = 0; i < menuList.size(); i++) {
            r += " " + (i + 1) + ") " + menuList.get(i).toString() + "\n";

        }

        return r;
    }
}