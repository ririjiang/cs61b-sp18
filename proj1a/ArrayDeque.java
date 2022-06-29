import javax.swing.plaf.synth.SynthTextAreaUI;

public class ArrayDeque<T> {
    public T[] item;
    public int size;
    public int nextFirst;
    public int nextLast;
    public ArrayDeque() {
        this.item = (T[]) new Object[8];
        size = 0;
        nextFirst =0;
        nextLast = 1;
    }

    public int minusone(int index){
        if(index == 0){
           return index = this.item.length-1;
        }
        else {return index = index-1;}
    }

    public int addone(int index){
        if(index == this.item.length-1){
            return index = 0;
        }
         return index = index+1;
        }
    //resize array
    public void resize(int changelength){
        T[] Narray = (T[]) new Object[changelength];
        System.arraycopy(this.item,0,Narray, 0,this.minusone(nextLast)+1);
        System.arraycopy(this.item,this.addone(nextFirst),Narray, this.addone(Narray.length-this.size+nextFirst), this.item.length-1-nextFirst);
        nextFirst = (Narray.length-1)-(item.length-nextFirst-1);
        int next = this.minusone(nextLast);
        this.item = Narray;
        nextLast = this.addone(next);
    }

    public void addFirst(T thing){
        if(size == item.length){
            resize(this.size*4);
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
            resize(this.size*4);
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

    public boolean isEmpty(){
        return size==0;
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }
    //print the list from the first to the last
    public void printDeque(){
        int x = this.addone(nextFirst);
        while(x == minusone(nextLast)){
            System.out.println(item[x]);
            x = this.addone(x);
        }
    }

    /** Deletes item from front of the list and
     * returns deleted item. */
    public T removeFirst(){
        int i = this.addone(nextFirst);
        T removedFront = item[i];
        item[nextFirst+1] = null;
        size--;
        nextFirst = this.addone(nextFirst);
        double ratio = (double)size/this.item.length;
        if(ratio <= 0.25 ){
            resize(this.item.length/4);
        }
        return removedFront;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast(){
        T removedBack = item[this.minusone(nextLast)];
        item[this.minusone(nextLast)] = null;
        size--;
        nextLast = this.minusone(nextLast);
        if((double)size/this.item.length <= 0.25 ){
            resize(this.item.length/4);
        }
        return removedBack;
    }


    public static void main(String[] args) {
        ArrayDeque<String> a1 = new ArrayDeque<>();
        a1.item[0] = "0";
        System.out.println(a1.item[1]);
    }
}