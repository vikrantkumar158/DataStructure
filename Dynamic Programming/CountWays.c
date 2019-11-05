#include <stdio.h>
int countWays(int n)
{
    if(n==0)
        return 1;
    if(n==1)
        return 1;
    if(n==2)
        return 2;
    return countWays(n-1)+countWays(n-2)+countWays(n-3);
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int i,n;
        scanf("%d",&n);
        printf("%d\n",countWays(n));
    }
	return 0;
}