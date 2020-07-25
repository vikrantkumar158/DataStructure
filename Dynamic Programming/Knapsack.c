#include <stdio.h>
#include <stdlib.h>
struct knapsack{
    int value;
    int weight;
};
int max(int a,int b)    
{
    if(a>b)
        return a;
    return b;
}
int ksack(int wreq,struct knapsack k[],int n)
{
    if(n<0||wreq==0)
        return 0;
    if(wreq<k[n].weight)
        return ksack(wreq,k,n-1);
    else
        return max(k[n].value+ksack(wreq-k[n].weight,k,n-1),ksack(wreq,k,n-1));
}
int KnapSack(struct knapsack k[],int n,int wreq)
{
	int i,j,arr[n+1][wreq+1];
	for(i=0;i<=n;++i)
	{
		for(j=0;j<=wreq;++j)
		{
			if(i==0||j==0)
				arr[i][j]=0;
			else if(k[i-1].weight>j)
				arr[i][j]=arr[i-1][j];
			else
				arr[i][j]=max(k[i-1].value+arr[i-1][j-k[i-1].weight],arr[i-1][j]);
		}
	}
	return arr[n][wreq];
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n,wreq;
        float ans=0;
        scanf("%d",&n);
        scanf("%d",&wreq);
        struct knapsack k[n];
        for(i=0;i<n;++i)
            scanf("%d",&k[i].value);
        for(i=0;i<n;++i)
            scanf("%d",&k[i].weight);
        printf("%d\n",KnapSack(k,n,wreq));
    } 
	return 0;
}