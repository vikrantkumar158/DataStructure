package vikrant.ds;
import vikrant.ds.Stack;
class LinkedList<E extends Comparable <E>>
{
    private static class Node<E>
    {
        private E element;
        private E min;            
        private Node<E> next;
        public Node(E e, Node<E> n) 
        {
            element=e;
            next=n;
        }
        public E getElement() 
        {
            return element;
        }
        public Node<E> getNext() 
        { 
            return next;
        }
        public void setNext(Node<E> n) 
        { 
            next=n;
        }
        public void setMin(E e)
        {
        	min=e;
        }
        public E getMin()
        {
        	return min;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public LinkedList() 
    { 
        
    }
    public int size() 
    {  
        return size;
    }
    public boolean isEmpty() 
    { 
        if(size==0)
            return true;
        return false;
    }
    public E first()
    {
        if(head!=null)
            return head.getElement();
        return null;
    }
    public E last() 
    {
        if(tail!=null)
            return tail.getElement();
        return null;
    }
    public void addFirst(E e) 
    {
        Node<E> n=new Node<>(e,head);
        if(head!=null)
       	{
       		E temp=head.getMin();
       		if(temp.compareTo(e)>0)
       			n.setMin(e);
       		else
       			n.setMin(temp);
       	}
        head=n;
        if(tail==null)
        {
            tail=n;
            tail.setMin(e);
        }
        ++size;
    }
    public void addLast(E e) 
    {
        Node<E> n=new Node<>(e,null);
        if(tail==null)
        {
            head=n;
        }
        else
        {
            tail.setNext(n);
        }
        tail=n;
        ++size;
    }
    public E removeFirst() 
    {
        if(head!=null)
        {
            E x=head.getElement();
            head=head.getNext();
            if(head==null)
                tail=null;
            --size;
            return x;
        }
        return null;
    }
    public E min()
    {
    	if(head!=null)
    		return head.getMin();
    	return null;
    }
    public String toString() 
    {
        StringBuilder s=new StringBuilder("(");
        if(head!=null)
        {
            Node<E> n=new Node<>(head.getElement(),head.getNext());
            while(n!=null)
            {
                s=s.append(n.getElement());
                n=n.getNext();
                if(n!=null)
                    s=s.append(", ");
            }
        }
        s=s.append(")");
        return s.toString();
    }
}
public class StackMin<E extends Comparable <E>>
{
    /** The primary storage for elements of the stack */
    private LinkedList<E> list = new LinkedList<>();   // an empty list

    /** Constructs an initially empty stack. */
    public StackMin() { }                   // new stack relies on the initially empty list

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    public int size() 
    {  
        return list.size();
    }

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() 
    { 
        return list.isEmpty();
    }

    /**
     * Inserts an element at the top of the stack.
     * @param element   the element to be inserted
     */
    public void push(E element) 
    { 
        list.addFirst(element);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    public E top() 
    { 
        return list.first();
    }

    /**
     * Returns, min element in the stack.
     * @return min element in the stack (or null if empty)
     */
    public E minimum()
    {
    	return list.min();
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    public E pop() 
    { 
        return list.removeFirst();
    }

    /** Produces a string representation of the contents of the stack.
     *  (ordered from top to bottom)
     *
     * This exists for debugging purposes only.
     *
     * @return textual representation of the stack
     */
    public String toString() 
    {
        return list.toString();
    }
}
