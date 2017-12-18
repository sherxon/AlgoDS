package timus;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Why Did you create this class? what does it do?
 */
public class Superstack {
    static void superStack(String[] operations) {
        if (operations == null || operations.length == 0) {
            System.out.println("EMPTY");
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {
            String current = operations[i];
            if (current.equals("pop")) {
                list.removeLast();
            } else {
                if (current.startsWith("push")) {
                    list.addLast(Integer.parseInt(current.split(" ")[1]));
                } else {
                    int e = Integer.parseInt(current.split(" ")[1]);
                    int k = Integer.parseInt(current.split(" ")[2]);
                    ListIterator<Integer> listIterator = list.listIterator();
                    int j = 1;
                    while (listIterator.hasNext()) {
                        if (j > e)
                            break;
                        listIterator.set(listIterator.next() + k);
                        j++;
                    }
                }
            }
            if (list.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(list.getLast());

        }

    }

}
