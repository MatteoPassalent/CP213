package cp213;

import org.w3c.dom.Node;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2023-06-04
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

        // your code here

        SingleNode<T> current = this.front;
        SingleNode<T> prev = this.front;

        while (current != null) {
            if (current.getData().equals(key)) {
                // not copy safe maybe
                return prev;
            }
            prev = current;
            current = current.getNext();
        }

        return null;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param data The value to append.
     */
    public void append(final T data) {
        SingleNode<T> newNode = new SingleNode<T>(data, null);
        if (this.front == null) {
            this.front = newNode;
        } else {
            this.rear.setNext(newNode);
        }
        this.rear = newNode;
        this.length += 1;

        return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {
        if (this.front == null || this.front == null) {
            // Empty list or only one element, no duplicates to remove
            return;
        }

        SingleNode<T> current = this.front;
        while (current != null) {
            SingleNode<T> runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    // Duplicate found, remove it
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
        return;
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {
        while (left.front != null && right.front != null) {
            this.moveFrontToRear(left);
            this.moveFrontToRear(right);
        }

        while (left.front != null) {
            this.moveFrontToRear(left);
        }

        while (right.front != null) {
            this.moveFrontToRear(right);
        }
    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

        return this.linearSearch(key) != null;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

        SingleNode<T> current = this.front;
        int count = 0;

        while (current != null) {
            if (current.getData().equals(key)) {
                count += 1;
            }
            current = current.getNext();
        }

        return count;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {

        SingleNode<T> srch = this.linearSearch(key);

        if (srch != null) {
            srch = srch.getNext();
            return srch.getData();
        } else {
            return null;
        }

    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

        SingleNode<T> curr = this.front;
        for (int j = 0; j <= n; j++) {
            curr = curr.getNext();
        }
        // Prvacy leak???
        return curr.getData();

    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {
        SingleNode<T> currentNode = front;
        SingleNode<T> sourceCurrentNode = source.front;

        while (currentNode != null && sourceCurrentNode != null) {
            if (!currentNode.getData().equals(sourceCurrentNode.getData())) {
                return false; // Values differ, lists are not identical
            }

            currentNode = currentNode.getNext();
            sourceCurrentNode = sourceCurrentNode.getNext();
        }

        // If one list is longer than the other, they are not identical
        if (currentNode != null || sourceCurrentNode != null) {
            return false;
        }

        return true; // Lists are identical
    }

    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {
        SingleNode<T> curr = this.front;
        int index = 0;
        while (curr != null) {
            if (curr.getData().equals(key)) {
                return index;
            } else {
                index += 1;
                curr = curr.getNext();
            }
        }

        return -1;
    }

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i    The index to insert the new data at.
     * @param data The new value to insert into this SingleList.
     */
    public void insert(int i, final T data) {
        SingleNode<T> newNode = new SingleNode(data, null);
        if (i >= this.length) {
            this.rear.setNext(newNode);
            this.rear = newNode;
        } else {
            SingleNode<T> curr = this.front;
            SingleNode<T> prev = null;
            for (int j = 0; j <= i; j++) {
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(newNode);
            newNode.setNext(curr);

        }
        this.length += 1;

        return;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {
        SingleNode<T> leftCurrent = left.front;
        SingleNode<T> rightCurrent = right.front;
        SingleNode<T> intersectionCurrent = null;
        SingleNode<T> intersectionFront = null;

        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.getData().equals(rightCurrent.getData())) {
                if (intersectionCurrent == null) {
                    intersectionCurrent = new SingleNode(leftCurrent.getData(), null);
                    intersectionFront = intersectionCurrent;
                } else {
                    intersectionCurrent.setNext(new SingleNode(leftCurrent.getData(), null));
                    intersectionCurrent = intersectionCurrent.getNext();
                }
            }

            leftCurrent = leftCurrent.getNext();
            rightCurrent = rightCurrent.getNext();
        }

        // Set the intersection as the result for this SingleList
        this.front = intersectionFront;
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {

        // your code here
        SingleNode<T> curr = this.front;
        T max = curr.getData();
        while (curr != null) {
            if (curr.getData().compareTo(max) > 0) {
                max = curr.getData();
            }
            curr = curr.getNext();
        }
        // privacy leak?
        return max;
    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {

        // your code here
        SingleNode<T> curr = this.front;
        T min = curr.getData();
        while (curr != null) {
            if (curr.getData().compareTo(min) < 0) {
                min = curr.getData();
            }
            curr = curr.getNext();
        }
        // privacy leak?
        return min;
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param data The value to insert into the front of this SingleList.
     */
    public void prepend(final T data) {

        SingleNode<T> newNode = new SingleNode<T>(data, null);
        if (this.front == null) {
            this.rear = newNode;
        } else {
            newNode.setNext(this.front);
        }
        this.front = newNode;
        this.length += 1;

        return;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {
        if (this.front == null) {
            // Empty list, nothing to remove
            return null;
        }

        if (this.front.getData().equals(key)) {
            // Key found at the head, remove and return it
            SingleNode<T> removedValue = this.front;
            this.front = this.front.getNext();
            this.length -= 1;
            return removedValue.getData();
        }

        SingleNode<T> current = this.front;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(key)) {
                // Key found in the next node, remove and return it
                SingleNode<T> removedValue = current.getNext();
                current.setNext(current.getNext().getNext());
                this.length -= 1;
                return removedValue.getData();
            }
            current = current.getNext();
        }

        // Key not found
        return null;
    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {
        if (this.front == null) {
            // Empty list, nothing to remove
            return null;
        }

        SingleNode<T> removedValue = this.front;
        this.front = this.front.getNext(); // Move the head pointer to the next node
        this.length -= 1;

        return removedValue.getData();
    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {

        if (this.front == null) {
            // Empty list, nothing to remove
            return;
        }

        // Handle case when the key is found at the beginning of the list
        while (this.front != null && this.front.getData().equals(key)) {
            this.front = this.front.getNext();
            this.length -= 1;
        }

        SingleNode<T> current = this.front;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getData().equals(key)) {
                current.setNext(current.getNext().getNext());
                this.length -= 1;
            } else {
                current = current.getNext();
            }
        }

        return;
    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {
        if (this.front == null || this.front.getNext() == null) {
            // Empty list or only one element, nothing to reverse
            return;
        }

        SingleNode<T> previous = null;
        SingleNode<T> current = this.front;
        SingleNode<T> next = null;

        while (current != null) {
            next = current.getNext(); // Store the next node
            current.setNext(previous);

            // Move to the next nodes
            previous = current;
            current = next;
        }

        // Update the head to the new first element
        this.front = previous;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {
        if (this.front == null || this.front.getNext() == null) {
            // Empty list or only one element, nothing to split
            return;
        }

        int size = this.length;
        int mid = size / 2 + size % 2;

        SingleNode<T> current = this.front;
        SingleNode<T> previous = null;

        // Traverse to the middle node
        for (int i = 0; i < mid; i++) {
            previous = current;
            current = current.getNext();
        }

        // Set the tail of the left list
        left.front = this.front;
        left.rear = previous;
        left.length = mid;

        // Set the head of the right list
        right.front = current;
        right.rear = this.rear;
        right.length = size - mid;

        // Break the link between left and right lists
        if (previous != null) {
            previous.setNext(null);
        }

        // Clear the original list
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {
        if (this.front == null) {
            // Empty list, nothing to split
            return;
        }

        while (this.front != null) {
            left.moveFrontToRear(this);
            if (this.front != null) {
                right.moveFrontToRear(this);
            }
        }

        // Clear the original list
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

        // Iterate over elements in the left SingleList
        for (SingleNode<T> node = left.front; node != null; node = node.getNext()) {
            this.moveFrontToFront(left); // Add the element to the current SingleList
        }

        // Iterate over elements in the right SingleList
        for (SingleNode<T> node = right.front; node != null; node = node.getNext()) {
            this.moveFrontToFront(right); // Add the element to the current SingleList if it doesn't already exist
        }
    }
}
