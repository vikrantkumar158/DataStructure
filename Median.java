import vikrant.ds.*;
import java.util.Scanner;
public class Median
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Heap m1=new MaxHeap(),m2=new MinHeap();
		int i,n;
		System.out.print("Enter number of elements : ");
		n=sc.nextInt();
		int[] arr=new int[n];
		for(i=0;i<n;++i)
		{
			arr[i]=sc.nextInt();
		}
		// int[] arr=new int[]{5,15,1,3,2,8,7,9,10,6,11,4};
		// n=arr.length;
		m1.insert(arr[0]);
		System.out.println(arr[0]);
		for(i=1;i<n;++i)
		{
			if(arr[i]<=(int)m1.top())
			{
				m1.insert(arr[i]);
				m1.buildHeap();
			}
			else
			{
				m2.insert(arr[i]);
				m2.buildHeap();
			}
			int size1=m1.length(),size2=m2.length();
			float median;
			if(size1-size2>1)
			{
				m2.insert(m1.remove());
				m1.buildHeap();	
				m2.buildHeap();	
			}
			else if(size2-size1>1)
			{
				m1.insert(m2.remove());
				m1.buildHeap();	
				m2.buildHeap();
			}
			size1=m1.length();
			size2=m2.length();
			if(size1==size2)
			median=(float)((int)m1.top()+(int)m2.top())/(float)2.0;
			else if(size1>size2)
				median=(int)m1.top();
			else
				median=(int)m2.top();
			System.out.println(median);
		}
	}
}