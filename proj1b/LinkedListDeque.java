public class LinkedListDeque <T> implements Deque<T>{
    private class ListItems {
        public T item;
        public ListItems next;
        public ListItems prev;
        public ListItems(){
            item = null;
            next = null;
            prev = null;
        }
    }

    private int size;
    private ListItems sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListItems();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }
    @Override
    public void addFirst(T item) {
        ListItems first = new ListItems();
        if (isEmpty()){
            sentinel.prev = first;
            sentinel.next =first;
            first.next =sentinel;
            first.prev=sentinel;
            first.item = item;
        }
        else {
            first.next = sentinel.next;
            first.prev =sentinel;
            first.item = item;
            sentinel.next.prev = first;
            sentinel.next = first;
        }

        size++;
    }
@Override
    public void addLast(T item) {
        ListItems Last = new ListItems();
        if(isEmpty()){
            sentinel.next = Last;
            sentinel.prev= Last;
            Last.prev = sentinel;
            Last.next = sentinel;
            Last.item = item;
        }
        else {
            Last.next = sentinel;
            Last.prev = sentinel.prev;
            Last.item = item;
            sentinel.prev.next = Last;
            sentinel.prev = Last;
        }
        size++;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        int a = size;
        ListItems track = sentinel;
        while(a > 0){
        System.out.println(track.next.item);
        track = track.next;
        a--;
        }
    }
    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        else {
            T a = sentinel.next.item;
            this.sentinel.next.next.prev = this.sentinel;
            this.sentinel.next = this.sentinel.next.next;
            size = size-1;
            return a;
        }
    }
    @Override
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        else {
            T a = sentinel.prev.item;
            this.sentinel.prev.prev.next = this.sentinel;
            this.sentinel.prev = this.sentinel.prev.prev;
            size--;
            return a;
        }
    }
    @Override
    public T get(int index){
        if(index < size){
        int num = index+1;
        ListItems track = sentinel;
        while (num >0 ){
            track = track.next;
            num--;
        }
        return track.item;
        }
        else {
        return null;
        }
    }

    private T recursivehelper(ListItems p, int x){
        if(x == 0){
            return p.next.item;
        }
        return recursivehelper(p.next, x-1);
    }
    public T getRecursive(int index){
        if(index<size){
        return recursivehelper(sentinel,index);
        }
        else{
        return null;
        }
    }

}