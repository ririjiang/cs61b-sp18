import com.sun.security.auth.module.NTSystem;

import java.util.List;

public class LinkedListDeque <T> {
    public class ListItems {
        public T item;
        public ListItems next;
        public ListItems prev;
        public ListItems(){
            item = null;
            next = null;
            prev = null;
        }
    }

    public int size;
    public ListItems sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListItems();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }

    public void addFirst(T item) {
        ListItems first = new ListItems();
        first.next = sentinel.next;
        first.prev =sentinel;
        first.item = item;
        sentinel.next.prev = first;
        sentinel.next = first;
        if (isEmpty()){
        sentinel.prev = first;
        }
        size++;
    }

    public void addLast(T item) {
        ListItems Last = new ListItems();
        Last.next = sentinel;
        Last.prev = sentinel.prev;
        Last.item = item;
        sentinel.prev.next = Last;
        sentinel.prev = Last;
        if(isEmpty()){
            sentinel.next = Last;
        }
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int a = size;
        ListItems track = sentinel;
        while(a > 0){
        System.out.println(track.next.item);
        track = track.next;
        a--;
        }
    }

    public T removeFirst(){
        size--;
        if(isEmpty()){
            return null;
        }
        T a = sentinel.next.item;
        this.sentinel.next.next.prev = this.sentinel;
        this.sentinel.next = this.sentinel.next.next;

        return a;
    }

    public T removeLast(){
        size--;
        if(isEmpty()){
            return null;
        }
        T a = sentinel.prev.item;
        this.sentinel.prev.prev.next = this.sentinel;
        this.sentinel.prev = this.sentinel.prev.prev;
        return a;

    }

    public T get(int index){
        int num = size;
        ListItems track = sentinel;
        while (num >0 ){
            track = track.next;
            num--;
        }
        return track.item;
    }

   /** public T getRecursive(int index){
        if(size == 0){
            return null;
        }
        int a = index;
        a--;
        return;
    }
*/




}