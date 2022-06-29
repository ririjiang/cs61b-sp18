public class ArrayDeque<T> {
    public T[] item;
    public int size;
    public int nextFirst;
    public int nextLast;
    public ArrayDeque() {
        this.item = (T[]) new Object[8];
        size = 0;
        nextFirst =3;
        nextLast = 4;
    }
    public void firstlesslast(int i){
        T[] Narray = (T[]) new Object[i];
        System.arraycopy(this.item,0, Narray, 0, this.size);
        nextFirst++;
        this.item = Narray;
    }

    public void firstlargelast(int i){
        T[] Narray = (T[]) new Object[i];
        System.arraycopy(this.item,0,Narray, 0, this.nextLast-1);
        System.arraycopy(this.item,Narray.length-this.size+nextFirst,Narray, 0, size-1-nextFirst);
        nextFirst = Narray.length-this.size+nextFirst;
        this.item = Narray;
    }
    //resize array
    public void resize(){
            if(nextFirst< nextLast|nextLast==0){
                firstlesslast(this.size*4);
            }
            else{
               firstlargelast(this.size*4);
            }
    }

    public void addFirst(T thing){
        if(size == item.length){
            resize();
            item [nextFirst] =thing;
            nextFirst--;
            size++;
        }
        else{
            if (nextFirst == 0){
                nextFirst = item.length-1;
                item[0] = thing;
                size++;
            }
            else{
                item[nextFirst] = thing;
                nextFirst--;
                size++;
            }
        }
    }

    /** Inserts X into the back of the list. */
    public void addLast(T thing) {
        if(size == item.length){
            resize();
            item [nextLast] =thing;
            nextLast++;
            size++;
        }
        else{
            if (nextLast == item.length -1){
                nextLast = 0;
                item[item.length -1] = thing;
                size++;
            }
            else{
                item[nextLast] = thing;
                nextLast++;
                size++;
            }
        }
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return 0;
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(T i) {
        return i;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        return 0;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        a1.addLast(3);
        a1.addLast(3);
        a1.addLast(3); a1.addLast(3);
        a1.addLast(3);
        a1.addFirst(3);
        a1.addLast(3);
        a1.addLast(3);
        a1.addFirst(3);
        a1.addLast(3);
        a1.addLast(3);

    }
}