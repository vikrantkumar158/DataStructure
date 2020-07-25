#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int min(int a,int b)
{
    if(a>b)
        return b;
    return a;
}
int minJ(int arr[],int n,int index,int count)
{
    if(index==n-1)
        return count;
    int i,ans=INT_MAX;
    for(i=1;i<=arr[index]&&index+i<n;++i)
    {
        ans=min(ans,minJ(arr,n,index+i,count+1));
    }
    return ans;
}
int minJumps(int arr[],int n)
{
    int ans=minJ(arr,n,0,0);
    if(ans==INT_MAX)
        return -1;
    return ans;
}
int MinJumps(int arr[],int n)
{
    
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n;
        scanf("%d",&n);
        int arr[n];
        for(i=0;i<n;++i)
            scanf("%d",&arr[i]);
        printf("%d\n",minJumps(arr,n));   
    }
	return 0;
}