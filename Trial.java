import vikrant.ds.Stack;
import vikrant.ds.Queue;
import vikrant.ds.*;
public class Trial
{
	public static void main(String args[])
	{
		HashTable h=new HashTable();
		h.insert("Hello");
		h.insert("Hi");
		h.insert("are");
		h.insert("you");
		System.out.println(h.get("Hi"));
		// SinglyLinkedList sll=new SinglyLinkedList();
		
		// System.out.println(sll.size());
		// System.out.println(sll.isEmpty());
		// System.out.println(sll.first());
		// System.out.println(sll.last());
		// sll.reverse();
		// System.out.println(sll.toString());

		// sll.addFirst(3);
		// sll.addFirst(2);
		// sll.addFirst(1);
		// sll.addLast(4);

		// System.out.println(sll.size());
		// System.out.println(sll.isEmpty());
		// System.out.println(sll.first());
		// System.out.println(sll.last());
		// System.out.println(sll.toString());
		// sll.reverse3();
		// System.out.println(sll.toString());

		// DoublyLinkedList dll=new DoublyLinkedList();
		// DoublyLinkedList dll1=new DoublyLinkedList();

		// dll.addLast(5);
		// dll.addLast(6);
		// dll.addLast(7);
		// dll.addLast(8);

		// System.out.println(dll.size());
		// System.out.println(dll.isEmpty());
		// System.out.println(dll.first());
		// System.out.println(dll.last());
		// System.out.println(dll.toString());

		// dll1.addLast(1);
		// dll1.addLast(2);
		// dll1.addLast(10);
		// dll1.addLast(11);
		// dll1.addLast(12);

		// dll.merge(dll1);
		// System.out.println(dll.toString());

		// LinkedStack l=new LinkedStack();
		// l.push(5);
		// l.push(6);
		// System.out.println(l.size());
		// System.out.println(l.toString());
		// System.out.println(l.pop());
		// System.out.println(l.toString());
	}
	/** Demonstrates sample usage of a stack. */
    // public static void main(String[] args) {
    // Stack S = new LinkedStack();  // contents: ()
    // S.push(5);                              // contents: (5)
    // S.push(3);                              // contents: (5, 3)
    // System.out.println(S.size());           // contents: (5, 3)     outputs 2
    // System.out.println(S.pop());            // contents: (5)        outputs 3
    // System.out.println(S.isEmpty());        // contents: (5)        outputs false
    // System.out.println(S.pop());            // contents: ()         outputs 5
    // System.out.println(S.isEmpty());        // contents: ()         outputs true
    // // System.out.println(S.minimum());            // contents: ()         outputs null
    // System.out.println(S.pop());
    // System.out.println(S.toString());            // contents: ()         outputs null
    // S.push(7);                              // contents: (7)
    // S.push(9);                              // contents: (7, 9)
    // System.out.println(S.toString());  
    // System.out.println(S.top());            // contents: (7, 9)     outputs 9
    // // System.out.println(S.minimum());            // contents: ()         outputs null
    // S.push(4);                              // contents: (7, 9, 4)
    // System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
    // System.out.println(S.pop());            // contents: (7, 9)     outputs 4
    // // System.out.println(S.minimum());            // contents: ()         outputs null
    // S.push(6);                              // contents: (7, 9, 6)
    // S.push(8);                              // contents: (7, 9, 6, 8)
    // System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
    // }
    // public static void main(String[] args) {
	   //  StackMin S = new StackMin();  // contents: ()
	   //  S.push(5);                              // contents: (5)
	   //  S.push(3);                              // contents: (5, 3)
	   //  System.out.println(S.size());           // contents: (5, 3)     outputs 2
	   //  System.out.println(S.pop());            // contents: (5)        outputs 3
	   //  System.out.println(S.isEmpty());        // contents: (5)        outputs false
	   //  System.out.println(S.pop());            // contents: ()         outputs 5
	   //  System.out.println(S.isEmpty());        // contents: ()         outputs true
	   //  System.out.println(S.minimum());            // contents: ()         outputs null
	   //  System.out.println(S.pop());
	   //  System.out.println(S.toString());            // contents: ()         outputs null
	   //  S.push(7);                              // contents: (7)
	   //  S.push(9);                              // contents: (7, 9)
	   //  System.out.println(S.toString());  
	   //  System.out.println(S.top());            // contents: (7, 9)     outputs 9
	   //  System.out.println(S.minimum());            // contents: ()         outputs null
	   //  S.push(4);                              // contents: (7, 9, 4)
	   //  System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
	   //  System.out.println(S.pop());            // contents: (7, 9)     outputs 4
	   //  System.out.println(S.minimum());            // contents: ()         outputs null
	   //  S.push(6);                              // contents: (7, 9, 6)
	   //  S.push(8);                              // contents: (7, 9, 6, 8)
	   //  System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
	   //  System.out.println(S.toString());
    // }
 //    public static void main(String args[])
	// {
	// 	CircularLinkedList sll=new CircularLinkedList();
		
	// 	System.out.println(sll.size());
	// 	System.out.println(sll.isEmpty());
	// 	System.out.println(sll.first());
	// 	System.out.println(sll.last());
	// 	System.out.println(sll.toString());

	// 	sll.addFirst(3);
	// 	sll.addFirst(2);
	// 	sll.addFirst(1);
	// 	sll.addLast(4);

	// 	System.out.println(sll.size());
	// 	System.out.println(sll.isEmpty());
	// 	System.out.println(sll.first());
	// 	System.out.println(sll.last());
	// 	System.out.println(sll.toString());
	// }
	// public static void main(String args[])
	// {
		// int i,arr[]=new int[]{10,9,8,7,6,5,4,3,2,1};
		// Sorting.HeapSort(arr);
		// for(i=0;i<arr.length;++i)
		// 	System.out.println(arr[i]);
		// StackUsingQueue s=new StackUsingQueue();
		// s.push(1);
		// s.push(2);
		// s.push(3);
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// QueueUsingStack q=new QueueUsingStack();
		// q.enqueue(1);
		// q.enqueue(2);
		// q.enqueue(3);
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// q.enqueue(1);
		// q.enqueue(2);
		// q.enqueue(3);
		// System.out.println(q.peek());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
	// 	int arr[]=new int[]{1,1,2,2,2,3,4,6,6,6,7};
	// 	System.out.println(BinarySearch.IterativeSearch(arr,6));
	// 	System.out.println(BinarySearch.RecursiveSearch(arr,6,0,arr.length-1));
	// }
}