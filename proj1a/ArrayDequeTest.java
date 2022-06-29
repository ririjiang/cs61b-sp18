public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> D1 = new ArrayDeque<>();
        D1.addLast(0);
        D1.addLast(1);
        D1.addFirst(24);
        D1.addLast(0);
        D1.removeFirst();
        D1.removeLast();
        D1.removeFirst();
        D1.removeLast();
        D1.addFirst(5);


    }

}
