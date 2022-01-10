public class ArrayDeque<Generic> {
    private Generic[] Array;
    public int size;
    public int nextFirst;
    public int nextLast;
    public int capacity = 8;

    public ArrayDeque(){
        Array = (Generic[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 7;
    }

    public void resize(){
        if(size == Array.length){
            Generic[] a = (Generic[]) new Object[2*size];
            System.arraycopy(Array,0,a,0,size);
            Array = a;
            capacity = 2*size;
            nextLast = LastAfterAdd(size);
            nextFirst = FirstAfterAdd(0);
        }
        double RFactor = size / Array.length;
        if(RFactor <= 0.25){
            Generic[] b = (Generic[]) new Object[size/2];
            for(int i=0; i<size; i++){
                if (Array[i] != null) {
                    b[i] = Array[i];
                }
            }
            capacity = size/2;
            nextLast = LastAfterAdd(size);
            nextFirst = FirstAfterAdd(0);
        }
    }

    public int FirstAfterRmv(int nextFirst){
        if(nextFirst +1 >= capacity){
            nextFirst = 0;
        }
        else{
            nextFirst +=1;
        }
        return nextFirst;
    }
    public int LastAfterRmv(int nextLast){
        if(nextLast -1 <0){
            nextLast = capacity - 1;
        }
        else{nextLast -= 1;}
        return nextLast;
    }
    public int FirstAfterAdd(int nextFirst){
        if(nextFirst -1 < 0){
            nextFirst = capacity - 1;
        }
        else {nextFirst -= 1;}
        return nextFirst;
    }
    public int LastAfterAdd(int nextLast){
        if(nextLast + 1 == capacity){
            nextLast = 0;
        }
        else{
            nextLast += 1;
        }
        return nextLast;
    }

    /*Adds an item of type T to the front of the deque.*/
    public void addFirst(Generic item){
        if(size == Array.length){
            resize();
        }

//        //The Array model after resizing decides this.
//        nextFirst = FirstAfterAdd(nextFirst);
//        nextLast = LastAfterAdd(nextLast);

        Array[nextFirst] = item;
        size +=1;

    }

    /*Adds an item of type T to the back of the dequ*/
    public void addLast(Generic item){
        if(size == Array.length){
            resize();

        }

//        nextFirst = FirstAfterAdd(nextFirst);
//        nextLast = LastAfterAdd(nextLast);

        Array[nextLast] = item;
        size +=1;
    }

    /*Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        for(int i = 0; i<Array.length; i++){
            if (Array[i] != null) {
                return false;
            }
        }
        return true;
    }

    /*Returns the number of items in the deque.*/
    public int size(){
        return size;
    }

    /*Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        for(int i = 0; i<Array.length; i++){
            if(Array[i] != null){
                System.out.print(Array[i] + " ");
            }
        }
    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public Generic removeFirst(){
        nextFirst = FirstAfterRmv(nextFirst);
        Generic rmv = Array[nextFirst];
        Array[nextFirst] = null;
        resize();
        return(rmv);
    }

    /*Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public Generic removeLast(){
        nextLast = LastAfterRmv(nextLast);
        Generic rmv = Array[nextLast];
        Array[nextLast] = null;
        resize();
        return(rmv);
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null. Must not alter the deque!*/
    public Generic get(int index){
        if(index < capacity && index >=0 ){
            if(Array[index] != null) return Array[index];
        }
        return null;
    }

}
