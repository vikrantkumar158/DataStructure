package vikrant.ds;
import vikrant.ds.Queue;
public class CircularQueue<E extends Comparable <E>> implements Queue<E> 
{
    /** The primary storage for elements of the queue */
    private CircularLinkedList<E> list = new CircularLinkedList<>();   // an empty  list

    /** Constructs an initially empty queue. */
    public CircularQueue() { }                  // new queue relies on the initially empty list

    /**
    * Returns the number of elements in the queue.
    * @return number of elements in the queue
    */
    @Override
    public int size() 
    { 
        return list.size();
    }

    /**
    * Tests whether the queue is empty.
    * @return true if the queue is empty, false otherwise
    */
    @Override
    public boolean isEmpty() 
    { 
        return list.isEmpty();
    }

    /**
    * Inserts an element at the rear of the queue.
    * @param element  the element to be inserted
    */
    @Override
    public void enqueue(E element) 
    { 
        list.addLast(element);
    }

    /**
    * Returns, but does not remove, the first element of the queue.
    * @return the first element of the queue (or null if empty)
    */
    @Override
    public E first() 
    { 
        return list.first();
    }

    /**
    * Removes and returns the first element of the queue.
    * @return element removed (or null if empty)
    */
    @Override
    public E dequeue() 
    {
        return list.removeFirst(); 
    }

    /** Produces a string representation of the contents of the queue.
    *  (from front to back). This exists for debugging purposes only.
    */
    public String toString() 
    {
        return list.toString();
    }
}
