package tpalgo;

/**
 * Class representing a circular simple linked list.
 *
 * @author gravallg
 * @param <Type> Type of the data the list will contain.
 */
public class CircularList<Type> {

    /**
     * Class representing a cell of a circular list.
     *
     * @param <Type> Type of the data the cell will contain.
     */
    private class Cell<Type> {

        // Contains the data of the cell.
        private Type mData;

        // Contains the next cell.
        private Cell<Type> mNext;

        /**
         * Default constructor of the Cell class.
         *
         * @param data
         * @param next
         */
        public Cell(Type data, Cell<Type> next) {
            mData = data;
            mNext = next;
        }

        /**
         * Getter of the data contained in the cell.
         *
         * @return Data contained in the cell.
         */
        public Type getData() {
            return mData;
        }

        /**
         * Getter of the next cell.
         *
         * @return The next cell.
         */
        public Cell<Type> getNext() {
            return mNext;
        }

        /**
         * Private setter of the next cell.
         *
         * @param next Next cell.
         */
        private void setNext(Cell<Type> next) {
            mNext = next;
        }

        /**
         * Getter of a string representation of the cell.
         *
         * @return String representation of the cell.
         */
        @Override
        public String toString() {
            return mData.toString();
        }
    }

    // Contains the first cell of the list.
    private Cell<Type> first;

    // Contains the last cell of the list.
    private Cell<Type> last;

    /**
     * Default constructor of the CircularList class.
     */
    public CircularList() {
        first = null;
        last = null;
    }

    /**
     * Getter of a string representation of the circular list.
     *
     * @return String representation of the circular list.
     */
    @Override
    public String toString() {
        String msg = "";
        Cell<Type> cur = first;

        if (first == null) {
            return "Empty list.";
        }
        do {
            msg += " " + cur.toString();
            cur = cur.getNext();
        } while (cur != first);

        return msg;

    }

    /**
     * Pushes a given data to the list in first position.
     *
     * @param data Data that will be pushed to the front of the list.
     */
    public void pushFront(Type data) {
        Cell<Type> c = new Cell<>(data, first);

        if (first == null) {
            c.setNext(c);
            last = c;
        } else {
            last.setNext(c);
        }

        first = c;
    }

    /**
     * Pushes a given data to the list in last position.
     *
     * @param data Data that will be pushed to the back of the list.
     */
    public void pushBack(Type data) {
        Cell<Type> c = new Cell<>(data, first);

        if (first == null) {
            c.setNext(c);
            first = c;
        } else {
            last.setNext(c);
            c.setNext(first);
        }
        last = c;
    }

    /**
     * Searches if a given data exists in the list.
     *
     * @param data Data that is searched for in the list.
     * @return true if the list contains the value.
     */
    public Boolean containsData(Type data) {
        Cell<Type> cell = first;

        do {
            if (cell.getData().equals(data)) {
                return true;
            }
            cell = cell.getNext();
        } while (cell != first);

        return false;
    }

    /**
     * Removes the data in the first position of the list.
     *
     * @return The data in the first position of the list or null.
     */
    public Type popFront() {
        if (first == null) {
            return null;
        }

        Type front = first.getData();

        last.setNext(first.getNext());

        first = first.getNext();

        return front;
    }

    /**
     * Removes the data in the last position of the list.
     *
     * @return The data in the last position of the list or null.
     */
    public Type popBack() {
        Type back;

        if (first == null) {
            return null;
        }

        Cell<Type> cur = first;

        while (cur.getNext() != last) {
            cur = cur.getNext();
        }

        back = last.getData();
        cur.setNext(first);
        last = cur;

        return back;

    }

    /**
     * Removes the given data in the list.
     * @param data The data to remove from the list.
     * @return The data in the the list or null.
     */
    public Type popData(Type data) {
        Type prev;

        if (first == null) {
            return null;
        }

        if (first.getData().equals(data)) {
            prev = first.getData();
            first = first.getNext();
            last.setNext(first);
            return prev;
        }

        Cell<Type> cur = first;

        while (!cur.getNext().getData().equals(data)) {
            if (cur == last) {
                return null;
            }
            cur = cur.getNext();
        }

        prev = cur.getNext().getData();
        cur.setNext(cur.getNext().getNext());

        return prev;
    }

    /**
     * Elects an item of the list by removing items every "step" position until
     * one is left.
     *
     * @param step Step used to remove items.
     * @param output Prints each step of the process if true.
     * @return The elected item.
     */
    public Type elect(int step, boolean output) {
        if (first == null) {
            return null;
        }

        int cpt = 0;

        // Until there's one item left.
        while (first.getNext() != first) {
            // We cycle to the next step item...
            for (int i = 0; i < step - 1; i++) {
                first = first.getNext();
                last = last.getNext();
                cpt++;
            }

            // ... to remove it.
            Type val = popFront();

            if (output) {
                System.out.println(val.toString() + " is eliminated...");

            }

        }

        System.out.println(first.getData().toString() + " is elected ! (cpt=" + cpt + ")");
        return first.getData();
    }

}
