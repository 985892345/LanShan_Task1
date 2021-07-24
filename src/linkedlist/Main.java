package linkedlist;

public class Main {

    private static final LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        printList();

        list.removeAt(0);
        printList();
        list.add(0, 0);
        printList();

        list.add(999);
        list.add(999);
        list.add(999);
        printList();
        list.remove(999);
        printList();
    }

    private static void printList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "    ");
        }
        System.out.println();
    }
}
