package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class foodtesting {
    public static void main(final String[] args) {
        testSingleList();
    }

    private static void testSingleStack() {
        SingleStack<Food> list = new SingleStack<Food>();
        SingleStack<Food> list1 = new SingleStack<Food>();
        SingleStack<Food> list2 = new SingleStack<Food>();
        Food food1 = new Food("apple", 0, true, 100);
        Food food2 = new Food("banana", 1, false, 200);
        Food food3 = new Food("carrot", 2, true, 300);
        list.push(food1);
        list.push(food2);
        list.push(food3);
        list.splitAlternate(list1, list2);
        list.combine(list1, list2);
        list.pop();

        System.out.println(valuesToString(list));
    }

    private static void testSingleQueue() {

    }

    private static void testSinglePriorityQueue() {

    }

    private static void testSingleList() {
        SingleList<Food> list = new SingleList<Food>();
        Food food1 = new Food("apple", 0, true, 100);
        Food food2 = new Food("banana", 1, false, 200);
        Food food21 = new Food("banana", 1, false, 200);
        Food food22 = new Food("banana", 1, false, 200);
        Food food3 = new Food("carrot", 2, true, 300);

        list.append(food1);
        list.append(food2);
        list.append(food21);
        list.append(food22);
        list.append(food3);
        list.removeMany(food2);

        System.out.println(valuesToString(list));

    }

    /**
     * Returns a comma-delimited string of the values in a data structure from front
     * to rear.
     *
     * @param <T>
     * @param dataStructure The object containing the values.
     * @return a string with the values of dataStructure listed from front to rear.
     */
    private static <T> String valuesToString(SingleLink<T> dataStructure) {
        List<T> actual = new ArrayList<T>();

        for (T value : dataStructure) {
            actual.add(value);
        }
        return actual.toString();
    }
}
