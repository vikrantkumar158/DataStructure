#include <stdio.h>
int max(int a,int b)
{
    if(a>b)
        return a;
    return b;
}
int construct(int arr[],int n,int a[])
{
    int i,m=0;
    for(i=0;i<n;++i)
    {
        if(arr[i]<arr[n])
            m=max(m,a[i]);
    }
    return m;
}
int LIS(int arr[],int n)
{
    int i,a[n],m=1;
    a[0]=1;
    for(i=1;i<n;++i)
    {
        a[i]=construct(arr,i,a)+1;    
        if(m<a[i])
            m=a[i];
    }
    return m;
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
        printf("%d\n",LIS(arr,n));
    }
	return 0;
}