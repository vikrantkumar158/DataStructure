package vikrant.ds;
public class KMPAlgorithm 
{ 
    public static void KMPArray(String pat,int arr[]) 
    { 
        int j=0,i=1;
        arr[0]=0;
        while(i<pat.length())
        {
            if(pat.charAt(i)==pat.charAt(j))
            {
                arr[i]=++j;
                ++i;
            }
            else
            {
                if(j!=0)
                {
                    j=arr[j-1];
                }
                else
                {
                    arr[i]=j;
                    i++;
                }
            }
        }
    }
    public static void KMPSearch(String str, String pat) 
    { 
        int i,j,s=str.length(),p=pat.length(),count;
        int arr[]=new int[p];
        KMPArray(pat,arr);
        i=count=j=0;
        while(i<s)
        {
            if(str.charAt(i)==pat.charAt(j))
            {
                ++i;
                ++j;
            }
            else
            {
                if(j!=0)
                    j=arr[j-1];
                else
                    ++i;
            }
            if(j==p)
            {
                System.out.println("Pattern found at index : "+(i-j));
                j=arr[j-1];
            }
        }
    }
}