public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    // iterative solution
    // public int size() {
    // int size = 1;
    // IntList tmp = this;
    // while (tmp.rest != null) {
    // size += 1;
    // tmp = tmp.rest;
    // }
    // return size;
    // }

    public int get(int idx) {
        if (idx == 0) {
            return first;
        }
        IntList tmp = this;
        int result = first;
        int count = 0;
        while (count <= idx) {
            result = tmp.first;
            tmp = tmp.rest;
            count += 1;
        }
        return result;
    }

    // a better implementation with recursion
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    // public int get(int idx) {
    // if (idx == 0) {
    // return first;
    // }
    // return rest.get(idx - 1);
    // }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(2, L);
        System.out.println(L.size());
        System.out.println(L.get(2));

    }
}
