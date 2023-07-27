package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class testing.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-07-05
 */
public class A05Main {

	// Constants
	private static final String LINE = "-".repeat(40);
	private static final String TEST_LINE = "=".repeat(80);

	/**
	 * For testing. Reads contents of "menu.txt" from root of project.
	 *
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		System.out.println("Assignment 5 Class Tests");
		testMenuItem();
		testMenu();
	}

	/**
	 * Simple MenuItem tests.
	 */
	public static void testMenuItem() {
		System.out.println(TEST_LINE);
		System.out.println("Testing MenuItem");
		System.out.println(LINE);
		System.out.println("Test double Constructor:");
		String item = "hot dog";
		double doublePrice = 1.25;
		MenuItem menuItem = new MenuItem(item, doublePrice);
		System.out.println(String.format("menuItem = new MenuItem(\"%s\", %.2f);", item, doublePrice));
		System.out.println(LINE);
		String name = menuItem.getName();
		System.out.println(String.format("menuItem.getName():\n  {\"hot dog\"}: \"%s\"", name));
		System.out.println(LINE);
		BigDecimal price = menuItem.getPrice();
		System.out.println(String.format("menuItem.getPrice():\n  {1.25}: %s", price));
		System.out.println(LINE);
		String string = menuItem.toString();
		System.out.println(String.format("menuItem.toString():\n  {\"hot dog      $ 1.25\"}: \"%s\"", string));
		System.out.println(LINE);
		System.out.println("Test BigDecimal Constructor:");
		BigDecimal bigPrice = new BigDecimal(doublePrice);
		menuItem = new MenuItem(item, bigPrice);
		System.out.println(String.format("menuItem = new MenuItem(\"%s\", %s);", item, bigPrice));
		System.out.println(LINE);
		name = menuItem.getName();
		System.out.println(String.format("menuItem.getName():\n  {\"hot dog\"}: \"%s\"", name));
		System.out.println(LINE);
		price = menuItem.getPrice();
		System.out.println(String.format("menuItem.getPrice():\n  {1.25}: %s", price));
		System.out.println(LINE);
		string = menuItem.toString();
		System.out.println(String.format("menuItem.toString():\n  {\"hot dog      $ 1.25\"}: \"%s\"", string));
		System.out.println();
	}

	/**
	 * Simple Menu tests.
	 */
	public static void testMenu() {
		System.out.println(TEST_LINE);
		System.out.println("Testing Menu");
		System.out.println(LINE);
		Menu menu = null;
		String filename = "pass7410_a05\\src\\cp213\\menu.txt";

		try {
			Scanner fileScanner = new Scanner(new File(filename));
			menu = new Menu(fileScanner);
			System.out.println("Menu menu = new Menu(fileScanner);");
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open menu file");
		}
		System.out.println(LINE);
		int size = menu.size();
		System.out.println(String.format("menu.size():\n  {7}: %d", size));
		System.out.println(LINE);
		MenuItem item = menu.getItem(3);
		System.out.println(String.format("menu.getItem(3):\n  {\"fries        $ 1.75\"}: \"%s\"", item));
		System.out.println(LINE);
		System.out.println("menu.toString():");
		System.out.println(menu.toString());
		System.out.println(LINE);
		MenuItem[] itemsArray = { new MenuItem("hot dog", 1.25), new MenuItem("fries", 1.75) };
		System.out.println("List of items:");
		System.out.println(Arrays.toString(itemsArray));
		List<MenuItem> items = new ArrayList<>(Arrays.asList(itemsArray));
		Menu menuFromList = new Menu(items);
		System.out.println("Menu menuFromList = new Menu(items);");
		System.out.println("menuFromList.toString():");
		System.out.println(menuFromList.toString());
	}

	/**
	 * Simple Menu tests.
	 */
	public static void testOrder() {
		System.out.println(TEST_LINE);
		System.out.println("Testing Menu");
		System.out.println(LINE);
		Order order = new Order();
		String item = "hot dog";
		double doublePrice = 1.25;
		MenuItem menuItem = new MenuItem(item, doublePrice);
		order.add(menuItem, 1);

	}

}
