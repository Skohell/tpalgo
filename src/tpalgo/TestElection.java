package tpalgo;

/**
 * Class used to do tests on the election process.
 *
 * @author gravallg
 */
public class TestElection {

    /**
     * Method to test the example given in the subject. Should elect 4 in a list
     * from 1 to 7.
     */
    public void testExample() {
        CircularList<Integer> cl = new CircularList<>();

        cl.pushBack(1);
        cl.pushBack(2);
        cl.pushBack(3);
        cl.pushBack(4);
        cl.pushBack(5);
        cl.pushBack(6);
        cl.pushBack(7);

        cl.elect(3, true);

    }

    /**
     * Method to test the election process for different values of 'step' and
     * 'n'.
     *
     * @param step Step used to remove items.
     * @param n Number of items in the list.
     * @param output Prints the steps of the process if true.
     */
    public void testElection(int step, int n, boolean output) {
        CircularList<Integer> cl = new CircularList<>();

        for (int i = 1; i <= n; i++) {
            cl.pushBack(i);
        }

        System.out.println(n + "candidates with k =" + step);

        cl.elect(step, output);
    }
}
