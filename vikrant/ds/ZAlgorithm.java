package vikrant.ds;
public class ZAlgorithm
{
	public static void ZArray(String pat,int arr[]) 
	{ 
  
        int p=pat.length(),i,l=0,r=0;
        arr[0]=0;
        for(i=1;i<p;++i)
        {
        	if(i>r)
        	{
        		l=r=i;
        		while(r<p&&pat.charAt(r-l)==pat.charAt(r))
        			r++;
        		arr[i]=r-l;
        		r--;
        	}
        	else
        	{
        		int k=i-l;
        		if(arr[k]<r-i-1)
        			arr[i]=arr[k];
        		else
        		{
        			l=i;
        			while(r<p&&pat.charAt(r-l)==pat.charAt(r))
        				++r;
        			arr[i]=r-l;
        			r--;
        		}	
        	}	
        } 
    }
	public static void ZSearch(String str,String pat) 
    { 
    	String tot=pat+"$"+str;
        int i,l=tot.length(); 
        int arr[]=new int[l]; 
        ZArray(tot,arr); 
  		for(i=0;i<l;++i)
  		{
  			if(arr[i]==pat.length())
  				System.out.println("Pattern found at index : "+(i-pat.length()-1));
  		} 
    }
}