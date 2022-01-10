public class LinkedListDeque<Generic> {
    //The node in the Deque
    private class GNode{
        public GNode previous;
        public Generic item;
        public GNode next;

        //constructor
        public GNode(GNode o, Generic i, GNode j){
            previous = o;
            item = i;
            next = j;
        }
    }
    //get ready to construct an empty or not empty deque.
    private int size;
    public GNode sentinel;
    public GNode temp;
    //construct an empty Deque
    public LinkedListDeque(){
        temp = new GNode(sentinel,null, sentinel);
        sentinel = temp;
        sentinel.next = sentinel;
        sentinel.previous = sentinel;

        size = 0;
    }
//    public LinkedListDeque(Generic stuff){
//        sentinal = new GNode(sentinal, null, sentinal);
//        sentinal.next = new GNode()
//    }

    //Using Circular Sentinel to code up Deque API

/*Adds an item of type T to the front of the deque.*/
    public void addFirst(Generic item){
        GNode first = new GNode(sentinel, item, sentinel.next);
        sentinel.next.previous = first;
        sentinel.next = first;
        if(sentinel.previous == sentinel) sentinel.previous = first;
        size +=1;
    }

/*Adds an item of type T to the back of the dequ*/
    public void addLast(Generic item){
        GNode last = new GNode(sentinel.previous, item, sentinel);
        sentinel.previous.next = last;
        sentinel.previous = last;
        if (sentinel.next == sentinel) sentinel.next = last;
        size +=1;
    }

/*Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        if((sentinel.next == sentinel) && (sentinel.previous == sentinel)){
            size = 0;
            return true;
        }
        else {
            return false;
        }
    }

/*Returns the number of items in the deque.*/
    public int size(){
        return size;
    }

/*Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        GNode p = sentinel;
        while(p.next != sentinel){
            p = p.next;
            System.out.print(p.item + " ");
        }
    }

/*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public GNode removeFirst(){
        if(sentinel.next == sentinel){
            return null;
        }
        else{
            sentinel.next.next.previous = sentinel;
            sentinel.next = sentinel.next.next;
            size -=1;
            return sentinel.next;
        }
    }

/*Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public GNode removeLast(){
        if(sentinel.previous == sentinel){
            return null;
        }
        else{
            sentinel.previous.previous.next = sentinel;
            sentinel.previous = sentinel.previous.previous;
            size -=1;
            return sentinel.previous;
        }
    }

/* Gets the item at the given index, where 0 is the front, 1 is the next item,
and so forth. If no such item exists, returns null. Must not alter the deque!*/
    public Generic get(int index){
        GNode p = sentinel.next;
        if(sentinel == sentinel.next){
            return null;
        }
        else{
            for(int i = index; i != 0; i--){
                p = p.next;
            }
            return p.item;
        }

    }
/* Same as get, but uses recursion.*/

    /*WARNING: CANNOT RETURN THE EXPECTED RESULT WITHOUT ALTERING DEQUE OR ALTERING THE FUNCTION VARIANT*/


    public Generic getRecursive(int index){
        if (index == 1){
            return sentinel.next.item;
        }
        else{
            sentinel = sentinel.next;
            getRecursive(index-1);
        }
        return null;
    }


}

