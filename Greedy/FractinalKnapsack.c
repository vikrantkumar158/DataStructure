#include <stdio.h>
#include <stdlib.h>
struct knapsack{
    float value;
    float weight;
    float valuePerWeight;
};
int comparator(const void *p,const void *q)
{
    float x=(*(struct knapsack *)p).valuePerWeight-(*(struct knapsack *)q).valuePerWeight;
    if(x>0)
        return 1;
    return -1;
}
int main() {
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n;
        float ans=0,wreq;
        scanf("%d",&n);
        scanf("%f",&wreq);
        struct knapsack k[n];
        for(i=0;i<n;++i)
        {
            scanf("%f %f ", &k[i].value, &k[i].weight);
            k[i].valuePerWeight=k[i].value/k[i].weight;
        }
        qsort(k,n,sizeof(k[0]),comparator);
        for(i=n-1;i>=0&&wreq!=0;--i)
        {
            if(k[i].weight<=wreq)
            {
                ans+=k[i].value;
                wreq-=k[i].weight;
            }
            else
            {
                ans+=k[i].valuePerWeight*wreq;
                wreq=0;
            }
        }
        printf("%.2f\n",ans);
    } 
	return 0;
}