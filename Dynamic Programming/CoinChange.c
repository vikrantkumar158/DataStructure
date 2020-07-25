#include <stdio.h>
int coinchange(int arr[],int n,int m)
{
    if(m==0)
        return 1;
    if(n<0||m<0)
        return 0;
    return coinchange(arr,n-1,m)+coinchange(arr,n,m-arr[n]);
}
int coinChange(int arr[],int n,int m)
{
    int i,j,a[m+1][n];
    for(i=0;i<n;++i)
        a[0][i]=1;
    for(i=1;i<=m;++i)
    {
        for(j=0;j<n;++j)
        {
            int x,y;
            x=(i-arr[j]>=0)?a[i-arr[j]][j]:0;
            y=(j>=1)?a[i][j-1]:0;
            a[i][j]=x+y;
        }
    }
    return a[m][n-1];
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n,m;
        scanf("%d",&n);
        int arr[n];
        for(i=0;i<n;++i)
            scanf("%d",&arr[i]);
        scanf("%d",&m);
        printf("%d\n",coinChange(arr,n,m));
    }
    return 0;
}