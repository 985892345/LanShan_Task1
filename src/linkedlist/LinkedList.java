package linkedlist;

public class LinkedList<T> {

    private Node first;
    private Node last;
    private int size = 0;

    public void add(T element) {
        if (size == 0) {
            first = new Node(element, null, null);
            first.prev = first;
            first.next = first;
            last = first;
        }else {
            Node node = new Node(element, last, first);
            first.prev = node;
            last.next = node;
            last = node;
        }
        size++;
    }

    public void add(int index, T element) {
        checkPositionIndex(index);
        if (index == size) {
            add(element);
        }else {
            Node now = getNode(index);
            Node prev = now.prev;
            Node node = new Node(element, prev, now);
            prev.next = node;
            now.prev = node;
            if (index == 0) {
                first = node;
            }
            size++;
        }
    }

    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).data;
    }

    public void set(int index, T element) {
        checkElementIndex(index);
        getNode(index).data = element;
    }

    public boolean remove(T o) {
        checkElementIndex(0);
        int index = 0;
        Node node = first;
        boolean isFound = false;
        if (size > 1) {
            while (index < size) {
                if (node.data.equals(o)) {
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                    if (index == 0) {
                        first = next;
                    }else if (index == size - 1) {
                        last = prev;
                    }
                    isFound = true;
                    size--;
                    index--;
                }
                node = node.next;
                index++;
            }
        }else {
            if (first.data.equals(o)) {
                first = null;
                last = null;
                isFound = true;
                size--;
            }
        }
        return isFound;
    }

    public void removeAt(int index) {
        checkElementIndex(index);
        Node node = getNode(index);
        if (size > 1) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            if (index == 0) {
                first = next;
            }else if (index == size - 1) {
                last = prev;
            }
        }else {
            first = null;
            last = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        Node node;
        if (index <= size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }else {
            node = last;
            for (int i = index; i < size - 1; i++) {
                node = node.prev;
            }
        }
        return node;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + "Size = " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index = " + index + "Size = " + size);
        }
    }

    private class Node {
        public T data;
        public Node prev;
        public Node next;

        public Node(T data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
