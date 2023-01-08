
// An SLList is a list of integers which hides the terrible truth of the nakedness within.
public class SLList {
    // to prevent code in other classes from using members of this class
    // the first item is at sentinel.next
    private IntNode sentinel;
    private int size;

    // nested class
    // if IntNode never looks for any details in SLList class, then can add "static"
    // meaning "never looks outwards"
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    // creates an empty SLList
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    // adds x to the front of the list
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    // get the first element
    public int getFirst() {
        return sentinel.next.item;
    }

    public int size_method() {
        IntNode tmp = sentinel.next;
        int size = 0;
        while (tmp != null) {
            size += 1;
            tmp = tmp.next;
        }
        return size;
    }

    public int size() {
        return size;
    }

    public void addLast(int n) {
        size += 1;
        IntNode tmp = sentinel;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new IntNode(n, null);
    }

    public void print() {
        IntNode tmp = sentinel.next;
        while (tmp != null) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        return;
    }

    public static void main(String[] args) {
        // creates a list of one integer, namely 10
        SLList L = new SLList();
        L.addLast(6);
        L.addFirst(10);
        L.addFirst(5);
        L.addFirst(25);
        System.out.println(L.getFirst());
        System.out.println(L.size());
        L.print();
    }
}
