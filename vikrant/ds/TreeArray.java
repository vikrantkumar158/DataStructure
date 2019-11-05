package vikrant.ds;
public class TreeArray<E extends Comparable<E>>
{
	private static final int CAPACITY=1000;
	private E[] data;
	public TreeArray()
	{
		data=(E[])new Comparable[CAPACITY];
		for(int i=0;i<CAPACITY;++i)
			data[i]=null;
	}
	public TreeArray(int capacity)
	{
		data=(E[])new Comparable[capacity];	
		for(int i=0;i<capacity;++i)
			data[i]=null;
	}
}