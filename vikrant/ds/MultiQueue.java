package vikrant.ds;
public class MultiQueue<E> 
{
    // instance variables
    /** Default array capacity. */
    public static final int CAPACITY = 1000;      // default array capacity

    /** Generic array used for storage of queue elements. */
    private E[] data;                             // generic array used for storage

    /** Index of the top element of the queue in the array. */
    private int f1 = 0;                            // index of the front element
    private int f2 = 999;

    /** Current number of elements in the queue. */
    private int sz1 = 0;
    private int sz2 = 0;                           // current number of elements

    // constructors
    /** Constructs an empty queue using the default array capacity. */
    public MultiQueue() 
    { 
        data = (E[])new Object[CAPACITY];
    }         // constructs queue with default capacity

    public MultiQueue(int capacity) 
    {
        data = (E[])new Object[capacity];
        f2=capacity-1;
    }

    // methods
    /**
    * Returns the number of elements in the queue.
    * @return number of elements in the queue
    */
    public int size1() 
    { 
        return sz1;
    }

    public int size2() 
    { 
        return sz2;
    }

    /** Tests whether the queue is empty. */
    public boolean isEmpty1() 
    {
        if(sz1==0)
            return true;
        return false; 
    }

    public boolean isEmpty2() 
    {
        if(sz2==0)
            return true;
        return false; 
    }

    /**
    * Inserts an element at the rear of the queue.
    * This method runs in O(1) time.
    * @param e   new element to be inserted
    * @throws IllegalStateException if the array storing the elements is full
    */
    public void enqueue1(E e) throws IllegalStateException 
    {
        if(f1+sz1<f2-sz2-1)
        {
            data[f1+sz1]=e;
            ++sz1;
        }
        else
        {
            System.out.println("Queue1 is full");
        }
    }

    public void enqueue2(E e) throws IllegalStateException 
    {
        if(f1+sz1-1<f2-sz2)
        {
            data[f2-sz2]=e;
            ++sz2;
        }
        else
        {
            System.out.println("Queue2 is full");
        }
    }

    /**
    * Returns, but does not remove, the first element of the queue.
    * @return the first element of the queue (or null if empty)
    */
    public E first1() 
    {
        if(!isEmpty1())
            return data[f1];
        return null;
    }

    public E first2() 
    {
        if(!isEmpty2())
            return data[f2];
        return null;
    }

    /**
    * Removes and returns the first element of the queue.
    * @return element removed (or null if empty)
    */
    public E dequeue1() 
    {
        if(!isEmpty1())
        {
            --sz1;
            return data[f1++];
        }
        return null;
    }

    public E dequeue2() 
    {
        if(!isEmpty2())
        {
            --sz2;
            return data[f2--];
        }
        return null;
    }

    /**
    * Returns a string representation of the queue as a list of elements.
    * This method runs in O(n) time, where n is the size of the queue.
    * @return textual representation of the queue.
    */
    public String toString1() 
    {
        StringBuilder s=new StringBuilder("(");
        for(int i=f1;i<sz1+f1;++i)
        {
            s=s.append(data[i]);
            if(i+1!=sz1+f1)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
    }

    public String toString2() 
    {
        StringBuilder s=new StringBuilder("(");
        for(int i=f2;i>f2-sz2;--i)
        {
            s=s.append(data[i]);
            if(i-1!=f2-sz2)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
    }
}