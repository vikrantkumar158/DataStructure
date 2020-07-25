#include <stdio.h>
int subsetSum(int arr[],int n,int sum)
{
    if(sum==0)
        return 1;
    if(n<0||sum<0)
        return 0;
    return subsetSum(arr,n-1,sum-arr[n])||subsetSum(arr,n-1,sum);
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n,sum=0;
        scanf("%d",&n);
        int arr[n];
        for(i=0;i<n;++i)
        {
            scanf("%d",&arr[i]);
            sum+=arr[i];
        }
        if(sum%2==0&&subsetSum(arr,n-1,sum/2))
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}