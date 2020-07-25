#include <stdio.h>
#include <limits.h>
int max(int a,int b)
{
    if(a>b)
        return a;
    return b;
}
int numberOfPieces(int arr[],int a[],int n)
{
    if(n==0)
        return 0;
    if(n<0)
        return INT_MIN;
    if(a[n]==-1)
    {
        if(n-arr[0]>=0)
            a[n]=1+numberOfPieces(arr,a,n-arr[0]);
        if(n-arr[1]>=0)
            a[n]=max(a[n],1+numberOfPieces(arr,a,n-arr[1]));
        if(n-arr[2]>=0)
            a[n]=max(a[n],1+numberOfPieces(arr,a,n-arr[2]));
        if(a[n]==-1)
            a[n]=INT_MIN;
    }
    return a[n];
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n,arr[3];
        scanf("%d",&n);
        int a[n+1];
        for(i=0;i<3;++i)
            scanf("%d",&arr[i]);
        for(i=0;i<=n;++i)
            a[i]=-1;
        printf("%d\n",numberOfPieces(arr,a,n));
    }
	return 0;
}